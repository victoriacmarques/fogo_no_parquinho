import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SistemaDeIngressos {
    private GestaoDeVisitantes gestaoDeVisitantes;
    private GestaoDeIngressos gestaoDeIngressos;
    private GestaoDeAtracoes gestaoDeAtracoes; // Adicionado

    public SistemaDeIngressos() {
        this.gestaoDeIngressos = new GestaoDeIngressos();
        this.gestaoDeVisitantes = new GestaoDeVisitantes(gestaoDeIngressos);
        this.gestaoDeAtracoes = new GestaoDeAtracoes(); // Inicializa as atrações
    }

    private Visitante criarVisitante(Scanner scanner) {
        System.out.println("Informe o nome:");
        String nome = scanner.nextLine();
        int anoNascimento = lerInteiro(scanner, "Informe o ano de nascimento:");
        int anoAtual = LocalDate.now().getYear();
        int idade = anoAtual - anoNascimento;

        if (idade < 12) {
            System.out.println("Informações sobre visitante criança:");
            System.out.println("Informe o nome do responsável:");
            String nomeResponsavel = scanner.nextLine();
            String telefoneResponsavel = lerTelefone(scanner, "Informe o telefone do responsável:");
            return new Crianca(nome, anoNascimento, nomeResponsavel, telefoneResponsavel);
        } else {
            System.out.println("Informações sobre visitante adulto:");
            String telefone = lerTelefone(scanner, "Informe o telefone:");
            return new Adulto(nome, anoNascimento, telefone);
        }
    }

    private int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.println(mensagem);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
            }
        }
    }

    private String lerString(Scanner scanner, String mensagem) {
        System.out.println(mensagem);
        return scanner.nextLine();
    }

    private boolean validarMesAno(String mesAno) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
            formatter.parse(mesAno);
            String[] partes = mesAno.split("/");
            int mes = Integer.parseInt(partes[0]);
            int ano = Integer.parseInt(partes[1]);
            return mes >= 1 && mes <= 12 && ano > 0;
        } catch (DateTimeParseException | NumberFormatException e) {
            return false;
        }
    }
    
    private String lerTelefone(Scanner scanner, String mensagem) {
        while (true) {
            System.out.println(mensagem);
            String telefone = scanner.nextLine();
            if (telefone.matches("\\d{9}")) {
                return telefone;
            } else {
                System.out.println("Telefone inválido. Por favor, insira um telefone válido com 9 dígitos.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n================ MENU ================");
        System.out.println("1. Cadastrar Visitante");
        System.out.println("2. Listar Visitantes");
        System.out.println("3. Emitir Ingresso");
        System.out.println("4. Registrar Visita à Atração");
        System.out.println("5. Localizar Visitante");
        System.out.println("6. Consultar Faturamento");
        System.out.println("7. Consultar Visitantes por Atração em uma Data");
        System.out.println("8. Cancelar Ingresso");
        System.out.println("9. Sair");
        System.out.println("======================================");
}

    public void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*************");
        System.out.println("*                                     *");
        System.out.println("*  Bem-vindo ao sistema do parque de  *");
        System.out.println("*          diversões!                 *");
        System.out.println("*                                     *");
        System.out.println("*************");

        while (true) {
            mostrarMenu();

            int escolha = lerInteiro(scanner, "Digite sua escolha:");

            switch (escolha) {
                case 1:
                    Visitante visitante = criarVisitante(scanner);
                    gestaoDeVisitantes.adicionarVisitante(visitante);
                    break;
                case 2:
                    gestaoDeVisitantes.listarVisitantes();
                    break;
                case 3:
                    String data = lerString(scanner, "Informe a data (dd/MM/yyyy):");
                    String nomeVisitante = lerString(scanner, "Informe o nome do visitante:");
                    Visitante v = gestaoDeVisitantes.encontrarVisitante(nomeVisitante);
                    if (v != null) {
                        if (gestaoDeIngressos.emitirIngresso(data, v)) {
                            System.out.println("Ingresso emitido com sucesso.");
                        }
                    } else {
                        System.out.println("Visitante não encontrado.");
                    }
                    break;
                case 4:
                    nomeVisitante = lerString(scanner, "Informe o nome do visitante:");
                    v = gestaoDeVisitantes.encontrarVisitante(nomeVisitante);
                    if (v != null) {
                        System.out.println("Escolha a atração para registrar a visita:");
                        gestaoDeAtracoes.listarAtracoes();
                        int escolhaAtracao = lerInteiro(scanner, "Digite o número da atração:");
                        if (escolhaAtracao >= 1 && escolhaAtracao <= Atracao.values().length) {
                            gestaoDeIngressos.registrarVisitaAtracao(v, Atracao.values()[escolhaAtracao - 1]);
                            System.out.println("Visita registrada com sucesso.");
                        } else {
                            System.out.println("Atração inválida.");
                        }
                    } else {
                        System.out.println("Visitante não encontrado.");
                    }
                    break;
                case 5:
                    String busca = lerString(scanner, "Digite parte do nome ou o ID do ingresso:");
                    v = gestaoDeVisitantes.encontrarVisitante(busca);
                    if (v != null) {
                        gestaoDeIngressos.listarAtracoesVisitante(v);
                    } else {
                        System.out.println("Visitante não encontrado.");
                    }
                    break;
                    case 6:
                    String mesAno = lerString(scanner, "Informe o mês e ano (mm/yyyy):");
                    if (validarMesAno(mesAno)) {
                        System.out.println("Faturamento: R$" + gestaoDeIngressos.consultarFaturamento(mesAno));
                    } else {
                        System.out.println("Formato inválido. Por favor, use o formato mm/yyyy.");
                    }
                    break;
                case 7:
                    data = lerString(scanner, "Informe a data (dd/MM/yyyy) para ver a quantidade de visitantes por atração:");
                    gestaoDeIngressos.listarVisitantesAtracaoPorData(data);
                    break;
                case 8:
                    String idIngresso = lerString(scanner, "Informe o ID do ingresso a ser cancelado:");
                    gestaoDeIngressos.cancelarIngresso(idIngresso);
                    break;
                case 9:
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

