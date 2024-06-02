public class Ingresso {
    private String data;
    private Visitante visitante;
    private boolean ativo;
    private int sequencia;
    private static final double PRECO_ADULTO = 100.00;
    private static final double PRECO_CRIANCA = 80.00;

    public Ingresso(String data, Visitante visitante, int sequencia) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Data não pode ser vazia.");
        }
        if (visitante == null) {
            throw new IllegalArgumentException("Visitante não pode ser nulo.");
        }
        this.data = data;
        this.visitante = visitante;
        this.ativo = true;
        this.sequencia = sequencia;
    }

    public String getData() {
        return data;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public String getIdIngresso() {
        return String.format("%s seq %03d", data, sequencia);
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void cancelar() {
        this.ativo = false;
        System.out.println("Ingresso cancelado.");
    }

    public void reativar() {
        this.ativo = true;
        System.out.println("Ingresso reativado.");
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

    public double getPreco() {
        return (visitante instanceof Adulto) ? PRECO_ADULTO : PRECO_CRIANCA;
    }

    @Override
    public String toString() {
        return "Ingresso: " + sequencia + ", Data: " + data + ", Visitante: " + visitante.getNome() + ", Ativo: " + ativo;
    }
}
