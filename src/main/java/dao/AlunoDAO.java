package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Aluno;

/**
 * Realiza a persistência de dados.
 */
public class AlunoDAO {

    //Utilizado para retornar uma lista de alunos.
    public ArrayList<Aluno> minhaLista = new ArrayList<>();

    /**
     * Retorna a Lista de Alunos(objetos)
     * @return Uma lista com os alunos.
     */
    public ArrayList<Aluno> getMinhaLista() {

        minhaLista.clear(); // Limpa nosso ArrayList

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_alunos");
            while (res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nome");
                int idade = res.getInt("idade");
                String curso = res.getString("curso");
                int fase = res.getInt("fase");

                Aluno objeto = new Aluno(id, nome, idade, curso, fase);

                minhaLista.add(objeto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return minhaLista;
    }

    /**
     * Modificado de minhaLista.
     * @param minhaLista Uma lista com os alunos.
     */
    public void setMinhaLista(ArrayList<Aluno> minhaLista) {
        this.minhaLista = minhaLista;
    }

    /**
     * Retorna o maior id de um aluno.
     * @return Um inteiro com o maior id de aluno.
     */
    public int maiorId() {
        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_alunos");
            res.next();
            maiorID = res.getInt("id");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return maiorID;
    }

    /**
     * Retorna uma conexão com o banco de dados.
     * @return Uma conexão com o banco de dados.
     */
    public Connection getConexao() {

        Connection connection = null;  //instância da conexão
        try {
            // Carregamento do JDBC Driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            // Configurar a conexão
            String server = "localhost"; //caminho do MySQL
            String database = "db_alunos";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "root";

            connection = DriverManager.getConnection(url, user, password);
            // Testando..
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NÃO CONECTADO!");
            }
            return connection;

        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver nao foi encontrado. " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
            return null;
        }
    }

    /**
     * Cadastra um novo aluno.
     * @param objeto Um aluno a ser inserido no banco de dados.
     * @return Verdadeiro e falso se incluiu o aluno no banco de dados.
     */
    public boolean inserirAlunoBD(Aluno objeto) {        
        try {
            String sql = "INSERT INTO tb_alunos(id,nome,idade,curso,fase) VALUES(?,?,?,?,?)";
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setInt(3, objeto.getIdade());
            stmt.setString(4, objeto.getCurso());
            stmt.setInt(5, objeto.getFase());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Deleta um aluno específico pelo seu campo ID
     * 
     * @param id Id do aluno a ser apagado.
     * @return Verdadeiro ou falso se apagou o aluno com o id especificado.
     */
    public boolean apagarAlunoBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_alunos WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return true;
    }

    /**
     * Edita um aluno específico pelo seu campo ID
     * @param objeto Um objeto aluno a ser atualizado.
     * @return Verdadeiro ou falso se atualizou o aluno.
     */
    public boolean atualizarAlunoBD(Aluno objeto) {

        String sql = "UPDATE tb_alunos set nome = ? ,idade = ? ,curso = ? ,fase = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setInt(2, objeto.getIdade());
            stmt.setString(3, objeto.getCurso());
            stmt.setInt(4, objeto.getFase());
            stmt.setInt(5, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Carrega um aluno pelo ID
     * @param id O id do aluno a ser carregado.
     * @return Um objeto aluno preenchido do banco de dados.
     */
    public Aluno carregarAluno(int id) {
        Aluno objeto = new Aluno();
        objeto.setId(id);
        try {
            Statement stmt = this.getConexao().createStatement();

            ResultSet res = stmt.executeQuery("SELECT * FROM tb_alunos WHERE id = " + id);
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setIdade(res.getInt("idade"));
            objeto.setCurso(res.getString("curso"));
            objeto.setFase(res.getInt("fase"));

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }
}
