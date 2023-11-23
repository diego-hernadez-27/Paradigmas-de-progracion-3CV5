import java.io.*;

public class Alumno implements Serializable{

    private int Boleta, Celular;
    private double Calificaiones[][];
    private String Nombre, Correo;

    public Alumno(){

    }

    public Alumno(int Boleta, int Celular, double Calificaciones[][], String Nombre, String Correo){
        this.Nombre = Nombre;
        this.Boleta = Boleta;
        this.Correo = Correo;
        this.Celular = Celular;
        this.Calificaiones = Calificaiones;
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

    public int getCelular(){
        return this.Celular;
    }

    public void setCelular(int Celular){
        this.Celular = Celular;
    }

    public double[][] getCalificaciones(){
        return this.Calificaiones;
    }

    public void setCalificaciones(double Califiaciones[][]){
        this.Calificaiones = Calificaiones;
    }
    
}
