package Modelo;

import java.sql.Date;

/**
 *
 * @author Maru
 */
public class ModeloAtendimento {

    private int id_atendimento;
    private int id_pessoa;
    private String data_suporte;
    private String sistema;
    private String versao;
    private String funcionario;
    private String problema;
    private String solucao;

    public int getId_atendimento() {
        return id_atendimento;
    }

    public void setId_atendimento(int id_atendimento) {
        this.id_atendimento = id_atendimento;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getData_suporte() {
        return data_suporte;
    }

    public void setData_suporte(String data_suporte) {
        this.data_suporte = data_suporte;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

}
