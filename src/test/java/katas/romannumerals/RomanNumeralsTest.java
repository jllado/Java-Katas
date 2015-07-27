package katas.romannumerals;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by jllado on 27/07/15.
 */
/*
1 - I
2 - II
5 - V
5 - IV
6 - VI
9 - IX
10 - X
 */
public class RomanNumeralsTest {

    @Test
    public void should_return_I_given_1() throws Exception {
        assertThat(getRomanNumeral(1), is("I"));
    }

    @Test
    public void should_return_II_given_2() throws Exception {
        assertThat(getRomanNumeral(2), is("II"));
    }

    @Test
    public void should_return_V_given_5() throws Exception {
        assertThat(getRomanNumeral(5), is("V"));
    }

    @Test
    public void should_return_IV_given_4() throws Exception {
        assertThat(getRomanNumeral(4), is("IV"));
    }

    @Test
    public void should_return_VI_given_6() throws Exception {
        assertThat(getRomanNumeral(6), is("VI"));
    }

    private String getRomanNumeral(int i) {
        return new RomanNumeral(i).getValue();
    }
}
