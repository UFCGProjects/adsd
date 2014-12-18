
package core;

public class GeradorMultiplicativo extends Gerador {

    private final int k;
    private int xn;

    public GeradorMultiplicativo(final int seed, final int K) {
        super(seed);
        k = K;
        xn = seed;
    }

    @Override
    public int next() {
        final int xn1 = xn * k % m;

        xn = xn1;

        return xn1;
    }
}
