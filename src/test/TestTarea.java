package test;
import datos.TareaDAO;
import datos.TareaDAOJDBC;
import domain.Menu;
import domain.TareaDTO;

import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import static datos.Conexion.getConnection;

public class TestTarea  {
    public static void main(String[] args) {
        boolean cerrarPrograma = false;
        while (!cerrarPrograma) {

            String texto, texto1;
            int id;
            Connection conexion = null;
            Scanner scanner = new Scanner(System.in);
            try {
                conexion = getConnection();
                if (conexion.getAutoCommit()) {
                    conexion.setAutoCommit(false);
                }
                //IMPLEMENTACION:
                TareaDAO tareaDAO = new TareaDAOJDBC(conexion);

                Menu menu = new Menu();
                menu.mostrarMenu();


                int respuesta = scanner.nextInt();
                switch (respuesta) {
                    case 1:
                        System.out.println("TODAS LAS TAREAS:");
                        List<TareaDTO> tareas = tareaDAO.seleccionar();
                        int num = 1;
                        for (TareaDTO tarea : tareas) {
                            System.out.println(num + ": Id." + tarea.getIdTarea() + " Titulo: "+tarea.getTitulo() + " Descripccion: " + tarea.getDescripcion() + " Estado: " +tarea.getEstado()) ;
                            num++;
                        }
                        break;
                    case 2:
                        System.out.println("TODAS LAS TAREAS COMPLETADAS:");
                        List<TareaDTO> tareasCompletas = tareaDAO.seleccionarCompleto();
                        for (TareaDTO tarea : tareasCompletas) System.out.println(tarea);
                        break;
                    case 3:
                        System.out.println("TODAS LAS TAREAS INCOMPLETAS:");
                        List<TareaDTO> tareasIncompletas = tareaDAO.seleccionarIncompleto();
                        for (TareaDTO tarea : tareasIncompletas) System.out.println(tarea);
                        break;
                    case 4:
                        System.out.println("NUEVA TAREA:");
                        TareaDTO tareaInsertar = new TareaDTO();
                        System.out.println("Ingresar Titulo: ");
                        scanner.nextLine();
                        texto = scanner.nextLine();
                        tareaInsertar.setTitulo(texto);
                        System.out.println("Ingresa descripcion: ");
                        texto1 = scanner.nextLine();
                        tareaInsertar.setDescripcion(texto1);
                        tareaDAO.insertar(tareaInsertar);
                        break;
                    case 5:

                        System.out.println("MARCAR UNA TAREA COMO COMPLETA:");
                        TareaDTO tareaCompleto = new TareaDTO();
                        System.out.println("Ingrese el id de la tarea completada ");
                        id = scanner.nextInt();
                        tareaCompleto.setIdTarea(id);
                        tareaDAO.marcarCompleto(tareaCompleto);
                        break;
                    case 6:

                        System.out.println("MARCAR UNA TAREA COMO INCOMPLETA:");
                        TareaDTO tareaInompleto = new TareaDTO();
                        System.out.println("Ingrese el id de la tarea incompleta ");
                        id = scanner.nextInt();
                        tareaInompleto.setIdTarea(id);
                        tareaDAO.marcarIncompleto(tareaInompleto);
                        break;
                    case 7:

                        System.out.println("ELIMINAR UNA TAREA:");
                        TareaDTO tareaEliminar = new TareaDTO();
                        System.out.println("Ingrese el id de la tarea a eliminar: ");
                        id = scanner.nextInt();
                        tareaEliminar.setIdTarea(id);
                        tareaDAO.eliminar(tareaEliminar);
                        break;
                    case 8:
                        System.out.println("ADIOS");
                        cerrarPrograma=true;
                    default:
                        System.out.println("Opcion erronea");
                        break;

                }


                conexion.commit();
            } catch (SQLException ex) {
                try {
                    ex.printStackTrace();
                    System.out.println("FALLO");
                    assert conexion != null;
                    conexion.rollback();
                } catch (SQLException ex1) {
                    ex1.printStackTrace();
                }
            }
        }
    }
}