import java.util.ArrayList;

public class Pokedex {
    private int id;
    private ArrayList<Pokemon> pokemons;
    private ArrayList<String> capturado;

    public Pokedex(int id) {
        this.id=id;
        pokemons=new ArrayList<>();
        capturado=new ArrayList<>();
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public ArrayList<String> getCapturado() {
        return capturado;
    }

    public void setCapturado(ArrayList<String> capturado) {
        this.capturado = capturado;
    }
    public void verPokedex(){
        System.out.println("    POKEDEX");
        System.out.println("****************************************");
        System.out.println("----------------------------------------");
        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemons.get(i)!=null){
                System.out.println("Nombre : "+ pokemons.get(i).getNombre());
                System.out.println("Tipo : "+ pokemons.get(i).getTipo());
                System.out.println("Numero Pokedex : "+ pokemons.get(i).getNumPokedex());
                System.out.println("Capturado : "+ capturado.get(i));
                System.out.println("----------------------------------------");
            }
        }
        System.out.println("****************************************");
    }

    public boolean comprobarPokemon(Pokemon pokemon){
        if (pokemons.size()<pokemon.getNumPokedex() || pokemons.size()==0){
            return false;
        }else if (pokemons.get(pokemon.getNumPokedex())==null){
            return false;
        }
        return true;
    }
    public void anadirPokemonVisto(Pokemon pokemon){
        if (pokemons.size()<pokemon.getNumPokedex()){
            while (pokemons.size()<pokemon.getNumPokedex()){
                pokemons.add(null);
            }
        }
        if (capturado.size()<pokemon.getNumPokedex()){
            while (capturado.size()<pokemon.getNumPokedex()){
                capturado.add(null);
            }
        }
        pokemons.add(pokemon.getNumPokedex(),pokemon);
        capturado.add(pokemon.getNumPokedex(),"No");
    }
    public void anadirPokemonCapturado(Pokemon pokemon){
        if (capturado.size()<pokemon.getNumPokedex()){
            while (capturado.size()<pokemon.getNumPokedex()){
                capturado.add(null);
            }
        }
        capturado.add(pokemon.getNumPokedex(),"Si");
    }


    public boolean comprobarCapturado(Pokemon pokemon){
        if (capturado.size()<pokemon.getNumPokedex()){
            return false;
        }
        if (capturado.get(pokemon.getNumPokedex())==null){
            return false;
        }
        if (capturado.get(pokemon.getNumPokedex()).equals("Si")){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Pokedex{" +"\n"+
                "pokemons=" + pokemons +"\n"+
                ", capturado=" + capturado +"\n"+
                '}';
    }
}
