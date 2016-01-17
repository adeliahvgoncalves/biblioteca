package pt.uc.dei.ar.ui;

import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class BibliotecarioChefePanel extends JPanel implements ActionListener {

	private Janela janela;
	private JButton btnSair;
	private JButton btnRegistarUtilizador;
	private JButton btnEmprestaDevolve;
	private JButton btnPesquisaPublicacao;
	private JButton btnEmprestimosAtraso;
	private JButton btnRegistaPublicacao;
	private JButton btnGerarRelatrio;

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

		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(350, 300, 80, 40);
		panel.add(btnSair);

		btnRegistarUtilizador = new JButton("Registar Utilizador");
		btnRegistarUtilizador.addActionListener(this);
		btnRegistarUtilizador.setBounds(250, 153, 144, 47);
		panel.add(btnRegistarUtilizador);

		btnEmprestaDevolve = new JButton("Emprestar/Devolver");
		btnEmprestaDevolve.addActionListener(this);
		btnEmprestaDevolve.setBounds(250, 84, 144, 47);
		panel.add(btnEmprestaDevolve);

		btnEmprestimosAtraso = new JButton("Empréstimos Atraso");
		btnEmprestimosAtraso.addActionListener(this);
		btnEmprestimosAtraso.setBounds(250, 224, 144, 47);
		panel.add(btnEmprestimosAtraso);

		btnPesquisaPublicacao = new JButton("Pesquisar Publicação");
		btnPesquisaPublicacao.addActionListener(this);
		btnPesquisaPublicacao.setBounds(69, 84, 144, 47);
		panel.add(btnPesquisaPublicacao);

		btnRegistaPublicacao = new JButton("Registar Publicação");
		btnRegistaPublicacao.addActionListener(this);
		btnRegistaPublicacao.setBounds(69, 153, 144, 47);
		panel.add(btnRegistaPublicacao);

		btnGerarRelatrio = new JButton("Gerar Relatório");
		btnGerarRelatrio.addActionListener(this);
		btnGerarRelatrio.setBounds(69, 224, 144, 47);
		panel.add(btnGerarRelatrio);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO faltam os botoes Emprestimos em atraso, gerar relatorio e registar Pub, ainda faltam os paineis.

		if(e.getSource() == this.btnSair){

			janela.sairOK();

		}
		else if(e.getSource() == this.btnRegistarUtilizador){

			janela.registaUtilizadorOK();

		}
		else if(e.getSource() == this.btnEmprestaDevolve){

			janela.emprestimoPanelBibliotecarioChefeOK();

		}
		else if(e.getSource() == this.btnPesquisaPublicacao){

			janela.pesquisaPublicacaoOK();

		}

		else if(e.getSource() == this.btnEmprestimosAtraso){

			janela.emprestimosForaPrazoOK();
			
		}
		else if(e.getSource() == this.btnRegistaPublicacao){

			janela.registaPublicacaoOK();
			
		}
		else if(e.getSource() == this.btnGerarRelatrio){
			
			janela.relatorioPanelOK();
			
		}
	}
}