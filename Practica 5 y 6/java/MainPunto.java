import java.util.Scanner;

public class MainPunto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double menorDistancia = Doible.MAX_VALUE;
        int punto1 = -1, punto2 = -1;
        
        System.out.println("En este programa vamos a calcular la distancia entre puntos.");
        Punto3D[] puntos = new Punto3D[10];

        for (int i = 0; i < 10; i++) {
            System.out.println("Ingresa las coordenadas del punto " + (i + 1) + ":");
            System.out.print("X: ");
            double x = scanner.nextDouble();
            System.out.print("Y: ");
            double y = scanner.nextDouble();
            System.out.print("Z: ");
            double z = scanner.nextDouble();
            puntos[i] = new Punto3D(x, y, z);
        }

        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                double distancia = puntos[i].distanciaP(puntos[j]);
                if (distancia < menorDistancia) {
                    menorDistancia = distancia;
                    punto1 = i;
                    punto2 = j;
                }
            }
        }

        if (punto1 != -1 && punto2 != -1) {
            System.out.println("La menor distancia es entre el punto " + (punto1 + 1) + " y el punto " + (punto2 + 1));
            System.out.println("Distancia: " + menorDistancia + " unidades cubicas");
        } else {
            System.out.println("No se encontraron dos puntos para calcular la distancia.");
        }
    }
}
