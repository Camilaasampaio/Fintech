package br.com.cabank.bean;

import java.util.Calendar;

public class Transferencia extends Operacao {

	private int codigoTransferencia;
	private String nomeTransferencia;
	private Calendar dataTransferencia;
	private double valorTransferencia;
	private String tipoTransferencia;
	private int codigoConta;
	private int codigoImagem;

	public Transferencia(
			String nomeTransferencia,
			Calendar dataTransferencia,
			double valorTransferencia) {
		super(dataTransferencia, valorTransferencia, nomeTransferencia);
		this.dataTransferencia = dataTransferencia;
		this.valorTransferencia = valorTransferencia;
		this.nomeTransferencia = nomeTransferencia;
	}

	public Transferencia(int codigoTransferencia,
			String nomeTransferencia,
			Calendar dataTransferencia,
			double valorTransferencia,
			String tipoTransferencia,
			int codigoConta,
			int codigoImagem) {
		super(dataTransferencia, valorTransferencia, nomeTransferencia);
		this.codigoTransferencia = codigoTransferencia;
		this.nomeTransferencia = nomeTransferencia;
		this.dataTransferencia = dataTransferencia;
		this.valorTransferencia = valorTransferencia;
		this.tipoTransferencia = tipoTransferencia;
		this.codigoConta = codigoConta;
		this.codigoImagem = codigoImagem;
	}

	public String getNomeTransferencia() {
		return nomeTransferencia;
	}

	public void setNomeTransferencia(String nomeTransferencia) {
		this.nomeTransferencia = nomeTransferencia;
	}

	public Calendar getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(Calendar dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public double getValorTransferencia() {
		return valorTransferencia;
	}

	public void setValorTransferencia(double valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}

	public String getTipoTransferencia() {
		return tipoTransferencia;
	}

	public void setTipoTransferencia(String tipoTransferencia) {
		this.tipoTransferencia = tipoTransferencia;
	}

	public int getCodigoConta() {
		return codigoConta;
	}

	public void setCodigoConta(int codigoConta) {
		this.codigoConta = codigoConta;
	}

	public int getCodigoImagem() {
		return codigoImagem;
	}

	public void setCodigoImagem(int codigoImagem) {
		this.codigoImagem = codigoImagem;
	}

	public int getCodigoTransferencia() {
		return codigoTransferencia;
	}

	public void setCodigoTransferencia(int codigoTransferencia) {
		this.codigoTransferencia = codigoTransferencia;
	}
}