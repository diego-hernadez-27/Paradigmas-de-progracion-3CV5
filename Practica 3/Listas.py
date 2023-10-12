# Código por Hernández Reyes Diego Alberto

# Mostrar el menú en pantalla
continuar = "y"

while continuar == "y":
    lista = []
    listaux = []
    
    print("Seleccione una tarea a realizar:")
    print("1. Duplicar los valores de los elementos de una lista.")
    print("2. Sumar dos listas")
    print("3. Duplicar un número si es par y triplicarlo si es impar")
    print("4. Convertir strings a lista")
    print("5. Encontrar las vocales de una cadena de texto.")
    print("6. Encontrar aquellos valores divisibles entre 3")
    print("7. Salir")

    opcion = int(input("Ingrese el número de la tarea que desea realizar: "))
    
    if(opcion < 7 and opcion >= 0):
        tam = int(input("Ingrese el numero de elementos de la(s) lista(s): "))
        for i in range(tam):
            elemento = str(input("Ingrese elemneto de la lista: "))
            lista.append(elemento)

    if opcion == 1:
        lista = list(map(lambda x: str(int(x) * 2), lista))
    elif opcion == 2:
        for i in range(tam):
            elemento = str(input("Ingrese elemneto de la lista 2: "))
            listaux.append(elemento)
    
        lista = list(map(lambda x, y: str(int(x) + int(y)), lista, listaux))
    elif opcion == 3:
        lista = list(map(lambda x: str(int(x) * 2) if int(x) % 2 == 0 else str(int(x) * 3), lista))
    elif opcion == 4:
        lista = list(map(lambda x: list(x), lista))
    elif opcion == 5:
        lista = list(map(lambda x: list(filter(lambda y: y in 'AEIOUaeiou', x)), lista))
    elif opcion == 6:
        lista = list(filter(lambda x: str((int(x) % 3 == 0)), lista))
    elif opcion == 7:
        print("Gracias por usar este programa")
    else:
        print("Opción no válida")
        
    if(not(opcion < 7 and opcion >= 0)):
        continuar = input("¿Desea volver al menú? (y/n): ")
    else:
        print(f"La lista es: {lista}")
        continuar = input("¿Desea continuar? (y/n): ")

print("Chau :)")