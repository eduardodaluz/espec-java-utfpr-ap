package br.edu.utfpr.ap.localiza;

import java.util.ArrayList;

public class Agencia {

    private String nome;
    private String endereco;
    private String telefone;
    private ArrayList<Veiculo> veiculos;
    private Cidade cidade;
    private Horario horario;

    public Agencia(String nome, String endereco, String telefone, Cidade cidade, Horario horario) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cidade = cidade;
        this.horario = horario;
        veiculos = new ArrayList<Veiculo>();
    }

    public void addVeiculo(Veiculo veiculo) {
    	veiculos.add(veiculo);
    }
    public void delVeiculo(Veiculo veiculo) {
    	veiculos.remove(veiculo);
    }

    public void horarioAtendimento() {
        System.out.println("HORARIO DE ATENDIMENTO");
        System.out.println(horario.toString());
        System.out.println();
    }

    public void localizacao() {
        System.out.println("AGENCIA: " + this.getNome() + " ENDEREÇO: " + this.getEndereco() + " TELEFONE: " + this.telefone);
        System.out.println(this.cidade.toString());
        System.out.println();
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	public Horario getHorario() {
		return horario;
	}
	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	@Override
    public String toString() {
        return "AGENCIA: " + this.getNome() + " TELEFONE: " + this.getTelefone() + " ENDERE�O: " + this.getEndereco();
    }
}
