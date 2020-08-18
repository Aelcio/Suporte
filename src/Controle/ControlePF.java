package Controle;

import Dao.ConexaoPostgres;
import Modelo.ModeloPF;

/**
 *
 * @author Maru
 */
public class ControlePF extends ConexaoPostgres {
    
    StringBuilder sql = new StringBuilder();
    
    public void incluir(ModeloPF pf) {
        pf.setId_pf(super.ultimasequencia("pessoa_fisica", "id_pf"));
        sql.delete(0, sql.length());
        sql.append("INSERT INTO pessoa_fisica (");
        sql.append("id_pf,");
        sql.append("cpf,");
        sql.append("id_pessoa");
        sql.append(")VALUES(");
        sql.append(pf.getId_pf()).append(",'");
        sql.append(pf.getCpf()).append("',");
        sql.append(pf.getId_pessoa()).append(")");
        super.atualizarSQL(sql.toString());        
    } 
    
    public void alterar(ModeloPF pf){
     sql.delete(0, sql.length());
        sql.append("UPDATE pessoa_fisica SET ");
        sql.append("cpf = '").append(pf.getCpf()).append("' ");
       // sql.append("id_pessoa = '").append(pf.getId_pessoa()).append("' ");
        sql.append("WHERE ");
        sql.append("id_pf = ").append(pf.getId_pf());
        super.atualizarSQL(sql.toString());
    }
}
