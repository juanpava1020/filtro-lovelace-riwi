package controller;

import entity.Coder;
import model.ModelCoder;

import javax.swing.*;

public class ControllerCoder {
    public static String listarString(){
        String listaDeCoders = "LISTA DE CODERS \n";
        for (Object coder : instanceModel().listar()){
            listaDeCoders += (Coder) coder + "\n";
        }
        return  listaDeCoders;
    }
    public static void listar(){
        JOptionPane.showMessageDialog(null, listarString());
    }

    public static void crear(){
        String nombre_coder = JOptionPane.showInputDialog("Ingrese el nombre del coder");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del coder");
        String documento  = JOptionPane.showInputDialog("Ingrese el documento del coder");
        int cohorte  = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cohorte del coder")) ;
        String cv  = JOptionPane.showInputDialog("Ingrese el cv del coder");


        instanceModel().create(new Coder(nombre_coder, apellido, documento,cohorte,cv));
        JOptionPane.showMessageDialog(null, "El coder fue creado con éxito");
    }
    public static void update(){
        int id_coder = Integer.parseInt(JOptionPane.showInputDialog(listarString() + "\nIngrese el id del coder que desea actualizar"));
        Coder objCoder = (Coder) instanceModel().findByID(id_coder);

        String nombre_coder = JOptionPane.showInputDialog("Ingrese el nombre del cliente", objCoder.getNombre_coder());
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del cliente", objCoder.getApellido());
        String documento  = JOptionPane.showInputDialog("Ingrese el documento del cliente", objCoder.getDocumento());
        int cohorte  =Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cohorte del coder", objCoder.getCohorte())) ;
        String cv  = JOptionPane.showInputDialog("Ingrese el cv del coder", objCoder.getCv());

        instanceModel().update(new Coder(id_coder, nombre_coder, apellido, documento, cohorte, cv ));
    }

    public  static void delete(){
        int id_coder = Integer.parseInt(JOptionPane.showInputDialog(listarString() + "\nIngrese el id del coder que desea eliminar"));
        instanceModel().delete(id_coder);
    }









    public static ModelCoder instanceModel(){
        return new ModelCoder();
    }
}




