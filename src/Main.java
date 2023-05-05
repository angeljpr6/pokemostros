import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sn=new Scanner(System.in);

        Pokedex pokedexProta = new Pokedex(1);
        Pokedex pokedexLucas = new Pokedex(2);
        Pokedex pokedexDani = new Pokedex(3);
        Pokedex pokedexRaul = new Pokedex(4);
        Pokedex pokedexCynthia = new Pokedex(5);
        Entrenador protagonista = new Entrenador(1,pokedexProta);

        // Pokemons
        Pokemon pikachu = new Pokemon(25,"Electrico","Pikachu",1,20,5);
        Pokemon bulbasaur = new Pokemon(1,"Planta","Bulbasaur",1,20,5);
        Pokemon ivysaur = new Pokemon(2,"Planta","Ivysaur",1,40,5);
        Pokemon venusaur = new Pokemon(3,"Planta","Venusaur",1,100,5);
        Pokemon charmander = new Pokemon(4,"Fuego","Charmander",1,20,5);
        Pokemon charmeleon = new Pokemon(5,"Fuego","Charmeleon",1,20,5);
        Pokemon charizard = new Pokemon(6,"Fuego","Charizard",1,20,5);
        Pokemon squirtle = new Pokemon(7,"Agua","Squirtle",1,20,5);
        Pokemon wartortle = new Pokemon(8,"Agua","Wartortle",1,20,5);
        Pokemon blastoise = new Pokemon(9,"Agua","Blastoise",1,20,5);
        Pokemon growlithe = new Pokemon(58,"Fuego","Growlithe",6,38,8);
        Pokemon poliwag = new Pokemon(58,"Agua","Poliwag",4,32,7);
        Pokemon ponyta = new Pokemon(58,"Fuego","Ponyta",4,34,7);
        Pokemon vaporeon = new Pokemon(58,"Agua","Vaporeon",5,36,8);

        //Array de pokemon salvajes
        ArrayList<Pokemon> pokemonsRegion=new ArrayList<>();
        pokemonsRegion.add(bulbasaur);
        pokemonsRegion.add(venusaur);
        pokemonsRegion.add(ivysaur);
        pokemonsRegion.add(charmander);
        pokemonsRegion.add(charmeleon);
        pokemonsRegion.add(charizard);
        pokemonsRegion.add(squirtle);
        pokemonsRegion.add(wartortle);
        pokemonsRegion.add(blastoise);
        pokemonsRegion.add(pikachu);

        //Array de entrenadores
        Entrenador lucas=new Entrenador(2,"Dominguero Lucas",pokedexLucas);
        lucas.anadirPokemon(poliwag);

        Entrenador dani=new Entrenador(2,"Ornitologo Dani",pokedexDani);
        dani.anadirPokemon(growlithe);


        Entrenador raul=new Entrenador(2,"Montañero Raul",pokedexRaul);
        raul.anadirPokemon(vaporeon);

        Entrenador cynthia=new Entrenador(2,"Karateka Cynthia",pokedexCynthia);
        cynthia.anadirPokemon(ponyta);

        ArrayList<Entrenador> entrenadores =new ArrayList<>();
        entrenadores.add(lucas);
        entrenadores.add(dani);
        entrenadores.add(raul);
        entrenadores.add(cynthia);


        //La posicion del pokemon que estas usando (Hay que restarle 1) y el numero de pokemons debilitados
        int posicionPokemon=0,nPokeDebilitados=0;

        int aux=0;

        //Un boolean con el que nos aseguramos de si se continuara la pelea o no
        boolean salirPelea=false;

        //Elijes tu pokemon inicial
        ControlarTexto.limpiarConsola();
        ControlarTexto.mostrarTextoLento("Buenas, soy el profesor Leonardo,\n" +
                "Me dedico a la investigacion de pokemon en toda la region de Gran Canaria.\n");
        sn.nextLine();
        ControlarTexto.limpiarConsola();
        ControlarTexto.mostrarTextoLento("Los pokemon son criaturas que conviven con los humanos, algunos los usan como\n" +
                "mascotas y otros, como tu, los esclavizan y obligan a pelear entre ellos\n\n" +
                "Dime ¿Cual es tu nombre?\n");
        protagonista.setNombre(sn.nextLine());
        ControlarTexto.limpiarConsola();
        ControlarTexto.mostrarTextoLento("\n"+protagonista.getNombre()+"... Vaya nombre\n" +
                "Bueno "+protagonista.getNombre()+" es hora de que empieces un aventura pokemon\n" +
                "Pero sin un pokemon para empezar no puedes hacer nada que putada");
        sn.nextLine();
        ControlarTexto.limpiarConsola();
        ControlarTexto.mostrarTextoLento("Venga va, que me has caido bien, te puedo dejar uno de estos\n" +
                "elije\n");
        protagonista.elegirPokInicial(sn,charmander,squirtle,bulbasaur);
        sn.nextLine();
        ControlarTexto.limpiarConsola();
        ControlarTexto.mostrarTextoLento("Pues ya que te deje el pokemon tendras que trabajar para mi\n" +
                "Toma esto\n");
        sn.nextLine();
        ControlarTexto.limpiarConsola();
        System.out.println("**Has recibido una pokedex**\n");
        sn.nextLine();
        ControlarTexto.limpiarConsola();
        ControlarTexto.mostrarTextoLento("Con esto registraras pokemon una vez te encuentres con ellos\n" +
                "Intenta capturarlos a todos para yo poder reunir mas informacion sobre ellos\n" +
                "(A ti solo te saldra si esta capturado o no)\n");
        sn.nextLine();
        ControlarTexto.limpiarConsola();
        ControlarTexto.mostrarTextoLento("Pues venga tira a pagar la deuda de tu "+protagonista.getMochila().get(0).getNombre()+"\n");
        sn.nextLine();
        ControlarTexto.limpiarConsola();

        //Opcion de los menus
        int opcion=1;

        //TODOS LOS MENUS
        while (opcion!=-2) {
            
            opcion = menuPrincipal(sn);
            
            switch (opcion){
                case 1:
                    int idPokemonRegion=Pokemon.buscarPokemon(pokemonsRegion);
                    if (idPokemonRegion==-1){
                        System.out.println("Ya no queda ningun pokemon");
                        break;
                    }
                    System.out.println("Un "+ pokemonsRegion.get(idPokemonRegion).getNombre()+" salvaje ha aparecido");
                    if (protagonista.getPokedex().comprobarPokemon(pokemonsRegion.get(idPokemonRegion))){

                    }else protagonista.getPokedex().anadirPokemonVisto(pokemonsRegion.get(idPokemonRegion));


                    salirPelea=false;
                    while (salirPelea==false) {
                        
                        opcion = menuLucha(sn, protagonista, pokemonsRegion, posicionPokemon, idPokemonRegion);
                        
                        switch (opcion) {
                            case 1:
                                protagonista.elegirMovimiento(sn,posicionPokemon,pokemonsRegion,idPokemonRegion);
                                break;
                            case 2:
                                double huir=Math.random()*10;
                                if (huir>4){
                                    System.out.println("Has logrado escapar");
                                    salirPelea=true;
                                } else System.out.println("No has logrado escapar");
                                break;
                            case 3:
                                System.out.println("¿Que pokemon quieres usar?");
                                protagonista.verMochila();
                                while (true) {
                                    posicionPokemon= sn.nextInt()-1;
                                    if (protagonista.getMochila().get(posicionPokemon).getPtosVida()==0){
                                        System.out.println("El pokemon esta debilitado, no puede combatir");
                                        System.out.println("Elije otro pokemon");
                                    } else break;
                                }
                                break;
                            case 4:
                                if (protagonista.capturarPokemon(pokemonsRegion.get(idPokemonRegion))){
                                    salirPelea=true;
                                }else System.out.println("Se ha escapado");
                                sn.nextLine();
                                break;
                        }

                        //Victoria
                        if (pokemonsRegion.get(idPokemonRegion).getPtosVida()<=0){
                            System.out.println("Felicidades has derrotado al "+ pokemonsRegion.get(idPokemonRegion).getNombre());
                            pokemonsRegion.remove(pokemonsRegion.get(idPokemonRegion));
                            break;
                        }
                        if (salirPelea==false) {
                            aux = (int) Math.floor(Math.random() * pokemonsRegion.get(idPokemonRegion).getMovimientos().size());
                            pokemonsRegion.get(idPokemonRegion).atacarPokemon(protagonista.getMochila().get(posicionPokemon), aux);

                            //Pokemon Debilitado
                            if (protagonista.getMochila().get(posicionPokemon).getPtosVida() <= 0) {
                                System.out.println(protagonista.getMochila().get(posicionPokemon).getNombre() + " se ha debilitado");
                                nPokeDebilitados++;
                                if (nPokeDebilitados == protagonista.getMochila().size()) {
                                    System.out.println("No te quedan mas pokemon, ");
                                    ControlarTexto.mostrarTextoLento("has perdido...");
                                    salirPelea = true;
                                } else {
                                    protagonista.verMochila();
                                    while (true) {
                                        System.out.println("Elije otro pokemon");
                                        posicionPokemon = sn.nextInt() - 1;
                                        if (protagonista.getMochila().get(posicionPokemon).getPtosVida() == 0) {
                                            System.out.println("El pokemon esta debilitado, no puede combatir");
                                        } else break;
                                    }
                                }
                            }
                        }
                        sn.nextLine();
                        ControlarTexto.limpiarConsola();
                    }
                    Pokemon.curarPokemons(pokemonsRegion);
                    Pokemon.curarPokemons(protagonista.getMochila());
                    break;
                case 2:
                    protagonista.verMochila();
                    break;
                case 3:
                    protagonista.getPokedex().verPokedex();
                    break;
                case 4:
                    System.out.println("Elije la posicion del pokemon que quieras liberar");
                    protagonista.verMochila();
                    opcion= sn.nextInt();
                    protagonista.liberarPokemon(opcion-1);
                    break;
                case 5:
                    int suPokemon=0,tuPokemon=0;
                    System.out.println("¿Con quien quieres intercambiar?");
                    for (int i = 0; i < entrenadores.size(); i++) {
                        System.out.println((i+1)+": "+entrenadores.get(i).getNombre());
                    }
                    opcion= sn.nextInt();
                    switch (opcion){
                        case 1:
                            menuIntercambiarPokemon(protagonista, suPokemon, lucas, tuPokemon, sn);
                            break;
                        case 2:
                            menuIntercambiarPokemon(protagonista, suPokemon, dani, tuPokemon, sn);
                            break;
                        case 3:
                            menuIntercambiarPokemon(protagonista, suPokemon, raul, tuPokemon, sn);
                            break;
                        case 4:
                            menuIntercambiarPokemon(protagonista, suPokemon, cynthia, tuPokemon, sn);
                            break;
                    }
                    break;
                default:
                    System.out.println("tu ere tonto o k");
            }

        }



    }

    private static void menuIntercambiarPokemon(Entrenador entrenador1, int tuPokemon, Entrenador entrenador2, int suPokemon, Scanner sn) {
        ControlarTexto.mostrarTextoLento("Elije el pokemon que quieres");
        entrenador2.verMochila();
        tuPokemon = sn.nextInt()-1;
        ControlarTexto.mostrarTextoLento("Elije el pokemon que quieres ofrecer");
        entrenador1.verMochila();
        suPokemon = sn.nextInt()-1;
        entrenador1.intercambiarPokemon(entrenador1.getMochila().get(suPokemon), entrenador2, entrenador2.getMochila().get(tuPokemon));
    }

    private static int menuPrincipal(Scanner sn) {
        int opcion;
        System.out.println("╔════════════════════════════╗");
        System.out.println("║ 1: Buscar un pokemon       ║");
        System.out.println("║ 2: Ver tus pokemon         ║");
        System.out.println("║ 3: Ver tu pokedex          ║");
        System.out.println("║ 4: Liberar un pokemon      ║");
        System.out.println("║ 5: Intercambiar un pokemon ║");
        System.out.println("║ -2: Salir                  ║");
        System.out.println("╚════════════════════════════╝");
        opcion = sn.nextInt();
        return opcion;
    }

    /**
     * Muestra el menu de la lucha (informacion sobre ambos pokemon, muestra las opciones y pide
     * la accion que quieras realizar
     * 
     * @param sn
     * @param entrenador1
     * @param pokemonsRegion
     * @param posicionPokemon
     * @param idPokemonRegion
     * @return int o
     */
    private static int menuLucha(Scanner sn, Entrenador entrenador1, ArrayList<Pokemon> pokemonsRegion, int posicionPokemon, int idPokemonRegion) {
        int opcion;
        System.out.println("╔════════════════════════════════════════════════════════");
        System.out.println("║                                  "+ pokemonsRegion.get(idPokemonRegion).getNombre());
        System.out.println("║                                  Nivel "+ pokemonsRegion.get(idPokemonRegion).getLvl());
        System.out.print("║                                  Vida  "+ pokemonsRegion.get(idPokemonRegion).getPtosVida());
        for (int j = 0; j < pokemonsRegion.get(idPokemonRegion).getPtosVida(); j+=3) {
            if (j+3> pokemonsRegion.get(idPokemonRegion).getPtosVida()){
                break;
            }
            System.out.print("-");
        }
        System.out.println("");
        System.out.println("║ "+ entrenador1.getMochila().get(posicionPokemon).getNombre());
        System.out.println("║ Nivel "+ entrenador1.getMochila().get(posicionPokemon).getLvl());
        System.out.print("║ Vida  "+ entrenador1.getMochila().get(posicionPokemon).getPtosVida());
        for (int j = 0; j < entrenador1.getMochila().get(posicionPokemon).getPtosVida(); j+=3) {
            if (j+3> entrenador1.getMochila().get(posicionPokemon).getPtosVida()){
                break;
            }
            System.out.print("-");
        }
        System.out.println("");
        System.out.println("╚════════════════════════════════════════════════════════");

        System.out.println("╔═══════════════════════════════════════════╗");
        System.out.println("║                                           ║");
        System.out.println("║ Elije una opcion:                         ║");
        System.out.println("║ 1: Luchar             2: Huir             ║");
        System.out.println("║                                           ║");
        System.out.println("║ 3: Cambiar Pokemon    4: Lanzar Pokeball  ║");
        System.out.println("║                                           ║");
        System.out.println("╚═══════════════════════════════════════════╝");
        opcion = sn.nextInt();
        return opcion;
    }

    public static void showMenu(){

    }
}