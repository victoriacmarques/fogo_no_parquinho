import java.util.Scanner;
import java.time.LocalDate;

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
        System.out.println("4. Sair");
        System.out.println("======================================");
    }

    public void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***************************************");
        System.out.println("*                                     *");
        System.out.println("*  Bem-vindo ao sistema do parque de  *");
        System.out.println("*          diversões!                 *");
        System.out.println("*                                     *");
        System.out.println("***************************************");

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
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
