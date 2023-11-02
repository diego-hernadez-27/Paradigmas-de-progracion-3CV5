import math


class Figura:
    
    def __init__(self, color):
        self._color = color
        
    def get_color(self):
        return self._color
    
    def perimetro(self):
        return 0
    
    def area(self):
        return 0
    

class Triangulo(Figura):
    
    def __init__(self, color, lado1, lado2, lado3):
        super(Triangulo, self).__init__(color)
        self._lado1 = lado1
        self._lado2 = lado2
        self._lado3 = lado3
    
    def perimetro(self):
        return self._lado1 + self._lado2 + self._lado3
    
    def area(self):
        semiperimetro = self.perimetro() / 2
        return (semiperimetro * (semiperimetro - self._lado1) * (semiperimetro - self._lado2) * (semiperimetro -
                                                                                                 self._lado3)) ** 0.5


class Rectangulo(Figura):

    def __init__(self, color, base, altura):
        super(Rectangulo, self).__init__(color)
        self._base = base
        self._altura = altura

    def perimetro(self):
        return 2 * (self._base + self._altura)

    def area(self):
        return self._base * self._altura
    

class Circulo(Figura):

    def __init__(self, color, radio):
        super(Circulo, self).__init__(color)
        self._radio = radio

    def perimetro(self):
        return 2 * math.pi * self._radio

    def area(self):
        return math.pi * self._radio ** 2
    

class Hexagono(Figura):

    def __init__(self, color, lado):
        super(Hexagono, self).__init__(color)
        self._lado = lado

    def perimetro(self):
        return 6 * self._lado

    def area(self):
        return self.perimetro() * ((self._lado ** 2 - (self._lado / 2) ** 2) ** 0.5) / 2
    
    
figuras = [Triangulo("Rojo", 3, 4, 5), Circulo("Verde", 5), Rectangulo("Azul", 10, 8), Hexagono("Amarillo", 5)]

for figura in figuras:
    print("Color: " + figura.get_color())
    print("Perimetro: " + str(figura.perimetro()))
    print("Area: " + str(figura.area()) + "\n")