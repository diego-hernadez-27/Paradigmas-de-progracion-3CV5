import java.lang.Math;

public class Punto3D {
    private double x;
    private double y;
    private double z;

    public Punto3D(double vx, double vy, double vz){
        setX(vx);
        setY(vy);
        setZ(vz);
    }

    private void setX(double vx){
        x = vx;
    }

    private void setY(double vy){
        y = vy;
    }

    private void setZ(double vz){
        z = vz;
    }

    private double GetX(){
        return x;
    }

    private double getY(){
        return y;
    }

    private double getZ(){
        return z;
    }

    public double distanciaP(Punto3D otroPunto){
        return Math.sqrt(Math.pow(this.x - otroPunto.x, 2) + Math.pow(this.y - otroPunto.y, 2) + Math.pow(this.z - otroPunto.z, 2));
    }
}