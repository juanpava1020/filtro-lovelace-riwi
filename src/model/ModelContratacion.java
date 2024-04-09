package model;

import database.ConfigDB;
import entity.Coder;
import entity.Contratacion;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelContratacion implements CRUD {
    @Override
    public ArrayList<Object> listar() {
        ArrayList<Object> listaDeContrataciones = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM contrataciones";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Contratacion objContratacion = new Contratacion();
                objContratacion.setId_contratacion(objResult.getInt("id_contratacion"));
                objContratacion.setId_vacante(objResult.getInt("id_vacante"));
                objContratacion.setId_coder(objResult.getInt("id_coder"));
                objContratacion.setFecha_aplicacion(objResult.getString("fecha_aplicacion"));
                objContratacion.setEstado(objResult.getString("estado"));
                objContratacion.setSalario(objResult.getBigDecimal("salario"));

                listaDeContrataciones.add(objContratacion);
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listaDeContrataciones;


    }

    @Override
    public Object create(Object obj) {
        Contratacion objContratacion = (Contratacion) obj;
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "INSERT INTO contratacion (id_contratacion, id_vacante, id_coder, fecha_aplicacion, estado, salario) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setInt(1, objContratacion.getId_contratacion());
            objPrepare.setInt(2, objContratacion.getId_vacante());
            objPrepare.setInt(3, objContratacion.getId_coder());
            objPrepare.setString(4, objContratacion.getFecha_aplicacion());
            objPrepare.setString(5, objContratacion.getEstado());
            objPrepare.setBigDecimal(6, objContratacion.getSalario());


            objPrepare.execute();

            ResultSet generatedKeys = objPrepare.getGeneratedKeys();

            while (generatedKeys.next()) {
                objContratacion.setId_vacante(generatedKeys.getInt(1));
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"
                    + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objContratacion;

    }

    @Override
    public boolean update(Object obj) {
        Contratacion objContratacion = (Contratacion) obj;
        Connection objConnection = ConfigDB.openConnection();

        boolean isUpdate = false;

        try {
            String sql = "UPDATE contratacion SET id_vacante = ?, id_coder = ?, fecha_aplicacion = ?, estado = ?, salario = ? WHERE id_contratacion = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objContratacion.getId_contratacion());
            objPrepare.setInt(2, objContratacion.getId_vacante());
            objPrepare.setInt(3, objContratacion.getId_coder());
            objPrepare.setString(4, objContratacion.getEstado());
            objPrepare.setBigDecimal(5, objContratacion.getSalario());

            objPrepare.setInt(6, objContratacion.getId_contratacion());


            int filasAfectadas =   objPrepare.executeUpdate();

            if (filasAfectadas > 0){
                isUpdate = true;
                JOptionPane.showMessageDialog(null,  "LA CONTRATACION fue actualizado exitosamente");
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"
                    + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isUpdate;

    }
    public Object findByID(int id_contratacion){
        Contratacion objContratacion = new Contratacion();

        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM contratacion WHERE id_contratacion = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, id_contratacion);

            ResultSet objResult =  objPrepare.executeQuery();

            while (objResult.next()){
                objContratacion.setId_contratacion(objResult.getInt("id_contratacion"));
                objContratacion.setId_vacante(objResult.getInt("id_vacante"));
                objContratacion.setId_coder(objResult.getInt("id_coder"));
                objContratacion.setFecha_aplicacion(objResult.getString("fecha_aplicacion"));
                objContratacion.setEstado(objResult.getString("estado"));
                objContratacion.setSalario(objResult.getBigDecimal("salario"));
            }
        } catch (SQLException e) {
            System.out.println("Error en model Contratacion findById: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objContratacion;
    }

    @Override
    public boolean delete(Object obj) {

        Connection objConnection = ConfigDB.openConnection();
        Boolean isDelete = false;


        try {
            String sql = "DELETE FROM contratacion WHERE id_contratacion = ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, (Integer) obj);

            int filasAfectadas =  objPrepare.executeUpdate();

            if (filasAfectadas >0){
                JOptionPane.showMessageDialog(null, "la contratacion fue eliminado exitosamente");
                isDelete = true;
            }

        } catch (SQLException e) {
            System.out.println("Error en model contratacion" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isDelete;

    }
}
