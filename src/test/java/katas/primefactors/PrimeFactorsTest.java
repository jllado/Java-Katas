package katas.primefactors;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;

/*
TODO
2 --> 2
3 --> 3
5 --> 5
6 --> 2, 3
4 --> 2, 2
7 --> 7
8 --> 2, 2, 2
9 --> 3, 3
10 --> 2, 5
11 --> 11
12 --> 2, 2, 3
13 --> 13
14 --> 2, 7
15 --> 3, 5
16 --> 2, 3, 3
1 --> empty
*/
public class PrimeFactorsTest {

    @Test
    public void should_return_2_when_2() throws Exception {
        assertThat(generatePrimeFactors(2), contains(2));
    }

    @Test
    public void should_return_3_when_3() throws Exception {
        assertThat(generatePrimeFactors(3), contains(3));
    }

    @Test
    public void should_return_5_when_5() throws Exception {
        assertThat(generatePrimeFactors(5), contains(5));
    }

    @Test
    public void should_return_2_3_when_6() throws Exception {
        assertThat(generatePrimeFactors(6), contains(2, 3));
    }

    @Test
    public void should_return_2_2_when_4() throws Exception {
        assertThat(generatePrimeFactors(4), contains(2, 2));
    }

    @Test
    public void should_return_7_when_7() throws Exception {
        assertThat(generatePrimeFactors(7), contains(7));
    }

    @Test
    public void should_return_2_2_3_when_12() throws Exception {
        assertThat(generatePrimeFactors(12), contains(2, 2, 3));
    }

    @Test
    public void should_return_13_when_13() throws Exception {
        assertThat(generatePrimeFactors(13), contains(13));
    }

    @Test
    public void should_return_empty_when_1() throws Exception {
        assertThat(generatePrimeFactors(1), empty());
    }

    private List<Integer> generatePrimeFactors(int number) {
        PrimeFactors primeFactors = new PrimeFactors(number);
        return primeFactors.list();
    }
}
