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
}
