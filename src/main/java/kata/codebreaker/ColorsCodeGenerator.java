package kata.codebreaker;

import java.util.List;
import java.util.Random;

public class ColorsCodeGenerator {

    private Random random = new Random();

    public String generate(int size, List<String> colors) {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < size; i++) {
            code.append(colors.get(random.nextInt(colors.size())));
        }
        return code.toString();
    }

}
