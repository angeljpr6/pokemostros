import java.util.ArrayList;

public class Pokemon {

    private int numPokedex;
    private String tipo;
    private String nombre;
    private int lvl;
    private int ptosVida;
    private int vidaMax;
    private int ptosPoder;
    private ArrayList<Movimiento> movimientos;

    public Pokemon(int numPokedex, String tipo, String nombre, int lvl, int ptosVida, int ptosPoder) {
        this.numPokedex = numPokedex;
        this.tipo = tipo;
        this.nombre = nombre;
        this.lvl = lvl;
        this.ptosVida = ptosVida;
        this.ptosPoder = ptosPoder;
        this.movimientos=new ArrayList<>();
        this.vidaMax=20;

        Movimiento placaje=new Movimiento("Placaje","Normal",5);
        Movimiento aranazo=new Movimiento("Arañazo","Normal",6);
        this.movimientos.add(placaje);
        this.movimientos.add(aranazo);
        if (tipo.equals("Agua")){
            Movimiento pistolaAgua=new Movimiento("Pistola agua","Agua",5);
            this.movimientos.add(pistolaAgua);
        }
        if (tipo.equals("Fuego")){
            Movimiento ascuas=new Movimiento("Ascuas","Fuego",7);
            this.movimientos.add(ascuas);
        }
        if (tipo.equals("Planta")){
            Movimiento hojaAfilada=new Movimiento("Hoja afilada","Planta",6);
            this.movimientos.add(hojaAfilada);
        }

    }
    /**
     * Elije un pokemon aleatorio de un array de pokemon dado por parametro
     * (Esto hay que cambiarlo a la clas pokemon)
     * @param pokemons
     * @return pokemon
     */
    public static Pokemon buscarPokemon(ArrayList<Pokemon> pokemons){
        if (pokemons.size()==0){
            return -1;
        }
        Pokemon pokemon=pokemons.get((int)(Math.random()*(pokemons.size() -1)+1));
        return pokemon;

    }
    public static void curarPokemons(ArrayList<Pokemon> pokemons){
        for (int i = 0; i < pokemons.size(); i++) {
            pokemons.get(i).setPtosVida(pokemons.get(i).getVidaMax());
        }
    }
    public void verMovimientos(){
        System.out.println("-------------------------------------");
        for (int i = 0; i < movimientos.size(); i++) {
            System.out.println((i+1));
            System.out.println(movimientos.get(i).getNombre());
            System.out.println(movimientos.get(i).getTipo());
            System.out.println(movimientos.get(i).getDanoBase());
            System.out.println("-------------------------------------\n");
        }
    }
    public void atacarPokemon(Pokemon pokemon,int movimiento){
        //Al pokemon se le resta de vida el dano base del movimiento mas el nivel y los puntos de poder del pokemon que ataca
        //pokemon.setPtosVida(pokemon.getPtosVida()-this.movimientos.get(movimiento).getDanoBase()+this.ptosPoder+this.lvl);
        String texto;
        System.out.println("***********************************************");
        System.out.println(this.nombre+" uso "+this.movimientos.get(movimiento).getNombre());

        //En caso de ser muy efectivo (multiplica por dos)
        if (this.movimientos.get(movimiento).efectivo(pokemon)==1){
            texto="Es muy efectivo \n";
            texto+=pokemon.getNombre()+" perdio "+((this.movimientos.get(movimiento).getDanoBase()+this.ptosPoder+this.lvl)*2)+" puntos de vida\n";
            ControlarTexto.mostrarTextoLento(texto);
            pokemon.setPtosVida(pokemon.getPtosVida()-((this.movimientos.get(movimiento).getDanoBase()+this.ptosPoder+this.lvl)*2));
        }
        //Poco efectivo hace la mitad de dano
        if (this.movimientos.get(movimiento).efectivo(pokemon)==3){
            texto="Es poco efectivo \n";
            texto+=pokemon.getNombre()+" perdio "+((int)(this.movimientos.get(movimiento).getDanoBase()+this.ptosPoder+this.lvl)*0.5)+" puntos de vida\n";
            ControlarTexto.mostrarTextoLento(texto);
            pokemon.setPtosVida((int) (pokemon.getPtosVida()-((this.movimientos.get(movimiento).getDanoBase()+this.ptosPoder+this.lvl)*0.5)));
        }
        //Efectivo
        if (this.movimientos.get(movimiento).efectivo(pokemon)==2){
            texto="Es efectivo \n";
            texto+=pokemon.getNombre()+" perdio "+(this.movimientos.get(movimiento).getDanoBase()+this.ptosPoder+this.lvl)+" puntos de vida\n";
            ControlarTexto.mostrarTextoLento(texto);
            pokemon.setPtosVida(pokemon.getPtosVida()-(this.movimientos.get(movimiento).getDanoBase()+this.ptosPoder+this.lvl));
        }
        System.out.println("***********************************************");

    }

    // GETTER & SETTER


    public int getNumPokedex() {
        return numPokedex;
    }

    public void setNumPokedex(int numPokedex) {
        this.numPokedex = numPokedex;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getPtosVida() {
        return ptosVida;
    }

    public void setPtosVida(int ptosVida) {
        this.ptosVida = ptosVida;
    }

    public int getPtosPoder() {
        return ptosPoder;
    }

    public void setPtosPoder(int ptosPoder) {
        this.ptosPoder = ptosPoder;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }
}
