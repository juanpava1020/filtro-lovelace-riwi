package entity;

import java.math.BigDecimal;

public class Contratacion {
    private int id_contratacion;
    private int id_vacante;
    private int id_coder;
    private String fecha_aplicacion;
    private String estado;
    private BigDecimal salario;

    public Contratacion(int id_contratacion, int id_vacante, int id_coder, String fecha_aplicacion, String estado, BigDecimal salario) {
        this.id_contratacion = id_contratacion;
        this.id_vacante = id_vacante;
        this.id_coder = id_coder;
        this.fecha_aplicacion = fecha_aplicacion;
        this.estado = estado;
        this.salario = salario;
    }

    public Contratacion() {
    }

    public Contratacion(int id_vacante, int id_coder, String fecha_aplicacion, String estado, BigDecimal salario) {
        this.id_vacante = id_vacante;
        this.id_coder = id_coder;
        this.fecha_aplicacion = fecha_aplicacion;
        this.estado = estado;
        this.salario = salario;
    }



    public int getId_contratacion() {
        return id_contratacion;
    }

    public void setId_contratacion(int id_contratacion) {
        this.id_contratacion = id_contratacion;
    }

    public int getId_vacante() {
        return id_vacante;
    }

    public void setId_vacante(int id_vacante) {
        this.id_vacante = id_vacante;
    }

    public int getId_coder() {
        return id_coder;
    }

    public void setId_coder(int id_coder) {
        this.id_coder = id_coder;
    }

    public String getFecha_aplicacion() {
        return fecha_aplicacion;
    }

    public void setFecha_aplicacion(String fecha_aplicacion) {
        this.fecha_aplicacion = fecha_aplicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}