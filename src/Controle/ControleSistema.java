package Controle;

import Dao.ConexaoPostgres;
import java.sql.ResultSet;

/**
 *
 * @author Maru
 */
public class ControleSistema extends ConexaoPostgres {
    
    public ResultSet consultasistema(){
        super.executeSQL("SELECT * FROM SISTEMA ");
    return super.resultset;    
    }
    
}
