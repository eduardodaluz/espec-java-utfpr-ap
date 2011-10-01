package atividadeprototype;

public class GolLuxo implements Gol, Cloneable {
    
    public GolLuxo() {
	modelo = "Gol com Motor AP de 250HP e Pneus 13/185";
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
