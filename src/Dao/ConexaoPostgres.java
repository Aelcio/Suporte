package Dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Maru
 */
public class ConexaoPostgres {

    public static Connection ConexaoPostgres;
    public static Statement statement;
    public static ResultSet resultset;
    public int retorno = 0;

    public ConexaoPostgres() {
        conecta();
    }

    public static Connection conecta() {
        if (ConexaoPostgres != null) {
            return ConexaoPostgres;
        } else {
            try {
                Class.forName("org.postgresql.Driver");
                ConexaoPostgres = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Suporte", "postgres", "11092014");
                System.out.println("Conectado");
                return ConexaoPostgres;
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Driver não encontrado" + ex);
                return null;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao conectar com o BD! " + ex);
                return null;
            }
        }
    }

    public void desconecta() {
        boolean result = true;
        try {
            ConexaoPostgres.close();
        } catch (SQLException fecha) {
            JOptionPane.showMessageDialog(null, "Não foi possível fechar o banco de dados" + fecha);
            result = false;
        }
    }

    public void executeSQL(String sql) {
        try {
            statement = ConexaoPostgres.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
            retorno = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possíuvel localizar o registro" + ex);
        }
    }

    public void atualizarSQL(String sql) {
        try {
            statement = ConexaoPostgres.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            retorno = 0;
            retorno = statement.executeUpdate(sql); 
            if (retorno == 1) {
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Incluir ou Alterar " + ex);
            retorno = 0;
        }
    }

    public int ultimasequencia(String tabela, String atributo) {
        executeSQL("SELECT COALESCE(MAX(" + atributo + "),0) + 1 AS ULTIMO FROM " + tabela);
        int retorno = 0;
        try {
            resultset.first();
            retorno = resultset.getInt("ULTIMO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Registro não Encontrado" + ex);
        }
        return retorno;
    }
   
}
