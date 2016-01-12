package pt.uc.dei.ar.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import pt.uc.dei.ar.Biblioteca;
import pt.uc.dei.ar.Periodicidade;

public class Table extends JPanel {
	
	JTable tabela;
	//Biblioteca biblioteca = Biblioteca.getInstance();
	
	public Table(){
		
		setLayout(new FlowLayout());
		
		String[] colunas={"Código", "Tipo", "Título", "Autor(es)", "Data Publicacao", "Data Receçao" , "Áreas", 
				"Periocidade" ,"Volume"," Nº Sequencial", "Nª Edição", "Orientador", "Tipo de Tese", "Editor", "ISBN"
				};
		
		Object [][] data= new Object[Biblioteca.getInstance().getListaDePublicacoes().size()][15];
		
		tabela=new JTable(data, colunas);
		tabela.setPreferredScrollableViewportSize(new Dimension(450, 190));
		tabela.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(tabela);
		add(scrollPane);
		
	}
	
	

}
