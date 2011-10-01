package atividadeprototype;

public class GolPopular implements Gol, Cloneable {
    
    public GolPopular() {
	modelo = "Gol com Motor AP de 180HP e Pneus 13/185";
    }
    
    private String modelo;
    
    @Override
    public String getModelo() {
	return modelo;
    }
    
    @Override
    public Object clone() {
	try {
	    return super.clone();
	} catch (CloneNotSupportedException e) {
	    return null;
	}
    }
    
}
