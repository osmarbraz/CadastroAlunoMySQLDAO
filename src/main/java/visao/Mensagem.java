package visao;

/**
 * Classe que trata as mensagens de exceções do sistema.
 */
public class Mensagem extends Exception {

    /**
     * Construtor com parâmetro.
     *
     * @param mensagem Uma string com a mensagem.
     */
    public Mensagem(String mensagem) {
        super(mensagem);
    }
}
