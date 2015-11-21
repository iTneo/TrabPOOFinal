package DAO;

import models.Contato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

	private Connection conecta() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Falha ao fazer conexão com banco de dados!");
			e.printStackTrace();
		}
		return DriverManager.getConnection("jdbc:mysql://localhost/agenda",
				"root", "");
	}

	public Boolean insere(Contato contato) {
		try(Connection conexao = conecta()){		
			Statement comando = conexao.createStatement();
			comando.executeUpdate(
					"insert into contatos(Nome,Telefone,Mail)values('"+ contato.getNome()+ "','"+ contato.getTelefone()	+ "','"+ contato.getEmail() + "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha ao adicionar");;
			return false;
		}
	}

	public Contato busca(int codigo) {
		try (Connection conexao = conecta()) {
			Statement comando = conexao.createStatement();
			ResultSet rs = comando
					.executeQuery("select Nome,Telefone,Mail from contatos where idCod = "
							+ codigo);
			if (rs.next()) {
				String nome = rs.getString("Nome");
				String telefone = rs.getString("Telefone");
				String mail = rs.getString("Mail");
				return new Contato(nome, telefone, mail);
			} else {
				return null;
			}
		} catch (SQLException ex) {
			System.out.println(ex.toString());
			return null;
		}
	}
	public List<Contato> buscaTodos(){
		try (Connection conexao = conecta()) {
			Statement comando = conexao.createStatement();
			ResultSet rs = comando
					.executeQuery("select Nome,Telefone,Mail from contatos");
			List<Contato> contatos = new ArrayList<>();
			while(rs.next()) {
				String nome = rs.getString("Nome");
				String telefone = rs.getString("Telefone");
				String mail = rs.getString("Mail");
				contatos.add(new Contato(nome, telefone, mail));
			} 
			return contatos;
		} catch (SQLException ex) {
			System.out.println(ex.toString());
			return null;
		}	
	}
}
