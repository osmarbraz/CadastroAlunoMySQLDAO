package modelo;

import dao.AlunoDAO;
import java.util.ArrayList;

/**
 * Classe que representa uma Aluno.
 */
public class Aluno extends Pessoa {

    /**
     * Curso que o aluno realiza.
     */
    private String curso;
    /**
     * Fase que o aluno se encontra.
     */
    private int fase;
    /**
     * Objeto dao manipulado pelo aluno.
     */
    private AlunoDAO dao;

    /**
     * Construtor de Objeto Vazio.
     */
    public Aluno() {
        this(0, "", 0, "", 0);
    }

    /**
     * Construtor com parâmetro.
     *
     * @param id Identificador do aluno.
     * @param nome Nome do aluno.
     * @param idade Idade do aluno.
     * @param curso Curso do aluno.
     * @param fase Fase do aluno.
     */
    public Aluno(int id, String nome, int idade, String curso, int fase) {
        super(id, nome, idade);
        this.curso = curso;
        this.fase = fase;
        this.dao = new AlunoDAO();
    }

    // Métodos GET e SET
    /**
     * Retorna o curso do aluno.
     *
     * @return Uma String com o nome do curso do aluno.
     */
    public String getCurso() {
        return curso;
    }

    /**
     * Modifica o curso do aluno.
     *
     * @param curso Uma string com o nome do curso do aluno.
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * Retorna a fase do aluno.
     *
     * @return Um inteiro com a fase do aluno.
     */
    public int getFase() {
        return fase;
    }

    /**
     * Modifica a fase do aluno.
     *
     * @param fase Um int com a fase do aluno.
     */
    public void setFase(int fase) {
        this.fase = fase;
    }

    /**
     * Retorna os dados do aluno em uma string.
     *
     * @return Uma string com todos os dados do aluno concatenado.
     */
    @Override
    public String toString() {
        return super.toString() + "curso=" + curso + ", fase=" + fase;
    }

    /*  ABAIXO OS MÉTODOS PARA USO JUNTO COM O DAO
        SIMULANDO A ESTRUTURA EM CAMADAS PARA USAR COM BANCOS DE DADOS.
     */
    /**
     * Retorna a Lista de Alunos(objetos).
     *
     * @return Um ArrayList com todos os Alunos.
     */
    public ArrayList<Aluno> getMinhaLista() {
        return dao.getMinhaLista();
    }

    /**
     * Insere um novo aluno.
     *
     * @param nome O nome do aluno.
     * @param idade A idade do aluno.
     * @param curso O curso do aluno
     * @param fase A fase do aluno.
     * @return Verdadeiro ou falso se conseguiu fazer a inclusão.
     */
    public boolean insertAlunoBD(String nome, int idade, String curso, int fase) {
        int id = this.maiorID() + 1;
        Aluno objeto = new Aluno(id, nome, idade, curso, fase);
        dao.insertAlunoBD(objeto);
        return true;
    }

    /**
     * Deleta um aluno especÍfico pelo seu ID.
     *
     * @param id Id do aluno a ser excluído.
     * @return Verdadeiro ou falso se conseguiu fazer a exclusão.
     */
    public boolean deleteAlunoBD(int id) {
        dao.deleteAlunoBD(id);
        return true;
    }

    /**
     * Edita um aluno especÍfico pelo seu ID.
     *
     * @param id O id do aluno.
     * @param nome O nome do aluno.
     * @param idade A idade do aluno.
     * @param curso O curso do aluno
     * @param fase A fase do aluno.
     * @return Verdadeiro ou falso se conseguiu fazer a inclusão.
     */
    public boolean updateAlunoBD(int id, String nome, int idade, String curso, int fase) {
        Aluno objeto = new Aluno(id, nome, idade, curso, fase);
        dao.updateAlunoBD(objeto);
        return true;
    }

    /**
     * Carrega dados de um aluno especÍfico pelo seu ID.
     *
     * @param id O id do aluno a ser carregado.
     * @return Um objeto aluno preenchido.
     */
    public Aluno carregaAluno(int id) {
        return dao.carregaAluno(id);
    }

    /**
     * Retorna o maior ID da nossa base de dados.
     *
     * @return Um inteiro com o maior valor de Id de aluno.
     */
    public int maiorID() {
        return dao.maiorID();
    }
}
