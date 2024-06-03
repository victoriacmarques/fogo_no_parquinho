import java.util.ArrayList;
import java.util.List;

public class GestaoDeAtracoes {
    private List<Atracao> atracoes;

    public GestaoDeAtracoes() {
        this.atracoes = new ArrayList<>();
        for (Atracao atracao : Atracao.values()) {
            this.atracoes.add(atracao);
        }
    }

}