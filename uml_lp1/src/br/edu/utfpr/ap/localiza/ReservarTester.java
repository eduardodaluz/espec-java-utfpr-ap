package br.edu.utfpr.ap.localiza;

import java.util.Date;

public class ReservarTester {
	
	public static void main(String[] args) {
		Garagem garagem = new Garagem();
		initializeGaragem(garagem);
		
		Cliente reservasEduardo = new Cliente("eduardo", "123", "456", null, null);
		for(Reserva reserva : garagem.consultaReservasPorCliente(reservasEduardo)) {
			System.out.println(reserva.toString());
		}
	}
	
	public static void initializeGaragem(Garagem garagem) {
		Cliente eduardo = garagem.addCliente("eduardo", "123", "456", "eduardo.r.luz@gmail.com", "000");
		Cliente amilcar = garagem.addCliente("amilcar", "321", "654", "halls@thebadcompany.com.br", "000");
		garagem.addReserva(new Date(), false, new Agencia(), eduardo);
		garagem.addReserva(new Date(), true, new Agencia(), amilcar);
		garagem.addReserva(new Date(), false, new Agencia(), amilcar);
		garagem.addReserva(new Date(), true, new Agencia(), eduardo);		
	}
	
}
