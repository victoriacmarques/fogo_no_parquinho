public class RegistroAtracao {
    private Visitante visitante;
    private Atracao atracao;
    private String data;

    public RegistroAtracao(Visitante visitante, Atracao atracao, String data) {
        if (visitante == null || atracao == null || data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Dados inválidos.");
        }
        this.visitante = visitante;
        this.atracao = atracao;
        this.data = data;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public Atracao getAtracao() {
        return atracao;
    }

    public String getData() {
        return data;
    }
}