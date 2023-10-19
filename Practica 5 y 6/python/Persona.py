from datetime import datetime

class Persona:
    def __init__(self, n, ap, am, o, dia, mes, agno):
        self._nombres = n
        self._appat = ap
        self._apmat = am
        self._nombre = f"{n} {ap} {am}"
        self._diaN = dia
        self._mesN = mes
        self._agnoN = agno
        self._ocupacion = o
        self._nacimiento = f"{dia}/{mes}/{agno}"
        self._edad = 0
        self._id = ""

    # Funciones Getters y Setters
    def get_nombre(self):
        return self._nombre

    def get_nacimiento(self):
        return self._nacimiento

    def get_ocupacion(self):
        return self._ocupacion

    def set_nombre(self, n, ap, am):
        self._nombres = n
        self._appat = ap
        self._apmat = am
        self._nombre = f"{n} {ap} {am}"

    def set_nacimiento(self, dia, mes, agno):
        self._diaN = dia
        self._mesN = mes
        self._agnoN = agno
        self._nacimiento = f"{dia}/{mes}/{agno}"

    def set_ocupacion(self, o):
        self._ocupacion = o

    def __str__(self):
        return f"Nombre: {self.get_nombre()}\nEdad: {self._edad}\nOcupación: {self.get_ocupacion()}\nID: {self._id}\nNacimiento: {self.get_nacimiento()}"

    # Calculamos información del usuario
    def calculate_edad(self):
        fecha_hoy = datetime.now()
        diaH = fecha_hoy.day
        mesH = fecha_hoy.month
        agnoH = fecha_hoy.year

        mesn = int(self._mesN)
        dian = int(self._diaN)
        agnon = int(self._agnoN)

        self._edad = agnoH - agnon
        if mesH > mesn and diaH > dian:
            self._edad -= 1

    def calculate_id(self):
        newyear = str(self._agnoN)[-2:]
        nom = self._nombres[0]
        apa = self._appat[:2].upper()
        ama = self._apmat[0]

        self._id = f"{apa}{ama}{nom}{newyear}{self._mesN}{self._diaN}XXX"

        