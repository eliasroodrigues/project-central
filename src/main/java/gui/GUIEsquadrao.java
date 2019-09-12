package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import central.ControleCentral;
import central.EspecialidadeEsq;

public class GUIEsquadrao extends JFrame {

	private JPanel contentPane;
	private JTextField textNomeEsq;
	private JTextField textTamEsq;
	
	ControleCentral controle = new ControleCentral();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIEsquadrao frame = new GUIEsquadrao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIEsquadrao() {
		setResizable(false);
		setTitle("Cadastro Esquadrão");
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
		
		JLabel nomeEsq = new JLabel("Nome:");
		nomeEsq.setBounds(12, 35, 70, 15);
		panel.add(nomeEsq);
		
		textNomeEsq = new JTextField();
		textNomeEsq.setText("Nome do esquadrão.");
		textNomeEsq.setBounds(229, 33, 209, 19);
		panel.add(textNomeEsq);
		textNomeEsq.setColumns(10);
		
		JLabel nomeEspecialidadeEsq = new JLabel("Especialidade:");
		nomeEspecialidadeEsq.setBounds(12, 80, 103, 15);
		panel.add(nomeEspecialidadeEsq);
		
		JComboBox comboEspeEsq = new JComboBox();
		comboEspeEsq.setModel(new DefaultComboBoxModel(new String[] {"Resgate de animais"}));
		comboEspeEsq.setBounds(239, 75, 199, 24);
		panel.add(comboEspeEsq);
		
		JLabel lblTamanhoDoEsquadro = new JLabel("Tamanho do Esquadrão:");
		lblTamanhoDoEsquadro.setBounds(12, 127, 188, 15);
		panel.add(lblTamanhoDoEsquadro);
		
		textTamEsq = new JTextField();
		textTamEsq.setText("10");
		textTamEsq.setBounds(324, 125, 114, 19);
		panel.add(textTamEsq);
		textTamEsq.setColumns(10);
		
		JButton btnVoltarEsq = new JButton("Voltar");
		btnVoltarEsq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVoltarEsq.setBackground(UIManager.getColor("Button.disabledText"));
		btnVoltarEsq.setBounds(12, 263, 117, 25);
		panel.add(btnVoltarEsq);
		
		JButton btnCadastrarEsq = new JButton("Cadastrar");
		btnCadastrarEsq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EspecialidadeEsq especialidade = null;
				controle.cadastrarEsquadrao(textNomeEsq.getText(), especialidade.COMBATE_INCENDIO,
						Integer.parseInt(textTamEsq.getText()));
			}
		});
		btnCadastrarEsq.setBounds(321, 263, 117, 25);
		panel.add(btnCadastrarEsq);
		
		JButton btnApagarEsq = new JButton("Apagar");
		btnApagarEsq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnApagarEsq.setBounds(192, 263, 117, 25);
		panel.add(btnApagarEsq);
	}
}
