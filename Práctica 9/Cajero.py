class Cajero:
    def __init__(self):
        self.saldo = 100000
        self.cuentas = {}

        def autenticar(self, cuenta, nip):
            if cuenta in self.cuentas and self.cuentas[cuenta]["nip"] == nip:
                return True
            else:
                return False

    def desplegar_datos(self, cuenta):
        if cuenta in self.cuentas:
            print(f"Nombre: {self.cuentas[cuenta]['nombre']}")
            print(f"Edad: {self.cuentas[cuenta]['edad']}")
            print(f"País: {self.cuentas[cuenta]['pais']}")
            print(f"Saldo: {self.cuentas[cuenta]['saldo']}")
        else:
            print("Cuenta no encontrada.")

    def depositar_propia(self, cuenta, cantidad):
        if cuenta in self.cuentas:
            self.cuentas[cuenta]["saldo"] += cantidad
            print(f"Depósito exitoso. Nuevo saldo: {self.cuentas[cuenta]['saldo']}")
        else:
            print("Cuenta no encontrada.")

    def depositar_otras(self, cuenta_origen, cuenta_destino, cantidad):
        if cuenta_origen in self.cuentas and cuenta_destino in self.cuentas:
            if self.cuentas[cuenta_origen]["saldo"] >= cantidad:
                self.cuentas[cuenta_origen]["saldo"] -= cantidad
                self.cuentas[cuenta_destino]["saldo"] += cantidad
                print(f"Transferencia exitosa. Nuevo saldo de {cuenta_origen}: {self.cuentas[cuenta_origen]['saldo']}")
            else:
                raise Exception("SaldoCuentaInsuficiente")
        else:
            print("Cuenta no encontrada.")

    def transferir(self, cuenta_origen, cuenta_destino, cantidad):
        if cuenta_origen in self.cuentas and cuenta_destino in self.cuentas:
            if self.cuentas[cuenta_origen]["saldo"] >= cantidad:
                self.cuentas[cuenta_origen]["saldo"] -= cantidad
                self.cuentas[cuenta_destino]["saldo"] += cantidad
                print(f"Transferencia exitosa. Nuevo saldo de {cuenta_origen}: {self.cuentas[cuenta_origen]['saldo']}")
            else:
                raise Exception("SaldoCuentaInsuficiente")
        else:
            print("Cuenta no encontrada.")

    def crear_cuenta(self, cuenta, nombre, nip, edad, pais):
        if cuenta not in self.cuentas:
            self.cuentas[cuenta] = {"nombre": nombre, "nip": nip, "edad": edad, "pais": pais, "saldo": 0}
            print("Cuenta creada exitosamente.")
        else:
            print("La cuenta ya existe.")

    def retirar(self, cuenta, cantidad):
        if cuenta in self.cuentas:
            if self.saldo >= cantidad:
                self.saldo -= cantidad
                self.cuentas[cuenta]["saldo"] -= cantidad
                print(f"Retiro exitoso. Nuevo saldo de {cuenta}: {self.cuentas[cuenta]['saldo']}")
            else:
                raise Exception("SaldoEfectivoInsuficiente")
        else:
            print("Cuenta no encontrada.")

    def depositar_otras(self, cuenta_origen, cuenta_destino, cantidad):
        if cuenta_origen in self.cuentas and cuenta_destino in self.cuentas:
            if self.cuentas[cuenta_origen]["saldo"] >= cantidad:
                self.cuentas[cuenta_origen]["saldo"] -= cantidad
                self.cuentas[cuenta_destino]["saldo"] += cantidad
                print(f"Transferencia exitosa. Nuevo saldo de {cuenta_origen}: {self.cuentas[cuenta_origen]['saldo']}")
            else:
                raise Exception("SaldoCuentaInsuficiente")
        else:
            print("Cuenta no encontrada.")

    def retirar(self, cuenta, cantidad):
        if cuenta in self.cuentas:
            if self.saldo >= cantidad:
                self.saldo -= cantidad
                self.cuentas[cuenta]["saldo"] -= cantidad
                print(f"Retiro exitoso. Nuevo saldo de {cuenta}: {self.cuentas[cuenta]['saldo']}")
            else:
                raise Exception("SaldoEfectivoInsuficiente")
        else:
            print("Cuenta no encontrada.")

    def ejecutar_cajero(self):
        while True:
            print("Bienvenido al cajero automático.")
            print("1. Autenticar cuentahabientes.")
            print("2. Desplegar datos de cuenta y saldos.")
            print("3. Depósito en efectivo a cuenta propia.")
            print("4. Depósito en efectivo a otras cuentas.")
            print("5. Transferencias a otras cuentas.")
            print("6. Crear cuenta.")
            print("7. Retiro de efectivo.")
            print("0. Salir.")

            opcion = int(input("Elige una opción: "))

            if opcion == 1:
                cuenta = input("Introduce el número de cuenta: ")
                nip = input("Introduce el NIP: ")
                if cajero.autenticar(cuenta, nip):
                    print("Autenticación exitosa.")
                else:
                    print("Autenticación fallida.")
            elif opcion == 2:
                cuenta = input("Introduce el número de cuenta: ")
                cajero.desplegar_datos(cuenta)
            elif opcion == 3:
                cuenta = input("Introduce el número de cuenta: ")
                cantidad = float(input("Introduce la cantidad de efectivo a depositar: "))
                cajero.depositar_propia(cuenta, cantidad)
            elif opcion == 4:
                cuenta_origen = input("Introduce el número de cuenta origen: ")
                cuenta_destino = input("Introduce el número de cuenta destino: ")
                cantidad = float(input("Introduce la cantidad de efectivo a transferir: "))
                cajero.depositar_otras(cuenta_origen, cuenta_destino, cantidad)
            elif opcion == 5:
                cuenta_origen = input("Introduce el número de cuenta origen: ")
                cuenta_destino = input("Introduce el número de cuenta destino: ")
                cantidad = float(input("Introduce la cantidad de efectivo a transferir: "))
                cajero.transferir(cuenta_origen, cuenta_destino, cantidad)
            elif opcion == 6:
                cuenta = input("Introduce el número de cuenta: ")
                nombre = input("Introduce el nombre: ")
                nip = input("Introduce el NIP: ")
                edad = int(input("Introduce la edad: "))
                pais = input("Introduce el país: ")
                cajero.crear_cuenta(cuenta, nombre, nip, edad, pais)
            elif opcion == 7:
                cuenta = input("Introduce el número de cuenta: ")
                cantidad = float(input("Introduce la cantidad de efectivo a retirar: "))
                cajero.retirar(cuenta, cantidad)
            elif opcion == 0:
                print("Gracias por utilizar el cajero automático.")
                break
            else:
                print("Opción no válida. Inténtelo de nuevo.")


cajero = Cajero()
cajero.ejecutar_cajero()
