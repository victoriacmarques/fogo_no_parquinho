/**
 * Representa um visitante criança do parque.
 */
public class Crianca extends Visitante {
    private String nomeResponsavel;
    private String telefoneResponsavel;

    /**
     * Inicializa uma criança com nome, ano de nascimento, nome do responsável e telefone do responsável.
     *
     * @param nome Nome da criança.
     * @param anoNascimento Ano de nascimento da criança.
     * @param nomeResponsavel Nome do responsável pela criança.
     * @param telefoneResponsavel Telefone do responsável pela criança.
     * @throws IllegalArgumentException se o nome do responsável ou o telefone do responsável forem nulos ou inválidos.
     */
    
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