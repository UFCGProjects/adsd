
package core;

import org.joda.time.Instant;

import utils.Utils;

import java.util.LinkedList;

public class Barbearia implements Runnable {

    private final LinkedList<Cliente> mClients;
    private int mCurrentId;
    private boolean mIsOpen;
    private final int mTimeDuration;

    public Barbearia(final int timeDuration) {
        mClients = new LinkedList<Cliente>();
        mCurrentId = 1;
        mTimeDuration = timeDuration;
    }

    public void addCliente(final Cliente c) {
        c.setId(mCurrentId++);
        mClients.add(c);

        Utils.log(getStatus() + "[CLIENT-ADD] \t[ID:" + c.getId() + "]");
    }

    public boolean getIsOpen() {
        return mIsOpen;
    }

    public void setIsOpen(final boolean isOpen) {
        mIsOpen = isOpen;
    }

    @Override
    public void run() {
        setIsOpen(true);

        Utils.log(getStatus() + "[BARBEARIA-START]");

        while (getIsOpen()) {

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

            Utils.log(getStatus() + "[CLIENT-START]\t[ID:" + c.getId() + "]\t[FINISH-AT:"
                    + Utils.formatTime(c.getTimeToFinish()) + "]");

            while (Instant.now().getMillis() < c.getTimeToFinish().getMillis()) {
                // Espera terminar o corte de cabelo
            }

            Utils.log(getStatus() + "[CLIENT-END] \t[ID:" + c.getId() + "]");

        }

        Utils.log(getStatus() + "[BARBEARIA-END]");
    }

    public String getStatus() {
        String status = "";

        for (int i = 0; i < mClients.size(); i++) {
            status += mClients.get(i).getId() + ",";
        }

        if (status.length() > 0) {
            status = "[" + status.substring(0, status.length() - 1) + "]";
        } else {
            status = "[]";
        }

        return String.format("%-20s", status);
    }
}
