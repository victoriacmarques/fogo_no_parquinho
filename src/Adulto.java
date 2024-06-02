public class Adulto extends Visitante {
    private String telefone;

    public Adulto(String nome, int anoNascimento, String telefone) {
        super(nome, anoNascimento);
        if (telefone == null || !telefone.matches("\\d{9}")) {
            throw new IllegalArgumentException("Telefone inválido.");
        }
        this.telefone = telefone;
    }
    @Override
    public String toString() {
        return getNome() + " (Adulto)";
    }
}
