public enum Atracao {
    MONTANHA_RUSSA("Montanha-russa"),
    RODA_GIGANTE("Roda-gigante"),
    BARCO_VIKING("Barco Viking"),
    CARRO_CHOQUE("Carro-choque"),
    TREM_FANTASMA("Trem-fantasma");

    private String nome;

    Atracao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
