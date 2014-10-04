package katas.codebreaker;

import java.util.Arrays;
import java.util.List;

public class CodeBreaker {

    public static final List<String> COLORS = Arrays.asList("R", "A", "M", "V", "N", "I");

    private InputSystem inputSystem;
    private ColorsCodeGenerator colorsCodeGenerator;
    private ColorCodeValidator colorsCodeValidator;

    public CodeBreaker(InputSystem inputSystem, ColorsCodeGenerator codeGenerator) {
        this.inputSystem = inputSystem;
        this.colorsCodeGenerator = codeGenerator;
    }

    public void play() {
        colorsCodeValidator = new ColorCodeValidator(colorsCodeGenerator.generate(4, COLORS));
        String colorsCodeToCheck = "";
         do {
            colorsCodeToCheck = inputSystem.read();
            System.out.println("Matches: " + colorsCodeValidator.getMatches(colorsCodeToCheck));
        } while (!colorsCodeValidator.isValid(colorsCodeToCheck));
    }

}
