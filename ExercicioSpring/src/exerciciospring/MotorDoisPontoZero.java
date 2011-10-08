package exerciciospring;

public class MotorDoisPontoZero implements Motor {
    
    @Override
    public void ligar() {
	
    }
    
    @Override
    public void acelerar() {
	System.out.println("VRRRRRRRRRRRRRUM! Gastei 10 litros de combustível.");
    }
    
}
