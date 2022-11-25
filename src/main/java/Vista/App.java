
package Vista;

import controlador.ControladorPrincipal;

public class App {
    public static void main(String[] args){
        ControladorPrincipal vista = new ControladorPrincipal(new frmPrincipal());
        vista.iniciar();
    }
}
        
