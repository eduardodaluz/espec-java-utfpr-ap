package br.edu.utfpr.ap.localiza;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String passaporte;
	private String email;
	private String telefone;
	
	public Cliente(String nome, String cpf, String passaporte, String email, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.passaporte = passaporte;
		this.email = email;
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPassaporte() {
		return passaporte;
	}
	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", passaporte="
				+ passaporte + ", email=" + email + ", telefone=" + telefone
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if (obj instanceof Cliente) {
			Cliente cliEquals = (Cliente) obj;
			if (!cliEquals.getNome().equals(getNome())) {
				return false;
			} else if (!cliEquals.getCpf().equals(getCpf())) {
				return false;
			} else if (!cliEquals.getPassaporte().equals(getPassaporte())) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

}
