import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestPokemon {

    @Test
    public void testCurarPokemon(){
        Pokemon pokemon1=new Pokemon(1,"pepe","Manolo",1,10,1);
        Pokemon pokemon2=new Pokemon(1,"pepe","Manolo",1,10,1);
        ArrayList<Pokemon> pokemons=new ArrayList<>();
        pokemons.add(pokemon1);
        pokemons.add(pokemon2);
        Pokemon.curarPokemons(pokemons);
        for (Pokemon pokemon :
                pokemons) {
            assertEquals(20,pokemon.getPtosVida());
        }

    }
}
