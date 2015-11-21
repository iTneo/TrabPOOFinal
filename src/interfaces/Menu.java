package interfaces;

import models.Contato;
import DAO.ContatoDAO;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame implements ActionListener {
	
	public Menu(){
		
	JButton Cadastrar;
	JButton Consultar;
	JButton Sair;
	
	setTitle("Menu");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(200,100);
	JPanel painel = new JPanel();
	
	Cadastrar = new JButton("Cadastrar");
	Cadastrar.setText("Cadastrar");
	Cadastrar.setName("Cadastrar");
	Cadastrar.addActionListener(this);
	Consultar = new JButton("Consultar");
	Consultar.setName("Consultar");
	Consultar.setText("Consultar");
	Consultar.addActionListener(this);
	Sair = new JButton("Sair");
	Sair.setName("Sair");
	Sair.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		System.exit(0);
			
		}
	});
	
	painel.add(Cadastrar);
	painel.add(Consultar);
	painel.add(Sair);
	add(painel);
	setVisible(true);
	
	}
	
	public void actionPerformed(ActionEvent arg0){
		JButton botao = (JButton)arg0.getSource();
		if (botao.getText().equals("Cadastrar")){
			Formulario form = new Formulario();
			form.setVisible(true);
		}else if(botao.getText().equals("Consultar")){
			Consultar consult = new Consultar();
			consult.setVisible(true);
		}
	}
}
