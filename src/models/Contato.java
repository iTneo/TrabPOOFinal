package models;

public class Contato {
	private String nome;
	private String telefone;
	private String email;
	private int codigo;
	
	public Contato(String nome, String telefone, String email){
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getNome() {
		return this.nome;
	}
}