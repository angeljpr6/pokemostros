public class Movimiento {
    private String nombre;
    private String tipo;
    private int danoBase;

    public Movimiento(String nombre, String tipo, int danoBase) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.danoBase = danoBase;
    }

    /**
     *
     * @param pokemon
     * @return 1 si es muy efectivo || 2 si efectivo || 3 si es poco efectivo
     */
    public int efectivo(Pokemon pokemon){
        if (this.tipo.equals("Fuego") && pokemon.getTipo().equals("Agua")){
            return 3;
        }
        if (this.tipo.equals("Fuego") && pokemon.getTipo().equals("Planta")){
            return 1;
        }
        if (this.tipo.equals("Agua") && pokemon.getTipo().equals("Fuego")){
            return 1;
        }
        if (this.tipo.equals("Agua") && pokemon.getTipo().equals("Planta")){
            return 3;
        }
        if (this.tipo.equals("Planta") && pokemon.getTipo().equals("Fuego")){
            return 3;
        }
        if (this.tipo.equals("Planta") && pokemon.getTipo().equals("Agua")){
            return 1;
        }
        return 2;
    }

    // GETTER & SETTER

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDanoBase() {
        return danoBase;
    }

    public void setDanoBase(int danoBase) {
        this.danoBase = danoBase;
    }
}
