import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sn=new Scanner(System.in);

        Pokedex pokedexAngel = new Pokedex(1);
        Entrenador angel = new Entrenador(1,"Angel",pokedexAngel);
        Pokemon bulbasaur = new Pokemon(1,"Planta","Bulbasaur",1,20,5);
        Pokemon ivysaur = new Pokemon(2,"Planta","Ivysaur",1,20,5);
        Pokemon venusaur = new Pokemon(3,"Planta","Venusaur",1,20,5);
        Pokemon charmander = new Pokemon(4,"Fuego","Charmander",1,20,5);
        Pokemon charmeleon = new Pokemon(5,"Fuego","Charmeleon",1,20,5);
        Pokemon charizard = new Pokemon(6,"Fuego","Charizard",1,20,5);
        Pokemon squirtle = new Pokemon(6,"Fuego","Squirtle",1,20,5);
        Pokemon wartortle = new Pokemon(6,"Fuego","Wartortle",1,20,5);
        Pokemon blastoise = new Pokemon(6,"Fuego","Blastoise",1,20,5);

        int opcion=1;
        System.out.println("Comienza la aventura Pokemon");

        while (opcion!=0) {
            System.out.println("1: Buscar un pokemon");
            System.out.println("2: Ver tus pokemon");
            System.out.println("3: Ver tu pokedex");
            System.out.println("4: Liberar un pokemon");
            System.out.println("0: Salir");
            opcion = sn.nextInt();
        }



        angel.capturarPokemon(charmander);

        angel.capturarPokemon(bulbasaur);
        angel.capturarPokemon(bulbasaur);

        angel.verMochila();
        angel.verPokedex();


    }
}