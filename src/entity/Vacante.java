package entity;

public class Vacante {
    private int id_vacante;
    private int id_empresa;
    private String titulo;
    private String descripcion;
    private String duracion;
    private String estado;

    public Vacante(int id_vacante, int id_empresa, String titulo, String descripcion, String duracion, String estado) {
        this.id_vacante = id_vacante;
        this.id_empresa = id_empresa;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.estado = estado;
    }

    public Vacante() {
    }

    public Vacante(int id_empresa, java.lang.String titulo, java.lang.String descripcion, java.lang.String duracion, java.lang.String estado) {
        this.id_empresa = id_empresa;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.estado = estado;
    }



    public int getId_vacante() {
        return id_vacante;
    }

    public void setId_vacante(int id_vacante) {
        this.id_vacante = id_vacante;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Vacante{" +
                "id_vacante=" + id_vacante +
                ", id_empresa=" + id_empresa +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", duracion='" + duracion + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}