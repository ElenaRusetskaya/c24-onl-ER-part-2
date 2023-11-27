package by.teachmeskills.lesson29.lsp;

public class Calculator {
    public int calculatePerimeter(Figure figure) {
        figure.setA(10);
        figure.setB(20);
        figure.setC(30);
        return figure.getPerimeter();
    }
}
