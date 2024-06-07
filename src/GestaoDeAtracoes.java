import java.util.ArrayList;
import java.util.List;
/**
 * Gerencia as atrações do parque.
 */
public class GestaoDeAtracoes {
    private List<Atracao> atracoes;

    /**
     * Inicializa a gestão de atrações com todas as atrações disponíveis.
     */
    public GestaoDeAtracoes() {
        this.atracoes = new ArrayList<>();
        for (Atracao atracao : Atracao.values()) {
            this.atracoes.add(atracao);
        }
    }

    /**
     * Lista todas as atrações disponíveis no parque.
     */
    public void listarAtracoes() {
        for (int i = 0; i < atracoes.size(); i++) {
            System.out.println((i + 1) + ". " + atracoes.get(i).getNome());
        }
    }
}

