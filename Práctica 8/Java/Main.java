public class Main {
    public static void main(String[] args) {
        Figura[] figuras = new Figura[4];
        figuras[0] = new Triangulo("Rojo", 3, 4, 5);
        figuras[1] = new Circulo("Azul", 2.5);
        figuras[2] = new Rectangulo("Verde", 4, 6);
        figuras[3] = new Hexagono("Amarillo", 4);

        for (Figura figura : figuras) {
            System.out.println("Color: " + figura.getColor());
            System.out.println("Perimetro: " + figura.perimetro());
            System.out.println("Area: " + figura.area());
            System.out.println();
        }
    }
}