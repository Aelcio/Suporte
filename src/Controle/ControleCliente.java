package Controle;

import Dao.ConexaoPostgres;
import java.sql.ResultSet;

/**
 *
 * @author Maru
 */
public class ControleCliente extends ConexaoPostgres{
    
    StringBuilder sql = new StringBuilder();
    
    public ResultSet consultageral(){
        super.executeSQL("SELECT "
                + "c.id_cliente, "
                + "c.nome,"
                + "cd.nome, "
                + "c.telefone, "
                + "c.celular, "
                + "c.email, "
                + "c.cod_sci, "
                + "c.usuario_sci, "
                + "c.senha_sci FROM cidade as c "
                + "JOIN cidade as cd "
                + "ON cd.id_cidade = c.id_cidade");        
        return super.resultset;
    }
}
