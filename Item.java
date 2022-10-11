import java.util.*;

public class Item {
        //OBJETOS RANDOM Y SCANNER
        Random rand = new Random(System.nanoTime());
        Scanner in = new Scanner(System.in);
    
        //ATRIBUTOS DE LOS ITEMS nombre, cantidad, vida, curación %, daño, ataque, velocidad, efecto
        private String nombre;
        private int cantidad;
        private int vida;
        private int curacion;
        private int daño;
        private int dañoA; //DAÑO EN AREA
        private int dañoDef; //DAÑÑO DEFENSIVO (CUANDO LO ATAQUEN)
        private int ataque;
        private int velocidad;
        private String efecto;


        
        //CONSTRUCTOR

        public Item(String nombre, int cantidad, int vida, int curacion, int daño, int dañoA, int dañoDef, int ataque,
                int velocidad, String efecto) {
            this.nombre = nombre;
            this.cantidad = cantidad;
            this.vida = vida;
            this.curacion = curacion;
            this.daño = daño;
            this.dañoA = dañoA;
            this.dañoDef = dañoDef;
            this.ataque = ataque;
            this.velocidad = velocidad;
            this.efecto = efecto;
        }

        //GETTERS Y SETTERS
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public int getCantidad() {
            return cantidad;
        }
        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
        public int getVida() {
            return vida;
        }
        public void setVida(int vida) {
            this.vida = vida;
        }
        public int getCuracion() {
            return curacion;
        }
        public void setCuracion(int curacion) {
            this.curacion = curacion;
        }
        public int getDaño() {
            return daño;
        }
        public void setDaño(int daño) {
            this.daño = daño;
        }
        public int getDañoA() {
            return dañoA;
        }
        public void setDañoA(int dañoA) {
            this.dañoA = dañoA;
        }
        public int getDañoDef() {
            return dañoDef;
        }

        public void setDañoDef(int dañoDef) {
            this.dañoDef = dañoDef;
        }

        public int getAtaque() {
            return ataque;
        }
        public void setAtaque(int ataque) {
            this.ataque = ataque;
        }
        public int getVelocidad() {
            return velocidad;
        }
        public void setVelocidad(int velocidad) {
            this.velocidad = velocidad;
        }
        public String getEfecto() {
            return efecto;
        }
        public void setEfecto(String efecto) {
            this.efecto = efecto;
        }
    
}
