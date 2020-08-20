package Controle;

import Dao.ConexaoPostgres;
import Modelo.ModeloCidade;
import Modelo.ModeloPF;
import Modelo.ModeloPJ;
import Modelo.ModeloPessoa;
import java.sql.ResultSet;
import java.sql.SQLException;

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
                + "cl.senha_sci, "
                + "cl.serial_sgbr "
                + "FROM "
                + "pessoa as cl "
                + "JOIN cidade as cd "
                + "ON cd.id_cidade = cl.id_cidade "
                + "JOIN uf ON uf.id_uf = cd.id_uf "
                + "LEFT JOIN pessoa_fisica as pf "
                + "ON pf.id_pessoa = cl.id_pessoa "
                + "LEFT JOIN pessoa_juridica as pj "
                + "ON pj.id_pessoa = cl.id_pessoa "
                + "ORDER BY cl.id_pessoa ASC");
        return super.resultset;
    }

    public ResultSet ConsultaCliente(ModeloPessoa pessoa) {
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
                + "cl.senha_sci, "
                + "cl.serial_sgbr "
                + "FROM "
                + "pessoa as cl "
                + "JOIN cidade as cd "
                + "ON cd.id_cidade = cl.id_cidade "
                + "JOIN uf ON uf.id_uf = cd.id_uf "
                + "LEFT JOIN pessoa_fisica as pf "
                + "ON pf.id_pessoa = cl.id_pessoa "
                + "LEFT JOIN pessoa_juridica as pj "
                + "ON pj.id_pessoa = cl.id_pessoa "
                + "WHERE cl.nome ILIKE '%" + pessoa.getNome()
                + "%'");
        return super.resultset;
    }

    public ResultSet consultacliente2(ModeloPessoa pessoa) {
        super.executeSQL("SELECT id_pessoa, nome "
                + "FROM pessoa "
                + "WHERE "
                + "nome ILIKE '%" + pessoa.getNome()
                + "%'");
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
        sql.append("CEP,");
        sql.append("serial_sgbr");
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
        sql.append(pessoa.getCep()).append("','");
        sql.append(pessoa.getSerial_sgbr()).append("')");
        super.atualizarSQL(sql.toString());
    }

    public void alterar(ModeloPessoa pessoa) {
        sql.delete(0, sql.length());
        sql.append("UPDATE pessoa SET ");
        sql.append("nome = '").append(pessoa.getNome()).append("',");
        sql.append("id_cidade = ").append(pessoa.getId_cidade()).append(",");
        sql.append("telefone = '").append(pessoa.getTelefone()).append("',");
        sql.append("celular = '").append(pessoa.getCelular()).append("',");
        sql.append("email = '").append(pessoa.getEmail()).append("',");
        sql.append("cod_sci = ").append(pessoa.getCod_sci()).append(",");
        sql.append("usuario_sci = '").append(pessoa.getUsuario_sci()).append("',");
        sql.append("senha_sci = '").append(pessoa.getSenha_sci()).append("',");
        sql.append("endereco = '").append(pessoa.getEndereco()).append("',");
        sql.append("numero = '").append(pessoa.getNumero()).append("',");
        sql.append("bairro = '").append(pessoa.getBairro()).append("',");
        sql.append("cep = '").append(pessoa.getCep()).append("','");
        sql.append("serial_sgbr = '").append(pessoa.getSerial_sgbr()).append("'");
        sql.append("WHERE ");
        sql.append("id_pessoa = ").append(pessoa.getId_pessoa());
        super.atualizarSQL(sql.toString());
    }

    public void retornadados(ModeloPessoa pessoa, ModeloCidade cidade, ModeloPF pf, ModeloPJ pj) {
        super.executeSQL("SELECT * FROM pessoa as p "
                + "JOIN Cidade as cd "
                + "ON cd.id_cidade = p.id_cidade "
                + "LEFT JOIN pessoa_fisica as pf "
                + "ON pf.id_pessoa = p.id_pessoa  "
                + "LEFT JOIN pessoa_juridica as pj "
                + "ON pj.id_pessoa = p.id_pessoa WHERE "
                + "p.id_pessoa = " + pessoa.getId_pessoa());
        try {
            super.resultset.first();
            pessoa.setId_pessoa(resultset.getInt("id_pessoa"));
            pessoa.setNome(resultset.getString("nome"));
            pf.setId_pf(resultset.getInt("id_pf"));
            pf.setCpf(resultset.getString("cpf"));
            pj.setId_pj(resultset.getInt("id_pj"));
            pj.setCnpj(resultset.getString("cnpj"));
            pessoa.setEndereco(resultset.getString("endereco"));
            pessoa.setNumero(resultset.getString("numero"));
            pessoa.setCep(resultset.getString("cep"));
            pessoa.setBairro(resultset.getString("bairro"));
            pessoa.setTelefone(resultset.getString("telefone"));
            pessoa.setCelular(resultset.getString("celular"));
            pessoa.setEmail(resultset.getString("email"));
            pessoa.setCod_sci((resultset.getInt("cod_sci")));
            pessoa.setUsuario_sci(resultset.getString("usuario_sci"));
            pessoa.setSenha_sci(resultset.getString("senha_sci"));
            pessoa.setSerial_sgbr(resultset.getString("serial_sgbr"));
            pessoa.setId_cidade(resultset.getInt("id_cidade"));
            cidade.setDs_cidade(resultset.getString("ds_cidade"));
            cidade.setId_uf(resultset.getString("id_uf"));

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
