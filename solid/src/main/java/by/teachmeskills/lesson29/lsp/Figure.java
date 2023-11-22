package by.teachmeskills.lesson29.lsp;

public class Figure {
    protected int a;
    protected int b;
    protected int c;
    public void setA(int a) {
        this.a = a;
    }
    public void setB(int b) {
        this.b = b;
    }
    public void setC(int c) {
        this.c = c;
    }
    public int getPerimeter() {
        return a + b + c;
    }
}
