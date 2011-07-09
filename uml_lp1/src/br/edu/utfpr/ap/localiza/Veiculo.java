package br.edu.utfpr.ap.localiza;

public class Veiculo {

    private String modelo;
    private int ano;
    private String placa;
    private Combustivel combustivel;
    private String status; //A = Ativo, I = Inativo
    private Grupo grupo;

    public Veiculo(String modelo, int ano, String placa, Combustivel combustivel, String status, Grupo grupo) {
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.combustivel = combustivel;
        this.status = status;
        this.grupo = grupo;
    }

    public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Veiculo other = (Veiculo) obj;
        if ((this.modelo == null) ? (other.modelo != null) : !this.modelo.equals(other.modelo)) {
            return false;
        }
        if (this.ano != other.ano) {
            return false;
        }
        if ((this.placa == null) ? (other.placa != null) : !this.placa.equals(other.placa)) {
            return false;
        }
        if (this.combustivel != other.combustivel) {
            return false;
        }
        if ((this.status == null) ? (other.status != null) : !this.status.equals(other.status)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (this.status == "A") {
            status = "Ativo";
        } else {
            status = "Inativo";
        }
        return "Veiculo modelo " + modelo + ", ano " + ano + ", placa " + placa + ", movido a " + combustivel.name() + " e se encontra " + status + '\n';
    }
}
