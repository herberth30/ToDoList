package datos;

import domain.TareaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;

public class TareaDAOJDBC implements TareaDAO {

    private Connection conexionTransaccional;
    //Peticiones SQL:
    private static final String SQL_INSERT = "INSERT INTO tarea(titulo,descripcion, estado)VALUES(?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM tarea WHERE (idTarea = ? )";
    private static final String SQL_UPDATE_COMPLETE = "UPDATE tarea SET estado='Completo' WHERE (idTarea = ?)";
    private static final String SQL_UPDATE_INCOMPLETE = "UPDATE tarea SET estado='Incompleto' WHERE (idTarea = ?)";
    private static final String SQL_SELECT_INCOMPLETE = "SELECT idTarea, titulo, descripcion,estado FROM tarea WHERE (estado = 'Incompleto')";
    private static final String SQL_SELECT_COMPLETE = "SELECT idTarea, titulo, descripcion,estado FROM tarea WHERE (estado = 'Completo')";
    private static final String SQL_SELECT = "SELECT idTarea, titulo, descripcion,estado FROM tarea";


    public TareaDAOJDBC()  {
    }

    public TareaDAOJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }


    public List<TareaDTO> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TareaDTO tarea = null;
        List<TareaDTO> tareas = new ArrayList<>();

        try {
            conn = this.conexionTransaccional!=null?this.conexionTransaccional:getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs=stmt.executeQuery();
            while (rs.next()){
                int idTarea = rs.getInt("idTarea");
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                String estado = rs.getString("estado");

                tarea = new TareaDTO(idTarea,titulo,descripcion,estado);
                tareas.add(tarea);
            }
        }  catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally {
            try {
                close(rs);
                close(stmt);
                if (this.conexionTransaccional==null){
                    close(conn);
                }
            }catch (SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return tareas;
    }

    public List<TareaDTO> seleccionarCompleto() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TareaDTO tarea = null;
        List<TareaDTO> tareas = new ArrayList<>();

        try {
            conn = this.conexionTransaccional!=null?this.conexionTransaccional:getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_COMPLETE);
            rs=stmt.executeQuery();
            while (rs.next()){
                int idTarea = rs.getInt("idTarea");
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                String estado = rs.getString("estado");

                tarea = new TareaDTO(idTarea,titulo,descripcion,estado);
                tareas.add(tarea);
            }
        }  catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally {
            try {
                close(rs);
                close(stmt);
                if (this.conexionTransaccional==null){
                    close(conn);
                }
            }catch (SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return tareas;
    }

    public List<TareaDTO> seleccionarIncompleto() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TareaDTO tarea = null;
        List<TareaDTO> tareas = new ArrayList<>();

        try {
            conn = this.conexionTransaccional!=null?this.conexionTransaccional:getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_INCOMPLETE);
            rs=stmt.executeQuery();
            while (rs.next()){
                int idTarea = rs.getInt("idTarea");
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                String estado = rs.getString("estado");

                tarea = new TareaDTO(idTarea,titulo,descripcion,estado);
                tareas.add(tarea);
            }
        }  catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally {
            try {
                close(rs);
                close(stmt);
                if (this.conexionTransaccional==null){
                    close(conn);
                }
            }catch (SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return tareas;
    }

    public void insertar(TareaDTO tarea) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn= this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1,tarea.getTitulo());
            stmt.setString(2,tarea.getDescripcion());
            stmt.setString(3, "Incompleto");
            stmt.executeUpdate();

        } finally {
            try{
                close(stmt);
            if (this.conexionTransaccional==null){
                close(conn);
            }
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }

    }

    public void eliminar(TareaDTO tarea) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn= this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, tarea.getIdTarea());
            stmt.executeUpdate();

        } finally {
            try{
                close(stmt);
                if (this.conexionTransaccional==null){
                    close(conn);
                }
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
    }

    public void marcarCompleto(TareaDTO tarea) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        stmt = conn.prepareStatement(SQL_UPDATE_COMPLETE);
        stmt.setInt(1,tarea.getIdTarea());
        stmt.executeUpdate();

    }

    public void marcarIncompleto(TareaDTO tarea) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;

        conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
        stmt = conn.prepareStatement(SQL_UPDATE_INCOMPLETE);
        stmt.setInt(1,tarea.getIdTarea());
        stmt.executeUpdate();

    }





}
