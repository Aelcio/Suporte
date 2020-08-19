package Controle;

import Dao.ConexaoPostgres;
import Modelo.ModeloAtendimento;
import Modelo.ModeloPessoa;
import Modelo.ModeloSistema;
import java.sql.ResultSet;

/**
 *
 * @author Maru
 */
public class ControleAtendimento extends ConexaoPostgres {

    StringBuilder sql = new StringBuilder();

    public ResultSet consultageral() {
        super.executeSQL("SELECT at.id_atendimento, "
                + "p.id_pessoa,"
                + "p.nome, "
                + "at.data_suporte, "
                + "s.id_sistema, "
                + "s.ds_sistema, "
                + "at.versao, "
                + "at.funcionario, "
                + "at.problema, "
                + "at.solucao "
                + "FROM atendimento as at "
                + "JOIN pessoa as p "
                + "ON p.id_pessoa = at.id_pessoa "
                + "JOIN sistema as s "
                + "ON s.id_sistema = at.id_sistema");
        return super.resultset;
    }

    public ResultSet consultacliente(ModeloAtendimento atendimento, ModeloPessoa pessoa, ModeloSistema sistema) {
        super.executeSQL("SELECT at.id_atendimento, "
                + "p.id_pessoa,"
                + "p.nome, "
                + "data_suporte, "
                + "s.id_sistema, "
                + "s.ds_sistema, "
                + "at.versao, "
                + "at.funcionario, "
                + "at.problema, "
                + "at.solucao "
                + "FROM atendimento as at "
                + "JOIN pessoa as p "
                + "ON p.id_pessoa = at.id_pessoa "
                + "JOIN sistema as s "
                + "ON s.id_sistema = at.id_sistema "
                + "WHERE "
                + "p.nome ILIKE '%" + pessoa.getNome()
                + "%' OR s.ds_sistema ILIKE '%" + sistema.getDs_sistema()
                + "%' OR at.problema ILIKE '%" + atendimento.getProblema()
                + "%' OR at.solucao ILIKE '%" + atendimento.getSolucao()
                + "%' OR at.solucao ILIKE '%" + atendimento.getSolucao()
                + "%' OR at.funcionario ILIKE '%" + atendimento.getFuncionario()
                + "%'");
        return super.resultset;
    }

    public void incluir(ModeloAtendimento atendimento) {
        atendimento.setId_atendimento(super.ultimasequencia("atendimento", "id_atendimento"));
        sql.delete(0, sql.length());
        sql.append("INSERT INTO atendimento (");
        sql.append("id_atendimento,");
        sql.append("id_pessoa,");
        sql.append("data_suporte,");
        sql.append("versao,");
        sql.append("funcionario,");
        sql.append("problema,");
        sql.append("solucao,");
        sql.append("id_sistema");
        sql.append(")VALUES(");
        sql.append(atendimento.getId_atendimento()).append(",");
        sql.append(atendimento.getId_pessoa()).append(",'");
        sql.append(atendimento.getData_suporte()).append("','");
        sql.append(atendimento.getVersao()).append("','");
        sql.append(atendimento.getFuncionario()).append("','");
        sql.append(atendimento.getProblema()).append("','");
        sql.append(atendimento.getSolucao()).append("',");
        sql.append(atendimento.getId_sistema()).append(" )");

        super.atualizarSQL(sql.toString());
    }
}
