package Controle;

import Dao.ConexaoPostgres;
import Modelo.ModeloAtendimento;

/**
 *
 * @author Maru
 */
public class ControleAtendimento extends ConexaoPostgres {
    
    StringBuilder sql = new StringBuilder();
    
    public void incluir(ModeloAtendimento atendimento){
        atendimento.setId_atendimento(super.ultimasequencia("atendimento", "id_atendimento"));
        sql.delete(0, sql.length());
        sql.append("INSERT INTO atendimento (");
        sql.append("id_atendimento,");
        sql.append("id_pessoa,");
        sql.append("data_suporte,");
        sql.append("sistema,");
        sql.append("versao,");
        sql.append("funcionario,");
        sql.append("problema,");
        sql.append("solucao");
        sql.append(")VALUES(");
        sql.append(atendimento.getId_atendimento()).append(",");
        sql.append(atendimento.getId_pessoa()).append(",'");
        sql.append(atendimento.getData_suporte()).append("','");
        sql.append(atendimento.getSistema()).append("','");
        sql.append(atendimento.getVersao()).append("','");
        sql.append(atendimento.getFuncionario()).append("','");
        sql.append(atendimento.getProblema()).append("','");
        sql.append(atendimento.getSolucao()).append("')");        
        super.atualizarSQL(sql.toString());        
    }    
}
