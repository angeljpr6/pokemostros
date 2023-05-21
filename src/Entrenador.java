import java.util.ArrayList;
import java.util.Scanner;

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
    public Entrenador(int id,Pokedex pokedex){
        this.id=id;
        this.nombre="";
        this.mochila = new ArrayList<>();
        this.pokedex=pokedex;
    }

    /**
     * Elejimos un pokemon inicial entre los tres dados por parametro
     *
     * @param sn
     * @param pokemon1
     * @param pokemon2
     * @param pokemon3
     * @return
     */
    public void elegirPokInicial(Scanner sn, Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3){
        int opcion=0;
        while (true) {
            System.out.println("1 " + pokemon1.getNombre() + "       2 " + pokemon2.getNombre() + "       3 " + pokemon3.getNombre());
            opcion= sn.nextInt();
            if (opcion<1 || opcion>3){
                System.out.println("Elige uno coño que te lo estoy dando");
                continue;
            }
            break;
        }
        switch (opcion){
            case 1:
                anadirPokemon(pokemon1);
                System.out.println(pokemon1.getNombre()+" Se ha unido a tu equipo");
                break;
            case 2:
                anadirPokemon(pokemon2);
                System.out.println(pokemon2.getNombre()+" Se ha unido a tu equipo");
                break;
            case 3:
                anadirPokemon(pokemon3);
                System.out.println(pokemon3.getNombre()+" Se ha unido a tu equipo");
                break;
            default:
                System.out.println("ere tonto o k");
        }
    }

    public void elegirMovimiento(Scanner sn, int posTuPoke, Pokemon pokemonRival){
        while (true) {
            System.out.println("Elije un movimiento: ");
            getMochila().get(posTuPoke).verMovimientos();
            int opcion = sn.nextInt() - 1;
            if (getMochila().get(posTuPoke).getMovimientos().get(opcion) == null) {
                System.out.println("La opcion no corresponde a ningun movimiento");
                continue;
            }
            getMochila().get(posTuPoke).atacarPokemon(pokemonRival, opcion);
            break;
        }
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

            Pokemon pokemon1=new Pokemon(pokemon);
            mochila.add(pokemon1);
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
        Pokemon pokemon1 =new Pokemon(pokemon);
        mochila.add(pokemon1);
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
        ControlarTexto.mostrarTextoLento(mochila.get(numPokemon).getNombre()+" esta mas feliz que nunca, por fin sera libre");
        System.out.println();
        mochila.remove(numPokemon);
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
                System.out.println("║ Exp : "+ mochila.get(i).getExp());
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
