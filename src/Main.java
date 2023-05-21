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
        Pokemon bulbasaur = new Pokemon(1,"Planta","Bulbasaur",5,28,5);
        Pokemon ivysaur = new Pokemon(2,"Planta","Ivysaur",1,20,5);
        Pokemon venusaur = new Pokemon(3,"Planta","Venusaur",1,20,5);
        Pokemon charmander = new Pokemon(4,"Fuego","Charmander",5,28,5);
        Pokemon charmeleon = new Pokemon(5,"Fuego","Charmeleon",1,20,5);
        Pokemon charizard = new Pokemon(6,"Fuego","Charizard",1,20,5);
        Pokemon squirtle = new Pokemon(7,"Agua","Squirtle",5,28,5);
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


        //posicionPokemon: la posicion del pokemon que estas usando (Hay que restarle 1)
        //nPokeDebilitados: el numero de pokemons debilitados en la mochila del protagonista
        //nivelPokSalv : el nivel del pokemon salvaje
        int posicionPokemon=0,nPokeDebilitados=0,nivelPokSalv;


        //Un boolean con el que nos aseguramos de si se continuara la pelea o no
        boolean salirPelea=false;

        //Texto inicial
        introduccion(sn, protagonista, bulbasaur, charmander, squirtle);

        //Opcion de los menus
        int opcion=1;

        //TODOS LOS MENUS
        while (opcion!=-2) {

            opcion = menuPrincipal(sn);
            
            switch (opcion){
                case 1:
                    if (protagonista.getMochila().size()>0) {


                        nivelPokSalv=elejirDificultad(sn);
                        Pokemon pokemonSalvaje=Pokemon.buscarPokemon(pokemonsRegion);
                        System.out.println("Un " + pokemonSalvaje.getNombre() + " salvaje ha aparecido");
                        pokemonSalvaje.setLvl(nivelPokSalv);
                        pokemonSalvaje.setPtosVida(20+(nivelPokSalv*2));
                        if (protagonista.getPokedex().comprobarPokemon(pokemonSalvaje)) {

                        } else protagonista.getPokedex().anadirPokemonVisto(pokemonSalvaje);

                        salirPelea = false;
                        while (salirPelea == false) {

                            opcion = menuLucha(sn, protagonista, posicionPokemon, pokemonSalvaje);

                            switch (opcion) {
                                case 1:
                                    protagonista.elegirMovimiento(sn, posicionPokemon, pokemonSalvaje);
                                    break;
                                case 2:
                                    salirPelea=huir();
                                    break;
                                case 3:
                                    System.out.println("¿Que pokemon quieres usar?");
                                    protagonista.verMochila();
                                    while (true) {
                                        posicionPokemon = sn.nextInt() - 1;
                                        if (protagonista.getMochila().get(posicionPokemon).getPtosVida() == 0) {
                                            System.out.println("El pokemon esta debilitado, no puede combatir");
                                            System.out.println("Elije otro pokemon");
                                        } else break;
                                    }
                                    break;
                                case 4:
                                    if (protagonista.capturarPokemon(pokemonSalvaje)) {
                                        salirPelea = true;
                                    } else System.out.println("Se ha escapado");
                                    sn.nextLine();
                                    break;
                                default:
                                    System.out.println("La opcion no es valida");
                                    continue;
                            }

                            //Victoria
                            if (pokemonSalvaje.getPtosVida() <= 0) {
                                System.out.println("Felicidades has derrotado al " +pokemonSalvaje.getNombre());
                                double experiencia=pokemonSalvaje.getLvl()*40/protagonista.getMochila().get(posicionPokemon).getLvl();
                                protagonista.getMochila().get(posicionPokemon).subirExp(experiencia);
                                break;
                            }

                            if (salirPelea == false) {
                                // Se elije un movimiento aleatorio del pokemon salvaje
                                pokemonSalvaje.atacarPokemon(protagonista.getMochila().get(posicionPokemon), (int) Math.floor(Math.random() * pokemonSalvaje.getMovimientos().size()));

                                //Pokemon Debilitado
                                nPokeDebilitados=menuPokemonDebilitado(protagonista,posicionPokemon,nPokeDebilitados,sn);
                                salirPelea=menuPerder(protagonista,nPokeDebilitados);

                            }
                            sn.nextLine();
                            ControlarTexto.limpiarConsola();
                        }
                        Pokemon.curarPokemons(pokemonsRegion);
                        Pokemon.curarPokemons(protagonista.getMochila());
                    }else System.out.println("No tienes ningun pokemon en tu inventario\n");
                    break;
                case 2:
                    protagonista.verMochila();
                    break;
                case 3:
                    protagonista.getPokedex().verPokedex();
                    break;
                case 4:
                    while (true) {
                        System.out.println("Elije la posicion del pokemon que quieras liberar (-1 para salir)");
                        protagonista.verMochila();
                        opcion = sn.nextInt();
                        if (opcion==-1){
                            break;
                        }
                        try{
                            protagonista.liberarPokemon(opcion - 1);
                        }catch (IndexOutOfBoundsException e){
                            System.out.println("La opcion elegida no corresponde a ningun pokemon");
                            continue;
                        }
                        break;
                    }
                    break;
                case 5:
                    System.out.println("¿Con quien quieres intercambiar?");
                    for (int i = 0; i < entrenadores.size(); i++) {
                        System.out.println((i+1)+": "+entrenadores.get(i).getNombre());
                    }
                    opcion= sn.nextInt();
                    switch (opcion){
                        case 1:
                            menuIntercambiarPokemon(protagonista, lucas, sn);
                            break;
                        case 2:
                            menuIntercambiarPokemon(protagonista, dani, sn);
                            break;
                        case 3:
                            menuIntercambiarPokemon(protagonista, raul, sn);
                            break;
                        case 4:
                            menuIntercambiarPokemon(protagonista, cynthia, sn);
                            break;
                    }
                    break;
                default:
                    System.out.println("tu ere tonto o k");
            }

            nPokeDebilitados=0;
        }



    }

    private static void introduccion(Scanner sn, Entrenador protagonista, Pokemon bulbasaur, Pokemon charmander, Pokemon squirtle) {
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
        ControlarTexto.mostrarTextoLento("\n"+ protagonista.getNombre()+"... Vaya nombre\n" +
                "Bueno "+ protagonista.getNombre()+" es hora de que empieces un aventura pokemon\n" +
                "Aunque... sin un pokemon para empezar poco puedes hacer");
        sn.nextLine();
        ControlarTexto.limpiarConsola();
        ControlarTexto.mostrarTextoLento("Venga va, que me has caido bien, te puedo dejar uno de estos\n" +
                "elije\n");
        protagonista.elegirPokInicial(sn, charmander, squirtle, bulbasaur);
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
        ControlarTexto.mostrarTextoLento("Pues venga tira a pagar la deuda de tu "+ protagonista.getMochila().get(0).getNombre()+"\n");
        sn.nextLine();
        ControlarTexto.limpiarConsola();
    }

    /**
     * Este metodo hace una operacion matematica para dejar o no escapar al entrenador
     *
     * @return el boolean salirPelea
     */
    private static boolean huir(){
        boolean salirPelea;
        double huir = Math.random() * 10;
        if (huir > 4) {
            System.out.println("Has logrado escapar");
            return salirPelea = true;
        } else System.out.println("No has logrado escapar");
        return salirPelea=false;
    }

    /**
     * /**
     * Si se debilita un pokemon se pasara este metodo que sumara el numero de pokemon debilitados (un indicador que cuantos pokemon te quedan por usar)
     * y en caso de que te quede alguno mas con vida suficiente para pelear te ensemara la mochila y te pedira que elijas un pokemon con vida.
     *
     * @param tuEntrenador
     * @param posTuPok
     * @param nPokeDebilitados
     * @param sn
     * @return numero de pokemon debilitados
     */
    private static int menuPokemonDebilitado(Entrenador tuEntrenador,int posTuPok,int nPokeDebilitados,Scanner sn){
        if (tuEntrenador.getMochila().get(posTuPok).getPtosVida() <= 0) {
            System.out.println(tuEntrenador.getMochila().get(posTuPok).getNombre() + " se ha debilitado");
            nPokeDebilitados++;
            if (nPokeDebilitados < tuEntrenador.getMochila().size()) {
                tuEntrenador.verMochila();
                while (true) {
                    System.out.println("Elije otro pokemon");
                    posTuPok = sn.nextInt() - 1;
                    if (tuEntrenador.getMochila().get(posTuPok).getPtosVida() == 0) {
                        System.out.println("El pokemon esta debilitado, no puede combatir");
                    } else break;
                }
            }
        }
        return nPokeDebilitados;
    }

    /**
     * Este metodo pide al usuario que elija una dificultad lo cual afectara al nivel del pokemon rival
     * @param sn
     * @return
     */
    public static int elejirDificultad(Scanner sn){

        int opcion,nivelPokSalv=0;

        while (true) {

        System.out.println("Elije una dificultad:");
        System.out.println("1: Nivel 1-10");
        System.out.println("2: Nivel 11-20");
        System.out.println("3: Nivel 21-30");
        System.out.println("4: Nivel 31-40");
        System.out.println("5: Nivel 41-50");
        System.out.println("6: Nivel 51-100");

        opcion=Integer.parseInt(sn.next());


            switch (opcion) {
                case 1:
                    nivelPokSalv = ((int) (Math.random() * 10 + 1));
                    break;
                case 2:
                    nivelPokSalv = ((int) (Math.random() * 10 + 11));
                    break;
                case 3:
                    nivelPokSalv = ((int) (Math.random() * 10 + 21));
                    break;
                case 4:
                    nivelPokSalv = ((int) (Math.random() * 10 + 31));
                    break;
                case 5:
                    nivelPokSalv = ((int) (Math.random() * 10 + 41));
                    break;
                case 6:
                    nivelPokSalv = ((int) (Math.random() * 50 + 51));
                    break;
                default:
                    System.out.println("Ese nivel no existe colega");
                    continue;

            }
            break;
        }
        return nivelPokSalv;
    }

    /**
     * Cuando se debilita un pokemon se pasara por este metodo para que en caso de que no quede ninguno
     * con vida el boolean salirPelea se iguales a true (Es decir se saldra de la pelea porquer no quedan
     * pokemons con vida con los que poder combatir)
     *
     * @param tuEntrenador
     * @param nPokeDebilitados
     * @return boolean salir pelea
     */
    private static boolean menuPerder(Entrenador tuEntrenador,int nPokeDebilitados){
        boolean salirPelea;
        if (nPokeDebilitados == tuEntrenador.getMochila().size()) {
            System.out.println("No te quedan mas pokemon, ");
            ControlarTexto.mostrarTextoLento("has perdido...");
            return salirPelea=true;
        }
        return salirPelea=false;
    }

    /**
     * Menu que muestra la mochila del otro entrenador y la tuya y te pide que elijas que pokemon quieres intercambiar de cada uno
     * @param entrenador1
     * @param entrenador2
     * @param sn
     */
    private static void menuIntercambiarPokemon(Entrenador entrenador1, Entrenador entrenador2, Scanner sn) {
        int tuPokemon,suPokemon;
        while (true) {
            System.out.println("Elije el pokemon que quieres");
            entrenador2.verMochila();
            suPokemon = sn.nextInt() - 1;
            if (entrenador2.getMochila().size()<(suPokemon+1) || suPokemon<0){
                System.out.println("Ese pokemon no existe");
                continue;
            }
            break;
        }

        while (true) {
            System.out.println("Elije el pokemon que quieres ofrecer");
            entrenador1.verMochila();
            tuPokemon = sn.nextInt() - 1;
            if (entrenador1.getMochila().size()<(tuPokemon+1) || tuPokemon<0){
                System.out.println("Ese pokemon no existe");
                continue;
            }
            break;
        }
        entrenador1.intercambiarPokemon(entrenador1.getMochila().get(tuPokemon), entrenador2, entrenador2.getMochila().get(suPokemon));
    }

    /**
     * Menu principal de juego
     * @param sn
     * @return
     */
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
     * @param posicionPokemon
     * @param pokemon
     * @return int con la opcion elegida
     */
    private static int menuLucha(Scanner sn, Entrenador entrenador1, int posicionPokemon, Pokemon pokemon) {
        int opcion;
        System.out.println("╔════════════════════════════════════════════════════════");
        System.out.println("║                                  "+ pokemon.getNombre());
        System.out.println("║                                  Nivel "+ pokemon.getLvl());
        System.out.print("║                                  Vida  "+ pokemon.getPtosVida());
        for (int j = 0; j < pokemon.getPtosVida(); j+=3) {
            if (j+3> pokemon.getPtosVida()){
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
}