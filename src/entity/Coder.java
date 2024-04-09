package entity;

import java.math.BigDecimal;

public class Coder {
    private int id_coder;
    private String nombre_coder;
    private String apellido;
    private String documento;
    private int cohorte;
    private String cv;

    public Coder(int id_coder, String nombre_coder, String apellido, String documento, int cohorte, String cv) {
        this.id_coder = id_coder;
        this.nombre_coder = nombre_coder;
        this.apellido = apellido;
        this.documento = documento;
        this.cohorte = cohorte;
        this.cv = cv;
    }

    public Coder(String nombre_coder, String apellido, String documento, int cohorte, String cv) {
        this.nombre_coder = nombre_coder;
        this.apellido = apellido;
        this.documento = documento;
        this.cohorte = cohorte;
        this.cv = cv;
    }

    public Coder() {

    }



    public int getId_coder() {
        return id_coder;
    }

    public void setId_coder(int id_coder) {
        this.id_coder = id_coder;
    }

    public String getNombre_coder() {
        return nombre_coder;
    }

    public void setNombre_coder(String nombre_coder) {
        this.nombre_coder = nombre_coder;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getCohorte() {
        return cohorte;
    }

    public void setCohorte(int cohorte) {
        this.cohorte = cohorte;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    @Override
    public String toString() {
        return "Coder{" +
                "id_coder=" + id_coder +
                ", nombre_coder='" + nombre_coder + '\'' +
                ", apellido='" + apellido + '\'' +
                ", documento='" + documento + '\'' +
                ", cohorte=" + cohorte +
                ", cv='" + cv + '\'' +
                '}';
    }
}
