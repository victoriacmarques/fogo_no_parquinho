import java.util.ArrayList;
import java.util.List;

public class GestaoDeVisitantes {
    private List<Visitante> visitantes;
    private GestaoDeIngressos gestaoDeIngressos;

    public GestaoDeVisitantes(GestaoDeIngressos gestaoDeIngressos) {
        this.visitantes = new ArrayList<>();
        this.gestaoDeIngressos = gestaoDeIngressos;
    }


    public void adicionarVisitante(Visitante visitante) {
        if (visitante != null) {
            visitantes.add(visitante);
            System.out.println("Visitante cadastrado com sucesso.");
        } else {
            System.out.println("Visitante não pode ser nulo.");
        }
    }

    public Visitante encontrarVisitante(String busca) {
        Visitante visitanteEncontrado = buscarPorNome(busca);
        if (visitanteEncontrado == null) {
            visitanteEncontrado = buscarPorIdIngresso(busca);
        }
        return visitanteEncontrado;
    }
    private Visitante buscarPorNome(String nome) {
        for (Visitante visitante : visitantes) {
            if (visitante.getNome().contains(nome)) {
                return visitante;
            }
        }
        return null;
    }
    private Visitante buscarPorIdIngresso(String idIngresso) {
        for (Ingresso ingresso : gestaoDeIngressos.getIngressos()) {
            if (ingresso.getIdIngresso().equals(idIngresso)) {
                return ingresso.getVisitante();
            }
        }
        return null;
    }

    public void listarVisitantes() {
        if (visitantes.isEmpty()) {
            System.out.println("Nenhum visitante cadastrado.");
            return;
        }
        int contador = 1;
        for (Visitante visitante : visitantes) {
            System.out.println(contador + ": Nome: " + visitante.getNome());
            List<Ingresso> ingressosVisitante = new ArrayList<>();
            for (Ingresso ingresso : gestaoDeIngressos.getIngressos()) {
                if (ingresso.getVisitante().equals(visitante)) {
                    ingressosVisitante.add(ingresso);
                }
            }
            if (ingressosVisitante.isEmpty()) {
                System.out.println("   Situação do Ingresso: Sem ingresso");
            } else {
                for (Ingresso ingresso : ingressosVisitante) {
                    String statusIngresso = ingresso.isAtivo() ? "Ativo" : "Inativo";
                    System.out.println("   Ingresso: " + ingresso.getIdIngresso() + ", Situação: " + statusIngresso);
                }
            }
            contador++;
        }
    }
}
