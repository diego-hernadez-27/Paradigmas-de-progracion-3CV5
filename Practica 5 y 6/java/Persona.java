import java.util.*;

public class Persona {
    private String nombre, nombres, appat, apmat, ocupacion, id, nacimiento, diaN, mesN, agnoN;
    private int edad;

    //Definimos los constructores
    
    public Persona(String n, String ap, String am, String o, String dia, String mes, String agno){
        nombres = n;
        appat = ap;
        apmat = am;
        nombre = n + " " + ap + " " + am;
        diaN = dia;
        mesN = mes;
        agnoN = agno;
        ocupacion = o;
        nacimiento = dia + "/" + mes + "/" + agno;
    }
    
    public Persona(){
    }
    
    //Funciones Getters and Stters

    public String getNombre(){
        return nombre;
    }

    public String getNacimiento(){
        return nacimiento;
    }

    public String getOcupacion(){
        return ocupacion;
    }

    public void setNombre(String n, String ap, String am){
        nombres = n; appat = ap; apmat = am;
        nombre = n + " " + ap + " " + am;
    }

    public void setNacimiento(String dia, String mes, String agno){
        diaN = dia; mesN = mes; agnoN = agno;
        nacimiento = dia + "/" + mes + "/" + agno; 
    }

    public void setOcupacion(String o){
        ocupacion = o;
    }

    public String toString(){
        return "Nombre: " + getNombre() + " \nEdad: " + edad + " \nOcupacion: " + getOcupacion() 
               + "\nID: " + id + "\nNacimiento: " + getNacimiento();
    }
    
    // Calculamos información del usuario

    public void calculateEdad(){
        Calendar fechaHoy = Calendar.getInstance();
        int diaH = fechaHoy.get(Calendar.DAY_OF_MONTH);
        int mesH = fechaHoy.get(Calendar.MONTH);
        int agnoH = fechaHoy.get(Calendar.YEAR);

        int mesn = Integer.parseInt(mesN);
        int dian = Integer.parseInt(diaN);
        int agnon = Integer.parseInt(agnoN);
        
        edad = agnoH - agnon;
        if((mesH > mesn) && (diaH > dian))
            edad--;
    }

    public void calculateID(){
        String newyear = String.valueOf(agnoN);
        newyear = newyear.substring(newyear.length() - 2);
        String nom = nombres.substring(0,1);
        String apa = appat.substring(0,2).toUpperCase();
        String ama = apmat.substring(0,1);

        id = apa + ama + nom + newyear + mesN + diaN + "XXX";
    }

}