/**
 * Representa um visitante adulto do parque.
 */
public class Adulto extends Visitante {
    private String telefone;

    /**
     * Inicializa um visitante adulto com nome, ano de nascimento e telefone.
     *
     * @param nome Nome do visitante.
     * @param anoNascimento Ano de nascimento do visitante.
     * @param telefone Telefone do visitante.
     * @throws IllegalArgumentException se o telefone for nulo ou inválido.
     */
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
