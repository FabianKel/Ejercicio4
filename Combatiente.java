import java.util.*;

public class Combatiente{
    //OBJETOS RANDOM Y SCANNER
    Random rand = new Random(System.nanoTime());
    Scanner in = new Scanner(System.in);

    //ATRIBUTOS DE COMBATIENTES
    private String nombre;
    private int puntosV, puntosA, velocidad;
    private boolean jugador;
    private ArrayList<Ataque> ataques = new ArrayList<Ataque>();
    private ArrayList<Item> items = new ArrayList<Item>();
    private String estado;
    
    //CONSTRUCTOR
    public Combatiente(String nombre, int puntosV, boolean jugador, ArrayList<Ataque> ataques, ArrayList<Item> items, String estado) {
        this.nombre = nombre;
        this.puntosV = puntosV;
        this.jugador = jugador;
        this.ataques = ataques;
        this.items = items;
        this.estado = estado;
    }

    //METODOS
    public void dialogo(){
        
        //CUANDO EMPIEZA LA BATALLA
        if(this.estado.equals("inicio")){
            System.out.println("Frase de inicio");
            
        }else
        //CUANDO MUERE
        if(this.estado.equals("morir")){
            System.out.println("Frase de muerte");
            
        }else//CUANDO GANA
        if(this.estado.equals("ganar")){
            System.out.println("Frase de ganarrr");
        }
    }

    //Turno
    
    public Ataque atacar(){
            //ATACAR

            System.out.println("Escoge el número de ataque para usarlo");
            for(int i = 0; i <= this.ataques.size()-1;i++){
                System.out.println((i+1)+". "+ this.ataques.get(i).getNombre());
            }
            int NumAtaque = in.nextInt();
            return this.ataques.get(NumAtaque-1);
    }

    public Item UsarItem(){
        //ATACAR

        System.out.println("Escoge el número de Objeto para utilizarlo");
        for(int i = 0; i <= this.items.size()-1;i++){
            System.out.println((i+1)+". "+ this.items.get(i).getNombre()+", Cantidad: "+this.items.get(i).getCantidad()+" , Descripción: "+this.items.get(i).getEfecto());
        }
        int NumItem = in.nextInt();
        return this.items.get(NumItem-1);
}



    //AFECTAR OBJETIVO CON ATAQUE
    public void afectar(int DañoBase, int DañoContinuo, int VelocidadEnemigo, int VelocidadPropia){
        //CAUSA EFECTO TRAS CADA TURNO
        if(this.estado.equals("En llamas")){
            this.puntosV -= 4;
        }
        //EFECTO DEL ATAQUE:

        //CAMBIA ESTADO SI LO QUEMÓ
        if(DañoContinuo != 0){
            this.estado="En llamas";
        }
        //AFECTAR VIDA DEL OBJETIVO
        this.puntosV += DañoBase;


        //AFECTAR VELOCIDAD DEL OBJETIVO
        this.velocidad += VelocidadEnemigo;
        this.velocidad += VelocidadPropia;

        //CAMBIAR ESTADO A MUERTO SI YA MURIÓ
        if(this.puntosV <= 0){
            this.estado = "muerto";
        }

    }
    public void afectarArea(int dañoA){

        this.puntosV += dañoA;

    }





    //GETTERS Y SETTERS

    public int getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getpuntosV() {
        return puntosV;
    }
    public void setpuntosV(int puntosV) {
        this.puntosV = puntosV;
    }
    public int getpuntosA() {
        return puntosA;
    }
    public void setpuntosA(int puntosA) {
        this.puntosA = puntosA;
    }
    public boolean isJugador() {
        return jugador;
    }
    public void setJugador(boolean jugador) {
        this.jugador = jugador;
    }
    public ArrayList<Ataque> getAtaques() {
        return ataques;
    }
    public void setAtaques(ArrayList<Ataque> ataques) {
        this.ataques = ataques;
    }
    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    


    


}
