package pt.uc.dei.ar.ui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import pt.uc.dei.ar.Biblioteca;
import pt.uc.dei.ar.Publicacao;

import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

public class EmprestimoPanel extends JPanel implements ActionListener {

	private Janela janela;

	private JTextField txtCodigoBarras;
	private JTextField txtNumeroLeitor;
	private JTextField txtCodigoBarrasDevolucao;

	private JLabel lblMensagem;
	private JLabel lblMensagemDevolver;

	private JButton btnEmprestarVoltar;
	private JButton btnDevolverVoltar;

	private JButton btnEmprestar;
	private JButton btnDevolver;
	private JButton btnSairDevolucao;

	private JButton btnSair;

	private Biblioteca biblioteca = Biblioteca.getInstance();

	/**
	 * Create the panel.
	 */
	public EmprestimoPanel(Janela j) {
		setLayout(null);

		this.janela = j;

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 488, 372);
		add(tabbedPane);

		Panel EmprestimoPanel = new Panel();
		tabbedPane.addTab("Empréstimo", null, EmprestimoPanel, null);
		EmprestimoPanel.setLayout(null);

		// Labels

		JLabel lblCodigoBarras = new JLabel("Código de barras");
		lblCodigoBarras.setBounds(104, 35, 117, 16);
		EmprestimoPanel.add(lblCodigoBarras);

		JLabel lblNumeroLeitor = new JLabel("Número de leitor");
		lblNumeroLeitor.setBounds(104, 68, 117, 16);
		EmprestimoPanel.add(lblNumeroLeitor);

		lblMensagem = new JLabel("");
		lblMensagem.setBounds(50, 140, 336, 16);
		EmprestimoPanel.add(lblMensagem);

		// Caixas de Texto

		txtCodigoBarras = new JTextField();
		txtCodigoBarras.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblMensagem.setText("");
			}
		});
		txtCodigoBarras.setBounds(256, 30, 130, 26);
		EmprestimoPanel.add(txtCodigoBarras);

		txtNumeroLeitor = new JTextField();
		txtNumeroLeitor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblMensagem.setText("");
			}
		});
		txtNumeroLeitor.setBounds(256, 63, 130, 26);
		EmprestimoPanel.add(txtNumeroLeitor);

		// Botoes

		btnEmprestar = new JButton("Emprestar");
		btnEmprestar.addActionListener(this);
		btnEmprestar.setBounds(50, 262, 117, 44);
		EmprestimoPanel.add(btnEmprestar);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(354, 262, 75, 44);
		EmprestimoPanel.add(btnSair);

		btnEmprestarVoltar = new JButton("Voltar");
		btnEmprestarVoltar.addActionListener(this);
		btnEmprestarVoltar.setBounds(267, 262, 75, 44);
		EmprestimoPanel.add(btnEmprestarVoltar);
		btnEmprestarVoltar.setVisible(false);

		// Painel devolver

		Panel DevolvePanel = new Panel();
		tabbedPane.addTab("Devolução", null, DevolvePanel, null);
		DevolvePanel.setLayout(null);

		// labels

		JLabel lblCodigoDeBarras = new JLabel("Código de barras");
		lblCodigoDeBarras.setBounds(104, 35, 117, 16);
		DevolvePanel.add(lblCodigoDeBarras);

		lblMensagemDevolver = new JLabel("");
		lblMensagemDevolver.setBounds(50, 143, 336, 16);
		DevolvePanel.add(lblMensagemDevolver);

		// Caixas de texto

		txtCodigoBarrasDevolucao = new JTextField();
		txtCodigoBarrasDevolucao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				lblMensagemDevolver.setText("");

			}
		});
		txtCodigoBarrasDevolucao.setBounds(256, 30, 130, 26);
		DevolvePanel.add(txtCodigoBarrasDevolucao);
		txtCodigoBarrasDevolucao.setColumns(10);

		// Butoes

		btnDevolver = new JButton("Devolver");
		btnDevolver.addActionListener(this);
		btnDevolver.setBounds(50, 262, 117, 44);
		DevolvePanel.add(btnDevolver);

		btnSairDevolucao = new JButton("Sair");
		btnSairDevolucao.addActionListener(this);
		btnSairDevolucao.setBounds(354, 262, 75, 44);
		DevolvePanel.add(btnSairDevolucao);

		btnDevolverVoltar = new JButton("Voltar");
		btnDevolverVoltar.addActionListener(this);
		btnDevolverVoltar.setBounds(267, 262, 75, 44);
		DevolvePanel.add(btnDevolverVoltar);
		btnDevolverVoltar.setVisible(false);

	}

	public void limpaPainel() {

		lblMensagem.setText("");
		lblMensagemDevolver.setText("");
		txtCodigoBarras.setText("");
		txtNumeroLeitor.setText("");
		txtCodigoBarrasDevolucao.setText("");

	}

	public void sairEmprestimoPanel() {

		limpaPainel();
		janela.sairOK();

	}

	public void activaVisibilidaBotaoVoltar() {

		btnEmprestarVoltar.setVisible(true);
		btnDevolverVoltar.setVisible(true);

	}

	public void desativaVisibilidaBotaoVoltar() {

		btnEmprestarVoltar.setVisible(false);
		btnDevolverVoltar.setVisible(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.btnDevolverVoltar || e.getSource() == this.btnEmprestarVoltar) {

			limpaPainel();
			janela.bibliotecarioChefeOK();
		}

		else if (e.getSource() == this.btnSair || e.getSource() == this.btnSairDevolucao) {

			sairEmprestimoPanel();
		}

		else if (e.getSource() == this.btnEmprestar) {

			validarBotaoEmprestimo();

		} else if (e.getSource() == this.btnDevolver) {

			validarBotaoDevolve();

		}

	}

	public void validarBotaoEmprestimo() {


		try{

			int numLeitor=Integer.parseInt(txtNumeroLeitor.getText());
			int codigoBarras=Integer.parseInt(txtCodigoBarras.getText());


			if (txtCodigoBarras.getText().equals("") || txtNumeroLeitor.getText().equals("")) {

				lblMensagem.setText("Não preencheu os campos do empréstimo.");

			} else if (biblioteca.pesquisaUtilizadorPorNumLeitor(numLeitor) == null) {

				lblMensagem.setText("O leitor não existe como leitor da biblioteca.");

			} else if (biblioteca.pesquisaPublicacaoPorCodBarras(codigoBarras) == null) {

				lblMensagem.setText("A publicação inserida não existe na biblioteca.");

			}

			else {

				txtCodigoBarras.setText("");
				txtNumeroLeitor.setText("");



				if (biblioteca.autorizaRequisitavel(biblioteca.pesquisaPublicacaoPorCodBarras(codigoBarras))){

					boolean emprestou = biblioteca.criaEmprestimo(numLeitor, codigoBarras);
					if (emprestou) {

						lblMensagem.setText("Empréstimo efectuado com sucesso.");
					}
					else{
						lblMensagem.setText("A publicação já se encontra ocupada.");
					}
				}	

				else{

					lblMensagem.setText("Erro! É um jornal, consultar na biblioteca.");

				}

			}
		}
		catch(NumberFormatException e){

			lblMensagem.setText("Coloque apenas números");

		}

	}

	public void validarBotaoDevolve() {


		try{

			int codigoBarras=Integer.parseInt(txtCodigoBarrasDevolucao.getText());

			if (biblioteca.pesquisaPublicacaoPorCodBarras(codigoBarras) == null) {

				lblMensagemDevolver.setText("A publicação inserida não existe na biblioteca.");

			}	else {

				txtCodigoBarrasDevolucao.setText("");

				if (biblioteca.devolveEmprestimo(codigoBarras)){

					lblMensagemDevolver.setText("O livro foi devolvido com sucesso");

				} else{

					lblMensagemDevolver.setText(" Erro! O livro não está emprestado");

				}
			}
		}
		
		catch(NumberFormatException e){

			lblMensagemDevolver.setText("Coloque apenas números");

		}

	}
}