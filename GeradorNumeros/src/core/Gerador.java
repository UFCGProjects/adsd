
package core;

public abstract class Gerador {

    // m - múltiplo de 2 (geralmente, # bits da palavra do computador)
    public final int m = 64;

    // X0 - primeiro numero
    protected final int mSeed;

    public Gerador(final int seed) {
        mSeed = seed;
    }

    public abstract int next();
}
