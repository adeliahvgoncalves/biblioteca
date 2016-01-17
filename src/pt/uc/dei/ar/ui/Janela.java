package pt.uc.dei.ar.ui;

import javax.swing.JFrame;

import pt.uc.dei.ar.Biblioteca;
import pt.uc.dei.ar.BibliotecaSerializer;
import pt.uc.dei.ar.Utilizador;
import java.awt.CardLayout;

public class Janela extends JFrame {

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Janela frame = new Janela();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	private CardLayout layout;
	private Login login;
	private EmprestimoPanel emprestimo;
	private LeitorPanel	leitor;
	private RegistaUtilizadorPanel registaUtilizador;
	private PesquisarPublicacao pesquisaPublicacao;
	private EmprestimosForaPrazo emprestimosForaPrazo;
	private RegistaPublicacaoPanel registaPublicacao;
	private RelatorioPanel relatorioPanel;

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

	public void loginOK(Utilizador utilizador) {

		leitor.setUtilizador(utilizador);
		layout.show(getContentPane(), "leitor");

	}

	public void colaboradorOK() {

		emprestimo.desativaVisibilidaBotaoVoltar();
		layout.show(getContentPane(), "emprestimo");

	}

	public void emprestimoPanelBibliotecarioChefeOK(){

		layout.show(getContentPane(), "emprestimo");
		emprestimo.activaVisibilidaBotaoVoltar();

	}

	public void bibliotecarioChefeOK(){

		layout.show(getContentPane(), "bibliotecarioChefe");

	}

	public void sairOK() {

		layout.show(getContentPane(), "login");

	}

	public void registaUtilizadorOK(){

		layout.show(getContentPane(), "registaUtilizador");

	}

	public void pesquisaPublicacaoOK(){

		layout.show(getContentPane(), "pesquisaPublicacao");

	}

	public void emprestimosForaPrazoOK(){

		layout.show(getContentPane(), "emprestimosForaPrazo");

	}

	public void registaPublicacaoOK(){

		layout.show(getContentPane(),"registaPublicacao");

	}

	public void relatorioPanelOK(){

		layout.show(getContentPane(),"relatorioPanel");

	}

}