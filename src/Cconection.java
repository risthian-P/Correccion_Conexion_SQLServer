import java.sql.*;

public class Cconection {
    protected Connection establecerConexion() {
        String DB_url = "jdbc:sqlserver://localhost:1433;databaseName=FORMULARIO;encrypt=true;trustServerCertificate=true";
        String usuario = "java_conn";
        String contrasena = "java_conn";

        Connection conectar;
        try {
            conectar = DriverManager.getConnection(DB_url, usuario, contrasena);

            System.out.println("conexion exitosa");
            /*
            while (rs.next()) {
                System.out.println("\nid: " + rs.getString("id"));
                System.out.println("nombre: " + rs.getString("nombre"));
                System.out.println("apellido: " + rs.getString("apellido"));
                System.out.println("edad: " + rs.getBigDecimal("edad"));
                System.out.println("profesion: " + rs.getString("profesion"));
            }
            */
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conectar;
    }

}
