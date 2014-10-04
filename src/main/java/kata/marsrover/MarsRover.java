package kata.marsrover;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class MarsRover {

    private Status status;
    private static final List<String> directions = Arrays.asList("N", "E", "S", "W");
    private static final Map<Character, Integer> rotationMove = new HashMap<>();

    public MarsRover(String direction) {
        rotationMove.put('r', 1);
        rotationMove.put('l', -1 + directions.size());

        status = new Status();
        status.setDirection(direction);
    }

    public void execute(char[] commands) {
        if(commands.length == 0) {
            return;
        }

        if(commands[0] == 'r' || commands[0] == 'l') {
            char direction = commands[0];
            rotate(direction);
            return;
        }

    }

    private void rotate(char direction) {
        int index = directions.indexOf(status.direction());
        String nextDirection = directions.get((index + rotationMove.get(direction)) % directions.size());

        status.setDirection(nextDirection);
    }

    public Status status() {
        return status;
    }

}
