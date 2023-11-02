public class Triangulo extends Figura {
    private double lado1;
    private double lado2;
    private double lado3;

    public Triangulo(String color, double lado1, double lado2, double lado3) {
        super(color);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    @Override
    public double perimetro() {
        return lado1 + lado2 + lado3;
    }

    @Override
    public double area() {
        double semiperimeto = perimetro() / 2;
        return Math.pow(semiperimeto * (semiperimeto - lado1) * (semiperimeto - lado2) * (semiperimeto - lado3), 0.5);
    }
}