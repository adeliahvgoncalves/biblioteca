package ui;

import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class BibliotecarioChefePanel extends JPanel {

	private Janela janela;
	/**
	 * Create the panel.
	 */
	public BibliotecarioChefePanel(Janela j) {

		this.janela=j;
		setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(10, 10, 480, 380);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblBibliotecarioChefe = new JLabel("BIBLIOTECÁRIO CHEFE");
		lblBibliotecarioChefe.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblBibliotecarioChefe.setBounds(161, 34, 158, 16);
		panel.add(lblBibliotecarioChefe);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				janela.sairOK();
			}
		});
		btnSair.setBounds(350, 300, 80, 40);
		panel.add(btnSair);
		
		JButton btnRegistarUtilizador = new JButton("Registar Utilizador");
		btnRegistarUtilizador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistarUtilizador.setBounds(250, 153, 144, 47);
		panel.add(btnRegistarUtilizador);
		
		JButton btnEmprestaDevolve = new JButton("Emprestar/Devolver");
		btnEmprestaDevolve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janela.emprestimoPanelBibliotecarioChefeOK();
			}
		});
		btnEmprestaDevolve.setBounds(250, 84, 144, 47);
		panel.add(btnEmprestaDevolve);
		
		JButton btnEmprestimosAtraso = new JButton("Empréstimos Atraso");
		btnEmprestimosAtraso.setBounds(250, 224, 144, 47);
		panel.add(btnEmprestimosAtraso);
		
		JButton btnPesquisaPublicacao = new JButton("Pesquisar Publicação");
		btnPesquisaPublicacao.setBounds(69, 84, 144, 47);
		panel.add(btnPesquisaPublicacao);
		
		JButton btnRegistarPublicao = new JButton("Registar Publicação");
		btnRegistarPublicao.setBounds(69, 153, 144, 47);
		panel.add(btnRegistarPublicao);
		
		JButton btnGerarRelatrio = new JButton("Gerar Relatório");
		btnGerarRelatrio.setBounds(69, 224, 144, 47);
		panel.add(btnGerarRelatrio);
		
	}
}
