import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Formulario extends JFrame {

  private JPanel contentPane;
  private JTextField tfNome;//nome
  private JTextField tfTele;//telefone
  private JTextField tfMail;//mail
  private JLabel labelResultado;
  private JButton btnConsultaPorCdigo;
  private JLabel lblCodigoBusca;
  private JTextField tfBusca;


  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Formulario frame = new Formulario();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }


  public Formulario() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 606, 405);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JLabel Nome = new JLabel("Nome:");
    Nome.setBounds(23, 38, 193, 18);
    contentPane.add(Nome);

    tfNome = new JTextField();
    tfNome.setBounds(247, 38, 193, 18);
    contentPane.add(tfNome);
    tfNome.setColumns(10);

    JLabel Telefone = new JLabel("Telefone:");
    Telefone.setBounds(23, 68, 207, 18);
    contentPane.add(Telefone);

    tfTele = new JTextField();
    tfTele.setBounds(247, 68, 207, 20);
    contentPane.add(tfTele);
    tfTele.setColumns(10);

    JLabel Mail = new JLabel("Mail:");
    Mail.setBounds(23,98, 227, 18);
    contentPane.add(Mail);

    tfMail = new JTextField();
    tfMail.setBounds(247, 98, 227, 20);
    contentPane.add(tfMail);
    tfMail.setColumns(10);

    JButton btnGravar = new JButton("Gravar");
    btnGravar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        labelResultado.setText("");        
        try {

          Connection conexao=DriverManager.getConnection("jdbc:mysql://localhost/agenda","root","root");
          Statement comando=conexao.createStatement();
          comando.executeUpdate("insert into Contatos(Nome,Telefone,Mail)values('"+tfNome.getText()+"','"+tfTele.getText()+"','"+tfMail.getText()+"')");
          conexao.close();
          labelResultado.setText("Contato Registrado");
          tfNome.setText("");
          tfTele.setText("");
          tfMail.setText("");
        } catch(SQLException ex){
          setTitle(ex.toString());
        }
      }
    });
    btnGravar.setBounds(247, 118, 89, 23);
    contentPane.add(btnGravar);

    labelResultado = new JLabel("Resultado");
    labelResultado.setBounds(361, 122, 229, 14);
    contentPane.add(labelResultado);

    btnConsultaPorCdigo = new JButton("Consulta por Código");
    btnConsultaPorCdigo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        labelResultado.setText("");
        tfNome.setText("");
        tfTele.setText("");
        tfMail.setText("");
        
        
        
        try {
          /* Connection conexao=DriverManager.getConnection("jdbc:mysql://localhost/agenda","root" ,"root");
          Statement comando=conexao.createStatement();
          ResultSet registro = comando.executeQuery("select Nome,Telefone,Mail from Contatos where idCod ="+tfBusca.getText());
          
          */
        	
          if (registro.next()==true) {
            tfNome.setText(registro.getString("Nome"));
            tfTele.setText(registro.getString("Telefone"));
            tfMail.setText(registro.getString("Mail"));
          } else {
            labelResultado.setText("Contato não Encontrado");
          }
          conexao.close();
        /*
        } catch(SQLException ex){
          setTitle(ex.toString());
        }*/
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
    carregarDriver();
  }

  private void carregarDriver() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
    }catch(Exception ex) {
      setTitle(ex.toString());
    }
  }
}