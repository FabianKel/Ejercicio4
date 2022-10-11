import java.util.*;

public class principal{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        //

    //MENU
        int respuesta = 0;

        Random rand = new Random();
        System.out.println("Prepárate para luchar B)");
        System.out.println("Tipo de batalla generada: ");
        int numAliados = 0;
        int numEnemigos = 0;

        

        numAliados = rand.nextInt(1,3);
        numEnemigos = rand.nextInt(1,4);
        System.out.println(numAliados+" Aliados vs "+numEnemigos+" Enemigos");
        
        //LISTAS DE ENEMIGOS Y ALIADOS
        ArrayList<Combatiente> CAliados = crearAliados(numAliados);
        ArrayList<Combatiente> CEnemigos = crearEnemigos(numEnemigos);

        



        while(respuesta!= 5){

            System.out.println("\n\nDATOS DE PARTIDA:\n"); 
            System.out.println("Aliados\n| PUNTOS DE VIDA | PUNTOS DE ATAQUE | ESTADO");

            for(Combatiente i:CAliados){
                if(i.getNombre().equals("Explorador")){
                    i.setpuntosA(1);
                }else if(i.getNombre().equals("Guerrero")){
                    i.setpuntosA(2);
                }
                System.out.println(i.getNombre()+"| "+i.getpuntosV()+" | "+i.getpuntosA()+" | "+i.getEstado()+"\n\n");
            }
            System.out.println("Enemigos\n| PUNTOS DE VIDA | PUNTOS DE ATAQUE | ESTADO");
            for(Combatiente i:CEnemigos){
                if(i.getNombre().equals("Explorador Enemigo")){
                    i.setpuntosA(1);
                }else if(i.getNombre().equals("Guerrero Enemigo")){
                    i.setpuntosA(2);
                }
                System.out.println(i.getNombre()+" | "+i.getpuntosV()+" | "+i.getpuntosA()+" | "+i.getEstado());
            }


            System.out.println("¿Qué desea hacer?\n1.Empezar la partida\n2.Instrucciones\n3.Ver Items\n4.Ver Ataques\n5.Salir");
            respuesta = sc.nextInt();

            //SELECCIONAR accion
            if(respuesta == 1){
                //EMPIEZA
                //MIENTRAS EL ALIADO O LOS ENEMIGOS ESTEN CON VIDA
                int numAMuertos = 0;
                int numEMuertos = 0;
                while(numAMuertos <= CAliados.size()){
                    
                    //CAMBIAR ESTADO DE PARTIDA
                    //CONTAR LOS ALIADOS MUERTOS
                    for(Combatiente i:CAliados){
                        if(i.getEstado().equals("muerto")){
                            numAMuertos +=1;
                        }  
                    }
                    for(Combatiente i:CEnemigos){
                        if(i.getEstado().equals("muerto")){
                            numEMuertos +=1;
                        }  
                    }
                    if(numEMuertos == CEnemigos.size()){
                        System.out.println("HAS GANADO, TODOS LOS ENEMIGOS HAN MUERTO!!");
                        break;
                    }
                    ////////////////////////////////////////////////////////////////////////

                    //////// I N I C I O ////////
                    //DEFINIR TURNOS
                    int numTurno = 0;
                    if(CEnemigos.size()==3 && CAliados.size()==2){
                        //turnos: aliado1 - enemigo1 - enemigo2 - aliado2 - enemigo3
                        System.out.println("Turno del aliado 1: "+CAliados.get(numTurno).getNombre());
                        System.out.println("¿Qué hará?\n1.Atacar\n2.Usar Item\n3.Escapar????");
                        int accionN = sc.nextInt();
                        switch(accionN){
                            //ATACAR
                            case 1: 
                                Ataque a = CAliados.get(numTurno).atacar();
                                //SI ES UN ATAQUE QUE HACE DAÑO BASE (ATAQUE DIRIGIDO), ENTONCES:
                                if(a.getDañoB() != 0){
                                    //ELEGIR A QUIEN ATACAR
                                    System.out.println("A cuál enemigo desea atacar con "+a.getNombre()+"?");
                                    int num = 1;
                                    for(Combatiente i:CEnemigos){

                                        System.out.println(num+". "+i.getNombre()+": Puntos de Vida -> "+i.getpuntosV());
                                        num++;

                                    }
                                    //input de cual enemigo atacar
                                    int numEnemigo = sc.nextInt();
                                    numEnemigo -= 1;
                                    Combatiente ene = CEnemigos.get(numEnemigo);

                                    
                                    //CALCULO ALEATORIO RESPECTO A LA VELOCIDAD
                                    //VELOCIDAD BASE: GUERRERO=->30 EXPLORADOR->20

                                    int fallar = rand.nextInt(0, CAliados.get(numTurno).getVelocidad()+1);
                                    if(fallar == 0){
                                        System.out.println("UY! DEMASIADO LENTO, HA FALLADO EL ATAQUE!");
                                    }else{
                                        //HACER DAÑO / AFECTAR AL ENEMIGO
                                        ene.afectar(a.getDañoB(),a.getDañoC(),a.getVelocidadE());
                                        System.out.println(CAliados.get(numTurno).getNombre()+" a usado "+a.getNombre()+" contra "+ene.getNombre());
                                        if(ene.getEstado().equals("muerto")){
                                            System.out.println(a.getDañoB()+": Ha eliminado a "+ene.getNombre());
                                        }
                                        else{
                                        System.out.println("Los nuevos stats del "+ene.getNombre()+" son: "+": Estado -> "+ene.getEstado()+": Puntos de Vida -> "+ene.getpuntosV()+": Velocidad -> "+ene.getVelocidad());
                                        }
                                    }


                                    
                                    
                                }else{

                                }
                        }
                        




                    }else if(CEnemigos.size()==2 && CAliados.size()==2){
                        //turnos: aliado1 - enemigo1 - aliado2 - enemigo2
                    }else if(CEnemigos.size()==1 && CAliados.size()==2){
                        //turnos: aliado1 - enemigo1 - aliado2
                    }else if(CEnemigos.size()==3 && CAliados.size()==1){
                        //turnos: enemigo1 - aliado1 - enemigo2 - enemigo3
                    }else if(CEnemigos.size()==2 && CAliados.size()==1){
                        //turnos: enemigo1 - aliado1 - enemigo2
                    }else if(CEnemigos.size()==1 && CAliados.size()==1){
                        //turnos: aliado1 - enemigo1
                    }
                }
            
            }
            if(respuesta == 2){
                //INSTRUCCIONES

            }
            if(respuesta == 3){
                //Desplegar ITEMS
                //i PASA POR ALIADOS
                System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nALIADOS:\n");
                for(Combatiente i: CAliados){
                    System.out.println("ITEMS DEL "+i.getNombre()+": ");
                    for(Item e: i.getItems()){
                        System.out.println("Nombre: " + e.getNombre());
                        System.out.println("    Cantidad: " + e.getCantidad());
                        System.out.println("    Aumento de Vida: " + e.getVida());
                        System.out.println("    Curación a Aliados: " + e.getCuracion());
                        System.out.println("    Daño Base Causado:" + e.getDaño());
                        System.out.println("    Daño en Area: " + e.getDañoA());
                        System.out.println("    Daño Defensivo: " + e.getDañoDef());
                        System.out.println("    Aumento de Ataque: " + e.getAtaque());
                        System.out.println("    Aumento de Velocidad: " + e.getVelocidad());
                        System.out.println("    Efecto: " + e.getEfecto());
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");

                    }

                }
                //DE ENEMIGOS
                // i PASA POR ENEMIGOS
                System.out.println("\nENEMIGOS:\n\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                for(Combatiente i: CEnemigos){
                    System.out.println("ITEMS DEL "+i.getNombre()+": ");
                    for(Item e: i.getItems()){
                        System.out.println("Nombre: " + e.getNombre());
                        System.out.println("    Cantidad: " + e.getCantidad());
                        System.out.println("    Aumento de Vida: " + e.getVida());
                        System.out.println("    Curación a Aliados: " + e.getCuracion());
                        System.out.println("    Daño Base Causado:" + e.getDaño());
                        System.out.println("    Daño en Area: " + e.getDañoA());
                        System.out.println("    Daño Defensivo: " + e.getDañoDef());
                        System.out.println("    Aumento de Ataque: " + e.getAtaque());
                        System.out.println("    Aumento de Velocidad: " + e.getVelocidad());
                        System.out.println("    Efecto: " + e.getEfecto());
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

                    }

                }
                      
            }
            if(respuesta == 4){
                //Desplegar ATAQUES

            }
            if(respuesta == 5){
                //SALIR
                System.out.println("SALIENDO...");
            }
        }
    }


    //CREAR ALIADOS

    public static ArrayList crearAliados(int numAliados){
        Random rand = new Random();
        ArrayList<Combatiente> CAliados = new ArrayList<>();
        for(int i = 0; i <= numAliados-1;i++){
            //crea y genera las variables
            int tipoAliado = rand.nextInt(1,3);
            if(tipoAliado ==3){
                tipoAliado = rand.nextInt(1,2);
            }
            String nombre = " ";
            int puntosV = 0;
            boolean jugador = true;
            String estado = "vivo";
            ArrayList<Ataque> ataques = new ArrayList<>();
            ArrayList<Item> items = new ArrayList<>();
            //en caso de ser explorador:
            if(tipoAliado == 1){
                nombre = "Explorador";
                puntosV = 100;
                jugador = true;
                //VACIAR ARRAY LISTS
                ataques.clear();
                items.clear();
                //LLENAR ARRAY LISTS
                //ATAQUES
                //NOMBRE, ESPECIAL, CANTIDAD, DAÑO BASE, DAÑO CONTÍNUO, VELOCIDAD PROPIA, VELOCIDAD ENEMIGA, EFECTO/DESCRIPCIÓN
                Ataque ataE1 =  new Ataque("puñetazo", false, 15, 15, 0, 0, 0, "El Explorador lanza un puñetazo al " );
                Ataque ataE2 =  new Ataque("patada", false, 15, 10, 0, 0, 0, "El Explorador da una patada al " );
                Ataque ataE3 =  new Ataque("lanzar roca", false, 15, 15, 0, 0, 0, "El Explorador lanza una roca al " );
                Ataque ataE4 =  new Ataque("motivación", false, 5, 0, 0, 50, 0, "El Explorador se concentrá y recuerda el valor de la amistad aumentando su velocidad" );

                ataques.add(ataE1);
                ataques.add(ataE2);
                ataques.add(ataE3);
                ataques.add(ataE4);
                //ITEMS        public Item(String nombre, int cantidad, int vida, int curacion, int daño, int dañoA, int dañoDef, int ataque,

                Item itemE1 = new Item("Redencion",1, 0, 60, 0, 0, 0, 0, 10, "Curará a todos sus aliados incluyéndolos, también obtendrán  un ligero aumento de velocidad.");
                Item itemE2 = new Item("ALternador Hextech", 1, 0, 0, 0, 25, 0, 0, 10, "Disparaá el aternador causando daño en área a los enemigos");
                Item itemE3 = new Item("Armadura de tela", 1, 30, 0, 0, 0, 0, 0, -5, "Se pone una armadura que le aumenta la vida");
                Item itemE4 = new Item("Guantes de combate", 1, 0, 0, 0, 0, 0, 15, -5, "Se pone unos guates de hierro que le aumentan el daño, pero lo vuelven mas lento");

                items.add(itemE1);
                items.add(itemE2);
                items.add(itemE3);
                items.add(itemE4);



                //CREAR OBJETO DEL PERSONAJE/COMBATIENTE

                Combatiente CombName = new Combatiente(nombre, puntosV, jugador, ataques, items, estado);
                CombName.setVelocidad(20);
                CAliados.add(CombName);               
                

            }else if(tipoAliado == 2){
                nombre = "Guerrero";
                puntosV = 150;
                jugador = true;
                //VACIAR ARRAY LISTS
                ataques.clear();
                items.clear();
                //LLENAR ARRAY LISTS
                //ATAQUES:
                Ataque ataG1 =  new Ataque("apuñalar", false, 5, 30, 1, 0, 0, "El Guerrero usa su daga y apuñala al enemigo causando que sangre!!" );
                Ataque ataG2 =  new Ataque("embestir", false, 5, 25, 0, 0, 0, "El Guerrero embiste al enemigo causandole daño." );
                Ataque ataG3 =  new Ataque("Golpe de Escudo", false, 10, 15, 0, 0, -3, "El Guerrero golpea al enemigo con su escudo aturdiéndolo y volviéndolo mas lento. " );
                Ataque ataG4 =  new Ataque("Quemar", false, 5, 15, 4, 0, 0, "La espada del guerrero está prendida fuego!! La utiliza contra el enemigo causandole un efecto de quemadura." );

                ataques.add(ataG1);
                ataques.add(ataG2);
                ataques.add(ataG3);
                ataques.add(ataG4);

                //ITEMS
                Item itemG1 = new Item("Cota de Espinas", 1, 15, 0, 0, 0, -20, 0, -5, "Realizará daño cuando lo ataquen");
                Item itemG2 = new Item("Posión de Furia", 2, 0, 0, 0, 0, 0, 40, 15, "Obtendrá mas poder de ataque y más velocidad");
            
                items.add(itemG1);
                items.add(itemG2);
             //CREAR OBJETO DEL PERSONAJE/COMBATIENTE
             //String combName = "guerrero"+i;

             Combatiente CombName = new Combatiente(nombre, puntosV, jugador, ataques, items, estado);
             CombName.setVelocidad(30);
             CAliados.add(CombName);

            }
        }

        return CAliados;
    }   

    //CREAR ENEMIGOS
    public static ArrayList crearEnemigos(int numEnemigos){
        Random rand = new Random();
        ArrayList<Combatiente> CEnemigos = new ArrayList<>();
        for(int i = 0; i <= numEnemigos-1;i++){
            //crea y genera las variables
            int tipoEnemigo = rand.nextInt(1,3);
            if(tipoEnemigo ==3){
                tipoEnemigo = rand.nextInt(1,2);
            }
            String nombre = " ";
            int puntosV = 0;
            boolean jugador = true;
            ArrayList<Ataque> ataques = new ArrayList<>();
            ArrayList<Item> items = new ArrayList<>();
            String estado = "vivo";
            //en caso de ser explorador:
            if(tipoEnemigo == 1){
                nombre = "Explorador Enemigo";
                puntosV = 100;
                jugador = false;
                //VACIAR ARRAY LISTS
                ataques.clear();
                items.clear();
                //LLENAR ARRAY LISTS
                //ATAQUES
                //NOMBRE, ESPECIAL, CANTIDAD, DAÑO BASE, DAÑO CONTÍNUO, VELOCIDAD PROPIA, VELOCIDAD ENEMIGA, EFECTO/DESCRIPCIÓN
                Ataque ataE1 =  new Ataque("puñetazo", false, 15, 15, 0, 0, 0, "El Explorador lanza un puñetazo al " );
                Ataque ataE2 =  new Ataque("patada", false, 15, 10, 0, 0, 0, "El Explorador da una patada al " );
                Ataque ataE3 =  new Ataque("lanzar roca", false, 15, 15, 0, 0, 0, "El Explorador lanza una roca al " );
                Ataque ataE4 =  new Ataque("motivación", false, 5, 0, 0, 50, 0, "El Explorador se concentrá y recuerda el valor de la amistad aumentando su velocidad" );

                ataques.add(ataE1);
                ataques.add(ataE2);
                ataques.add(ataE3);
                ataques.add(ataE4);
                //ITEMS        public Item(String nombre, int cantidad, int vida, int curacion, int daño, int dañoA, int dañoDef, int ataque,

                Item itemE1 = new Item("Redencion",1, 0, 60, 0, 0, 0, 0, 10, "Curará a todos sus aliados incluyéndolos, también obtendrán  un ligero aumento de velocidad.");
                Item itemE2 = new Item("ALternador Hextech", 1, 0, 0, 0, 25, 0, 0, 10, "Disparaá el aternador causando daño en área a los enemigos");
                Item itemE3 = new Item("Armadura de tela", 1, 30, 0, 0, 0, 0, 0, -5, "Se pone una armadura que le aumenta la vida");
                Item itemE4 = new Item("Guantes de combate", 1, 0, 0, 0, 0, 0, 15, -5, "Se pone unos guates de hierro que le aumentan el daño, pero lo vuelven mas lento");

                items.add(itemE1);
                items.add(itemE2);
                items.add(itemE3);
                items.add(itemE4);



                //CREAR OBJETO DEL PERSONAJE/COMBATIENTE

                Combatiente CombNamee = new Combatiente(nombre, puntosV, jugador, ataques, items, estado);
                CombNamee.setVelocidad(20);
                CEnemigos.add(CombNamee);               
                

            }else if(tipoEnemigo == 2){
                nombre = "Guerrero Enemigo";
                puntosV = 150;
                jugador = false;
                //VACIAR ARRAY LISTS
                ataques.clear();
                items.clear();
                //LLENAR ARRAY LISTS
                //ATAQUES:
                Ataque ataG1 =  new Ataque("apuñalar", false, 5, 30, 1, 0, 0, "El Guerrero usa su daga y apuñala al enemigo causando que sangre!!" );
                Ataque ataG2 =  new Ataque("embestir", false, 5, 25, 0, 0, 0, "El Guerrero embiste al enemigo causandole daño." );
                Ataque ataG3 =  new Ataque("Golpe de Escudo", false, 10, 15, 0, 0, -3, "El Guerrero golpea al enemigo con su escudo aturdiéndolo y volviéndolo mas lento. " );
                Ataque ataG4 =  new Ataque("Quemar", false, 5, 15, 4, 0, 0, "La espada del guerrero está prendida fuego!! La utiliza contra el enemigo causandole un efecto de quemadura." );

                ataques.add(ataG1);
                ataques.add(ataG2);
                ataques.add(ataG3);
                ataques.add(ataG4);
                //ITEMS
                Item itemG1 = new Item("Cota de Espinas", 1, 15, 0, 0, 0, -20, 0, -5, "Realizará daño cuando lo ataquen");
                Item itemG2 = new Item("Posión de Furia", 2, 0, 0, 0, 0, 0, 40, 15, "Obtendrá mas poder de ataque y más velocidad");
            
                items.add(itemG1);
                items.add(itemG2);

             //CREAR OBJETO DEL PERSONAJE/COMBATIENTE
             //String combName = "guerrero"+i;

             Combatiente CombNamee = new Combatiente(nombre, puntosV, jugador, ataques, items, estado);
             CombNamee.setVelocidad(30);
             CEnemigos.add(CombNamee);

            }
        }

        return CEnemigos;
    }   
}
