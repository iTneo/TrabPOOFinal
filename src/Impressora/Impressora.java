package Impressora;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import models.Contato;

public class Impressora {

	private String arquivoSaida = "saida.txt";

	public void imprime(List<Contato> contatos) {
		FileWriter saida = null;
		try {
			saida = new FileWriter(arquivoSaida);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter gravarSaida = new PrintWriter(saida);

		gravarSaida.printf("+--- Contatos da Agenda Telefonica --+\n");
		for (Contato contato : contatos) {
			gravarSaida.printf("| Nome: " + contato.getNome()
					+ " |\tTelefone: " + contato.getTelefone() + " |\tE-mail:"
					+ contato.getEmail() + "|\n");
		}
		try {
			saida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
