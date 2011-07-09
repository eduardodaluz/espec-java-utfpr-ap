package br.edu.utfpr.ap.localiza;

import java.util.ArrayList;

public class Grupo {

    private String descricao;
    private String simbologia;
    private ArrayList<Tarifa> tarifas;

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
	public ArrayList<Tarifa> getTarifas() {
		return tarifas;
	}
	public void addTarifa(Tarifa tarifa) {
		tarifas.add(tarifa);
	}
	public void delTarifa(Tarifa tarifa) {
		tarifas.remove(tarifa);
	}

	@Override
    public String toString() {
        return "GRUPO: " + this.getDescricao() + "SIMBOLOGIA: " + this.getSimbologia();
    }    
}
