package br.edu.utfpr.ap.localiza;

import java.util.Date;

public class Tester {
	
	public static void main(String[] args) {
		ControlReserva ctrReserva = new ControlReserva();
		ControlGaragem ctrlGaragem = new ControlGaragem();
		initializeLocaliza(ctrReserva, ctrlGaragem);
		
		Cliente reservasEduardo = new Cliente("eduardo", "123", "456", null, null);
		System.out.println("Reservas por Clientes:");
		for(Reserva reserva : ctrReserva.consultaReservasPorCliente(reservasEduardo)) {
			System.out.println(reserva.toString());
		}
		System.out.println("Consuta cliente por nome:");
		for(Cliente cliente : ctrReserva.consultaClientesPorNome("amilcar")) {
			System.out.println(cliente.toString());
		}
		System.out.println("Consulta veículo por placa:");
		for(Veiculo veiculo : ctrlGaragem.consultaVeiculoPorPlaca("ASD-1234")) {
			System.out.println(veiculo.toString());
		}
		System.out.println("Consulta veículo por Grupo:");
		for(Veiculo veiculo : ctrlGaragem.consultaVeiculoPorGrupo(new Grupo("RELIQUIA", null))) {
			System.out.println(veiculo.toString());
		}
	}
	
	public static void initializeLocaliza(ControlReserva ctrReserva, ControlGaragem ctrGaragem) {
		
		Cliente eduardo = ctrReserva.addCliente("eduardo", "123", "456", "eduardo.r.luz@gmail.com", "000");
		Cliente amilcar = ctrReserva.addCliente("amilcar", "321", "654", "halls@thebadcompany.com.br", "000");
		
		Agencia apucarana = new Agencia("Localiza Apuka", "Rua Dr. Oswaldo Goiaba", "(43)3033-1234",
				new Cidade("Apucarana", "PR"), new Horario("08:00", "18:00", DiaSemana.SEGUNDA, DiaSemana.SABADO));
		Agencia londrina = new Agencia("Localiza Londres", "Rua Londres Meldels", "(43)3034-0001",
				new Cidade("Londrina", "PR"), new Horario("07:00", "22:00", DiaSemana.SEGUNDA, DiaSemana.DOMINGO));
		
		Grupo economico = ctrGaragem.addGrupo("Economico", "E");
		Grupo luxo = ctrGaragem.addGrupo("LUXO", "L");
		Grupo reliquia = ctrGaragem.addGrupo("RELIQUIA", "R");
		
		Veiculo gol = ctrGaragem.addVeiculo("GOL", 1995, "ASD-1234", Combustivel.Etanol, "A", economico);
		Veiculo vectra = ctrGaragem.addVeiculo("VECTRA", 2001, "ADQ-1977", Combustivel.Flex, "A", luxo);
		ctrGaragem.addVeiculo("FUSCA", 1969, "FHR-4395", Combustivel.Gasolina, "I", reliquia);
		
		ctrReserva.addReserva(new Date(), new Date(), false, apucarana, apucarana, eduardo, gol);
		ctrReserva.addReserva(new Date(), new Date(), true, apucarana, londrina, amilcar, vectra);		
	}
	
}
