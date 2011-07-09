package br.edu.utfpr.ap.localiza;

public enum DiaSemana {
	DOMINGO,
	SEGUNDA,
	TERCA,
	QUARTA,
	QUINTA,
	SEXTA,
	SABADO,
	FERIADO;
	
	public int getDiaSemana(DiaSemana dia){
		switch (dia) {
			case DOMINGO:
				return 1;
			case SEGUNDA:
				return 2;
			case TERCA:
				return 3;
			case QUARTA:
				return 4;
			case QUINTA:
				return 5;
			case SEXTA:
				return 6;
			case SABADO:
				return 7;
			case FERIADO:
				return 8;
		default:
			return 0;
		}		
	}
}