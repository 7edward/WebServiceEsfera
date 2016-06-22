package Evento;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class DAOEvento {
    
     /**
     * Metodo que realiza un insert en la base de datos
     * para registrar un nuevo evento.
     *
     * @param dtoEvento
     * @return
     * @throws SQLException
     */
    public boolean nuevoEvento(DTOEvento dtoEvento) throws SQLException {
        boolean valida = false;
        Conexion cn = null;
        try {
            cn = new Conexion();
            cn.getConection().setAutoCommit(false);
            insertEvento(cn.getConection(), dtoEvento);
            valida = true;
        } catch (Exception e) {
            throw e;
        } finally {
            if (valida) {
                cn.getConection().commit();
            } else {
                cn.getConection().rollback();
            }
            if (cn.getConection() != null) {
                cn.closeConnection();
            }
        }
        return valida;
    }
     /**
     * Metodo que reaaliza el insert en la base de datos.
     *
     * @param cn
     * @param dtoEvento
     * @throws SQLException
     */
    public void insertEvento(Connection cn, DTOEvento dtoEvento) throws SQLException {
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try {
            StringBuilder query = new StringBuilder();
            query.append(" INSERT INTO lisyxevent (idevento,nombre_evento,fecha_evento,no_participantes,descripcion,estatus");
            query.append(" VALUES (?,?,?,?,?,?) ");
            preparedStatement = cn.prepareStatement(query.toString());
            preparedStatement.setLong(1, dtoEvento.getIdEvento());
            preparedStatement.setString(2, dtoEvento.getNombre_evento());
            preparedStatement.setString(3, dtoEvento.getFecha_evento());
            preparedStatement.setInt(4, dtoEvento.getNo_participantes());
            preparedStatement.setString(5, dtoEvento.getDescripcion());
            preparedStatement.setInt(6, dtoEvento.getEstatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
}
