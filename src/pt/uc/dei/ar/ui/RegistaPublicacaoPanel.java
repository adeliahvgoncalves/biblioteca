package pt.uc.dei.ar.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class RegistaPublicacaoPanel extends JPanel implements ActionListener {
	private JTextField txtTitulo;
	private JTextField txtAreas;
	private JTextField txtAnoPublicacao;
	private JTextField txtDataRecepcao;
	private JTextField txtAutores;
	private JTextField txtNumEdicao;
	private JTextField txtEditor;
	private JTextField txtIsbn;
	private JTextField txtAutor;
	private JTextField txtOrientador;
	
	private JButton btnSair;
	private JButton btnVoltar;
	private JButton btnRegistar;
	
	private Janela janela;
	private CardLayout layout;
	
	private JPanel pnlTipoPublicacao;
	private JPanel pnlTese;
	private JPanel pnlLivro;
	
	private JComboBox comboBox;
	private JTextField txtVolume;
	private JTextField txtNumEdicaoJornal;
	

	/**
	 * Create the panel.
	 */
	public RegistaPublicacaoPanel(Janela j) {
		setLayout(null);
		
		this.janela=j;
		this.layout=new CardLayout(0,0);
		
		JPanel pnlRegistaPublicacao = new JPanel();
		pnlRegistaPublicacao.setBounds(6, 6, 462, 369);
		add(pnlRegistaPublicacao);
		pnlRegistaPublicacao.setLayout(null);
		
		JLabel lblRegistarPublicaes = new JLabel("Registar Publicações");
		lblRegistarPublicaes.setBounds(166, 16, 129, 16);
		pnlRegistaPublicacao.add(lblRegistarPublicaes);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Livro", "Tese", "Revista", "Jornal"}));
		comboBox.addActionListener(this);
		comboBox.setBounds(336, 45, 101, 27);
		pnlRegistaPublicacao.add(comboBox);
		
		JLabel lblTipoDePublicao = new JLabel("Tipo de publicação");
		lblTipoDePublicao.setBounds(205, 49, 119, 16);
		pnlRegistaPublicacao.add(lblTipoDePublicao);
		
		JLabel lblTitulo = new JLabel("Título");
		lblTitulo.setBounds(39, 83, 61, 16);
		pnlRegistaPublicacao.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(151, 78, 286, 26);
		pnlRegistaPublicacao.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblreas = new JLabel("Áreas");
		lblreas.setBounds(39, 111, 61, 16);
		pnlRegistaPublicacao.add(lblreas);
		
		txtAreas = new JTextField();
		txtAreas.setBounds(151, 106, 286, 26);
		pnlRegistaPublicacao.add(txtAreas);
		txtAreas.setColumns(10);
		
		JLabel lblAnoPublicacao = new JLabel("Ano Publicação");
		lblAnoPublicacao.setBounds(38, 139, 101, 16);
		pnlRegistaPublicacao.add(lblAnoPublicacao);
		
		txtAnoPublicacao = new JTextField();
		txtAnoPublicacao.setBounds(151, 134, 130, 26);
		pnlRegistaPublicacao.add(txtAnoPublicacao);
		txtAnoPublicacao.setColumns(10);
		
		JLabel lblDataRecepo = new JLabel("Data Recepção");
		lblDataRecepo.setBounds(38, 167, 101, 16);
		pnlRegistaPublicacao.add(lblDataRecepo);
		
		txtDataRecepcao = new JTextField();
		txtDataRecepcao.setBounds(151, 162, 130, 26);
		pnlRegistaPublicacao.add(txtDataRecepcao);
		txtDataRecepcao.setColumns(10);
		
		//Painel conjunto
		
		this.pnlTipoPublicacao = new JPanel();
		pnlTipoPublicacao.setBounds(6, 189, 450, 127);
		pnlRegistaPublicacao.add(pnlTipoPublicacao);
		pnlTipoPublicacao.setLayout(layout);
		
		
		//Livro
		
		this.pnlLivro = new JPanel();
		pnlLivro.setBounds(6, 6, 438, 115);
		pnlTipoPublicacao.add(pnlLivro, "livro");
		pnlLivro.setLayout(null);
		
		JLabel lblAutores = new JLabel("Autor(es)");
		lblAutores.setBounds(36, 6, 61, 16);
		pnlLivro.add(lblAutores);
		
		txtAutores = new JTextField();
		txtAutores.setBounds(141, 1, 280, 26);
		pnlLivro.add(txtAutores);
		txtAutores.setColumns(10);
		
		JLabel lblNumEdicao = new JLabel("Nº Edição");
		lblNumEdicao.setBounds(36, 34, 61, 16);
		pnlLivro.add(lblNumEdicao);
		
		txtNumEdicao = new JTextField();
		txtNumEdicao.setBounds(141, 29, 130, 26);
		pnlLivro.add(txtNumEdicao);
		txtNumEdicao.setColumns(10);
		
		JLabel lblEditor = new JLabel("Editor");
		lblEditor.setBounds(36, 62, 61, 16);
		pnlLivro.add(lblEditor);
		
		txtEditor = new JTextField();
		txtEditor.setBounds(141, 57, 130, 26);
		pnlLivro.add(txtEditor);
		txtEditor.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(36, 90, 61, 16);
		pnlLivro.add(lblIsbn);
		
		txtIsbn = new JTextField();
		txtIsbn.setBounds(141, 85, 130, 26);
		pnlLivro.add(txtIsbn);
		txtIsbn.setColumns(10);
		
		JPanel pnlPeriodico = new JPanel();
		pnlTipoPublicacao.add(pnlPeriodico, "name_1632122016732");
		pnlPeriodico.setLayout(null);
		
		JComboBox comboBoxPeriodicidade = new JComboBox();
		comboBoxPeriodicidade.setModel(new DefaultComboBoxModel(new String[] {"Diário", "Semanal", "Quinzenal", "Mensal", "Trimestral", "Semestral", "Anual"}));
		comboBoxPeriodicidade.setBounds(299, 6, 134, 27);
		pnlPeriodico.add(comboBoxPeriodicidade);
		
		JLabel lblPeriodicidade = new JLabel("Periodicidade");
		lblPeriodicidade.setBounds(196, 10, 84, 16);
		pnlPeriodico.add(lblPeriodicidade);
		
		JLabel lblVolume = new JLabel("Volume");
		lblVolume.setBounds(38, 46, 61, 16);
		pnlPeriodico.add(lblVolume);
		
		JLabel lblNumEdicaoJornal = new JLabel("Nº Edição");
		lblNumEdicaoJornal.setBounds(38, 79, 61, 16);
		pnlPeriodico.add(lblNumEdicaoJornal);
		
		txtVolume = new JTextField();
		txtVolume.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		txtVolume.setForeground(Color.LIGHT_GRAY);
		txtVolume.setText("revista");
		txtVolume.setBounds(150, 38, 130, 26);
		pnlPeriodico.add(txtVolume);
		txtVolume.setColumns(10);
		
		txtNumEdicaoJornal = new JTextField();
		txtNumEdicaoJornal.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		txtNumEdicaoJornal.setForeground(Color.LIGHT_GRAY);
		txtNumEdicaoJornal.setText("jornal");
		txtNumEdicaoJornal.setBounds(150, 74, 130, 26);
		pnlPeriodico.add(txtNumEdicaoJornal);
		txtNumEdicaoJornal.setColumns(10);
		
		//Tese
		
		this.pnlTese = new JPanel();
		pnlTese.setBounds(6, 6, 438, 115);
		pnlTipoPublicacao.add(pnlTese, "tese");
		pnlTese.setLayout(null);
		
		JComboBox comboBoxTipoTese = new JComboBox();
		comboBoxTipoTese.setModel(new DefaultComboBoxModel(new String[] {"Mestrado", "Doutoramento"}));
		comboBoxTipoTese.setBounds(279, 6, 153, 27);
		pnlTese.add(comboBoxTipoTese);
		
		JLabel lblTipoTese = new JLabel("Tipo de tese");
		lblTipoTese.setBounds(160, 10, 96, 16);
		pnlTese.add(lblTipoTese);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(35, 36, 61, 16);
		pnlTese.add(lblAutor);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(142, 31, 130, 26);
		pnlTese.add(txtAutor);
		txtAutor.setColumns(10);
		
		JLabel lblOrientador = new JLabel("Orientador");
		lblOrientador.setBounds(35, 64, 76, 16);
		pnlTese.add(lblOrientador);
		
		txtOrientador = new JTextField();
		txtOrientador.setBounds(142, 59, 130, 26);
		pnlTese.add(txtOrientador);
		txtOrientador.setColumns(10);
		
		//Butões
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(375, 323, 81, 40);
		pnlRegistaPublicacao.add(btnSair);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(this); 
		btnVoltar.setBounds(282, 323, 81, 40);
		pnlRegistaPublicacao.add(btnVoltar);
		
		btnRegistar = new JButton("Registar");
		btnRegistar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistar.setBounds(27, 323, 95, 40);
		pnlRegistaPublicacao.add(btnRegistar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Falta Colocar o botao do registar e fazer os ultimos dois paineis
		
		
		if (e.getSource() == this.btnSair) {
			
			janela.sairOK();
		}
		
		else if (e.getSource() == this.btnVoltar) {

			janela.bibliotecarioChefeOK();

		} else if (e.getSource() == this.comboBox) {
			
			String str = (String) this.comboBox.getSelectedItem();
			
			if(str.equals("Livro")){
				
				abrePainelLivroOK();
				
			}
			else if(str.equals("Tese")){
				
				abrePainelTeseOK();
			}
			else if(str.equals("Revista")){
				
				
				
			}
			else if(str.equals("Jornal")){
				
				
				
			}
		}
	}
	
	public void abrePainelLivroOK(){
	
		layout.show(pnlTipoPublicacao,"livro");
	
	}
	public void abrePainelTeseOK(){
		
		layout.show(pnlTipoPublicacao,"tese");
		
	}
}
