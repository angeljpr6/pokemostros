public class Pokemon {

    private int numPokedex;
    private String tipo;
    private String nombre;
    private int lvl;
    private int ptosVida;
    private int ptosPoder;

    public Pokemon(int numPokedex, String tipo, String nombre, int lvl, int ptosVida, int ptosPoder) {
        this.numPokedex = numPokedex;
        this.tipo = tipo;
        this.nombre = nombre;
        this.lvl = lvl;
        this.ptosVida = ptosVida;
        this.ptosPoder = ptosPoder;
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
}
