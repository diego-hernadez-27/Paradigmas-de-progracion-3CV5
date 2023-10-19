import tkinter as tk
from Persona import Persona
class InterfazGrafica(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Formulario de Información")
        self.geometry("620x400")
        self.create_widgets()
        self.persona = Persona("a", "b", "c", "d", "e", "f", "g")
        
    def create_widgets(self):
        lblNombre = tk.Label(self, text="Nombre:")
        lblFechaNacimiento = tk.Label(self, text="Fecha de Nacimiento (DD/MM/AAAA):")
        lblOcupacion = tk.Label(self, text="Ocupación:")

        self.txtNombre = tk.Entry(self)
        self.txtApellidoPaterno = tk.Entry(self)
        self.txtApellidoMaterno = tk.Entry(self)
        self.txtDiaNacimiento = tk.Entry(self)
        self.txtMesNacimiento = tk.Entry(self)
        self.txtAnioNacimiento = tk.Entry(self)
        self.txtOcupacion = tk.Entry(self)

        self.txtAreaInformacion = tk.Text(self, height=10, width=40)
        self.txtAreaInformacion.config(state=tk.DISABLED)
        
        # Botones con funciones
        btnSetNombre = tk.Button(self, text="Actualizar Nombre", command=self.actualizar_nombre)
        btnSetNacimiento = tk.Button(self, text="Actualizar Nacimiento", command=self.actualizar_nacimiento)
        btnSetOcupacion = tk.Button(self, text="Actualizar Ocupación", command=self.actualizar_ocupacion)
        btnMostrar = tk.Button(self, text="Mostrar Información", command=self.mostrar_informacion)
        btnOcultar = tk.Button(self, text="Ocultar Información", command=self.ocultar_informacion)
        btnActualizarGlobal = tk.Button(self, text="Actualizar Global", command=self.actualizar_informacion_global)

        #Interfaz en pantalla
        lblNombre.grid(row=0, column=0)
        self.txtNombre.grid(row=0, column=1)
        tk.Label(self, text="Apellido Paterno:").grid(row=1, column=0)
        self.txtApellidoPaterno.grid(row=1, column=1)
        tk.Label(self, text="Apellido Materno:").grid(row=2, column=0)
        self.txtApellidoMaterno.grid(row=2, column=1)
        lblFechaNacimiento.grid(row=3, column=0)
        self.txtDiaNacimiento.grid(row=3, column=1)
        tk.Label(self, text="/").grid(row=3, column=2)
        self.txtMesNacimiento.grid(row=3, column=3)
        tk.Label(self, text="/").grid(row=3, column=4)
        self.txtAnioNacimiento.grid(row=3, column=5)
        lblOcupacion.grid(row=4, column=0)
        self.txtOcupacion.grid(row=4, column=1)

        self.txtAreaInformacion.grid(row=5, column=0, columnspan=2)
        
        btnSetNombre.grid(row=6, column=0)
        btnSetNacimiento.grid(row=6, column=1)
        btnSetOcupacion.grid(row=7, column=0)
        btnMostrar.grid(row=7, column=1)
        btnOcultar.grid(row=8, column=0)
        btnActualizarGlobal.grid(row=8, column=1)
        
    
    # Funciones de los botones
    def actualizar_nombre(self):
        nombre = self.txtNombre.get()
        apellido_paterno = self.txtApellidoPaterno.get()
        apellido_materno = self.txtApellidoMaterno.get()
        
        self.persona.set_nombre(nombre, apellido_paterno, apellido_materno)
        self.persona.calculate_id()
        
        self.txtAreaInformacion.config(state=tk.NORMAL)
        self.txtAreaInformacion.delete("1.0", tk.END)
        self.txtAreaInformacion.insert(tk.END, self.persona.__str__())
        self.txtAreaInformacion.config(state=tk.DISABLED)
        
    def actualizar_nacimiento(self):
        dia_nacimiento = self.txtDiaNacimiento.get()
        mes_nacimiento = self.txtMesNacimiento.get()
        anio_nacimiento = self.txtAnioNacimiento.get()

        self.persona.set_nacimiento(dia_nacimiento, mes_nacimiento, anio_nacimiento)
        self.persona.calculate_id()
        self.persona.calculate_edad()

        self.txtAreaInformacion.config(state=tk.NORMAL)
        self.txtAreaInformacion.delete("1.0", tk.END)
        self.txtAreaInformacion.insert(tk.END, self.persona.__str__())
        self.txtAreaInformacion.config(state=tk.DISABLED)
        
    def actualizar_ocupacion(self):
        ocupacion = self.txtOcupacion.get()

        self.persona.set_ocupacion(ocupacion)

        self.txtAreaInformacion.config(state=tk.NORMAL)
        self.txtAreaInformacion.delete("1.0", tk.END)
        self.txtAreaInformacion.insert(tk.END, self.persona.__str__())
        self.txtAreaInformacion.config(state=tk.DISABLED)
    
    def mostrar_informacion(self):
        self.txtAreaInformacion.config(state=tk.NORMAL)
        self.txtAreaInformacion.delete("1.0", tk.END)
        self.txtAreaInformacion.insert(tk.END, "Aquí se mostrará la información.")
        self.txtAreaInformacion.config(state=tk.DISABLED)
    def ocultar_informacion(self):
        self.txtAreaInformacion.config(state=tk.NORMAL)
        self.txtAreaInformacion.delete("1.0", tk.END)
        self.txtAreaInformacion.config(state=tk.DISABLED)
    def actualizar_informacion_global(self):
        nombre = self.txtNombre.get()
        apellido_paterno = self.txtApellidoPaterno.get()
        apellido_materno = self.txtApellidoMaterno.get()
        dia_nacimiento = self.txtDiaNacimiento.get()
        mes_nacimiento = self.txtMesNacimiento.get()
        anio_nacimiento = self.txtAnioNacimiento.get()
        ocupacion = self.txtOcupacion.get()

        self.persona.set_nombre(nombre, apellido_paterno, apellido_materno)
        self.persona.set_nacimiento(dia_nacimiento, mes_nacimiento, anio_nacimiento)
        self.persona.set_ocupacion(ocupacion)

        self.persona.calculate_edad()
        self.persona.calculate_id()

        self.txtAreaInformacion.config(state=tk.NORMAL)
        self.txtAreaInformacion.delete("1.0", tk.END)
        self.txtAreaInformacion.insert(tk.END, self.persona.__str__())
        self.txtAreaInformacion.config(state=tk.DISABLED)

if __name__ == "__main__":
    app = InterfazGrafica()
    app.mainloop()
