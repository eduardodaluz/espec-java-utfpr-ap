package br.edu.utfpr.ap.localiza;

import java.util.LinkedList;
import java.util.List;

public class ControlGaragem {
	
	private List<Veiculo> veiculos;
	private List<Grupo> grupos;
	
	public ControlGaragem() {
		veiculos = new LinkedList<Veiculo>();
		grupos = new LinkedList<Grupo>();
	}
	
	public Grupo addGrupo(String descricao, String simbologia) {
		Grupo grupo = new Grupo(descricao, simbologia);
		grupos.add(grupo);
		return grupo;
	}
	
	public Veiculo addVeiculo(String modelo, int ano, String placa, Combustivel combustivel, String status, Grupo grupo) {
		Veiculo veiculo = new Veiculo(modelo, ano, placa, combustivel, status, grupo);
		veiculos.add(veiculo);
		return veiculo;
	}
	
	public List<Veiculo> consultaVeiculoPorPlaca(String placa) {
		List<Veiculo> veiculoEqual = new LinkedList<Veiculo>();
		for(Veiculo veiculo : veiculos) {
			if(veiculo.getPlaca().equals(placa)) {
				veiculoEqual.add(veiculo);
			}
		}
		return veiculoEqual;
	}
	
	public List<Veiculo> consultaVeiculoPorGrupo(Grupo grupo) {
		List<Veiculo> veiculoEqual = new LinkedList<Veiculo>();
		for(Veiculo veiculo : veiculos) {
			if(veiculo.getGrupo().equals(grupo)) {
				veiculoEqual.add(veiculo);
			}
		}
		return veiculoEqual;
	}

}
