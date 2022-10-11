import java.util.*;

public class Ataque{
    //OBJETOS RANDOM Y SCANNER
    Random rand = new Random(System.nanoTime());
    Scanner in = new Scanner(System.in);

    //ATRIBUTOS DE LOS ATAQUES nombre, cantidad, vida, ataque, velocidad, efecto
    private String nombre;
    private boolean especial;
    private int cantidad;
    private int dañoB; //daño base
    private int dañoC; //daño contínuo
    private int velocidadA; //VELOCIDAD PROPIA
    private int velocidadE; //VELOCIDAD DEL ENEMIGO
    private String efecto;

    

    //CONSTRUCTOR

    public Ataque(String nombre, boolean especial, int cantidad, int dañoB, int dañoC, int velocidadA, int velocidadE, String efecto) {
        this.nombre = nombre;
        this.especial = especial;
        this.cantidad = cantidad;
        this.dañoB = dañoB;
        this.dañoC = dañoC;
        this.velocidadA = velocidadA;
        this.velocidadE = velocidadE;
        this.efecto = efecto;
    }


   //METODOS




    //GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public boolean isEspecial() {
        return especial;
    }



    public void setEspecial(boolean especial) {
        this.especial = especial;
    }



    public int getCantidad() {
        return cantidad;
    }



    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }



    public int getDañoB() {
        return dañoB;
    }



    public void setDañoB(int dañoB) {
        this.dañoB = dañoB;
    }



    public int getDañoC() {
        return dañoC;
    }



    public void setDañoC(int dañoC) {
        this.dañoC = dañoC;
    }



    public int getVelocidadA() {
        return velocidadA;
    }



    public void setVelocidadA(int velocidadA) {
        this.velocidadA = velocidadA;
    }



    public int getVelocidadE() {
        return velocidadE;
    }



    public void setVelocidadE(int velocidadE) {
        this.velocidadE = velocidadE;
    }



    public String getEfecto() {
        return efecto;
    }



    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    

}
