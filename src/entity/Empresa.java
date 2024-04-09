package entity;

public class Empresa {
    private int id_empresa;
    private String nombre_empresa;
    private String sector;
    private String ubicacion;
    private String contacto;

    public Empresa(int id_empresa, String nombre_empresa, String sector, String ubicacion, String contacto) {
        this.id_empresa = id_empresa;
        this.nombre_empresa = nombre_empresa;
        this.sector = sector;
        this.ubicacion = ubicacion;
        this.contacto = contacto;
    }

    public Empresa() {
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id_empresa=" + id_empresa +
                ", nombre_empresa='" + nombre_empresa + '\'' +
                ", sector='" + sector + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", contacto='" + contacto + '\'' +
                '}';
    }
}
