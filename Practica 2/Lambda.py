# Código por Hernández Reyes Diego Alberto

# Funciones Lambda
a_mayuscula_lambda = lambda x: x.upper()

cubo_lambda = lambda x: x ** 3

cuadratica_res1 = lambda a, b, c: (-b + (b ** 2 - 4 * a * c) ** 0.5) / (2 * a)

cuadratica_res2 = lambda a, b, c: (-b - (b ** 2 - 4 * a * c) ** 0.5) / (2 * a)

# Funciones normales
def a_mayuscula(cadena):
    return cadena.upper()

def cubo(num):
    return num ** 3

# Mostrar el menú en pantalla
continuar = "y"

while continuar == "y":    
    print("Seleccione una tarea a realizar:")
    print("1. Pasar de minusculas a mayusculas")
    print("2. Cubo de un numero")
    print("3. Solución de una ecuación cuadrada")
    print("4. Salir")
    
    opcion = input("Ingrese el número de la tarea que desea realizar: ")
    
    if opcion == "1":
        cadena = input("Ingrese algo con minusculas: ")
        
        while continuar == "y":
            print("Seleccione el tipo de función:")
            print("1. Función normal")
            print("2. Función lambda")
            opcion = input("Ingrese el número de la fuinción que quiera usar: ")
            
            if opcion == "1":
                cadena = a_mayuscula_lambda(cadena)
                continuar = "n"
            elif opcion == "2":
                cadena = a_mayuscula(cadena)
                continuar = "n"
            else:
                print("Opción no válida, intentelo otra vez")
                continuar = "y"
                
        print(f"La cadena en mayúsculas es: {cadena}")
    elif opcion == "2":
        num = float(input("Ingrese el número: "))
        res = float(0)
    
        while continuar == "y":
            print("Seleccione el tipo de función:")
            print("1. Función normal")
            print("2. Función lambda")
            opcion = input("Ingrese el número de la fuinción que quiera usar: ")

            if opcion == "1":
                res = cubo_lambda(num)
                continuar = "n"
            elif opcion == "2":
                res = cubo(num)
                continuar = "n"
            else:
                print("Opción no válida, intentelo otra vez")
                continuar = "y"
                
        print(f"El cubo de {num} es {res}")
    elif opcion == "3":
        num1 = float(input("Ingrese el número del coeficiente cuadratico: "))
        num2 = float(input("Ingrese el número del coeficiente lineal: "))
        num3 = float(input("Ingrese el número del termino independiete: "))

        print(f"La respuestas de la ecución son: {cuadratica_res1(num1, num2, num3)} y {cuadratica_res2(num1, num2, num3)}")
    elif opcion == "4":
        print("Gracias por usar este programa")
    else:
        print("Opción no válida")
    
    continuar = input("¿Desea continuar? (y/n): ")

print("Chau :)")