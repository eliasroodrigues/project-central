/*
*   Trabalho I de POO   
*
*   Classe: GUIEsquadrao.java
*
*   Alunos: Ana Paula Pacheco
*           Elias Eduardo Silva Rodrigues
*
*/

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

import dao.ControleCentral;
import modelo.EspecialidadeEsq;

public class GUIEsquadrao extends JFrame {

	private JPanel contentPane;
	private JTextField textNomeEsq;
	private JTextField textTamEsq;
	private ControleCentral controle;
	
	/**
	 * Construtor da classe para inicializar a interface e receber
	 * os dados do controle, assim como receber o nome das regiões
	 * já cadastradas.
	 *
	 * @param controle Recebe o ControleSatelie para ter acesso 
	 *				   aos dados.
	 */
	public GUIEsquadrao(ControleCentral controle) {
		GUIEsq();
		this.controle = new ControleCentral();
		this.controle = controle;
	}

	/**
	 * Create the frame.
	 */
	public void GUIEsq() {
		setResizable(false);
		setTitle("Cadastro Esquadrão");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		comboEspeEsq.setModel(new DefaultComboBoxModel(EspecialidadeEsq.values()));
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
				dispose();
			}
		});
		btnVoltarEsq.setBackground(UIManager.getColor("Button.disabledText"));
		btnVoltarEsq.setBounds(12, 263, 117, 25);
		panel.add(btnVoltarEsq);
		
		JButton btnCadastrarEsq = new JButton("Cadastrar");
		btnCadastrarEsq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomeEsq = textNomeEsq.getText();
				EspecialidadeEsq especialidadeEsq = EspecialidadeEsq.valueOf(String.valueOf(comboEspeEsq.getSelectedItem())); 
				int tamanhoEsq = Integer.parseInt(textTamEsq.getText());
				controle.cadastrarEsquadrao(
						nomeEsq,
						especialidadeEsq,
						tamanhoEsq);
			}
		});
		btnCadastrarEsq.setBounds(321, 263, 117, 25);
		panel.add(btnCadastrarEsq);
		
		JButton btnApagarEsq = new JButton("Apagar");
		btnApagarEsq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textNomeEsq.setText(" ");
				textTamEsq.setText(" ");
				comboEspeEsq.setSelectedIndex(-1);;
			}
		});
		btnApagarEsq.setBounds(192, 263, 117, 25);
		panel.add(btnApagarEsq);
	}
}
