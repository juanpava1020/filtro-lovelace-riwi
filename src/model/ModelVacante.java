package model;

import database.ConfigDB;
import entity.Empresa;
import entity.Vacante;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelVacante implements CRUD {
    @Override
    public ArrayList<Object> listar() {

        ArrayList<Object> listaDeVacantes = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM vacante";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult =  objPrepare.executeQuery();

            while (objResult.next()){
                Vacante objVacante = new Vacante();
                objVacante.setId_vacante(objResult.getInt("id_vacante"));
                objVacante.setId_empresa(objResult.getInt("id_empresa"));
                objVacante.setTitulo(objResult.getString("titulo"));
                objVacante.setDescripcion(objResult.getString("descripcion"));
                objVacante.setDuracion(objResult.getString("duracion"));
                objVacante.setEstado(objResult.getString("estado"));

                Empresa objEmpresa = new Empresa();
                objEmpresa.setNombre_empresa(objResult.getString("nombre_empresa"));
                objEmpresa.setUbicacion(objResult.getString("ubicacion"));
                objEmpresa.setId_empresa(objResult.getInt("id_empresa"));
                objEmpresa.setContacto(objResult.getString("contacto"));
                objEmpresa.setSector(objResult.getString("sector"));

                listaDeVacantes.add(objVacante);

            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listaDeVacantes;
    }


    //este es el listar de empresa

    public ArrayList<Object> listarEmpresa() {
        ArrayList<Object> listaDeEmpresas = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM empresa";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult =  objPrepare.executeQuery();

            while (objResult.next()){
                Empresa objEmpresa = new Empresa();
                objEmpresa.setId_empresa(objResult.getInt("id_empresa"));
                objEmpresa.setNombre_empresa(objResult.getString("nombre_empresa"));
                objEmpresa.setSector(objResult.getString("sector"));
                objEmpresa.setUbicacion(objResult.getString("ubicacion"));
                objEmpresa.setContacto(objResult.getString("contacto"));


                listaDeEmpresas.add(objEmpresa);
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listaDeEmpresas;
    }
    @Override
    public Object create(Object obj) {
        Vacante objVacante = (Vacante) obj;
        Connection objConnection = ConfigDB.openConnection();
        System.out.println(objVacante);
        try {
            String sql = "INSERT INTO vacante (id_empresa, titulo, descripcion, duracion, estado) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setInt(1, objVacante.getId_empresa());
            objPrepare.setString(2, objVacante.getTitulo());
            objPrepare.setString(3, objVacante.getDescripcion());
            objPrepare.setString(4, objVacante.getDuracion());
            objPrepare.setString(5, objVacante.getEstado());

            objPrepare.execute();

            ResultSet generatedKeys = objPrepare.getGeneratedKeys();

            while (generatedKeys.next()){
                objVacante.setId_vacante(generatedKeys.getInt(1));
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en modelo  crear vacante"
                    + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objVacante;

    }


    @Override
    public boolean update(Object obj) {

        Vacante objVacante = (Vacante) obj;
        Connection objConnection = ConfigDB.openConnection();

        Boolean isUpdate = false;

        try {
            String sql = "UPDATE vacante SET id_empresa = ?, titulo = ?, descripcion = ?, duracion = ?, estado = ? = WHERE id_vacante = ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objVacante.getId_empresa());
            objPrepare.setString(2, objVacante.getTitulo());
            objPrepare.setString(3, objVacante.getDescripcion());
            objPrepare.setString(4, objVacante.getDuracion());
            objPrepare.setString(5, objVacante.getEstado());

            int filasAfectadas =  objPrepare.executeUpdate();

            if (filasAfectadas >0){
                JOptionPane.showMessageDialog(null, "la vacante fue actualizada exitosamente");
                isUpdate = true;
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"
                    + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isUpdate;



    }


    @Override
    public boolean delete(Object obj) {
            Connection objConnection = ConfigDB.openConnection();
            Boolean isDelete = false;


            try {
                String sql = "DELETE FROM vacante WHERE id_vacante = ?";
                PreparedStatement objPrepare = objConnection.prepareStatement(sql);
                objPrepare.setInt(1, (Integer) obj);

                int filasAfectadas =  objPrepare.executeUpdate();

                if (filasAfectadas >0){
                    JOptionPane.showMessageDialog(null, "la vacante fue eliminada exitosamente");
                    isDelete = true;
                }

            } catch (SQLException e) {
                System.out.println("Error en model cliente" + e.getMessage());
            }
            ConfigDB.closeConnection();
            return isDelete;
        }


    public Object findByID(int id_vacante){
        Vacante objVacante = new Vacante();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM vacante WHERE id_vacante = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, id_vacante);

            ResultSet objResult =  objPrepare.executeQuery();

            while (objResult.next()){
                objVacante.setId_empresa(objResult.getInt("id_empresa"));
                objVacante.setTitulo(objResult.getString("titulo"));
                objVacante.setDescripcion(objResult.getString("descripcion"));
                objVacante.setDuracion(objResult.getString("duracion"));
                objVacante.setEstado(objResult.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error en model cliente findById: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objVacante;

    }

}
