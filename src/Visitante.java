import java.time.LocalDate;

public abstract class Visitante {
    private String nome;
    private int anoNascimento;

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