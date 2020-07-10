package Controle;

import Dao.ConexaoPostgres;
import Modelo.ModeloCidade;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Maru
 */
public class ControleCidade extends ConexaoPostgres {

    StringBuilder sql = new StringBuilder();

    public ResultSet consultageral() {
        super.executeSQL("SELECT cd.id_cidade, cd.ds_cidade, uf.id_uf FROM CIDADE AS cd "
                + "JOIN uf ON uf.id_uf = cd.id_uf "
                + "ORDER BY id_cidade ASC");
        return super.resultset;
    }

    public void incluir(ModeloCidade cidade) {
        cidade.setId_cidade(super.ultimasequencia("cidade", "id_cidade"));
        sql.delete(0, sql.length());
        sql.append("INSERT INTO cidade (");
        sql.append("id_cidade,");
        sql.append("ds_cidade,");
        sql.append("id_uf");
        sql.append(")VALUES(");
        sql.append(cidade.getId_cidade()).append(",'");
        sql.append(cidade.getDs_cidade()).append("','");
        sql.append(cidade.getId_uf()).append("')");
        super.atualizarSQL(sql.toString());
    }
    
    public void alterar(ModeloCidade cidade){
     sql.delete(0, sql.length());
        sql.append("UPDATE cidade SET ");
        sql.append("ds_cidade = '").append(cidade.getDs_cidade()).append("', ");
        sql.append("id_uf = '").append(cidade.getId_uf()).append("' ");
        sql.append("WHERE ");
        sql.append("id_cidade = ").append(cidade.getId_cidade());
        super.atualizarSQL(sql.toString());
    }

    public void excluir(ModeloCidade cidade) {
        sql.delete(0, sql.length());
        sql.append("DELETE FROM pessoa ");
        sql.append("WHERE ");
        sql.append("id_pessoa = ").append(cidade.getId_cidade());
        super.atualizarSQL(sql.toString());
     
    }
    
     public void retornadados(ModeloCidade cidade) {
        super.executeSQL("SELECT * FROM cidade WHERE "
                + "id_cidade = " + cidade.getId_cidade());
        try {
            super.resultset.first();
            cidade.setId_cidade(resultset.getInt("id_cidade"));
           cidade.setDs_cidade(resultset.getString("ds_cidade"));
            cidade.setId_uf(resultset.getString("id_uf"));
            } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
