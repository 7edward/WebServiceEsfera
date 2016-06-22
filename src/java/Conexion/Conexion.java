package Conexion;

/*
 * Clase que permite establecer la conexion con un servidor de base datos.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Adolfo Sanchez
 */
public class Conexion {

    private final String servidor = "localhost";
    private final String db_name = "lisyxproyect";
    private final String usuario = "root";
    private final String password = "toor";
    //fabrica private final String password = "Neoteck2014";
    //private final String password = "tutankamon7";
    //private final String password = "Asanchezl11++";
    private Connection conexion;
    private String url;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            url = "jdbc:sqlserver://" + servidor + ":1433;databaseName=" + db_name + ";user=" + usuario + ";password=" + password + ";";
            url = "jdbc:mysql://"+servidor+"/"+db_name+"";
            conexion = null;
        } catch (ClassNotFoundException e) {
            System.err.println("Conexion.Conexion " + e.getMessage());
        }
    }

    /**
     * Metodo que obtiene la conexion a la base deatos y revisa si ya existe la
     * instacia de la base de datos activa, la reutiliza para evitar que se
     * genere nuevamente.
     *
     * @return Connection
     */
    public Connection getConection() throws SQLException {
        try {
            if (conexion == null) {
                conexion = DriverManager.getConnection(url, usuario, password);
            }
        } catch (SQLException ex) {
            System.err.println("Conexion.getConnection " + ex.getMessage());
            throw ex;
        }
        return conexion;
    }

    /**
     * Metodo que permite cerrar la conexion a la base de datos.
     */
    public void closeConnection() throws SQLException {
        if (conexion != null) {
            conexion.close();
            conexion = null;
        } else {
            throw new SQLException("Conexion.closeConexion: no esta iniciada la conexion");
        }
    }

}
