package kata.codebreaker;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ColorsCodeGeneratorTest {

    private ColorsCodeGenerator generator;
    private List<String> colors = Arrays.asList("R", "A", "M", "V", "N", "I");

    @Before
    public void setUp() {
        generator = new ColorsCodeGenerator();
    }

    @Test
    public void should_return_code_one_color() {
        String colorsCode = generator.generate(1, colors);

        assertThat(colorsCode.length(), is(1));
        assertThat(colors, hasItem(String.valueOf(colorsCode.charAt(0))));
    }

    @Test
    public void should_return_code_two_colors() {
        String colorsCode = generator.generate(2, colors);

        assertThat(colorsCode.length(), is(2));
        assertThat(colors, hasItems(String.valueOf(colorsCode.charAt(0)), String.valueOf(colorsCode.charAt(1))));
    }

    @Test
    public void not_always_generate_same_code() {
        boolean differentCode = false;
        for (int i = 0; i < 10; i++) {
            if (!generator.generate(2, colors).equals(generator.generate(2, colors))) {
                differentCode = true;
                break;
            }

        }
        assertThat(differentCode, is(true));
    }

}
