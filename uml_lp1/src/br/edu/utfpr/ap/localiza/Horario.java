package br.edu.utfpr.ap.localiza;

public class Horario {

    private String horaEntrada;
    private String horaSaida;
    private DiaSemana diaInicia;
    private DiaSemana diaFinal;

    public Horario(String entrada, String saida, DiaSemana diaInicio, DiaSemana diaFinal) {
        this.horaEntrada = entrada;
        this.horaSaida = saida;
        this.diaInicia = diaInicio;
        this.diaFinal = diaFinal;
    }

    public DiaSemana getDiaInicia() {
		return diaInicia;
	}

	public void setDiaInicia(DiaSemana diaInicia) {
		this.diaInicia = diaInicia;
	}

	public DiaSemana getDiaFinal() {
		return diaFinal;
	}

	public void setDiaFinal(DiaSemana diaFinal) {
		this.diaFinal = diaFinal;
	}

	public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    @Override
    public String toString() {
        return "DE " + this.diaInicia + " Á " + this.diaFinal + " DAS " + this.horaEntrada + " ÁS " + this.horaSaida + "\n";
    }
}
