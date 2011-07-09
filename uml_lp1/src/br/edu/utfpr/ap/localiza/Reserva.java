package br.edu.utfpr.ap.localiza;

import java.util.Date;

public class Reserva {
	
	private Date dataRetirada;
	private Date dataDevolucao;
	private boolean gps;
	private Agencia agenciaRetirada;
	private Agencia agenciaDevolucao;
	private Cliente cliente;
	private Veiculo veiculo;
	
	public Agencia getAgenciaRetirada() {
		return agenciaRetirada;
	}

	public void setAgenciaRetirada(Agencia agenciaRetirada) {
		this.agenciaRetirada = agenciaRetirada;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public Reserva(Date dataRetirada, Date dataDevolucao, boolean gps, Agencia agenciaRetirada,
			Agencia agenciaDevolucao, Cliente cliente, Veiculo veiculo) {
		this.dataRetirada = dataRetirada;
		this.dataDevolucao = dataDevolucao;
		this.gps = gps;
		this.agenciaRetirada = agenciaRetirada;
		this.agenciaDevolucao = agenciaDevolucao;
		this.cliente = cliente;
		this.veiculo = veiculo;
	}

	public Date getDataRetirada() {
		return dataRetirada;
	}
	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public boolean isGps() {
		return gps;
	}
	public void setGps(boolean gps) {
		this.gps = gps;
	}
	public Agencia getAgenciaDevolucao() {
		return agenciaDevolucao;
	}
	public void setAgenciaDevolucao(Agencia agenciaDevolucao) {
		this.agenciaDevolucao = agenciaDevolucao;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Reserva [dataRetirada=" + dataRetirada +
				(dataDevolucao != null ? ",\n dataDevolucao=" + dataDevolucao : "" ) +
				",\n gps=" + gps +
				",\n agenciaRetirada=" + agenciaRetirada.toString() +
				(agenciaDevolucao != null ? ",\n agenciaDevolucao=" + agenciaDevolucao.toString() : "" ) +
				",\n cliente=" + cliente.toString() + "]";
	}

}
