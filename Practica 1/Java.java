// Importar las bibliotecas
import java.util.Scanner;

// Definir la clase
public class Java {
    // Definir las funciones de las operaciones
    public static int factorial(int num1) {
        int aux = num1, res = 1;

        for(int i = 0; i < aux; i++){
            res = res * num1;  
            num1--;  
        }

        return res;
    }

    public static int division(int num1, int num2) {
        int res = 0;  

        do{
            num1 = num1 -  num2;
            res++;
        } while(num1 >= num2);

        return res;
    }

    public static int multiplicacion(int num1, int num2) {
        int res = 0;  

        for(int i = 0; i < num2; i++){
            res = res + num1;    
        }

        return res;
    }

    // Definir el método principal
    
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario 
        Scanner s = new Scanner(System.in);
        int opcion, num1, num2;
        
        // Mostrar el menú en pantalla
        do {
            System.out.println("Seleccione una operación:");
            System.out.println("1. Factorial");
            System.out.println("2. División");
            System.out.println("3. Multiplicación");
            System.out.println("4. Salir");
            System.out.print("Ingrese el número de la operación que desea realizar: ");
            opcion = s.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un número entero positivo: ");
                    num1 = s.nextInt();
                    
                    System.out.println("El factorial de " + num1 + " es " + factorial(num1));
                break;
                case 2:
                    System.out.print("Ingrese el primer número: ");
                    num1 = s.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    num2 = s.nextInt();
                    
                    if (num2 == 0) {
                        System.out.println("No se puede dividir por cero");
                    } else {
                        System.out.println("La división de " + num1 + " y " + num2 + " es " + division(num1, num2));
                    }
                break;
                case 3:
                    System.out.print("Ingrese el primer número: ");
                    num1 = s.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    num2 = s.nextInt();
                    
                    System.out.println("La multiplicación de " + num1 + " y " + num2 + " es " + multiplicacion(num1, num2));
                break;
                case 4:
                    System.out.println("Gracias por usar este programa");
                break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 4);
        
        s.close(); // Cerrar el objeto Scanner
    }    
}