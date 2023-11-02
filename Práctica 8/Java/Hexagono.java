public class Hexagono extends Figura {
    private double lado;

    public Hexagono(String color, double lado) {
        super(color);
        this.lado = lado;
    }

    @Override
    public double perimetro() {
        return 6 * lado;
    }

    @Override
    public double area() {
        return perimetro() * Math.pow(Math.pow(lado, 2) - Math.pow(lado / 2, 2), 0.5) / 2;
    }
}