package Modelo;

/**
 *
 * @author Maru
 */
public class ModeloCliente {

    public int id_cliente;
    public String nome;
    public int id_cidade;
    public String telefone;
    public String celular;
    public String email;
    public int cod_sci;
    public String usuario_sci;
    public String senha_sci;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCod_sci() {
        return cod_sci;
    }

    public void setCod_sci(int cod_sci) {
        this.cod_sci = cod_sci;
    }

    public String getUsuario_sci() {
        return usuario_sci;
    }

    public void setUsuario_sci(String usuario_sci) {
        this.usuario_sci = usuario_sci;
    }

    public String getSenha_sci() {
        return senha_sci;
    }

    public void setSenha_sci(String senha_sci) {
        this.senha_sci = senha_sci;
    }
}
