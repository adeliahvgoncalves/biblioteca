package pt.uc.dei.ar.ui;

import javax.swing.JPanel;

import pt.uc.dei.ar.Biblioteca;
import pt.uc.dei.ar.ExportadorCSV;

import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import java.util.Calendar;
import java.awt.event.ActionEvent;

/**
 *  @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 * Interface do bibliotecario chefe (disponibiliza a visualizacao de 
 * todas as operacoes que lhe sao permitidas)
 *
 */
public class BibliotecarioChefePanel extends JPanel implements ActionListener {

	/**
	 * A janela e atributo do BibliotecarioChefePanel
	 */
	private Janela janela;
	/**
	 * btnSair e atributo do BibliotecarioChefePanel
	 */
	private JButton btnSair;
	/**
	 * btnRegistarUtilizador e atributo do BibliotecarioChefePanel
	 */
	private JButton btnRegistarUtilizador;
	/**
	 * btnEmprestaDevolve e atributo do BibliotecarioChefePanel
	 */
	private JButton btnEmprestaDevolve;
	/**
	 * btnPesquisaPublicacao e atributo do BibliotecarioChefePanel
	 */
	private JButton btnPesquisaPublicacao;
	/**
	 * btnEmprestimosAtraso e atributo do BibliotecarioChefePanel
	 */
	private JButton btnEmprestimosAtraso;
	/**
	 * btnRegistaPublicacao e atributo do BibliotecarioChefePanel
	 */
	private JButton btnRegistaPublicacao;
	/**
	 * btnGerarRelatrio e atributo do BibliotecarioChefePanel
	 */
	private JButton btnGerarRelatrio;

	/**
	 * Create the panel
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
	
	/**
	 * actionPerformed dos botoes a disposicao do bibliotecario chefe
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		

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

			
			//janela.relatorioPanelOK();
			JFileChooser fs = new JFileChooser(new File("c:\\"));
			fs.setDialogTitle("Gravar um ficheiro");
			fs.setFileFilter(new SaveFile(".csv", "Ficheiro CSV"));
			int result = fs.showSaveDialog(null);

			if(result==JFileChooser.APPROVE_OPTION){
				ExportadorCSV exportador = new ExportadorCSV(Biblioteca.getInstance());
				String csv = exportador.geraCSV(Calendar.getInstance());
				File fi=fs.getSelectedFile();
				try {
					FileWriter fw = new FileWriter(fi.getPath());
					fw.write(csv);
					fw.flush();
					fw.close();
				} catch (Exception e2){
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}

		}

			
		}

}