
package principal;

import controlador.ControladorVistaSplash;
import vista.VistaSplash;

/**
 *
 * @author 52375
 */
public class AppZapateria {
    public static void main(String[] args) {
        VistaSplash VistaSplash = new VistaSplash();
        ControladorVistaSplash CVS = new ControladorVistaSplash(VistaSplash);
    }
}
