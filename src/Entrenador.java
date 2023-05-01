import java.util.ArrayList;

public class Entrenador {
    private int id;
    private String nombre;
    private ArrayList<Pokemon> mochila;
    private Pokedex pokedex;

    public Entrenador(int id, String nombre,Pokedex pokedex) {
        this.id = id;
        this.nombre = nombre;
        this.mochila = new ArrayList<>();
        this.pokedex = pokedex;
    }

    /**
     * Metodo que en base a una probabilidad especifica
     * captura un pokemon. Esta clase registra automaticamente
     * al pokemon en la pokedex si no lo esta y si lo capturas
     * lo añade como capturado.
     * @param pokemon
     */
    public void capturarPokemon(Pokemon pokemon){
        if (pokedex.comprobarPokemon(pokemon)){

        }else pokedex.anadirPokemonVisto(pokemon);
        if(Math.random()*101>0){
            System.out.println("¡¡Pokemon capturado!!");
            if (pokedex.comprobarCapturado(pokemon)) {

            } else pokedex.anadirPokemonCapturado(pokemon);

            mochila.add(pokemon);
        }
    }

    public void liberarPokemon(Pokemon pokemon){

    }

    public void intercambiarPokemon(Pokemon miPokemon, Entrenador entrenador, Pokemon suPokemon){

    }

    public void verPokedex(){
        pokedex.verPokedex();
    }

    public void combatir(Pokemon pokemon){

    }

    /**
     * Muestra los pokemon que tengas en la mochila
     */
    public void verMochila(){
        System.out.println("    MOCHILA");
        System.out.println("****************************************");
        System.out.println("----------------------------------------");
        for (int i = 0; i < mochila.size(); i++) {
            if (mochila.get(i)!=null){
                System.out.println(i);
                System.out.println("Nombre : "+ mochila.get(i).getNombre());
                System.out.println("Tipo : "+ mochila.get(i).getTipo());
                System.out.println("Numero Pokedex : "+ mochila.get(i).getNumPokedex());
                System.out.println("Nivel : "+ mochila.get(i).getLvl());
                System.out.println("Vida : "+ mochila.get(i).getPtosVida());
                System.out.println("Poder : "+ mochila.get(i).getPtosPoder());
                System.out.println("----------------------------------------");
            }
        }
        System.out.println("****************************************");
    }

    @Override
    public String toString() {
        return "Nombre = "+nombre+"\n"+
                "Id = "+id+"\n"+
                "Mochila = "+mochila+"\n"+
                "Pokedex = "+ pokedex +"\n";
    }
}
