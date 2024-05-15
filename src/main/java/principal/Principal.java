package principal;

import visao.FrmMenuPrincipal;

/**
 * Classe que possui a operação main do programa.
 *
 * Serve para dar inicio ao sistema.
 *
 */
public class Principal {

    /**
     * Método que inicia o programa.
     *
     * @param args Paràmetros do programa principal.
     */
    public static void main(String[] args) {
        // Instancia a interface gráfica
        FrmMenuPrincipal objetotela = new FrmMenuPrincipal();
        // Torna a janela visível
        objetotela.setVisible(true);
    }
}
