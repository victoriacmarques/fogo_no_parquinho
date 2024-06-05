import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GestaoDeIngressos {
    private List<Ingresso> ingressos;
    private Map<String, List<Ingresso>> ingressosPorData;
    private List<RegistroAtracao> registrosAtracoes;

    public GestaoDeIngressos() {
        this.ingressos = new ArrayList<>();
        this.ingressosPorData = new HashMap<>();
        this.registrosAtracoes = new ArrayList<>();
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    private LocalDate validarData(String data) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(data, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida. Por favor, use o formato dd/MM/yyyy.");
            return null;
        }
    }

    public boolean emitirIngresso(String data, Visitante visitante) {
        LocalDate dataIngresso = validarData(data);
        if (dataIngresso == null) {
            return false;
        }
        LocalDate dataAtual = LocalDate.now();
        if (dataIngresso.isBefore(dataAtual)) {
            System.out.println("Não é possível emitir um ingresso para uma data no passado.");
            return false;
        }
        List<Ingresso> ingressosDoDia = ingressosPorData.getOrDefault(data, new ArrayList<>());


        for (Ingresso ingresso : ingressosDoDia) {
            if (ingresso.getVisitante().equals(visitante)) {
                if (ingresso.isAtivo()) {
                    System.out.println("O visitante já possui um ingresso ativo para esta data.");
                    return false;
                } else {

                    ingresso.reativar();
                    System.out.println("Ingresso reativado: " + ingresso.getIdIngresso());
                    return true;
                }
            }
        }

        if (ingressosDoDia.size() < 500) {
            Ingresso ingresso = new Ingresso(data, visitante, ingressosDoDia.size() + 1);
            ingressos.add(ingresso);
            ingressosDoDia.add(ingresso);
            ingressosPorData.put(data, ingressosDoDia);
            System.out.println("Ingresso emitido: " + ingresso.getIdIngresso());
            return true;
        } else {
            System.out.println("Limite máximo de ingressos alcançado para o dia.");
            return false;
        }
    }
    public void registrarVisitaAtracao(Visitante visitante, Atracao atracao) {
        boolean temIngressoAtivo = false;
        String data = null;
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getVisitante().equals(visitante) && ingresso.isAtivo()) {
                temIngressoAtivo = true;
                data = ingresso.getData();
                break;
            }
        }
        if (temIngressoAtivo) {
            registrosAtracoes.add(new RegistroAtracao(visitante, atracao, data));
        } else {
            System.out.println("O visitante não possui um ingresso ativo.");
        }
    }

    public void listarAtracoesVisitante(Visitante visitante) {
        Set<String> atracoesVisitadas = new HashSet<>();
        for (RegistroAtracao registro : registrosAtracoes) {
            if (registro.getVisitante().equals(visitante)) {
                atracoesVisitadas.add(registro.getAtracao().getNome());
            }
        }
        System.out.println("Atrações visitadas por " + visitante.getNome() + ":");
        if (atracoesVisitadas.isEmpty()) {
            System.out.println(visitante.getNome() + " não foi em nenhuma atração do parque.");
        } else {
            for (String atracao : atracoesVisitadas) {
                System.out.println(atracao);
            }
    }
}
    public double consultarFaturamento(String mesAno) {
        double faturamento = 0;
        for (Ingresso ingresso : ingressos) {
            if (ingresso.isAtivo() && ingresso.getData().substring(3).equals(mesAno)) {
                faturamento += ingresso.getPreco();
            }
        }
        return faturamento;
    }
    public void listarVisitantesAtracaoPorData(String data) {
        Map<String, Set<Visitante>> contagemAtracao = new HashMap<>();
        for (Atracao atracao : Atracao.values()) {
            contagemAtracao.put(atracao.getNome(), new HashSet<>());
        }
        for (RegistroAtracao registro : registrosAtracoes) {
            if (registro.getData().equals(data)) {
                contagemAtracao.get(registro.getAtracao().getNome()).add(registro.getVisitante());
            }
        }
        List<Map.Entry<String, Set<Visitante>>> sortedEntries = new ArrayList<>(contagemAtracao.entrySet());
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
        for (Map.Entry<String, Set<Visitante>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size());
        }
    }

    public void cancelarIngresso(String idIngresso) {
        Ingresso ingressoParaCancelar = null;
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getIdIngresso().equals(idIngresso)) {
                ingressoParaCancelar = ingresso;
                break;
            }
        }

        if (ingressoParaCancelar == null) {
            System.out.println("Ingresso não encontrado.");
            return;
        }

        if (!ingressoParaCancelar.isAtivo()) {
            System.out.println("Este ingresso já está cancelado.");
            return;
        }

        for (RegistroAtracao registro : registrosAtracoes) {
            if (registro.getVisitante().equals(ingressoParaCancelar.getVisitante()) && registro.getData().equals(ingressoParaCancelar.getData())) {
                System.out.println("Não é possível cancelar o ingresso, pois o visitante já registrou uma visita a uma atração.");
                return;
            }
        }

        ingressoParaCancelar.cancelar();
        System.out.println("Ingresso cancelado com sucesso.");
    }
    public int consultarTotalVisitantes(String data) {
        int total = 0;
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getData().equals(data) && ingresso.isAtivo()) {
                total++;
            }
        }
        return total;
    }
}
