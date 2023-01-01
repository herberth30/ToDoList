package datos;

import domain.TareaDTO;

import java.sql.SQLException;
import java.util.List;

public interface TareaDAO {
     List<TareaDTO> seleccionar() throws SQLException;
     List<TareaDTO> seleccionarCompleto() throws SQLException;
     List<TareaDTO> seleccionarIncompleto() throws SQLException;
     void insertar(TareaDTO tarea) throws SQLException;
     void eliminar(TareaDTO tarea) throws SQLException;
     void marcarCompleto(TareaDTO tarea) throws SQLException;
     void marcarIncompleto(TareaDTO tarea) throws SQLException;

}
