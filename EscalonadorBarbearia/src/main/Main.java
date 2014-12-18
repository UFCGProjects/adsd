
package main;

import core.Barbearia;
import core.Escalonador;
import core.GeradorMisto;

import java.util.Scanner;

public class Main {

    private static Barbearia mBarbearia;
    private static Escalonador mEscalonador;

    public static void main(final String[] args) {
        final int timeDuration = 100;

        mBarbearia = new Barbearia(timeDuration);
        mEscalonador = new Escalonador(mBarbearia, new GeradorMisto(7, 10), timeDuration);

        new Thread(mBarbearia).start();
        new Thread(mEscalonador).start();

        final Scanner sc = new Scanner(System.in);

        if (sc.nextInt() == 1) {
            mBarbearia.setIsOpen(false);
        }

        sc.close();
    }

}
