package br.edu.utfpr.ap.localiza;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ControlReserva {
	
	private List<Reserva> reservas;
	private List<Cliente> clientes;
	private List<Agencia> agencias;
	
	public ControlReserva() {
		reservas = new LinkedList<Reserva>();
		clientes = new LinkedList<Cliente>();
		agencias = new LinkedList<Agencia>();
	}
	
	public Cliente addCliente(String nome, String cpf, String passaporte, String email, String telefone) {
		Cliente cliente = new Cliente(nome, cpf, passaporte, email, telefone);
		clientes.add(cliente);
		return cliente;
	}
	
	public Reserva addReserva(Date dataRetirada, Date dataDevolucao, boolean gps, Agencia agenciaRetirada,
			Agencia agenciaDevolucao, Cliente cliente, Veiculo veiculo) {
		Reserva reserva = new Reserva(dataRetirada, dataDevolucao, gps, agenciaRetirada, agenciaDevolucao, cliente, veiculo);
		reservas.add(reserva);
		return reserva;
	}
	
	public Agencia addAgencia(String nome, String endereco, String telefone, Cidade cidade, Horario horario) {
		Agencia agencia = new Agencia(nome, endereco, telefone, cidade, horario);
		agencias.add(agencia);
		return agencia;
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
			if(reserva.getAgenciaRetirada().equals(agencia)) {
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
