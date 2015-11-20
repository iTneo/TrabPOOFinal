package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


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
}