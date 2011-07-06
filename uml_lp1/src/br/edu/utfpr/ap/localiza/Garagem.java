package br.edu.utfpr.ap.localiza;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Garagem {
	
	private List<Reserva> reservas;
	private List<Cliente> clientes;
	
	public Garagem() {
		reservas = new LinkedList<Reserva>();
		clientes = new LinkedList<Cliente>();
	}
	
	public Cliente addCliente(String nome, String cpf, String passaporte, String email, String telefone) {
		Cliente cliente = new Cliente(nome, cpf, passaporte, email, telefone);
		clientes.add(cliente);
		return cliente;
	}
	
	public Reserva addReserva(Date dataRetirada, boolean gps, Agencia agenciaRetirada, Cliente cliente) {
		Reserva reserva = new Reserva(dataRetirada, gps, agenciaRetirada, cliente);
		reservas.add(reserva);
		return reserva;
	}
	
	public void devolverReserva(Reserva reserva, Date dataDevolucao, Agencia agenciaDevolucao) {
		reserva.setDataDevolucao(dataDevolucao);
		reserva.setAgenciaDevolucao(agenciaDevolucao);
	}
	
	public List<Reserva> consultaReservasPorCliente(Cliente cliente) {
		List<Reserva> reservaEquals = new LinkedList<Reserva>();
		for (Reserva reserva : reservas) {
			if(reserva.getCliente().equals(cliente)) {
				reservaEquals.add(reserva);
			}
		}
		return reservaEquals;
	}
	
	public List<Reserva> consultaReservasPorAgencia(Agencia agencia) {
		List<Reserva> reservaEquals = new LinkedList<Reserva>();
		for (Reserva reserva : reservas) {
			if(reserva.getAngenciaRetirada().equals(agencia)) {
				reservaEquals.add(reserva);
			}
		}
		return reservaEquals;
	}
	
	public List<Cliente> consultaClientesPorNome(String nome) {
		List<Cliente> clienteEquals = new LinkedList<Cliente>();
		for (Cliente cliente : clientes) {
			if(cliente.getNome().equals(nome)) {
				clienteEquals.add(cliente);
			}
		}
		return clienteEquals;
	}

}
