import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class formulario {
    private JPanel rootPanel;
    private JTextField textCodigo;
    private JComboBox SignoComboBox;
    private JButton buscarPorCódigoButton;
    private JButton buscarPorNombreButton;
    private JButton buscarPorSignoButton;
    private JButton limpiarFormularioButton;
    private JButton borrarElPresenteRegistroButton;
    private JButton actualizarElPresenteRegistroButton;
    private JButton ingresarElPresenteRegistroButton;
    private JTextField textCedula;
    private JTextField textNombre;
    private JTextField textFecha;

    private formulario(){
        limpiarFormularioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textCodigo.setText("");
                textCedula.setText("");
                textNombre.setText("");
                textFecha.setText("");
                SignoComboBox.setSelectedItem("--Seleccionar--");
                //falta setear el valor del signo
                System.out.println(SignoComboBox.getSelectedIndex());
            }
        });
    }
    private Connection establecerConexion() {
        String DB_url = "jdbc:sqlserver://localhost:1433;databaseName=FORMULARIO;encrypt=true;trustServerCertificate=true";
        String usuario = "java_conn";
        String contrasena = "java_conn";
        String query = "Select * from registro";
        Connection conectar;
        try {
            conectar = DriverManager.getConnection(DB_url, usuario, contrasena);
            Statement stmt = conectar.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("conexion exitosa");
            while (rs.next()) {
                System.out.println("\nid: " + rs.getString("id"));
                System.out.println("nombre: " + rs.getString("nombre"));
                System.out.println("apellido: " + rs.getString("apellido"));
                System.out.println("edad: " + rs.getBigDecimal("edad"));
                System.out.println("profesion: " + rs.getString("profesion"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conectar;
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("formulario");
        frame.setContentPane(new formulario().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        formulario conn = new formulario();
        conn.establecerConexion();
    }
}
