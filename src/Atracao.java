/**
 * Enumeração que representa as atrações do parque.
 */

public enum Atracao {
    MONTANHA_RUSSA("Montanha-russa"),
    RODA_GIGANTE("Roda-gigante"),
    BARCO_VIKING("Barco Viking"),
    CARRO_CHOQUE("Carro-choque"),
    TREM_FANTASMA("Trem-fantasma");

    private String nome;

    /**
     * Inicializa uma atração com o nome fornecido.
     *
     * @param nome Nome da atração.
     * @throws IllegalArgumentException se o nome for nulo ou vazio.
     */

    Atracao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
