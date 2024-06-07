import java.util.ArrayList;
import java.util.List;

/**
 * Gerencia os visitantes do parque.
 */
public class GestaoDeVisitantes {
    private List<Visitante> visitantes;
    private GestaoDeIngressos gestaoDeIngressos;


    public GestaoDeVisitantes(GestaoDeIngressos gestaoDeIngressos) {
        this.visitantes = new ArrayList<>();
        this.gestaoDeIngressos = gestaoDeIngressos;
    }

    /**
     * Adiciona um visitante à lista de visitantes.
     *
     * @param visitante Visitante a ser adicionado.
     * @throws IllegalArgumentException se o visitante for nulo.
     */
    public void adicionarVisitante(Visitante visitante) {
        if (visitante != null) {
            visitantes.add(visitante);
            System.out.println("Visitante cadastrado com sucesso.");
        } else {
            System.out.println("Visitante não pode ser nulo.");
        }
    }

    /**
     * Encontra um visitante pelo nome ou ID do ingresso.
     *
     * @param busca Nome ou ID do ingresso a ser buscado.
     * @return Visitante encontrado ou null se não for encontrado.
     */
    //refazendo método de busca e a reduzindo redundância no código
    public Visitante encontrarVisitante(String busca) {
    for (Visitante visitante : visitantes) {
        if (visitante.getNome().contains(busca)) {
            return visitante;
        }
    }
    for (Ingresso ingresso : gestaoDeIngressos.getIngressos()) {
        if (ingresso.getIdIngresso().equals(busca)) {
            return ingresso.getVisitante();
        }
    }
   return null;
}

    /**
     * Lista todos os visitantes cadastrados.
     */
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
