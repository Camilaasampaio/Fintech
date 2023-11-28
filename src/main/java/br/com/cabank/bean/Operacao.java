package br.com.cabank.bean;

import java.util.Calendar;

public class Operacao {

	private Calendar dataOperacao;
    private double valor;
    private String descricao;

    public Operacao(Calendar dataOperacao, double valor, String descricao) {
        this.dataOperacao = dataOperacao;
        this.valor = valor;
        this.descricao = descricao;
    }

    public void registrarValor(Calendar dataOperacao, double valor, String descricao) {
        this.dataOperacao = dataOperacao;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Calendar getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(Calendar dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}