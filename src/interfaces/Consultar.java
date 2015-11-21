package interfaces;

import javax.swing.JFrame;
import javax.swing.JLabel;

import models.Contato;
import DAO.ContatoDAO;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Consultar extends JFrame{
	
	public Consultar(){
		
		RadioButton radioButtonFrame = new RadioButton();
		radioButtonFrame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
		radioButtonFrame.setSize( 350, 100 );
		radioButtonFrame.setVisible(true);
		
		
	}     
	
}
