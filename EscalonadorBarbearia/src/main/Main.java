
package main;

import core.Barbearia;
import core.Escalonador;
import core.GeradorMisto;

public class Main {

    private static Barbearia mBarbearia;
    private static Escalonador mEscalonador;

    public static void main(final String[] args) {
        final int timeDuration = 10;

        mBarbearia = new Barbearia(timeDuration);
        mEscalonador = new Escalonador(mBarbearia, new GeradorMisto(97, 83), timeDuration);

        new Thread(mBarbearia).start();
        new Thread(mEscalonador).start();

    }

}
