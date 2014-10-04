package katas.codebreaker;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import katas.codebreaker.ColorCodeValidator;

import org.junit.Test;

/*
A - A   --> X
A - I   --> void
AI - AV --> X
AI - AI --> XX
AI - VI --> X
AI - VV --> void
AI - VA --> *
AI - IV --> *
AI - IA --> **
AI - AA --> X
AIY - AAI --> X*
AIY - IBI --> *
 */
public class ColorsCodeValidatorTest {

    private ColorCodeValidator validator;

    @Test
    public void should_return_X_when_match_one_color_and_the_position() {
        validator = new ColorCodeValidator("A");
        assertThat(validator.getMatches("A"), is("X"));
    }

    @Test
    public void should_return_void_when_not_match_anything() {
        validator = new ColorCodeValidator("A");
        assertThat(validator.getMatches("I"), is(""));
    }

    @Test
    public void should_return_X_when_match_one_color_and_the_position_of_two_colors() {
        validator = new ColorCodeValidator("AI");
        assertThat(validator.getMatches("AV"), is("X"));
        assertThat(validator.getMatches("VI"), is("X"));
        assertThat(validator.getMatches("AA"), is("X"));
    }

    @Test
    public void should_return_XX_when_match_two_color_and_the_position_of_two_colors() {
        validator = new ColorCodeValidator("AI");
        assertThat(validator.getMatches("AI"), is("XX"));
    }

    @Test
    public void should_return_asteriks_when_match_one_color_but_not_the_position_of_two_colors() {
        validator = new ColorCodeValidator("AI");
        assertThat(validator.getMatches("VA"), is("*"));
        assertThat(validator.getMatches("IV"), is("*"));
    }

    @Test
    public void should_return_two_asteriks_when_match_two_color_but_not_the_position_of_two_colors() {
        validator = new ColorCodeValidator("AI");
        assertThat(validator.getMatches("IA"), is("**"));
    }

    @Test
    public void should_return_asteriks_and_X_when_match_two_color_but_not_the_position_of_one_for_two_colors() {
        validator = new ColorCodeValidator("AIY");
        assertThat(validator.getMatches("AAI"), is("X*"));
    }

    @Test
    public void should_return_asteriks_when_match_one_color_but_not_the_position() {
        validator = new ColorCodeValidator("AIY");
        assertThat(validator.getMatches("IBI"), is("*"));
    }

    @Test
    public void should_return_X_when_match_one_color_of_four() {
        validator = new ColorCodeValidator("AAAA");
        assertThat(validator.getMatches("RRRA"), is("X"));
    }

    @Test
    public void should_return_true_when_match_all_colors() {
        validator = new ColorCodeValidator("AIY");
        assertThat(validator.isValid("AIY"), is(true));
    }
}
