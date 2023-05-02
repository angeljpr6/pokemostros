import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sn=new Scanner(System.in);

        Pokedex pokedexAngel = new Pokedex(1);
        Entrenador angel = new Entrenador(1,"Angel",pokedexAngel);
        Pokemon pikachu = new Pokemon(25,"Electrico","Pikachu",1,0,5);
        Pokemon bulbasaur = new Pokemon(1,"Planta","Bulbasaur",1,20,5);
        Pokemon ivysaur = new Pokemon(2,"Planta","Ivysaur",1,20,5);
        Pokemon venusaur = new Pokemon(3,"Planta","Venusaur",1,20,5);
        Pokemon charmander = new Pokemon(4,"Fuego","Charmander",1,20,5);
        Pokemon charmeleon = new Pokemon(5,"Fuego","Charmeleon",1,20,5);
        Pokemon charizard = new Pokemon(6,"Fuego","Charizard",1,20,5);
        Pokemon squirtle = new Pokemon(7,"Agua","Squirtle",1,20,5);
        Pokemon wartortle = new Pokemon(8,"Agua","Wartortle",1,20,5);
        Pokemon blastoise = new Pokemon(9,"Agua","Blastoise",1,20,5);
        Pokemon[] pokemonsRegion=new Pokemon[]{bulbasaur,ivysaur,venusaur,charmander,charmeleon,charizard,squirtle,wartortle,blastoise};


        //La posicion del pokemon que estas usando (Hay que restarle 1) y el numero de pokemons debilitados
        int posicionPokemon=0,nPokeDebilitados=0;

        int aux=0;
        char o='1';

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
                break;
            case 2:
                angel.anadirPokemon(squirtle);
                break;
            case 3:
                angel.anadirPokemon(bulbasaur);
                break;
            default:
                System.out.println("ere tonto o k");
        }


        while (opcion!=-2) {
            System.out.println("╔═════════════════════════╗");
            System.out.println("║ 1: Buscar un pokemon    ║");
            System.out.println("║ 2: Ver tus pokemon      ║");
            System.out.println("║ 3: Ver tu pokedex       ║");
            System.out.println("║ 4: Liberar un pokemon   ║");
            System.out.println("║ -2: Salir               ║");
            System.out.println("╚═════════════════════════╝");
            opcion = sn.nextInt();
            switch (opcion){
                case 1:
                    int idPokemonRegion=3;//angel.buscarPokemon(pokemonsRegion);
                    System.out.println("Un "+pokemonsRegion[idPokemonRegion].getNombre()+" salvaje ha aparecido");
                    angel.getPokedex().anadirPokemonVisto(pokemonsRegion[idPokemonRegion]);
                    salirPelea=false;
                    while (salirPelea==false) {
                        int i=0;
                        System.out.println("╔════════════════════════════════════════════════════════");
                        System.out.println("║                                  "+pokemonsRegion[idPokemonRegion].getNombre());
                        System.out.println("║                                  Nivel "+pokemonsRegion[idPokemonRegion].getLvl());
                        System.out.println("║                                  Vida  "+pokemonsRegion[idPokemonRegion].getPtosVida()+"\n║");
                        System.out.println("║ "+angel.getMochila().get(posicionPokemon).getNombre());
                        System.out.println("║ Nivel "+angel.getMochila().get(posicionPokemon).getLvl());
                        System.out.println("║ Vida  "+angel.getMochila().get(posicionPokemon).getPtosVida());
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
                                angel.getMochila().get(posicionPokemon).atacarPokemon(pokemonsRegion[idPokemonRegion],opcion);
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
                            case 4:
                                angel.capturarPokemon(pokemonsRegion[idPokemonRegion]);
                                salirPelea=true;
                                break;
                        }

                        //Victoria
                        if (pokemonsRegion[idPokemonRegion].getPtosVida()<=0){
                            System.out.println("Felicidades has derrotado al "+pokemonsRegion[idPokemonRegion].getNombre());
                            break;
                        }
                        if (salirPelea==false) {
                            aux = (int) Math.round(Math.random() * pokemonsRegion[idPokemonRegion].getMovimientos().size());
                            pokemonsRegion[idPokemonRegion].atacarPokemon(angel.getMochila().get(posicionPokemon), aux);

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
                    angel.verPokedex();
                    break;
                case 4:
                    System.out.println("Elije la posicion del pokemon que quieras eliminar");
                    opcion= sn.nextInt();
                    angel.liberarPokemon(opcion-1);

                default:
                    System.out.println("tu ere tonto o k");
            }
        }



    }
}