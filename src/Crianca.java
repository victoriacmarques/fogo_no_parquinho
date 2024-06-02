public class Crianca extends Visitante {
    private String nomeResponsavel;
    private String telefoneResponsavel;

    public Crianca(String nome, int anoNascimento, String nomeResponsavel, String telefoneResponsavel) {
        super(nome, anoNascimento);
        this.nomeResponsavel = nomeResponsavel;
        this.telefoneResponsavel = telefoneResponsavel;
    }
    @Override
    public String toString() {
        return getNome() + " (Criança)";
    }
}