package modelo;

/**
 * Classe que representa uma Pessoa.
 */
public abstract class Pessoa {

    // Atributos
    /**
     * Id do aluno.
     */
    private int id;
    /**
     * Nome do aluno.
     */
    private String nome;
    /**
     * Idade do aluno.
     */
    private int idade;

    /**
     * Construtor de Objeto Vazio.
     */
    public Pessoa() {
        this(0, "", 0);
    }

    /**
     * Construtor de Objeto com parâmetro.
     *
     * @param id O id do aluno.
     * @param nome O nome do aluno.
     * @param idade A idade do aluno.
     */
    public Pessoa(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    // Métodos GET e SET
    /**
     * Recuperador do id do aluno.
     *
     * @return Um inteiro com o Id do aluno.
     */
    public int getId() {
        return id;
    }

    /**
     * Modifica o id do aluno.
     *
     * @param id Um inteiro com o id do aluno.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o nome do aluno.
     *
     * @return Uma string com o nome do aluno.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Modifica o nome do aluno.
     *
     * @param nome Uma string com o nome do aluno.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a idade do aluno.
     *
     * @return Um inteiro com a idade do aluno.
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Modifica a idade do aluno.
     *
     * @param idade Um inteiro com a idade do aluno.
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Retorna os dados da pessoa em uma string.
     *
     * @return Uma string com todos os dados da pessoa concatenado.
     */
    @Override
    public String toString() {
        return "id=" + id + ", nome=" + nome + ", idade=" + idade;
    }
}
