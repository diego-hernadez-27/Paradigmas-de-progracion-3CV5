import java.io.*;

public class LecturaNumeros extends BufferedReader {

    LecturaNumeros(Reader r) {
        super(r);
    }

    LecturaNumeros(){
        super(new StringReader(""));
    }

    public int readInt() throws IOException {
        try {
            String cadena = super.readLine();
            return Integer.parseInt(cadena);
        } catch (NumberFormatException e) {
            System.err.println("La cadena no es un numero entero valido.");
            return 0;
        }
    }
    
    public int readInt(String m) throws IOException {
        System.out.println("Mensaje: " + m);
        System.out.print("Ingrese un entero: ");
        String cadena = super.readLine();

        try {
            return Integer.parseInt(cadena);
        } catch (NumberFormatException e) {
            System.err.println("La cadena no es un numero entero valido.");
            return 0;
        }
    }
    
    public Integer readInteger() throws IOException {
        String cadena = super.readLine();
        
        try {
            Integer enteroObj = Integer.valueOf(cadena);
            return enteroObj;
        } catch (NumberFormatException e) {
            System.err.println("La cadena no es un objeto Integer valido.");
            return Integer.valueOf(0);
        }
    }
    
    public double readDouble() throws IOException {
        String cadena = super.readLine();

        try {
            return Double.parseDouble(cadena);
        } catch (NumberFormatException e) {
            System.err.println("La cadena no es un numero double valido.");
            return 0;
        }
    }

    public double readDouble(String m) throws IOException {
        System.out.println("Mensaje: " + m);
        System.out.print("Ingrese un double: ");
        String cadena = super.readLine();

        try {
            return Double.parseDouble(cadena);
        } catch (NumberFormatException e) {
            System.err.println("La cadena no es un numero double valido.");
            return 0;
        }
    }
}