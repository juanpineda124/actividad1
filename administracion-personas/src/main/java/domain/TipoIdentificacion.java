
package domain;


public class TipoIdentificacion {
    private int id;
    private String nombre;

    public TipoIdentificacion() {
    }

    public TipoIdentificacion(int id) {
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
