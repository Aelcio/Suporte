package Controle;

import Dao.ConexaoPostgres;
import java.sql.ResultSet;

/**
 *
 * @author Maru
 */
public class ControleUF extends ConexaoPostgres {

    StringBuilder sql = new StringBuilder();
    
    public ResultSet consultgeral(){
        super.executeSQL("SELECT * FROM UF "
                + "ORDER BY id_uf ASC");
        return super.resultset;
    }
}
