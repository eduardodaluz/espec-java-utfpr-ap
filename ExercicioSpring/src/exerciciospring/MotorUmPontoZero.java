package exerciciospring;

public class MotorUmPontoZero implements Motor {
    
    @Override
    public void ligar() {
	
    }
    
    @Override
    public void acelerar() {
	System.out.println("VRUM! Gastei 1 litro de combustível.");
    }
    
}
