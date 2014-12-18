
package core;

import org.joda.time.Instant;

import utils.Utils;

import java.util.LinkedList;

public class Barbearia implements Runnable {

    private final LinkedList<Cliente> mClients;
    private int mCurrentId;
    private int mClienteCortando;
    private final int mTimeDuration;

    public Barbearia(final int timeDuration) {
        mClients = new LinkedList<Cliente>();
        mCurrentId = 1;
        mTimeDuration = timeDuration;
        mClienteCortando = 0;
    }

    public void addCliente(final Cliente c) {
        c.setId(mCurrentId++);
        mClients.add(c);

        if (mClienteCortando == 0) {
            Utils.log("C-ADD", getQueue(), "");
        } else {
            Utils.log("C-ADD", getQueue(), String.valueOf(mClienteCortando));
        }
    }

    public String getQueue() {
        if (mClients.size() == 0) {
            return "";
        }

        String status = "";

        for (int i = 0; i < mClients.size(); i++) {
            status += mClients.get(i).getId() + ",";
        }

        return status.substring(0, status.length() - 1);
    }

    @Override
    public void run() {
        Utils.log("EVENT", "QUEUE", "CLIENTE_BARBEIRO", "OTHERS");
        Utils.log("START", "", "");

        while (true) {

            while (mClients.size() <= 0) {
                // Espera cliente chegar...
                try {
                    Thread.sleep(5);
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                }
            }

            final Cliente c = mClients.pop();
            c.setTimeToFinish(Instant.now().plus(c.getDuration() * mTimeDuration));
            mClienteCortando = c.getId();

            Utils.log("C-START", getQueue(), String.valueOf(mClienteCortando), "FINISH-AT:"
                    + Utils.formatTime(c.getTimeToFinish()));

            while (Instant.now().getMillis() < c.getTimeToFinish().getMillis()) {
                // Espera terminar o corte de cabelo
            }

            Utils.log("C-END", getQueue(), "");

        }

    }

}
