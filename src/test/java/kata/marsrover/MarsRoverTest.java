package kata.marsrover;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

//You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.
//The rover receives a character array of commands.
//Implement commands that move the rover forward/backward (f,b).
//Implement commands that turn the rover left/right (l,r).
//Implement wrapping from one edge of the grid to another. (planets are spheres after all)
//Implement obstacle detection before each move to a new square. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point and reports the obstacle.
//Example: The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2)
//- 1x1, (0,0), N, f --> (0, 0), N
//- 1x1, (0,0), N, l --> (0, 0), W
//- 1x1, (0,0), W, nothing --> (0, 0), W
//- 1x1, (0,0), N, nothing --> (0, 0), N
//- 1x1, (0,0), N, r --> (0, 0), E
//- 1x1, (0,0), E, r --> (0, 0), S
//- 1x1, (0,0), N, b --> (0, 0), N
public class MarsRoverTest {

    private MarsRover marsRover;

    @Test
    public void should_move_to_position_0_0_N_when_move_fordward_in_1x1_grid_from_0_0_N() {
        //GIVEN
        marsRover = new MarsRover("N");
        char[] commands = {'f'};

        //WHEN
        marsRover.execute(commands);

        //EXPECT
        assertThat(marsRover.status().position(), is("0,0"));
        assertThat(marsRover.status().direction(), is("N"));
    }

    @Test
    public void should_move_to_position_0_0_W_when_rotate_left_in_1x1_grid_from_0_0_N() {
        //GIVEN
        marsRover = new MarsRover("N");
        char[] commands = {'l'};

        //WHEN
        marsRover.execute(commands);

        //EXPECT
        assertThat(marsRover.status().position(), is("0,0"));
        assertThat(marsRover.status().direction(), is("W"));
    }

    @Test
    public void should_move_to_position_0_0_W_when_nothing_in_1x1_grid_from_0_0_W() {
        //GIVEN
        marsRover = new MarsRover("W");
        char[] commands = {};

        //WHEN
        marsRover.execute(commands);

        //EXPECT
        assertThat(marsRover.status().position(), is("0,0"));
        assertThat(marsRover.status().direction(), is("W"));
    }

    @Test
    public void should_move_to_position_0_0_N_when_nothing_in_1x1_grid_from_0_0_N() {
        //GIVEN
        marsRover = new MarsRover("N");
        char[] commands = {};

        //WHEN
        marsRover.execute(commands);

        //EXPECT
        assertThat(marsRover.status().position(), is("0,0"));
        assertThat(marsRover.status().direction(), is("N"));
    }

    @Test
    public void should_move_to_position_0_0_E_when_rotate_right_in_1x1_grid_from_0_0_N() {
        //GIVEN
        marsRover = new MarsRover("N");
        char[] commands = {'r'};

        //WHEN
        marsRover.execute(commands);

        //EXPECT
        assertThat(marsRover.status().position(), is("0,0"));
        assertThat(marsRover.status().direction(), is("E"));
    }

    @Test
    public void should_move_to_position_0_0_S_when_rotate_right_in_1x1_grid_from_0_0_E() {
        //GIVEN
        marsRover = new MarsRover("E");
        char[] commands = {'r'};

        //WHEN
        marsRover.execute(commands);

        //EXPECT
        assertThat(marsRover.status().position(), is("0,0"));
        assertThat(marsRover.status().direction(), is("S"));
    }

}
