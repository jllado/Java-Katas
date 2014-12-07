package katas.primefactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    private final int value;

    public PrimeFactors(int value) {
        this.value = value;
    }

    public List<Integer> list() {
        return loadPrimeFactorsOf(this.value);
    }

    private List<Integer> loadPrimeFactorsOf(int number) {
        List<Integer> primeFactors = new ArrayList<>();
        if (number != 1) {
            PrimeFactor firstPrimeFactor = getFirstPrimeFactorOf(number);
            primeFactors.add(firstPrimeFactor.getInt());
            primeFactors.addAll(loadPrimeFactorsOf(number / firstPrimeFactor.getInt()));
        }
        return primeFactors;
    }

    private PrimeFactor getFirstPrimeFactorOf(int number) {
        for (int j = 2; j <= number; j++) {
            PrimeFactor primeFactor = new PrimeFactor(j);
            if (primeFactor.isFactorOf(number))
                return primeFactor;
        }
        return new PrimeFactor(number);
    }
}