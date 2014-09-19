package katas.fizzbuzz;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/*
 0 -> ?
 1 -> 1
 2 -> 2
 3 -> Fizz
 4 -> 4
 5 -> Buzz
 6 -> Fizz
 7 -> 7
 15 -> FizzBuzz
 */
public class FizzBuzzTest {

    private FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void return_1_when_1() {
        assertThat(fizzBuzz.getWord(1), is("1"));
    }

    @Test
    public void return_2_when_2() {
        assertThat(fizzBuzz.getWord(2), is("2"));
    }

    @Test
    public void return_Fizz_when_3() {
        assertThat(fizzBuzz.getWord(3), is("Fizz"));
    }

    @Test
    public void return_Buzz_when_5() {
        assertThat(fizzBuzz.getWord(5), is("Buzz"));
    }

    @Test
    public void return_Buzz_when_6() {
        assertThat(fizzBuzz.getWord(6), is("Fizz"));
    }

    @Test
    public void return_FizzBuzz_when_15() {
        assertThat(fizzBuzz.getWord(15), is("FizzBuzz"));
    }

}
