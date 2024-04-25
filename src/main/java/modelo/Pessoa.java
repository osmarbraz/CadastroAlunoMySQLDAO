package modelo;

public abstract class Pessoa {

    // Atributos
    private int id;
    private String nome;
    private int idade;

    // Construtor de Objeto Vazio
    public Pessoa() {
        this(0, "", 0);
    }

    // Construtor de Objeto com parâmetro
    public Pessoa(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    // Métodos GET e SET
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "id=" + id + ", nome=" + nome + ", idade=" + idade;
    }
}
