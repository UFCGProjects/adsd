
package core;

import org.joda.time.Instant;

public class Cliente {

    private final int mDuration;
    private Instant mTimeToFinish;
    private int mId;

    public Cliente(final int duration) {
        mDuration = duration;
    }

    /**
     * @return the mDuration
     */
    public int getDuration() {
        return mDuration;
    }

    public void setTimeToFinish(final Instant time) {
        mTimeToFinish = time;
    }

    public Instant getTimeToFinish() {
        return mTimeToFinish;
    }

    public void setId(final int id) {
        mId = id;
    }

    public int getId() {
        return mId;
    }

}
