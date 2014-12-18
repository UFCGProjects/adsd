
package core;

public class GeradorAditivo extends Gerador {

    private int xn;
    private int xnk;

    public GeradorAditivo(final int seed) {
        super(seed);
        xn = seed;
        xnk = seed;
    }

    @Override
    public int next() {
        final int xn1 = (xn + xnk) % m;

        xnk = xn;
        xn = xn1;

        return xn1;
    }
}
