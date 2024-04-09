package controller;

import entity.Empresa;
import entity.Vacante;
import model.ModelVacante;

import javax.swing.*;

public class ControllerVacante {
    public static String listarString(){
        String listaDeVacantes = "LISTA DE VACANTES \n";
        for (Object vacante : instanceModel().listar()){
            listaDeVacantes += (Vacante) vacante + "\n";
        }
        return  listaDeVacantes;
    }


    public static void listar(){
        JOptionPane.showMessageDialog(null, listarString());
    }
    public static String listarEmpresas(){
        String listaDeEmpresas = "LISTA DE EMPRESAS \n";
        for (Object empresa : instanceModel().listarEmpresa()){
            listaDeEmpresas += (Empresa) empresa + "\n";
        }
        return  listaDeEmpresas;
    }
    public static void crear(){
        int id_empresa =Integer.parseInt(JOptionPane.showInputDialog(ControllerVacante.listarEmpresas()+ "Ingrese el id de la empresa donde vas a agregar la vacante"));
        String titulo = JOptionPane.showInputDialog("Ingrese el titulo de la vacante");
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion de la vacante");
        String duracion = JOptionPane.showInputDialog("Ingrese la duracion de la vacante");
        String estado = JOptionPane.showInputDialog("Ingrese el estado de la vacante");

        Vacante obj = new Vacante(id_empresa, titulo, descripcion, duracion, estado);
        System.out.println(obj);
        instanceModel().create(obj);
        JOptionPane.showMessageDialog(null, "la vacante fue creada con éxito");
    }


    public static void update(){

            int id_vacante = Integer.parseInt(JOptionPane.showInputDialog(listarString() + "\nIngrese el id de la vacante que desea actualizar"));
            Vacante objVacante = (Vacante) instanceModel().findByID(id_vacante);

            int id_empresa =Integer.parseInt(JOptionPane.showInputDialog(ControllerVacante.listarEmpresas()+"Ingrese el nombre del cliente", objVacante.getId_empresa()) );
            String titulo = JOptionPane.showInputDialog("Ingrese el titulo del cliente", objVacante.getTitulo());
            String descripcion  = JOptionPane.showInputDialog("Ingrese la descripcion del cliente", objVacante.getDescripcion());
            String duracion  = JOptionPane.showInputDialog("Ingrese la duracion de la vacante", objVacante.getDescripcion());
            String estado  = JOptionPane.showInputDialog("Ingrese el estado de la vacante", objVacante.getDescripcion());

            instanceModel().update(new Vacante(id_empresa, titulo, descripcion, duracion, estado));

    }

    public  static void delete(){
        int id_vacante = Integer.parseInt(JOptionPane.showInputDialog(listarString() + "\nIngrese el id de la vacante que desea eliminar"));
        instanceModel().delete(id_vacante);}



    public static ModelVacante instanceModel(){
        return new ModelVacante();
    }

}
