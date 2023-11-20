package by.teachmeskills.lesson29.lsp;

class Triangle {
    private int a;
    private int b;
    private int c;
    public Triangle(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public void setA (int a) {
        this.a = a;
    }
    public void setB(int b) {
        this.b = b;
    }
    public void setC(int c) {
        this.c = c;
    }
    double perimeter() {
        return this.a + this.b + this.c;
    }
}
