package pt.uc.dei.ar.ui;

import javax.swing.JFrame;

import pt.uc.dei.ar.Biblioteca;
import pt.uc.dei.ar.BibliotecaSerializer;
import pt.uc.dei.ar.Utilizador;
import java.awt.CardLayout;

/**
 * @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 *Janela que inclui todos os paineis
 *
 */
public class Janela extends JFrame {

	/**
	 * Create the frame.
	 */
	/**
	 * layout e atributo da janela
	 */
	private CardLayout layout;
	/**
	 * login e atributo da janela
	 */
	private Login login;
	/**
	 * EmprestimoPanel emprestimo e atributo da janela
	 */
	private EmprestimoPanel emprestimo;
	/**
	 * LeitorPanel	leitor e atributo da janela
	 */
	private LeitorPanel	leitor;
	/**
	 * RegistaUtilizadorPanel registaUtilizador e atributo da janela
	 */
	private RegistaUtilizadorPanel registaUtilizador;
	/**
	 * PesquisarPublicacao pesquisaPublicacao e atributo da janela
	 */
	private PesquisarPublicacao pesquisaPublicacao;
	/**
	 * EmprestimosForaPrazo emprestimosForaPrazo e atributo da janela
	 */
	private EmprestimosForaPrazo emprestimosForaPrazo;
	/**
	 * RegistaPublicacaoPanel registaPublicacao e atributo da janela
	 */
	private RegistaPublicacaoPanel registaPublicacao;
	/**
	 * RelatorioPanel relatorioPanel e atributo da janela
	 */
	private RelatorioPanel relatorioPanel;

	/**
	 * Create the JFrame
	 */
	public Janela() {

		setTitle("Biblioteca");
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {

				Biblioteca biblioteca = Biblioteca.getInstance();
				BibliotecaSerializer.getInstance().gravaBiblioteca(biblioteca);
				System.exit(0);
			}
		});

		setBounds(50, 50, 500, 400);
		this.setResizable(false);
		this.layout = new CardLayout();
		getContentPane().setLayout(layout);

		login = new Login(this);
		getContentPane().add(login, "login");

		this.emprestimo = new EmprestimoPanel(this);
		getContentPane().add(emprestimo, "emprestimo");

		this.leitor = new LeitorPanel(this, null);
		getContentPane().add(leitor, "leitor");

		BibliotecarioChefePanel bibliotecarioChefe=new BibliotecarioChefePanel(this);
		getContentPane().add(bibliotecarioChefe, "bibliotecarioChefe");

		this.registaUtilizador= new RegistaUtilizadorPanel(this);
		getContentPane().add(registaUtilizador, "registaUtilizador");

		this.pesquisaPublicacao= new PesquisarPublicacao(this);
		getContentPane().add(pesquisaPublicacao, "pesquisaPublicacao");

		this.emprestimosForaPrazo= new EmprestimosForaPrazo(this);
		getContentPane().add(emprestimosForaPrazo, "emprestimosForaPrazo");

		this.registaPublicacao= new RegistaPublicacaoPanel(this);
		getContentPane().add(registaPublicacao, "registaPublicacao");

		this.relatorioPanel= new RelatorioPanel(this);
		getContentPane().add(relatorioPanel, "relatorioPanel");

	}

	/**
	 * Login
	 * @param utilizador
	 */
	public void loginOK(Utilizador utilizador) {

		leitor.setUtilizador(utilizador);
		layout.show(getContentPane(), "leitor");

	}

	/**
	 * Colaborador
	 */
	public void colaboradorOK() {

		emprestimo.desativaVisibilidaBotaoVoltar();
		layout.show(getContentPane(), "emprestimo");

	}

	/**
	 * Bibliotecario chefe emprestimos
	 */
	public void emprestimoPanelBibliotecarioChefeOK(){

		layout.show(getContentPane(), "emprestimo");
		emprestimo.activaVisibilidaBotaoVoltar();

	}

	/**
	 * Bibliotecario chefe
	 */
	public void bibliotecarioChefeOK(){

		layout.show(getContentPane(), "bibliotecarioChefe");

	}

	/**
	 * Sair 
	 */
	public void sairOK() {

		layout.show(getContentPane(), "login");

	}

	/**
	 * Registar utilizador
	 */
	public void registaUtilizadorOK(){

		layout.show(getContentPane(), "registaUtilizador");

	}

	/**
	 * Pesquisar publicacao
	 */
	public void pesquisaPublicacaoOK(){

		layout.show(getContentPane(), "pesquisaPublicacao");

	}

	/**
	 * Emprestimos expirados
	 */
	public void emprestimosForaPrazoOK(){

		layout.show(getContentPane(), "emprestimosForaPrazo");

	}
	
	/**
	 * Registar publicacao
	 */
	public void registaPublicacaoOK(){

		layout.show(getContentPane(),"registaPublicacao");

	}

	/**
	 * Gerar relatorio da evolucao dos emprestimos globais
	 */
	public void relatorioPanelOK(){

		layout.show(getContentPane(),"relatorioPanel");

	}
}