package katas.fizzbuzz;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class FizzBuzzGameTest {

    private FizzBuzzGame fizzBuzzGame = new FizzBuzzGame();

    @Test
    public void play_1() {
        List<String> results = fizzBuzzGame.resultsPlayBy(1);

        assertThat(results.size(), is(1));
        assertThat(results.get(0), is("1"));
    }

    @Test
    public void play_2() {
        List<String> results = fizzBuzzGame.resultsPlayBy(2);

        assertThat(results.size(), is(2));
        assertThat(results.get(0), is("1"));
        assertThat(results.get(1), is("2"));
    }

    @Test
    public void play_3() {
        List<String> results = fizzBuzzGame.resultsPlayBy(3);

        assertThat(results.size(), is(3));
        assertThat(results.get(0), is("1"));
        assertThat(results.get(1), is("2"));
        assertThat(results.get(2), is("Fizz"));
    }

    @Test
    public void play_5() {
        List<String> results = fizzBuzzGame.resultsPlayBy(5);

        assertThat(results.size(), is(5));
        assertThat(results.get(0), is("1"));
        assertThat(results.get(1), is("2"));
        assertThat(results.get(2), is("Fizz"));
        assertThat(results.get(4), is("Buzz"));
    }

    @Test
    public void play_15() {
        List<String> results = fizzBuzzGame.resultsPlayBy(15);

        assertThat(results.size(), is(15));
        assertThat(results.get(0), is("1"));
        assertThat(results.get(1), is("2"));
        assertThat(results.get(2), is("Fizz"));
        assertThat(results.get(4), is("Buzz"));
        assertThat(results.get(14), is("FizzBuzz"));
    }

}
