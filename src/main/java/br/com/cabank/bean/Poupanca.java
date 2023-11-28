package br.com.cabank.bean;

import java.util.Calendar;

public class Poupanca {

    private int codigoPoupanca;
    private double valorPoupanca;
    private Calendar dataAbertura;
    private int codigoConta;

    public int getCodigoPoupanca() {
        return codigoPoupanca;
    }

    public void setCodigoPoupanca(int codigoPoupanca) {
        this.codigoPoupanca = codigoPoupanca;
    }

    public double getValorPoupanca() {
        return valorPoupanca;
    }

    public void setValorPoupanca(double valorPoupanca) {
        this.valorPoupanca = valorPoupanca;
    }

    public Calendar getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public int getCodigoConta() {
        return codigoConta;
    }

    public void setCodigoConta(int codigoConta) {
        this.codigoConta = codigoConta;
    }
}