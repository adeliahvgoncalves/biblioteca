package ui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class EmprestimoPanel extends JPanel {
	
	
	private JTextField txtCodigoBarras;
	private JTextField txtNumeroLeitor;
	private JTextField txtData;
	private JTextField txtCodigoBarrasDevolucao;
	private JTextField txtDataDevolucao;
	private JLabel lblMensagem;
	private Janela janela;
	private JButton btnEmprestarVoltar;
	private JButton btnDevolverVoltar;
	
	/**
	 * Create the panel.
	 */
	public EmprestimoPanel(Janela j) {
		setLayout(null);
		
		this.janela=j;
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 488, 388);
		add(tabbedPane);
		
		Panel EmprestimoPanel = new Panel();
		tabbedPane.addTab("Emprestimo", null, EmprestimoPanel, null);
		EmprestimoPanel.setLayout(null);
		
		//Labels
		
		JLabel lblCodigoBarras = new JLabel("Código de Barras");
		lblCodigoBarras.setBounds(104, 35, 117, 16);
		EmprestimoPanel.add(lblCodigoBarras);
		
		JLabel lblNumeroLeitor = new JLabel("Número de leitor");
		lblNumeroLeitor.setBounds(104, 68, 117, 16);
		EmprestimoPanel.add(lblNumeroLeitor);
		
		JLabel lblData = new JLabel("Data Emprestimo");
		lblData.setBounds(104, 102, 117, 16);
		EmprestimoPanel.add(lblData);
		
		//Caixas de Texto
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setBounds(256, 30, 130, 26);
		EmprestimoPanel.add(txtCodigoBarras);
		
		txtNumeroLeitor = new JTextField();
		txtNumeroLeitor.setBounds(256, 63, 130, 26);
		EmprestimoPanel.add(txtNumeroLeitor);
		
		txtData = new JTextField();
		txtData.setBounds(256, 97, 130, 26);
		EmprestimoPanel.add(txtData);
		
		lblMensagem = new JLabel("");
		lblMensagem.setBounds(50, 140, 336, 16);
		EmprestimoPanel.add(lblMensagem);
		
		//Butoes
		
		JButton btnEmpresta = new JButton("EMPRESTAR");
		btnEmpresta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMensagem.setText("Emprestimo efectuado com sucesso.");
				txtData.setText("");
				txtCodigoBarras.setText("");
				txtNumeroLeitor.setText("");
			}
		});
		btnEmpresta.setBounds(50, 262, 117, 44);
		EmprestimoPanel.add(btnEmpresta);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janela.sairOK();
			}
		});
		btnSair.setBounds(354, 262, 75, 44);
		EmprestimoPanel.add(btnSair);
		
		btnEmprestarVoltar = new JButton("VOLTAR");
		btnEmprestarVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaPainel();
				j.bibliotecarioChefeOK();
			}
		});
		btnEmprestarVoltar.setBounds(267, 262, 75, 44);
		EmprestimoPanel.add(btnEmprestarVoltar);
		btnEmprestarVoltar.setVisible(false);
		
		//Painel devolver
		
		Panel DevolvePanel = new Panel();
		tabbedPane.addTab("Devoluções", null, DevolvePanel, null);
		DevolvePanel.setLayout(null);
		
		//labels
		
		JLabel lblCodigoDeBarras = new JLabel("Código de Barras");
		lblCodigoDeBarras.setBounds(104, 35, 117, 16);
		DevolvePanel.add(lblCodigoDeBarras);
		
		JLabel lblDataDevolucao = new JLabel("Data Emprestimo");
		lblDataDevolucao.setBounds(104, 68, 117, 16);
		DevolvePanel.add(lblDataDevolucao);
		
		JLabel lblMensagemDevolver = new JLabel("");
		lblMensagemDevolver.setBounds(50, 143, 336, 16);
		DevolvePanel.add(lblMensagemDevolver);
		
		//Caixas de texto
		
		txtCodigoBarrasDevolucao = new JTextField();
		txtCodigoBarrasDevolucao.setBounds(256, 30, 130, 26);
		DevolvePanel.add(txtCodigoBarrasDevolucao);
		txtCodigoBarrasDevolucao.setColumns(10);
		
		txtDataDevolucao = new JTextField();
		txtDataDevolucao.setBounds(256, 63, 130, 26);
		DevolvePanel.add(txtDataDevolucao);
		txtDataDevolucao.setColumns(10);
		
		//Butoes
		
		JButton btnDevolver = new JButton("DEVOLVER");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMensagemDevolver.setText("O livro com o codigo "+txtCodigoBarras.getText()+" foi devolvido.");
				txtDataDevolucao.setText("");
				txtCodigoBarrasDevolucao.setText("");
				
			}
		});
		btnDevolver.setBounds(50, 262, 117, 44);
		DevolvePanel.add(btnDevolver);
		
		JButton btnSairDevolucao = new JButton("SAIR");
		btnSairDevolucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janela.sairOK();
			}
		});
		btnSairDevolucao.setBounds(354, 262, 75, 44);
		DevolvePanel.add(btnSairDevolucao);
		
		btnDevolverVoltar = new JButton("VOLTAR");
		btnDevolverVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaPainel();
				j.bibliotecarioChefeOK();
			}
		});
		btnDevolverVoltar.setBounds(267, 262, 75, 44);
		DevolvePanel.add(btnDevolverVoltar);
		btnDevolverVoltar.setVisible(false);
		
	}
	
	public void limpaPainel(){
		
		lblMensagem.setText("");
		txtData.setText("");
		txtCodigoBarras.setText("");
		txtNumeroLeitor.setText("");
		txtDataDevolucao.setText("");
		txtCodigoBarrasDevolucao.setText("");
		janela.sairOK();
		
	}
	
	public void activaVisibilidadeBotaoVoltar(){
		
		btnEmprestarVoltar.setVisible(true);
		btnDevolverVoltar.setVisible(true);
		
	}	
}
