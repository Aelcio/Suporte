package Modelo;

/**
 *
 * @author Maru
 */
public class ModeloPJ {

    private int id_pj;
    private String cnpj;
    private String razao_social;
    private int id_pessoa;

    public int getId_pj() {
        return id_pj;
    }

    public void setId_pj(int id_pj) {
        this.id_pj = id_pj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }
}
