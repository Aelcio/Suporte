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
                + "cl.id_pessoa, "
                + "cl.nome, "
                + "pf.cpf, "
                + "pj.cnpj, "
                + "pj.razao_social,"
                + "cl.endereco, "
                + "cl.numero, "
                + "cl.cep, "
                + "cl.bairro, "
                + "cd.ds_cidade, "
                + "uf.id_uf, "
                + "cl.telefone, "
                + "cl.celular, "
                + "cl.email, "
                + "cl.cod_sci, "
                + "cl.usuario_sci, "
                + "cl.senha_sci "
                + "FROM " 
                + "pessoa as cl "
                + "JOIN cidade as cd "
                + "ON cd.id_cidade = cl.id_cidade "
                + "JOIN uf ON uf.id_uf = cd.id_uf "
                + "LEFT JOIN pessoa_fisica as pf "
                + "ON pf.id_pessoa = cl.id_pessoa "
                + "LEFT JOIN pessoa_juridica as pj "
                + "ON pj.id_pessoa = cl.id_pessoa");
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
        sql.append("senha_sci,");
        sql.append("endereco,");
        sql.append("numero,");
        sql.append("bairro,");
        sql.append("CEP");
        sql.append(")VALUES(");
        sql.append(pessoa.getId_pessoa()).append(",'");
        sql.append(pessoa.getNome()).append("',");
        sql.append(pessoa.getId_cidade()).append(",'");
        sql.append(pessoa.getTelefone()).append("','");
        sql.append(pessoa.getCelular()).append("','");
        sql.append(pessoa.getEmail()).append("',");
        sql.append(pessoa.getCod_sci()).append(",'");
        sql.append(pessoa.getUsuario_sci()).append("','");
        sql.append(pessoa.getSenha_sci()).append("','");
        sql.append(pessoa.getEndereco()).append("','");
        sql.append(pessoa.getNumero()).append("','");
        sql.append(pessoa.getBairro()).append("','");
        sql.append(pessoa.getCep()).append("')");
        super.atualizarSQL(sql.toString());
    }
}
