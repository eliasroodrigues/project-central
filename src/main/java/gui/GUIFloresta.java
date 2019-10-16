/*
*   Trabalho I de POO   
*
*   Classe: GUIFloresta.java
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import dao.ControleCentral;
import modelo.ProtecaoFloresta;

public class GUIFloresta extends JFrame {

	private JPanel contentPane;
	private JTextField textFloresta;
	private ControleCentral controle;
	private JComboBox comboFloresta = new JComboBox();
	
	/**
	 * Construtor da classe para inicializar a interface e receber
	 * os dados do controle, assim como receber o nome das regiões
	 * já cadastradas.
	 *
	 * @param controle Recebe o ControleSatelie para ter acesso 
	 *				   aos dados.
	 */
	public GUIFloresta(ControleCentral controle) {
		GUIFlo();
		this.controle = new ControleCentral();
		this.controle = controle;

		String nomesEsquadrao[] = controle.nomesEsquadrao();
        for (String nome : nomesEsquadrao) {
            if (nome != null) {
                comboFloresta.addItem(nome);
            }
        }
	}

	/**
	 * Create the frame.
	 */
	public void GUIFlo() {
		setTitle("Cadastra Região");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel nomeFloresta = new JLabel("Nome:");
		nomeFloresta.setBounds(12, 35, 70, 15);
		panel.add(nomeFloresta);
		
		textFloresta = new JTextField();
		textFloresta.setText("Nome da região.");
		textFloresta.setBounds(203, 33, 235, 19);
		panel.add(textFloresta);
		textFloresta.setColumns(10);
		
		JLabel lblreaDeProteo = new JLabel("Área de Proteção:");
		lblreaDeProteo.setBounds(12, 76, 128, 15);
		panel.add(lblreaDeProteo);
		
		JRadioButton rdbtnSim = new JRadioButton("Sim");
		JRadioButton rdbtnNo = new JRadioButton("Não");
		rdbtnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNo.setSelected(false);
			}
		});
		rdbtnSim.setSelected(true);
		rdbtnSim.setBounds(203, 76, 100, 23);
		panel.add(rdbtnSim);
		
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSim.setSelected(false);
			}
		});
		rdbtnNo.setBounds(342, 72, 100, 23);
		panel.add(rdbtnNo);
		
		JLabel lblEsquadroResponsvel = new JLabel("Esquadrão Responsável:");
		lblEsquadroResponsvel.setBounds(12, 129, 175, 15);
		panel.add(lblEsquadroResponsvel);
		
		comboFloresta.setModel(new DefaultComboBoxModel(new String[] {"Sem esquadrão"}));
		comboFloresta.setBounds(263, 124, 175, 24);
		panel.add(comboFloresta);
		
		JButton btnVoltarFloresta = new JButton("Voltar");
		btnVoltarFloresta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltarFloresta.setBounds(12, 263, 117, 25);
		panel.add(btnVoltarFloresta);
		
		JButton btnCadastrarFloresta = new JButton("Cadastrar");
		btnCadastrarFloresta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String radio = null;
				if (rdbtnSim.isSelected() == true) {
					radio = "PROTEGIDO";
				} else radio = "NAO_PROTEGIDO";

				ProtecaoFloresta protecaoFlo =
					ProtecaoFloresta.valueOf(String.valueOf(radio)); 

				String nomeEsq = comboFloresta.getSelectedItem().toString();

				if (textFloresta.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o nome da região.",
                    	"Alerta", JOptionPane.WARNING_MESSAGE);
				} else {
					if (!textFloresta.getText().matches("^[A-Z a-z áàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]+[0-9]*$")) {
						JOptionPane.showMessageDialog(null, "Por Favor, insira um nome válido.",
                    		"Alerta", JOptionPane.WARNING_MESSAGE);
					} else {
						String nomeRegiao = textFloresta.getText();
						controle.cadastrarRegiao(nomeRegiao, protecaoFlo, nomeEsq, "Não informado");
					}
				}
			}
		});
		btnCadastrarFloresta.setBounds(321, 263, 117, 25);
		panel.add(btnCadastrarFloresta);
		
		JButton btnApagarFloresta = new JButton("Apagar");
		btnApagarFloresta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFloresta.setText(" ");
				rdbtnSim.setSelected(true);
				rdbtnNo.setSelected(false);
			}
		});
		btnApagarFloresta.setBounds(186, 263, 117, 25);
		panel.add(btnApagarFloresta);
	}

}
