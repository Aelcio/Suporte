package Controle;

import Dao.ConexaoPostgres;
import Modelo.ModeloCidade;
import java.sql.ResultSet;

/**
 *
 * @author Maru
 */
public class ControleCidade extends ConexaoPostgres {

    StringBuilder sql = new StringBuilder();

    public ResultSet consultageral() {
        super.executeSQL("SELECT * FROM CIDADE "
                + "ORDER BY id_cidade ASC");
        return super.resultset;
    }

    public void incluir(ModeloCidade cidade) {
        cidade.setId_cidade(super.ultimasequencia("cidade", "id_cidade"));
        sql.delete(0, sql.length());
        sql.append("INSERT INTO cidade (");
        sql.append("id_cidade,");
        sql.append("ds_cidade,");
        sql.append("id_uf,");
        sql.append(")VALUES(");
        sql.append(cidade.getId_cidade()).append(",'");
        sql.append(cidade.getDs_cidade()).append("','");
        sql.append(cidade.getId_uf()).append(" '");
        super.atualizarSQL(sql.toString());
    }
    
    public void alterar(ModeloCidade cidade){
        
    }
}
