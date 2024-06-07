/**
 * Representa o registro de um visitante em uma atração do parque.
 */
public class RegistroAtracao {
    private Visitante visitante;
    private Atracao atracao;
    private String data;

    /**
     * Inicializa um registro de atração com visitante, atração e data.
     *
     * @param visitante Visitante que visitou a atração.
     * @param atracao Atração visitada.
     * @param data Data da visita.
     * @throws IllegalArgumentException se o visitante, a atração ou a data forem nulos ou se a data estiver vazia.
     */

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