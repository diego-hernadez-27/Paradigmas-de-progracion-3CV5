import java.io.*;
import java.util.*;

public class Prueba {

    public static void main(String[] args) throws IOException {
        Reader reader = new InputStreamReader(System.in);
        LecturaNumeros ln = new LecturaNumeros(reader);
        Scanner br = new Scanner((System.in));
        int entero; double doble; Integer objEntero; String mensaje, bandera = "y";
        
        while (bandera.equals("y")) {
            System.out.println("Menu de Lectura Numerica:");
            System.out.println("1. Leer un entero.");
            System.out.println("2. Leer un entero con mensaje.");
            System.out.println("3. Leer un Integer.");
            System.out.println("4. Leer un double.");
            System.out.println("5. Leer un double con mensaje.");
            System.out.println("6. Salir.");
            System.out.print("Seleccione una opcion: ");

            int opcion = br.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un entero: ");
                    entero = ln.readInt();
                    System.out.println("Numero entero leido: " + entero);
                    br.nextLine();
                break;
                case 2:
                    System.out.print("Ingrese un mensaje: ");
                    br.nextLine();
                    mensaje = br.nextLine();
                    entero = ln.readInt(mensaje);
                    System.out.println("Numero entero leido: " + entero);
                break;
                case 3:
                    System.out.print("Ingrese un Integer: ");
                    objEntero = ln.readInteger();
                    System.out.println("Numero como objeto Integer leido: " + objEntero);
                    br.nextLine();
                break;
                case 4:
                    System.out.print("Ingrese un double: ");
                    doble = ln.readDouble();
                    System.out.println("Numero double leido: " + doble);
                    br.nextLine();
                break;
                case 5:
                    System.out.print("Ingrese un mensaje: ");
                    br.nextLine();
                    mensaje = br.nextLine();
                    doble = ln.readDouble(mensaje);
                    System.out.println("Numero double leido: " + doble);
                break;
                case 6:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                break;
                default:
                    System.out.println("Opcion no valida. Por favor, elija una opción valida.");
            }
            
            System.out.println("¿Quieres volver volver a empezar? (y/n)");
            bandera = br.nextLine();
        } 
    }
}