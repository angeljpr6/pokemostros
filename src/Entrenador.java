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
     *
     * @param pokemon
     */
    public boolean capturarPokemon(Pokemon pokemon){
        if(Math.random()*101>30+pokemon.getPtosVida()*0.4){
            System.out.println("¡¡Pokemon capturado!!");
            if (pokedex.comprobarCapturado(pokemon)) {

            } else pokedex.anadirPokemonCapturado(pokemon);

            mochila.add(pokemon);
            return true;
        }
        return false;
    }

    /**
     * Anade un pokemon directamente a tu inventario
     * y si no esta registrado en la pokedex lo registra
     *
     * @param pokemon
     */
    public void anadirPokemon(Pokemon pokemon){
        if (pokedex.comprobarPokemon(pokemon)){

        }else pokedex.anadirPokemonVisto(pokemon);
        if (pokedex.comprobarCapturado(pokemon)) {

        } else pokedex.anadirPokemonCapturado(pokemon);
        mochila.add(pokemon);
    }

    public void curarPokemon(){
        for (int i = 0; i < mochila.size(); i++) {
            mochila.get(i).setPtosVida(20);
        }
    }

    /**
     * Elimina un pokemon de tu mochila
     * @param numPokemon
     */
    public void liberarPokemon(int numPokemon){
        mochila.remove(numPokemon);
    }

    /**
     * Elije un pokemon aleatorio de un array de pokemon dado por parametro
     * @param pokemons
     * @return pokemon
     */
    public int buscarPokemon(ArrayList<Pokemon> pokemons){
        if (pokemons.size()==0){
            return -1;
        }
        return (int)(Math.random()*(pokemons.size() -1)+1);

    }
    public void intercambiarPokemon(Pokemon miPokemon, Entrenador entrenador, Pokemon suPokemon){
        anadirPokemon(suPokemon);
        entrenador.mochila.remove(suPokemon);

        entrenador.anadirPokemon(miPokemon);
        this.mochila.remove(miPokemon);
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
        System.out.println("╔════════════════════════════════════════");
        System.out.println("║ ----------------------------------------");
        for (int i = 0; i < mochila.size(); i++) {
            if (mochila.get(i)!=null){
                System.out.println("║ Posicion : "+(i+1));
                System.out.println("║ Nombre : "+ mochila.get(i).getNombre());
                System.out.println("║ Tipo : "+ mochila.get(i).getTipo());
                System.out.println("║ Numero Pokedex : "+ mochila.get(i).getNumPokedex());
                System.out.println("║ Nivel : "+ mochila.get(i).getLvl());
                System.out.println("║ Vida : "+ mochila.get(i).getPtosVida());
                System.out.println("║ Poder : "+ mochila.get(i).getPtosPoder());
                System.out.println("║ ----------------------------------------");
            }
        }
        System.out.println("╚════════════════════════════════════════");
    }

    // GETTER & SETTER


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Pokemon> getMochila() {
        return mochila;
    }

    public void setMochila(ArrayList<Pokemon> mochila) {
        this.mochila = mochila;
    }

    public Pokedex getPokedex() {
        return pokedex;
    }

    public void setPokedex(Pokedex pokedex) {
        this.pokedex = pokedex;
    }

    @Override
    public String toString() {
        return "Nombre = "+nombre+"\n"+
                "Id = "+id+"\n"+
                "Mochila = "+mochila+"\n"+
                "Pokedex = "+ pokedex +"\n";
    }
}
