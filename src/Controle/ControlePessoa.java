package Controle;

import Dao.ConexaoPostgres;
import Modelo.ModeloPessoa;
import java.sql.ResultSet;

/**
 *
 * @author Maru
 */
public class ControlePessoa extends ConexaoPostgres {

    StringBuilder sql = new StringBuilder();

    public ResultSet consultageral() {
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

    public void incluir(ModeloPessoa pessoa) {
        pessoa.setId_pessoa(super.ultimasequencia("pessoa", "id_pessoa"));
        sql.delete(0, sql.length());
        sql.append("INSERT INTO PESSOA (");
        sql.append("id_pessoa,");
        sql.append("nome,");
        sql.append("id_cidade,");
        sql.append("telefone,");
        sql.append("celular,");
        sql.append("email,");
        sql.append("cod_sci,");
        sql.append("usuario_sci,");
        sql.append("senha_sci");
        sql.append(")VALUES(");
        sql.append(pessoa.getId_pessoa()).append(",'");
        sql.append(pessoa.getNome()).append("',");
        sql.append(pessoa.getId_cidade()).append(",'");
        sql.append(pessoa.getTelefone()).append("','");
        sql.append(pessoa.getCelular()).append("','");
        sql.append(pessoa.getEmail()).append("',");
        sql.append(pessoa.getCod_sci()).append(",'");
        sql.append(pessoa.getUsuario_sci()).append("','");
        sql.append(pessoa.getSenha_sci()).append("')");
        super.atualizarSQL(sql.toString());
        
        

    }
}
