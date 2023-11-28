package br.com.cabank.bean;

import java.util.Calendar;

public class Investimento {

    private int codigoInvestimento;
    private String nomeInvestimento;
    private Calendar dataInvestimento;
    private double valorInvestimento;
    private int codigoConta;

    public int getCodigoInvestimento() {
        return codigoInvestimento;
    }

    public void setCodigoInvestimento(int codigoInvestimento) {
        this.codigoInvestimento = codigoInvestimento;
    }

    public String getNomeInvestimento() {
        return nomeInvestimento;
    }

    public void setNomeInvestimento(String nomeInvestimento) {
        this.nomeInvestimento = nomeInvestimento;
    }

    public Calendar getDataInvestimento() {
        return dataInvestimento;
    }

    public void setDataInvestimento(Calendar dataInvestimento) {
        this.dataInvestimento = dataInvestimento;
    }

    public double getValorInvestimento() {
        return valorInvestimento;
    }

    public void setValorInvestimento(double valorInvestimento) {
        this.valorInvestimento = valorInvestimento;
    }

    public int getCodigoConta() {
        return codigoConta;
    }

    public void setCodigoConta(int codigoConta) {
        this.codigoConta = codigoConta;
    }
}
