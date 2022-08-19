package Models;

import java.util.Date;

public class Aluguel {
    private Integer id;
    private Date dataInicio;
    private Date dataFim;
    private Integer seguro;
    private Integer chaveExtra;
    private Integer controleClimatico;
    private Integer clientId;
    private Integer armazenamentoId;

    public Aluguel() {
    }

    public Aluguel(Integer id, Date dataInicio, Date dataFim, Integer seguro, Integer chaveExtra, Integer controleClimatico, Integer clientId, Integer armazenamentoId) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguro = seguro;
        this.chaveExtra = chaveExtra;
        this.controleClimatico = controleClimatico;
        this.clientId = clientId;
        this.armazenamentoId = armazenamentoId;
    }

    public Aluguel(Date dataInicio, Date dataFim, Integer seguro, Integer chaveExtra, Integer controleClimatico, Integer clientId, Integer armazenamentoId) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguro = seguro;
        this.chaveExtra = chaveExtra;
        this.controleClimatico = controleClimatico;
        this.clientId = clientId;
        this.armazenamentoId = armazenamentoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Integer getSeguro() {
        return seguro;
    }

    public void setSeguro(Integer seguro) {
        this.seguro = seguro;
    }

    public Integer getChaveExtra() {
        return chaveExtra;
    }

    public void setChaveExtra(Integer chaveExtra) {
        this.chaveExtra = chaveExtra;
    }

    public Integer getControleClimatico() {
        return controleClimatico;
    }

    public void setControleClimatico(Integer controleClimatico) {
        this.controleClimatico = controleClimatico;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getArmazenamentoId() {
        return armazenamentoId;
    }

    public void setArmazenamentoId(Integer armazenamentoId) {
        this.armazenamentoId = armazenamentoId;
    }
}
