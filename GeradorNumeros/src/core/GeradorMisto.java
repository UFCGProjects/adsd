
package core;

public class GeradorMisto extends Gerador {

    private int xn;
    private final int c;
    private int xnk;
    private int k;

    public GeradorMisto(final int seed, final int C) {
        super(seed);
        xn = seed;
        xnk = seed;
        c = C;
        k = 1;
    }

    @Override
    public int next() {
        final int xn1 = (k++ * (xn + xnk) + c) % m;

        xnk = xn;
        xn = xn1;

        return xn1;
    }
}
