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
                System.out.println("Limpieza Exitosa");
            }
        });
        ingresarElPresenteRegistroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                String DB_url = "jdbc:sqlserver://localhost:1433;databaseName=FORMULARIO;encrypt=true;trustServerCertificate=true";
                String usuario = "java_conn";
                String contrasena = "java_conn";
                String Scodigo = textCodigo.getText().toString();
                String Sid = textCedula.getText().toString();
                String Snombre = textNombre.getText().toString();
                String Sfecha = textFecha.getText().toString();
                String Ssigno = SignoComboBox.getSelectedItem().toString();

                String query = "insert into registro (codigo, id, nombre, fecha_nacimiento, signo) values (?,?,?,?,?)";

                Connection conectar = DriverManager.getConnection(DB_url,usuario,contrasena);
                PreparedStatement statement = conectar.prepareStatement(query);
                statement.setString(1, Scodigo);
                statement.setString(2, Sid);
                statement.setString(3,Snombre);
                statement.setString(4, Sfecha);
                statement.setString(5, Ssigno);
                statement.executeUpdate();
                statement.close();
                conectar.close();
                System.out.println("Ingreso Exitoso");
            }
            catch (SQLException m){
                throw new RuntimeException(m);
            }
            }
        });
        buscarPorCódigoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String DB_url = "jdbc:sqlserver://localhost:1433;databaseName=FORMULARIO;encrypt=true;trustServerCertificate=true";
                    String usuario = "java_conn";
                    String contrasena = "java_conn";
                    String CodigoRecuperar = textCodigo.getText().toString();
                    String arg = "Select * from registro where codigo = "+ CodigoRecuperar + ";";
                    String query = arg;

                    Connection conectar = DriverManager.getConnection(DB_url,usuario,contrasena);
                    Statement stmt = conectar.createStatement();
                    ResultSet rs = stmt.executeQuery(query);

                    if (rs.next()){
                        String idRec = rs.getString("id");
                        String nombreRec = rs.getString("nombre");
                        String fechaRec = rs.getString("fecha_nacimiento");
                        String signoRec = rs.getString("signo");

                        textCedula.setText(idRec);
                        textNombre.setText(nombreRec);
                        textFecha.setText(String.valueOf(fechaRec));
                        SignoComboBox.setSelectedItem(signoRec);

                        System.out.println("Se encontro el registro");
                    } else {
                        System.out.println("No se encontro el registro ingresado");
                    }

                    stmt.close();
                    rs.close();
                    conectar.close();
                }
                catch (SQLException m){
                    throw new RuntimeException(m);
                }
            }

        });
        buscarPorNombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String DB_url = "jdbc:sqlserver://localhost:1433;databaseName=FORMULARIO;encrypt=true;trustServerCertificate=true";
                    String usuario = "java_conn";
                    String contrasena = "java_conn";
                    String NombreRecuperar = textNombre.getText().toString();
                    String arg = "select * from registro where nombre = "+ "'" + NombreRecuperar  + "'" + " ;";
                    String query = arg;
                    Connection conectar = DriverManager.getConnection(DB_url,usuario,contrasena);
                    Statement stmt = conectar.createStatement();
                    ResultSet rs = stmt.executeQuery(query);

                    if (rs.next()){
                        String codRec = rs.getString("codigo");
                        String idRec = rs.getString("id");
                        String fechaRec = rs.getString("fecha_nacimiento");
                        String signoRec = rs.getString("signo");

                        textCodigo.setText(codRec);
                        textCedula.setText(idRec);
                        textFecha.setText(fechaRec);
                        SignoComboBox.setSelectedItem(signoRec);

                        System.out.println("Se encontro el registro");
                    } else {
                        System.out.println("No se encontro el registro ingresado");
                    }

                    stmt.close();
                    rs.close();
                    conectar.close();
                }
                catch (SQLException m){
                    throw new RuntimeException(m);
                }
            }
        });
        buscarPorSignoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String DB_url = "jdbc:sqlserver://localhost:1433;databaseName=FORMULARIO;encrypt=true;trustServerCertificate=true";
                    String usuario = "java_conn";
                    String contrasena = "java_conn";
                    String SignoRecuperar = SignoComboBox.getSelectedItem().toString();
                    String arg = "select * from registro where signo = "+ "'" + SignoRecuperar  + "'" + " ;";
                    String query = arg;
                    Connection conectar = DriverManager.getConnection(DB_url,usuario,contrasena);
                    Statement stmt = conectar.createStatement();
                    ResultSet rs = stmt.executeQuery(query);

                    if (rs.next()){
                        String codRec = rs.getString("codigo");
                        String idRec = rs.getString("id");
                        String fechaRec = rs.getString("fecha_nacimiento");
                        String nombreRec = rs.getString("nombre");

                        textCodigo.setText(codRec);
                        textCedula.setText(idRec);
                        textFecha.setText(fechaRec);
                        textNombre.setText(nombreRec);

                        System.out.println("Se encontro el registro");
                    } else {
                        System.out.println("No se encontro el registro ingresado");
                    }

                    stmt.close();
                    rs.close();
                    conectar.close();
                }
                catch (SQLException m){
                    throw new RuntimeException(m);
                }
            }
        });
        actualizarElPresenteRegistroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String DB_url = "jdbc:sqlserver://localhost:1433;databaseName=FORMULARIO;encrypt=true;trustServerCertificate=true";
                    String usuario = "java_conn";
                    String contrasena = "java_conn";
                    String Scodigo = textCodigo.getText().toString();
                    String Sid = textCedula.getText().toString();
                    String Snombre = textNombre.getText().toString();
                    String Sfecha = textFecha.getText().toString();
                    String Ssigno = SignoComboBox.getSelectedItem().toString();

                    String query = "Update registro set codigo = ?, id = ?, nombre = ?, fecha_nacimiento = ?, signo = ? where codigo = ?";

                    Connection conectar = DriverManager.getConnection(DB_url,usuario,contrasena);
                    PreparedStatement upstatement = conectar.prepareStatement(query);

                    upstatement.setString(1, Scodigo);
                    upstatement.setString(2,Sid);
                    upstatement.setString(3, Snombre);
                    upstatement.setString(4, Sfecha);
                    upstatement.setString(5, Ssigno);
                    upstatement.setString(6, Scodigo);

                    int filasactualizada = upstatement.executeUpdate();

                    if (filasactualizada > 0){
                        System.out.println("Actualizacion exitosa");
                    }else {
                        System.out.println("No se encontró el ID proporcionado");
                    }
                    upstatement.close();
                    conectar.close();

                }
                catch (SQLException m){
                    throw new RuntimeException(m);
                }
            }
        });
        borrarElPresenteRegistroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String DB_url = "jdbc:sqlserver://localhost:1433;databaseName=FORMULARIO;encrypt=true;trustServerCertificate=true";
                    String usuario = "java_conn";
                    String contrasena = "java_conn";
                    String CodigoBorrar = textCodigo.getText().toString();

                    String query = "delete from registro where codigo = ?";

                    Connection conectar = DriverManager.getConnection(DB_url,usuario,contrasena);
                    PreparedStatement statement = conectar.prepareStatement(query);
                    statement.setString(1, CodigoBorrar);
                    int filasafectadas = statement.executeUpdate();


                    if (filasafectadas > 0){
                        System.out.println("Eliminación exitosa");
                    } else {
                        System.out.println("No se encontró ningun dato en el ID proporcionado");
                    }

                    statement.close();
                    conectar.close();
                }
                catch (SQLException m){
                    throw new RuntimeException(m);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("formulario");
        frame.setContentPane(new formulario().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Cconection conn = new Cconection();
        conn.establecerConexion();
    }
}
