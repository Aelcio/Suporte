package Ferramentas;

import Dao.ConexaoPostgres;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maru
 */
public class PreencherJtableGenerico {

    public void somaitens(JTable tabela, JLabel text, int coluna) {
        DefaultTableModel Tabela = (DefaultTableModel) tabela.getModel();
        int totlinha = Tabela.getRowCount();
        double total = 0;
        for (int i = 0; i < totlinha; i++) {
            String vl = ((String) Tabela.getValueAt(i, coluna));
            total = total + (Double.parseDouble(vl));
        }
        text.setText(Double.toString(total));
    }

    public void FormatarJTable(JTable tabela, int valores[]) {
        int x;
        for (x = 0; x < valores.length; x++) {
            tabela.getColumnModel().getColumn(x).setPreferredWidth(valores[x]);
        }

    }

    public void PreencherJtableGenerico(JTable tabela, String campos[], ResultSet resultSet) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        try {
            while (resultSet.next()) {
                int len = campos.length;
                Object[] row = new Object[len];
                int i;
                for (i = 0; i < len; i++) {
                    row[i] = resultSet.getString(campos[i]);
                }
                modelo.addRow(row);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar JTable" + erro);
        }
    }

    public void PreencherJtableGenericoSel(JTable tabela, String campos[], ResultSet resultSet) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        try {
            while (resultSet.next()) {
                int len = campos.length;
                Object[] row = new Object[len];
                int i;
                for (i = 0; i < len; i++) {
                    if (i == 0) {
                        row[i] = (false);
                    } else {
                        row[i] = resultSet.getString(campos[i]);
                    }
                }
                modelo.addRow(row);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar JTable" + erro);
        }
    }

    public void limparJtable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
    }

    // Método para Preencher ComboBox  
    public String[] preencherComboStr(JComboBox combo, ResultSet resultado, String[] pk,
            String conteudo, String chave) {
        combo.removeAllItems();
        try {
            resultado.last();
            pk = new String[resultado.getRow()];

            resultado.first();
            int x = 0;
            do {
                combo.addItem(resultado.getString(conteudo));
                pk[x] = resultado.getString(chave);
                x++;
            } while (resultado.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return pk;
    }
    
        public static void main(String[] args){
            ConexaoPostgres.conecta();
        }


}
