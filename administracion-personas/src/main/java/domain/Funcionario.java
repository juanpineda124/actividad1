package domain;

public class Funcionario {
    
    private int id;
    private Short tipoIdentificacion_id;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private Short estadoCivil_id;
    private Short sexo_id;
    private String direccion;
    private String telefono;
    private String fechaNacimiento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Short getTipoIdentificacion_id() {
        return tipoIdentificacion_id;
    }

    public void setTipoIdentificacion_id(Short tipoIdentificacion_id) {
        this.tipoIdentificacion_id = tipoIdentificacion_id;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Short getEstadoCivil_id() {
        return estadoCivil_id;
    }

    public void setEstadoCivil_id(Short estadoCivil_id) {
        this.estadoCivil_id = estadoCivil_id;
    }

    public Short getSexo_id() {
        return sexo_id;
    }

    public void setSexo_id(Short sexo_id) {
        this.sexo_id = sexo_id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return nombres + " " + apellidos;
    }
    
    
}
