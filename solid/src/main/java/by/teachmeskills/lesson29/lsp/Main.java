package by.teachmeskills.lesson29.lsp;

public class Main {
    public static void main(String[] args) {
        Figure figure = new Figure();
        Triangle triangle = new Triangle();

        Calculator calculator = new Calculator();
        int figurePerimeter = calculator.calculatePerimeter(figure);
        int trianglePerimeter = calculator.calculatePerimeter(triangle);

        System.out.println("Shape area: " + figurePerimeter);
        System.out.println("Triangle area: " + trianglePerimeter);
    }
}
