import controller.ControllerCoder;
import controller.ControllerContratacion;
import controller.ControllerVacante;
import database.ConfigDB;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int opcion = 0, opcionCoder = 0, opcionVacante = 0, opcionContratacion = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    Ingrese una opción
                    1 - CRUD CODER
                    2 - CRUD VACANTE
                    3 - CRUD CONTRATACION
                    """));

            switch (opcion){
                case 1:
                    do {
                        opcionCoder = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear coder
                                2 - Eliminar coder 
                                3 - Actualizar coder
                                4 - Listar coder
                                5 - Salir 
                                """));

                        switch (opcionCoder){
                            case 1:
                                ControllerCoder.crear();
                                break;
                            case 2:
                                ControllerCoder.delete();
                                break;
                            case 3:
                                ControllerCoder.update();
                                break;
                            case 4:
                                ControllerCoder.listar();
                                break;
                        }
                    }while (opcionCoder != 5);

                    break;

                case 2:
                    do {
                        opcionVacante = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear vacante
                                2 - Eliminar vacante 
                                3 - Actualizar vacante
                                4 - Listar vacante
                                5 - Buscar cliente por nombre
                                6 - Salir 
                                """));

                        switch (opcionVacante){
                            case 1:
                                ControllerVacante.crear();
                                break;
                            case 2:
                                ControllerVacante.delete();
                                break;
                            case 3:
                                ControllerVacante.delete();
                                break;
                            case 4:
                                ControllerVacante.listar();
                                break;
                            case 5:

                                break;
                        }
                    }while (opcionVacante != 6);
                    break;

                case 3:
                    do {
                        opcionContratacion = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear contratacion
                                2 - Eliminar contratacion 
                                3 - Actualizar contratacion
                                4 - Listar producontratacioncto
                                5 - Salir 
                                 """));

                        switch (opcionContratacion){
                            case 1:
                                ControllerContratacion.crear();
                                break;
                            case 2:
                                ControllerContratacion.delete();
                                break;
                            case 3:
                                ControllerContratacion.update();
                                break;
                            case 4:
                                ControllerContratacion.listar();
                                break;
                        }

                    }while (opcionContratacion != 5);
                    break;
            }
        }while (opcion != 5);
    }
    }
