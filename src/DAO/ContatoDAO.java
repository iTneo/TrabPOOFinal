package DAO;

import models.Contato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContatoDAO {
	
	private Connection conecta() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost/agenda","root" ,"root");
	}
	
	
	public Contato busca(int codigo) throws SQLException{
        try(Connection conexao = conecta()){
        	Statement comando = conexao.createStatement();
        	ResultSet rs = comando.executeQuery("select Nome,Telefone,Mail from Contatos where idCod = " + codigo);
        	if (rs.next()==true) {
        		String nome = rs.getString("Nome");
        		String telefone = rs.getString("Telefone");
        		String mail = rs.getString("Mail");
        		return new Contato(nome, telefone, mail);
        	} else {
        		return null;
        	}
        } catch(SQLException ex){
          System.out.println(ex.toString());
          return null;
        }   
	}
}
