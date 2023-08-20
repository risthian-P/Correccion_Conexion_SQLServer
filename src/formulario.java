import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                //falta setear el valor del signo
                System.out.println(SignoComboBox.getSelectedIndex());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("formulario");
        frame.setContentPane(new formulario().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
