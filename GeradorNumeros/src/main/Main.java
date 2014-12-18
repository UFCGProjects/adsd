
package main;

import core.Gerador;
import core.GeradorAditivo;
import core.GeradorMisto;
import core.GeradorMultiplicativo;
import utils.WriteUtils;

/**
 * The Class Main2 is used to simply run without passing args on terminal.
 */
public class Main {

    private static final String ADITIVO = "aditivo";
    private static final String MULTIPLICATIVO = "multiplicativo";
    private static final String MISTO = "misto";

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final String metodo = args[0];
        final Integer seed = Integer.parseInt(args[1]);

        Gerador gerador = null;

        if (ADITIVO.equalsIgnoreCase(metodo)) {
            gerador = new GeradorAditivo(seed);
        } else if (MULTIPLICATIVO.equalsIgnoreCase(metodo)) {
            final Integer K = Integer.parseInt(args[2]);
            gerador = new GeradorMultiplicativo(seed, K);
        } else if (MISTO.equalsIgnoreCase(metodo)) {
            final Integer C = Integer.parseInt(args[2]);
            gerador = new GeradorMisto(seed, C);
        }

        if (gerador != null) {

            final WriteUtils writeUtils = new WriteUtils(metodo);

            for (int i = 0; i < 500; i++) {
                final int value = gerador.next();

                System.out.println(value);
                writeUtils.write(String.valueOf(value));
            }
        }
    }
}
