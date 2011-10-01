package atividadeprototype;

public class Cliente {
    
    
    public Cliente() {
	luxo = new GolLuxo();
	popular = new GolPopular();
    }
    
    
    private Gol luxo;
    private Gol popular;
    private static String tipoLuxo = "MODELO_DE_LUXO";
    private static String tipoPopular = "MODELO_POPULAR";
    
    public Gol comprarCarro(String tipo) {
	if(tipo.equals(tipoLuxo)) {
	    return (Gol) luxo.clone();
	} else if (tipo.equals(tipoPopular)) {
	    return (Gol) popular.clone();
	}
	return null;
    }
    
}
