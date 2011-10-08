package exerciciospring;

import java.util.List;

public class Carro {
    
    private List<Opcionais> opcionais;
    private Motor motor;

    public Carro(List<Opcionais> opcionais, Motor motor) {
	this.opcionais = opcionais;
	this.motor = motor;
    }
    
    public Carro() {
    }

    public Motor getMotor() {
	return motor;
    }

    public void setMotor(Motor motor) {
	this.motor = motor;
    }

    public List<Opcionais> getOpcionais() {
	return opcionais;
    }

    public void setOpcionais(List<Opcionais> opcionais) {
	this.opcionais = opcionais;
    }
    
    public void imprimirCarro() {
	motor.acelerar();
	for(Opcionais op : opcionais) {
	    System.out.println(op);
	}
    }
    
}
