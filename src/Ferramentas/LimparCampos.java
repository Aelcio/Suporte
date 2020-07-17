package Ferramentas;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author Maru
 */
public class LimparCampos {

    public static void limparcampos(Container container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JFormattedTextField) {
                JFormattedTextField field = (JFormattedTextField) component;
                field.setValue(null);
                field.setText("");
            }else if (component instanceof JTextField){
                JTextField field = (JTextField) component;
                field.setText("");
            }
        }
    }
}
