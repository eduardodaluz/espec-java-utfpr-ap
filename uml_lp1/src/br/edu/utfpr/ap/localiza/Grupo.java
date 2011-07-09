package br.edu.utfpr.ap.localiza;

import java.util.ArrayList;
import java.util.List;

public class Grupo {

    private String descricao;
    private String simbologia;
    private List<Tarifa> tarifas;

    public Grupo(String descricao, String simbologia) {
        this.descricao = descricao;
        this.simbologia = simbologia;
        this.tarifas = new ArrayList<Tarifa>();
    }
    
    public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSimbologia() {
		return simbologia;
	}
	public void setSimbologia(String simbologia) {
		this.simbologia = simbologia;
	}
	public List<Tarifa> getTarifas() {
		return tarifas;
	}
	public void addTarifa(Tarifa tarifa) {
		tarifas.add(tarifa);
	}
	public void delTarifa(Tarifa tarifa) {
		tarifas.remove(tarifa);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null) {
			if (obj instanceof Grupo) {
				Grupo gp = (Grupo) obj;
				if (getDescricao().equals(gp.getDescricao())) {
					return true;
				}
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
    public String toString() {
        return "GRUPO: " + this.getDescricao() + "SIMBOLOGIA: " + this.getSimbologia();
    }    
}
