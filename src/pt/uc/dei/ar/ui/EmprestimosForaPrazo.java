package pt.uc.dei.ar.ui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import pt.uc.dei.ar.Biblioteca;
import pt.uc.dei.ar.Emprestimo;
import pt.uc.dei.ar.Publicacao;

/**
 *  @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 * Interface de consulta de emprestimo expirados
 *
 */
public class EmprestimosForaPrazo extends JPanel implements ActionListener {

	/**
	 * A janela e atributo do EmprestimosForaPrazo
	 */
	private Janela janela;
	/**
	 * textFielPesquisa e atributo do EmprestimosForaPrazo
	 */
	private JTextField textFielPesquisa;
	/**
	 * layout e atributo do EmprestimosForaPrazo
	 */
	private CardLayout layout;
	/**
	 * tabela e atributo do EmprestimosForaPrazo
	 */
	private JTable tabela;
	/**
	 * btnSair e atributo do EmprestimosForaPrazo
	 */
	private JButton btnSair;
	/**
	 * btnVoltar e atributo do EmprestimosForaPrazo
	 */
	private JButton btnVoltar;
	/**
	 * Instancia a biblioteca
	 */
	private Biblioteca biblioteca = Biblioteca.getInstance();

	public EmprestimosForaPrazo(Janela j) {
		setLayout(null);

		this.janela = j;
		this.layout = new CardLayout(0, 0);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 480, 380);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Empréstimo em atraso");
		lblNewLabel.setBounds(150, 6, 200, 16);
		panel.add(lblNewLabel);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(376, 297, 75, 40);
		panel.add(btnSair);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(this);
		btnVoltar.setBounds(283, 297, 81, 40);
		panel.add(btnVoltar);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(6, 71, 454, 191);
		panel.add(scrollPane_1);

		String[] colunas={"Código de barras", "Tipo", "Título", "Número de Leitor", "Nome do Leitor", "Telefone Leitor", "Email Leitor", 
				"Data Empréstimo", "Prazo máximo entrega"};

		Object [][] data=null;
		//cria tabela
		tabela = new JTable(data, colunas);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tabela);

		ArrayList<Emprestimo> emprestimos = biblioteca.consultaEmprestimoExpirado();
		data= new Object[emprestimos.size()][10];

		for (int i = 0; i < emprestimos.size(); i++) {

			Emprestimo emp = emprestimos.get(i);
			Publicacao pub = (Publicacao) emp.getPublicacao();

			this.preencheTabelaEmprestimo();

		}
	}

	/**
	 * Preenche a tabela emprestimo expirados
	 */
	public void preencheTabelaEmprestimo(){

		DefaultTableModel dtm = new DefaultTableModel(0, 0){

			//impede o utilizador de escrever dentro das celulas	
			public boolean isCellEditable(int row, int columns){
				return false;
			}
		};

		// add header of the table
		String[] colunas={"Código de barras", "Tipo", "Título", "Número de Leitor", "Nome do Leitor", "Telefone Leitor", "Email Leitor", 
				"Data Empréstimo", "Prazo máximo entrega"};

		// add header in table model     
		dtm.setColumnIdentifiers(colunas);

		ArrayList<Emprestimo> emprestimos = biblioteca.consultaEmprestimoExpirado();
		Object [][] data= new Object[emprestimos.size()][10];





		for (int i = 0; i < emprestimos.size(); i++) {
			
			Emprestimo emp = emprestimos.get(i);
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date emprestimo = emp.getDataEmp(); 
			Date datadev = emp.dataMaximaEntrega();  
			String dataEmp = df.format(emprestimo);
			String datadevolucao = df.format(datadev);


			Publicacao pub = (Publicacao) emp.getPublicacao();
			dtm.addRow(new Object[] {  pub.getCodBarras(),
					pub.getClass().getSimpleName(),
					pub.getTitulo(),
					emp.getLeitor().getNumLeitor(),
					emp.getLeitor().getNome(),
					emp.getLeitor().getTelefone(),
					emp.getLeitor().getEmail(),
					dataEmp,
					datadevolucao, });

		}

		tabela.setModel(dtm);

	}

	/**
	 * Gera os dados da tabela emprestimo expirados
	 * @return um objeto matriz
	 */
	public Object [][] geraDadosDaTabelaEmprestimosExpirados(){

		ArrayList<Emprestimo> emprestimos = biblioteca.consultaEmprestimoExpirado();
		Object [][] data= new Object[emprestimos.size()][10];

		for (int i = 0; i < emprestimos.size(); i++) {

			Emprestimo emp = emprestimos.get(i);
			Publicacao pub = (Publicacao) emp.getPublicacao();

			data[i][0] = pub.getCodBarras();
			data[i][1] = pub.getClass();
			data[i][2] = pub.getTitulo();
			data[i][3] = emp.getLeitor().getNumLeitor();
			data[i][5] = emp.getLeitor().getNome();
			data[i][6] = emp.getLeitor().getTelefone();
			data[i][7] = emp.getLeitor().getEmail();
			data[i][8] = emp.getDataEmp();
			data[i][9] = emp.dataMaximaEntrega();

		}

		return data;

	}

	/**
	 * actionPerformed dos botoes da classe
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == this.btnSair) {

			janela.sairOK();

		} else if (e.getSource() == this.btnVoltar) {

			janela.bibliotecarioChefeOK();

		}
	}
}
