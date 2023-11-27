import java.io.*;

public class Alumno implements Serializable{

    private int Boleta;
    private long Celular;
    private double Calificaiones[][];
    private String Nombre, Correo;

    public Alumno(){

    }

    public Alumno(int Boleta, long Celular, String Nombre, String Correo){
        this.Nombre = Nombre;
        this.Boleta = Boleta;
        this.Correo = Correo;
        this.Celular = Celular;
        this.Calificaiones = new double[2][55];
    }
    
    public String getNombre(){
        return this.Nombre;
    }

    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }

    public int getBoleta(){
        return this.Boleta;
    }

    public void setBoleta(int Boleta){
        this.Boleta = Boleta;
    }

    public String getCorreo(){
        return this.Correo;
    }

    public void setCorreo(String Correo){
        this.Correo = Correo;
    }	

    public long getCelular(){
        return this.Celular;
    }

    public void setCelular(long Celular){
        this.Celular = Celular;
    }

    public double[][] getCalificaciones(){
        return this.Calificaiones;
    }

    public void setCalificaciones(double Califiaciones[][]){
        Calificaiones = llenarCalificaciones(Calificaiones);
        this.Calificaiones = Calificaiones;
    }
    

    double[][] llenarCalificaciones(double cali[][]) {
        for (int i = 0; i < 55; i++) {
            cali[0][i] = i + 1;
        }

        for (int i = 0; i < 55; i++) {
            cali[1][i] = (double) (Math.random() * 10) + 1;
        }

        return cali;
    }
}
