package modelo;

import dao.AlunoDAO;
import java.util.ArrayList;

public class Aluno extends Pessoa {

    // Atributos
    private String curso;
    private int fase;
    AlunoDAO dao;

    // Construtor de Objeto Vazio
    public Aluno() {
        this(0, "", 0, "", 0);
    }

    // Construtor com parâmetro
    public Aluno(int id, String nome, int idade, String curso, int fase) {
        super(id, nome, idade);
        this.curso = curso;
        this.fase = fase;
        dao = new AlunoDAO();
    }

    // Métodos GET e SET
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    @Override
    public String toString() {
        return super.toString() + "curso=" + curso + ", fase=" + fase;
    }

    /*  ABAIXO OS MéTODOS PARA USO JUNTO COM O DAO
        SIMULANDO A ESTRUTURA EM CAMADAS PARA USAR COM BANCOS DE DADOS.
     */
    // Retorna a Lista de Alunos(objetos)
    public ArrayList getMinhaLista() {
        return dao.getMinhaLista();
    }

    // Cadastra novo aluno
    public boolean InsertAlunoBD(String nome, int idade, String curso, int fase) {
        int id = this.maiorID() + 1;
        Aluno objeto = new Aluno(id, nome, idade, curso, fase);
        dao.insertAlunoBD(objeto);
        return true;

    }

    // Deleta um aluno especÍfico pelo seu campo ID
    public boolean deleteAlunoBD(int id) {
        dao.deleteAlunoBD(id);
        return true;
    }

    // Edita um aluno especÍfico pelo seu campo ID
    public boolean updateAlunoBD(int id, String nome, int idade, String curso, int fase) {
        Aluno objeto = new Aluno(id, nome, idade, curso, fase);
        dao.updateAlunoBD(objeto);
        return true;
    }

    // carrega dados de um aluno especÍfico pelo seu ID
    public Aluno carregaAluno(int id) {
        return dao.carregaAluno(id);
    }

    // retorna o maior ID da nossa base de dados
    public int maiorID() {
        return dao.maiorID();
    }
}
