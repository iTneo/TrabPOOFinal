package interfaces;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import models.Contato;
import DAO.ContatoDAO;
import Impressora.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Consultar extends JFrame{
		
	public JLabel Nome;
	public JTextField tfNome;
	public JLabel Telefone;
	public JTextField tfTele;
	public JLabel Mail;
	public JTextField tfMail;
	JButton Imprimir;
	public JButton Sair;
	JLabel lblCodigoBusca;
	JTextField tfBusca;
	
	
	public Consultar(){
		
		setTitle("Consulta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 606, 315);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConsultaPorCdigo = new JButton("Consultar");
		btnConsultaPorCdigo.addActionListener(new ActionListener() {		

			public void actionPerformed(ActionEvent arg0) {
				tfNome.setText("");
				tfTele.setText("");
				tfMail.setText("");
				ContatoDAO dao = new ContatoDAO();
				Contato contato;
				try {
					contato = dao.busca(Integer.parseInt(tfBusca.getText()));
				} catch (NumberFormatException e) {
					e.printStackTrace();
					contato = null;
				} 
				
				if (contato != null) {
					tfNome.setText(contato.getNome());
					tfTele.setText(contato.getTelefone());
					tfMail.setText(contato.getEmail());
				} else {
					JOptionPane.showMessageDialog(null, "Contato não Encontrado");
				}
			}
		});
		
		btnConsultaPorCdigo.setBounds(300, 20, 110, 20);
		contentPane.add(btnConsultaPorCdigo);

		lblCodigoBusca = new JLabel("Digite o código para a Busca:");
		lblCodigoBusca.setBounds(20, 20, 227, 20);
		contentPane.add(lblCodigoBusca);

		tfBusca = new JTextField();
		tfBusca.setBounds(240, 20, 40, 20);
		contentPane.add(tfBusca);
		tfBusca.setColumns(10);

		Nome = new JLabel("Nome:");
		Nome.setBounds(60, 100, 60, 20);
		contentPane.add(Nome);

		tfNome = new JTextField();
		tfNome.setBounds(180, 100, 230, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		Telefone = new JLabel("Telefone:");
		Telefone.setBounds(60, 130, 230, 20);
		contentPane.add(Telefone);

		tfTele = new JTextField();
		tfTele.setBounds(180, 130, 230, 20);
		contentPane.add(tfTele);
		tfTele.setColumns(10);

		Mail = new JLabel("e-mail:");
		Mail.setBounds(60, 160, 227, 20);
		contentPane.add(Mail);

		tfMail = new JTextField();
		tfMail.setBounds(180, 160, 230, 20);
		contentPane.add(tfMail);
		tfMail.setColumns(10);
		
		
		
		
		Imprimir = new JButton("Imprimir");
		Imprimir.setName("Imprimir");
		Imprimir.setBounds(400, 210, 120, 20);
		contentPane.add(Imprimir);
		Imprimir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Impressora imp = new Impressora();
				List<Contato> contatos = new ContatoDAO().buscaTodos();
				imp.imprime(contatos);
				
			}
		});
		
		Sair = new JButton("Sair");
		Sair.setName("Sair");
		Sair.setBounds(400, 250, 120, 20);
        contentPane.add(Sair);
		Sair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			dispose();
				
			}
		});
				
	}     
	
}