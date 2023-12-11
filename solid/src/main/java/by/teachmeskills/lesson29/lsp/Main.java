package by.teachmeskills.lesson29.lsp;

import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Main.class));
    public static void main(String[] args) {
        Figure figure = new Figure();
        Triangle triangle = new Triangle();

        Calculator calculator = new Calculator();
        int figurePerimeter = calculator.calculatePerimeter(figure);
        int trianglePerimeter = calculator.calculatePerimeter(triangle);

        //System.out.println("Shape area: " + figurePerimeter);
        //System.out.println("Triangle area: " + trianglePerimeter);
        LOGGER.info("Shape area: " + figurePerimeter);
        LOGGER.info("Triangle area: " + trianglePerimeter);
    }
}
