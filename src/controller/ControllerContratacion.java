package controller;

import entity.Coder;
import entity.Contratacion;
import model.ModelCoder;

import javax.swing.*;
import java.math.BigDecimal;

public class ControllerContratacion {
    public static String listarString(){
        String listaDeContrataciones = "LISTA DE CONTRATACIONES \n";
        for (Object contratacion : instanceModel().listar()){
            listaDeContrataciones += (Contratacion) contratacion + "\n";
        }
        return  listaDeContrataciones;
    }
    public static void listar(){
        JOptionPane.showMessageDialog(null, listarString());
    }

    public static void crear(){
        int id_vacante =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la vacante")) ;
        int id_coder =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del coder")) ;
        String fecha_aplicacion  = JOptionPane.showInputDialog("Ingrese la fecha de aplicacion");
        String estado  = JOptionPane.showInputDialog("Ingrese el estado de la contratacion") ;
        BigDecimal salario =BigDecimal.valueOf(JOptionPane.showInputDialog("Ingrese el salario de la contratacion");


        instanceModel().create(new Contratacion(id_vacante, id_coder, fecha_aplicacion,estado,salario));
        JOptionPane.showMessageDialog(null, "la contratacion fue creado con éxito");
    }
    public static void update(){


        int id_contratacion = Integer.parseInt(JOptionPane.showInputDialog(listarString() + "\nIngrese el id de la contratacion que desea actualizar"));
        Contratacion objContratacion = (Contratacion) instanceModel().findByID(id_contratacion);

        int id_vacante =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la vacante", objContratacion.getId_vacante())) ;
        int id_coder =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del coder", objContratacion.getId_coder())) ;
        String fecha_aplicacion  = JOptionPane.showInputDialog("Ingrese la fecha de aplicacion  de la contratacion", objContratacion.getFecha_aplicacion());
        String estado  =JOptionPane.showInputDialog("Ingrese la cohorte del coder", objContratacion.getEstado()) ;
        BigDecimal salario  = BigDecimal.valueOf(JOptionPane.showInputDialog("Ingrese el salario de la contratacion",objContratacion.getSalario());

        instanceModel().update(new Contratacion(id_vacante, id_coder, fecha_aplicacion, estado, salario ));
    }

    public  static void delete(){
        int id_contratacion = Integer.parseInt(JOptionPane.showInputDialog(listarString() + "\nIngrese el id de la contratacion que desea eliminar"));
        instanceModel().delete(id_contratacion);
    }









    public static ModelCoder instanceModel(){
        return new ModelCoder();
    }
}