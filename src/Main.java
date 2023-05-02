import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sn=new Scanner(System.in);

        Pokedex pokedexAngel = new Pokedex(1);
        Pokedex pokedexLucas = new Pokedex(2);
        Pokedex pokedexDani = new Pokedex(3);
        Pokedex pokedexRaul = new Pokedex(4);
        Pokedex pokedexCynthia = new Pokedex(5);
        Entrenador angel = new Entrenador(1,"Angel",pokedexAngel);

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


        Entrenador raul=new Entrenador(2,"Montañero Lucas",pokedexRaul);
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

        boolean salirPelea=false;

        //Opcion de los menus
        int opcion=1;
        System.out.println("══════════════════════════════");
        System.out.println("Comienza la aventura Pokemon");
        System.out.println("Elije un pokemon:");
        System.out.println("1: Charmander     2: Squirtle     3: Bulbasaur");
        opcion= sn.nextInt();
        switch (opcion){
            case 1:
                angel.anadirPokemon(charmander);
                pokemonsRegion.remove(charmander);
                break;
            case 2:
                angel.anadirPokemon(squirtle);
                pokemonsRegion.remove(squirtle);
                break;
            case 3:
                angel.anadirPokemon(bulbasaur);
                pokemonsRegion.remove(bulbasaur);
                break;
            default:
                System.out.println("ere tonto o k");
        }


        while (opcion!=-2) {
            System.out.println("╔════════════════════════════╗");
            System.out.println("║ 1: Buscar un pokemon       ║");
            System.out.println("║ 2: Ver tus pokemon         ║");
            System.out.println("║ 3: Ver tu pokedex          ║");
            System.out.println("║ 4: Liberar un pokemon      ║");
            System.out.println("║ 5: Intercambiar un pokemon ║");
            System.out.println("║ -2: Salir                  ║");
            System.out.println("╚════════════════════════════╝");
            opcion = sn.nextInt();
            switch (opcion){
                case 1:
                    int idPokemonRegion=angel.buscarPokemon(pokemonsRegion);
                    if (idPokemonRegion==-1){
                        System.out.println("Ya no queda ningun pokemon");
                        break;
                    }
                    System.out.println("Un "+ pokemonsRegion.get(idPokemonRegion).getNombre()+" salvaje ha aparecido");
                    angel.getPokedex().anadirPokemonVisto(pokemonsRegion.get(idPokemonRegion));
                    salirPelea=false;
                    while (salirPelea==false) {
                        int i=0;
                        System.out.println("╔════════════════════════════════════════════════════════");
                        System.out.println("║                                  "+ pokemonsRegion.get(idPokemonRegion).getNombre());
                        System.out.println("║                                  Nivel "+ pokemonsRegion.get(idPokemonRegion).getLvl());
                        System.out.print("║                                  Vida  "+ pokemonsRegion.get(idPokemonRegion).getPtosVida());
                        for (int j = 0; j < pokemonsRegion.get(idPokemonRegion).getPtosVida(); j+=3) {
                            if (j+3>pokemonsRegion.get(idPokemonRegion).getPtosVida()){
                                break;
                            }
                            System.out.print("-");
                        }
                        System.out.println("");
                        System.out.println("║ "+angel.getMochila().get(posicionPokemon).getNombre());
                        System.out.println("║ Nivel "+angel.getMochila().get(posicionPokemon).getLvl());
                        System.out.print("║ Vida  "+angel.getMochila().get(posicionPokemon).getPtosVida());
                        for (int j = 0; j < angel.getMochila().get(posicionPokemon).getPtosVida(); j+=3) {
                            if (j+3>angel.getMochila().get(posicionPokemon).getPtosVida()){
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
                        switch (opcion) {
                            case 1:
                                System.out.println("Elije un movimiento: ");
                                angel.getMochila().get(posicionPokemon).verMovimientos();
                                opcion= sn.nextInt()-1;
                                angel.getMochila().get(posicionPokemon).atacarPokemon(pokemonsRegion.get(idPokemonRegion),opcion);
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
                                angel.verMochila();
                                while (true) {
                                    posicionPokemon= sn.nextInt()-1;
                                    if (angel.getMochila().get(posicionPokemon).getPtosVida()==0){
                                        System.out.println("El pokemon esta debilitado, no puede combatir");
                                        System.out.println("Elije otro pokemon");
                                    } else break;
                                }
                                break;
                            case 4:
                                if (angel.capturarPokemon(pokemonsRegion.get(idPokemonRegion))){
                                    pokemonsRegion.remove(pokemonsRegion.get(idPokemonRegion));
                                    salirPelea=true;
                                }else System.out.println("Se ha escapado");
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
                            pokemonsRegion.get(idPokemonRegion).atacarPokemon(angel.getMochila().get(posicionPokemon), aux);

                            //Pokemon Debilitado
                            if (angel.getMochila().get(posicionPokemon).getPtosVida() <= 0) {
                                System.out.println(angel.getMochila().get(posicionPokemon).getNombre() + " se ha debilitado");
                                nPokeDebilitados++;
                                if (nPokeDebilitados == angel.getMochila().size()) {
                                    System.out.println("No te quedan mas pokemon, has perdido...");
                                    salirPelea = true;
                                } else {
                                    angel.verMochila();
                                    while (true) {
                                        System.out.println("Elije otro pokemon");
                                        posicionPokemon = sn.nextInt() - 1;
                                        if (angel.getMochila().get(posicionPokemon).getPtosVida() == 0) {
                                            System.out.println("El pokemon esta debilitado, no puede combatir");
                                        } else break;
                                    }
                                }

                            }
                        }

                    }

                    break;
                case 2:
                    angel.verMochila();
                    break;
                case 3:
                    angel.getPokedex().verPokedex();
                    break;
                case 4:
                    System.out.println("Elije la posicion del pokemon que quieras eliminar");
                    angel.verMochila();
                    opcion= sn.nextInt();
                    angel.liberarPokemon(opcion-1);
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
                            System.out.println("Elije el pokemon que quieres");
                            lucas.verMochila();
                            suPokemon= sn.nextInt()-1;
                            System.out.println("Elije el pokemon que quieres ofrecer");
                            angel.verMochila();
                            tuPokemon= sn.nextInt()-1;
                            angel.intercambiarPokemon(angel.getMochila().get(tuPokemon),lucas,lucas.getMochila().get(suPokemon));
                            break;
                        case 2:
                            System.out.println("Elije el pokemon que quieres");
                            dani.verMochila();
                            suPokemon= sn.nextInt();
                            System.out.println("Elije el pokemon que quieres ofrecer");
                            angel.verMochila();
                            tuPokemon= sn.nextInt();
                            angel.intercambiarPokemon(angel.getMochila().get(tuPokemon),dani,dani.getMochila().get(suPokemon));
                            break;
                        case 3:
                            System.out.println("Elije el pokemon que quieres");
                            raul.verMochila();
                            suPokemon= sn.nextInt();
                            System.out.println("Elije el pokemon que quieres ofrecer");
                            angel.verMochila();
                            tuPokemon= sn.nextInt();
                            angel.intercambiarPokemon(angel.getMochila().get(tuPokemon),raul,raul.getMochila().get(suPokemon));
                            break;
                        case 4:
                            System.out.println("Elije el pokemon que quieres");
                            cynthia.verMochila();
                            suPokemon= sn.nextInt();
                            System.out.println("Elije el pokemon que quieres ofrecer");
                            angel.verMochila();
                            tuPokemon= sn.nextInt();
                            angel.intercambiarPokemon(angel.getMochila().get(tuPokemon),cynthia,cynthia.getMochila().get(suPokemon));
                            break;
                    }
                    break;
                default:
                    System.out.println("tu ere tonto o k");
            }

        }



    }
    public static void showMenu(){

    }
}