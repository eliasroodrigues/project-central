package gui;

// Importações para criação de janela.
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.security.GeneralSecurityException;

// Importações dos códigos do programa.
import dao.ControleCentral;

public class GUIPrincipal extends JFrame {

	private JPanel contentPane;
	private ControleCentral controle;
	
	public GUIPrincipal(ControleCentral controle) {
		GUIPri();
		this.controle = new ControleCentral();
		this.controle = controle;
	}

	/**
	 * Create the frame.
	 */
	public void GUIPri() {
		setTitle("Central de Monitoramento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 450, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCadastros = new JLabel("CADASTROS");
		lblCadastros.setBounds(179, 32, 126, 15);
		panel.add(lblCadastros);
		
		JButton btnEsquadro = new JButton("Esquadrão");
		btnEsquadro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GUIEsquadrao(controle).setVisible(true);
			}
		});
		btnEsquadro.setBounds(29, 94, 166, 25);
		panel.add(btnEsquadro);
		
		JButton btnRegies = new JButton("Regiões");
		btnRegies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUIFloresta(controle).setVisible(true);
			}
		});
		btnRegies.setBounds(232, 94, 166, 25);
		panel.add(btnRegies);
		
		JLabel lblConexo = new JLabel("CONEXÃO");
		lblConexo.setBounds(179, 167, 70, 15);
		panel.add(lblConexo);
		
		JButton btnBuscarDados = new JButton("Buscar Dados");
		btnBuscarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarDados.setBounds(29, 234, 166, 25);
		panel.add(btnBuscarDados);
		
		JButton btnEnviarDados = new JButton("Enviar Dados");
		btnEnviarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controle.enviarDados();
				} catch(IOException ex) {
					ex.printStackTrace();
				} catch(GeneralSecurityException ex) {
        			ex.printStackTrace();
        		}
			}
		});
		btnEnviarDados.setBounds(232, 234, 166, 25);
		panel.add(btnEnviarDados);
	}
}
