import java.time.LocalDate;
/**
 * Representa um visitante do parque.
 */
public abstract class Visitante {
    private String nome;
    private int anoNascimento;

    /**
     * Inicializa um visitante com nome e ano de nascimento.
     *
     * @param nome Nome do visitante.
     * @param anoNascimento Ano de nascimento do visitante.
     * @throws IllegalArgumentException se o nome for nulo ou vazio,
     * ou se o ano de nascimento for inválido.
     */
    public Visitante(String nome, int anoNascimento) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        if (anoNascimento < 1900 || anoNascimento > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Ano de nascimento inválido.");
        }
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }

    public String getNome() {
        return nome;
    }
    public int getAnoNascimento() {
        return anoNascimento;
    }
}