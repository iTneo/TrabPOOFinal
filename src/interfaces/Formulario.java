package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import models.Contato;
import DAO.ContatoDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfTele;
	private JTextField tfMail;
	private JButton btnConsultaPorCdigo;
	private JLabel lblCodigoBusca;
	private JTextField tfBusca;
	
	public Formulario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 606, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Nome = new JLabel("Nome:");
		Nome.setBounds(23, 38, 227, 20);
		contentPane.add(Nome);

		tfNome = new JTextField();
		tfNome.setBounds(247, 38, 227, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		JLabel Telefone = new JLabel("Telefone:");
		Telefone.setBounds(23, 68, 227, 20);
		contentPane.add(Telefone);

		tfTele = new JTextField();
		tfTele.setBounds(247, 68, 227, 20);
		contentPane.add(tfTele);
		tfTele.setColumns(10);

		JLabel Mail = new JLabel("e-mail:");
		Mail.setBounds(23, 98, 227, 20);
		contentPane.add(Mail);

		tfMail = new JTextField();
		tfMail.setBounds(247, 98, 227, 20);
		contentPane.add(tfMail);
		tfMail.setColumns(10);

		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				ContatoDAO dao = new ContatoDAO();
				Boolean insert = dao.insere(new Contato(tfNome.getText(), tfTele.getText(), tfMail.getText()));
				if(insert){
					JOptionPane.showMessageDialog(null,"Contato Registrado");
					tfNome.setText("");
					tfTele.setText("");
					tfMail.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Falha ao inserir Contato");
				}
			}
		});
		btnGravar.setBounds(247, 138, 89, 23);
		contentPane.add(btnGravar);

		btnConsultaPorCdigo = new JButton("Consulta por Código");
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
		
		btnConsultaPorCdigo.setBounds(23, 212, 177, 23);
		contentPane.add(btnConsultaPorCdigo);

		lblCodigoBusca = new JLabel("Entre com o código de Busca:");
		lblCodigoBusca.setBounds(10, 179, 243, 14);
		contentPane.add(lblCodigoBusca);

		tfBusca = new JTextField();
		tfBusca.setBounds(247, 176, 86, 20);
		contentPane.add(tfBusca);
		tfBusca.setColumns(10);
	}
}
