class Punto3D:
    def __init__(self, vx, vy, vz):
        self.setX(vx)
        self.setY(vy)
        self.setZ(vz)

    def setX(self, vx):
        self.x = vx

    def setY(self, vy):
        self.y = vy

    def setZ(self, vz):
        self.z = vz

    def getX(self):
        return self.x

    def getY(self):
        return self.y

    def getZ(self):
        return self.z

    def distanciaP(self, otroPunto):
        return ((self.x - otroPunto.x) ** 2 + (self.y - otroPunto.y) ** 2 + (self.z - otroPunto.z) ** 2) ** 0.5

if __name__ == "__main__":
    print("En este programa vamos a calcular la distancia entre puntos.")
    puntos = []

    for i in range(10):
        print(f"Ingresa las coordenadas del punto {i + 1}:")
        x = float(input("X: "))
        y = float(input("Y: "))
        z = float(input("Z: "))
        puntos.append(Punto3D(x, y, z))

    menorDistancia = float('inf')
    punto1, punto2 = -1, -1

    for i in range(10):
        for j in range(i + 1, 10):
            distancia = puntos[i].distanciaP(puntos[j])
            if distancia < menorDistancia:
                menorDistancia = distancia
                punto1 = i
                punto2 = j

    if punto1 != -1 and punto2 != -1:
        print(f"La menor distancia es entre el punto {punto1 + 1} y el punto {punto2 + 1}")
        print(f"Distancia: {menorDistancia}")
    else:
        print("No se encontraron dos puntos para calcular la distancia.")

