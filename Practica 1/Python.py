# Definir las funciones de las operaciones
def factorial(num1):
    aux = num1
    res = int(1)

    for i in range(aux):
        res = res * num1
        num1 = num1 - 1
    
    return res

def multiplicacion(num1, num2):
    res = int(0)

    for i in range(num2):
        res = res + num1

    return res

def dividision(num1, num2):
    res = int(0)
    
    while num1 >= num2:
        num1 = num1 - num2   
        res = res + 1
        
    return res

# Mostrar el menú en pantalla
print("Seleccione una operación:")
print("1. Factorial")
print("2. División")
print("3. Multiplicación")
print("4. Salir")

opcion = input("Ingrese el número de la operación que desea realizar: ")

if opcion == "1":
    num1 = int(input("Ingrese un número entero positivo: "))
    
    print(f"El factorial de {num1} es {factorial(num1)}")
elif opcion == "2":
    num1 = int(input("Ingrese el primer número: "))
    num2 = int(input("Ingrese el segundo número: "))
    
    if num2 == 0:
        print("No se puede dividir por cero")
    else:
        print(f"La división de {num1} y {num2} es {dividision(num1, num2)}")
elif opcion == "3":
    num1 = int(input("Ingrese el primer número: "))
    num2 = int(input("Ingrese el segundo número: "))
    
    print(f"La multiplicación de {num1} y {num2} es {multiplicacion(num1, num2)}")
elif opcion == "4":
    print("Gracias por usar este programa")
else:
    print("Opción no válida")