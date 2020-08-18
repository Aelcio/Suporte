package Controle;

import Dao.ConexaoPostgres;
import Modelo.ModeloPJ;

/**
 *
 * @author Maru
 */
public class ControlePJ extends ConexaoPostgres {

    StringBuilder sql = new StringBuilder();

    public void incluir(ModeloPJ pj) {
        pj.setId_pj(super.ultimasequencia("pessoa_juridica", "id_pj"));
        sql.delete(0, sql.length());
        sql.append("INSERT INTO pessoa_juridica (");
        sql.append("id_pj,");
        sql.append("cnpj,");
        sql.append("razao_social,");
        sql.append("id_pessoa");
        sql.append(")VALUES(");
        sql.append(pj.getId_pj()).append(",'");
        sql.append(pj.getCnpj()).append("','");
        sql.append(pj.getRazao_social()).append("',");
        sql.append(pj.getId_pessoa()).append(")");
        super.atualizarSQL(sql.toString());
    }
    
    public void alterar(ModeloPJ pj){
     sql.delete(0, sql.length());
        sql.append("UPDATE pessoa_juridica SET ");
        sql.append("cnpj = '").append(pj.getCnpj()).append("', ");
        sql.append("razao_social = '").append(pj.getRazao_social()).append("' ");
        //sql.append("id_pessoa = ").append(pj.getId_pessoa()).append(" ");
        sql.append("WHERE ");
        sql.append("id_pj = ").append(pj.getId_pj());
        super.atualizarSQL(sql.toString());
    }
}
