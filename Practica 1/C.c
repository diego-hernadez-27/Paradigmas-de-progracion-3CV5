/* Incluir las bibliotecas */
#include <stdio.h>

/* Definir las funciones de las operaciones */

int factorial(int num1) {
    int aux = num1, res = 1;

    for(int i = 0; i < aux; i++){
        res = res * num1;  
        num1--;  
    }
    
  return res;
}

int division(int num1, int num2) {
    int res = 0;  
  
    do{
        num1 = num1 -  num2;
        /*printf("\n%i", num2);*/
        res++;
    } while(num1 >= num2);
    
    return res;
}

int multiplicacion(int num1, int num2) {
    int res = 0;  
  
    for(int i = 0; i < num2; i++){
        res = res + num1;    
    }
    
    return res;
}

/* Mostrar el menú en pantalla */
void mostrar_menu() {
    printf("Seleccione una operación:\n");
    printf("1. Factorial\n");
    printf("2. División\n");
    printf("3. Multiplicación\n");
    printf("4. Salir\n");
}

int main() {
    int opcion, num1, num2;

    do {
        mostrar_menu();
        printf("Ingrese el número de la operación que desea realizar: ");
        scanf("%i", &opcion);
    
        switch (opcion) {
            case 1:
                printf("Ingrese un número entero positivo: ");
                scanf("%i", &num1);

                printf("El factorial de %d es %d\n", num1, factorial(num1));
            break;
            case 2:
                printf("Ingrese el primer número: ");
                scanf("%i", &num1);
                printf("Ingrese el segundo número: ");
                scanf("%i", &num2);
    
                if (num2 == 0) {
                    printf("No se puede dividir por cero\n");
                } else {
                    printf("La división de %i y %i es %i\n", num1, num2, division(num1, num2));
                }
            break;
            case 3:
                printf("Ingrese el primer número: ");
                scanf("%i", &num1);
                printf("Ingrese el segundo número: ");
                scanf("%i", &num2);

                printf("La multiplicación de %i y %i es %i\n", num1, num2, multiplicacion(num1, num2));
            break;
            case 4:
                printf("Gracias por usar este programa\n");
                break;
            default:
                printf("Opción no válida\n");
        }
    } while (opcion != 4);

    return 0;
}
            