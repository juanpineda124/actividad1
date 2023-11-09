package domain;

public class Sexo {
    private int id;
    private String nombre;
    
     public Sexo() {
    }
     
    public Sexo(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return id + " " +nombre;
    }
}
