import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestaoDeIngressos {
    private List<Ingresso> ingressos;
    private Map<String, List<Ingresso>> ingressosPorData;

    public GestaoDeIngressos() {
        this.ingressos = new ArrayList<>();
        this.ingressosPorData = new HashMap<>();
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

}
