package pt.uc.dei.ar.ui;

import javax.swing.JFrame;

import pt.uc.dei.ar.Biblioteca;
import pt.uc.dei.ar.BibliotecaSerializer;
import pt.uc.dei.ar.Utilizador;
import java.awt.CardLayout;

/**
 * @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 *Janela que inclui todos os paineis
 */
public class Janela extends JFrame {

	private static final long serialVersionUID = 1263932340481970651L;
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
	}

	/**
	 * Mostra o Jpanel de LeitorPanel
	 * @param utilizador
	 */
	public void loginOK(Utilizador utilizador) {
		Biblioteca biblioteca=Biblioteca.getInstance();
		leitor.preencheTabelaListaPublicacaoTotal(biblioteca.getListaDePublicacoes());
		leitor.setUtilizador(utilizador);
		layout.show(getContentPane(), "leitor");
	}

	/**
	 * Mostra o Jpanel EmprestimoPanel do Colaborador
	 */
	public void colaboradorOK() {

		emprestimo.desativaVisibilidaBotaoVoltar();
		layout.show(getContentPane(), "emprestimo");
	}

	/**
	 * Mosta o Jpanel EmprestimoPanel do Bibliotecario chefe
	 */
	public void emprestimoPanelBibliotecarioChefeOK(){

		layout.show(getContentPane(), "emprestimo");
		emprestimo.activaVisibilidaBotaoVoltar();
	}

	/**
	 * Mostra o Jpanel BibliotecarioChefePanel do Bibliotecario chefe
	 */
	public void bibliotecarioChefeOK(){

		layout.show(getContentPane(), "bibliotecarioChefe");
	}

	/**
	 * Mostra o Jpanel do Login, sai da sessao do utilizador
	 */
	public void sairOK() {

		layout.show(getContentPane(), "login");
	}

	/**
	 * Mostra o JPanel RegistaUtilizadorPanel do Bibliotecario chefe
	 */
	public void registaUtilizadorOK(){

		layout.show(getContentPane(), "registaUtilizador");
	}

	/**
	 *  Mostra o JPanel PesquisarPublicacao do Bibliotecario chefe
	 */
	public void pesquisaPublicacaoOK(){

		layout.show(getContentPane(), "pesquisaPublicacao");
	}

	/**
	 * Mostra o JPanel EmprestimosForaPrazo do Bibliotecario chefe
	 */
	public void emprestimosForaPrazoOK(){

		this.emprestimosForaPrazo.preencheTabelaEmprestimo();
		layout.show(getContentPane(), "emprestimosForaPrazo");
	}

	/**
	 *  Mostra o JPanel RegistaPublicacao do Bibliotecario chefe
	 */
	public void registaPublicacaoOK(){

		layout.show(getContentPane(),"registaPublicacao");
	}
}