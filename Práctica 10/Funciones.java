import java.io.*;
import java.util.*;

public class Funciones {

    static Scanner sc = new Scanner(System.in);
    public ArrayList<Alumno> ListadoAlumnos = new ArrayList<Alumno>();
    static final String nomarch = "lista.txt";

    public void llenar() {
        System.out.print("Ingrese su nombre: ");
        sc.nextLine();
        String nom = sc.nextLine();
        System.out.print("Ingrese su boleta: ");
        int bol = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Ingrese su correo: ");
        String cor = sc.nextLine();
        System.out.print("Ingrese su celular: ");
        int cel = sc.nextInt();
        System.out.println("Sus calificaciones han sido ingresadas automáticamente: ");
        double cali[][] = new double[2][55];
        
        
        Alumno alum = new Alumno(bol, cel, cali, nom, cor);
        imprimirCalificaciones(alum.getCalificaciones());
        ListadoAlumnos.add(alum);
        guardar(ListadoAlumnos, nomarch);
    }

    public void llenarCalificaciones(double cali[][]) {
        for (int i = 0; i < 55; i++) {
            cali[0][i] = i + 1;
        }

        for (int i = 0; i < 55; i++) {
            cali[1][i] = (double) (Math.random() * 10) + 1;
        }
    }

    public void imprimir() {
        ArrayList<Alumno> nuevaLista = leer(nomarch);

        if (nuevaLista.isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
            System.out.println("Datos de los alumnos:");
            
            for (int i = 0; i < nuevaLista.size(); i++) {
                Alumno alumno = nuevaLista.get(i);
                
                System.out.println("Nombre: " + alumno.getNombre());
                System.out.println("Boleta: " + alumno.getBoleta());
                System.out.println("Correo: " + alumno.getCorreo());
                System.out.println("Celular: " + alumno.getCelular());
                System.out.println("Calificaciones:");
                imprimirCalificaciones(alumno.getCalificaciones());
                System.out.println();   
            }
        }
    }

    private void imprimirCalificaciones(double[][] calificaciones) {
        for (int i = 0; i < calificaciones[0].length; i++) {
            System.out.println("Materia " + (int) calificaciones[0][i] + ": " + calificaciones[1][i]);
        }
    }
    
    public void guardar(ArrayList<Alumno> listaAlumnos, String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(listaAlumnos);
            System.out.println("ArrayList guardado en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Alumno> leer(String nombreArchivo) {
        ArrayList<Alumno> lista = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            lista = (ArrayList<Alumno>) ois.readObject();
            System.out.println("ArrayList cargado exitosamente desde " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void menu() {
        int opcion;
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Añadir elemento");
            System.out.println("2. Mostrar elementos");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    llenar();
                break;
                case 2:
                    imprimir();
                break;
                case 3:
                    System.out.println("Saliendo del programa. Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
    
    public static void main(String args[]){
        Funciones funciones = new Funciones();
        funciones.menu();
    }
}
