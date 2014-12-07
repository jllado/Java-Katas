package katas.primefactors;

/**
 * Created by jllado on 7/12/14.
 */
public class PrimeFactor {
    private final int factor;

    public PrimeFactor(int factor) {
        this.factor = factor;
    }

    public boolean isFactorOf(int number) {
        return number % this.factor == 0;
    }

    public int getInt() {
        return factor;
    }
}
