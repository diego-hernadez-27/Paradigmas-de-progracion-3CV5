from datetime import datetime

class Persona:
    def __init__(self, n, ap, am, o, dia, mes, agno):
        self.nombres = n
        self.appat = ap
        self.apmat = am
        self.nombre = f"{n} {ap} {am}"
        self.diaN = dia
        self.mesN = mes
        self.agnoN = agno
        self.ocupacion = o
        self.nacimiento = f"{dia}/{mes}/{agno}"
        self.edad = 0
        self.id = ""

    # Funciones Getters y Setters
    def get_nombre(self):
        return self.nombre

    def get_nacimiento(self):
        return self.nacimiento

    def get_ocupacion(self):
        return self.ocupacion

    def set_nombre(self, n, ap, am):
        self.nombres = n
        self.appat = ap
        self.apmat = am
        self.nombre = f"{n} {ap} {am}"

    def set_nacimiento(self, dia, mes, agno):
        self.diaN = dia
        self.mesN = mes
        self.agnoN = agno
        self.nacimiento = f"{dia}/{mes}/{agno}"

    def set_ocupacion(self, o):
        self.ocupacion = o

    def __str__(self):
        return f"Nombre: {self.get_nombre()}\nEdad: {self.edad}\nOcupación: {self.get_ocupacion()}\nID: {self.id}\nNacimiento: {self.get_nacimiento()}"

    # Calculamos información del usuario
    def calculate_edad(self):
        fecha_hoy = datetime.now()
        diaH = fecha_hoy.day
        mesH = fecha_hoy.month
        agnoH = fecha_hoy.year

        mesn = int(self.mesN)
        dian = int(self.diaN)
        agnon = int(self.agnoN)

        self.edad = agnoH - agnon
        if mesH > mesn and diaH > dian:
            self.edad -= 1

    def calculate_id(self):
        newyear = str(self.agnoN)[-2:]
        nom = self.nombres[0]
        apa = self.appat[:2].upper()
        ama = self.apmat[0]

        self.id = f"{apa}{ama}{nom}{newyear}{self.mesN}{self.diaN}XXX"
        