package katas.codebreaker;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import katas.codebreaker.CodeBreaker;
import katas.codebreaker.ColorsCodeGenerator;
import katas.codebreaker.InputSystem;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CodeBreakerTest {

    private CodeBreaker game;
    @Mock
    private InputSystem inputSystem;
    @Mock
    private ColorsCodeGenerator generator;

    @Before
    public void setUp() {
        when(generator.generate(4, CodeBreaker.COLORS)).thenReturn("AAAA");
        game = new CodeBreaker(inputSystem, generator);
    }

    @Test
    public void play_one_round() {
        when(inputSystem.read()).thenReturn("AAAA");

        game.play();

        verify(inputSystem, times(1)).read();
    }

    @Test
    public void play_two_rounds() {
        when(inputSystem.read()).thenReturn("RRRA", "AAAA");

        game.play();

        verify(inputSystem, times(2)).read();
    }

}
