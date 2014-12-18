
package core;

import org.joda.time.Instant;

public class Escalonador implements Runnable {

    private final Barbearia mBarbearia;
    private Cliente mNextCliente;
    private final Gerador mGerador;
    private final int mTimeDuration;

    public Escalonador(final Barbearia barbearia, final Gerador gerador, final int timeDuration) {
        mBarbearia = barbearia;
        mGerador = gerador;
        mTimeDuration = timeDuration;
    }

    @Override
    public void run() {

        while (mBarbearia.getIsOpen()) {
            mNextCliente = new Cliente(mGerador.next());

            final Instant timeToArrive = Instant.now().plus(mGerador.next() * mTimeDuration);
            // Utils.log("[E] [TIME_NEXT] " + Utils.formatTime(timeToArrive));

            while (Instant.now().getMillis() < timeToArrive.getMillis()) {
                // Espera terminar o corte de cabelo
            }

            mBarbearia.addCliente(mNextCliente);
        }
    }

}
