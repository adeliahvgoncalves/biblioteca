package pt.uc.dei.ar;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import ui.Janela;

public class Main {

	public static void main(String[] args) {
		
		//uso do mysingleton, construcao so para ter uma biblioteca
		Biblioteca maravilha= Biblioteca.getInstance();
		
		maravilha.criaBibliotecarioChefe("dio", "123", "João Francisco Sousa Andrade", 1237);
		maravilha.criaColaborador("AAZZ", "123", "Maria Teresa Boto Santos", 1456);
		maravilha.criaColaborador("AAZA", "124", "Manuela Maria Costa Tavares", 1123);
		maravilha.criaLeitor("AAA", "123", "Maria Gabriela Tomaz Mourao", "25/08/1981", "123456", "Coimbra", "maria@gmail.com", "918989765");
		maravilha.criaLeitor("AAB", "123", "Jesus Cristo", "25/12/0000", "123456", "Coimbra", "maria@gmail.com", "918989765");
		maravilha.criaLeitor("AAC", "123", "Joao Jose Da Costa Miranda", "25/12/0000", "1236656", "Coimbra", "maria@gmail.com", "918989765");
	
		ArrayList<String>areasDiarioEconomico = new ArrayList<String>();
		areasDiarioEconomico.add("Economia");
		areasDiarioEconomico.add("Financas");
		ArrayList<String>areasRevista = new ArrayList<String>();
		areasRevista.add("Cultura geral");
		areasRevista.add("Informaçao atual");
		
		maravilha.criaJornal("Diário Económico", "01/01/2016", "02/01/2016", areasDiarioEconomico, Periodicidade.Diaria, 2);
		maravilha.criaJornal("Wall Street Journal", "09/01/2016", "10/01/2016",areasDiarioEconomico,Periodicidade.Diaria, 9);
		maravilha.criaRevista("Times", "08/01/2016", "10/01/2016", areasDiarioEconomico,Periodicidade.Quinzenal, 2);
		maravilha.criaRevista("Forbes", "05/01/2016", "10/01/2016",areasDiarioEconomico, Periodicidade.Quinzenal, 1);
		maravilha.criaRevista("The economist", "24/12/2015", "02/01/2016",areasRevista, Periodicidade.Quinzenal, 2);
		maravilha.criaRevista("The week", "12/12/2015", "24/12/2015", areasRevista,Periodicidade.Semanal, 51);
		
		ArrayList<String>autor1 = new ArrayList<String>();
		autor1.add("Manuel Mota");
		autor1.add("Monica Santos");
		
		ArrayList<String>autor2 = new ArrayList<String>();
		autor2.add("Carlos Moedas");
		autor2.add("Monica Santos");
		
		maravilha.criaLivro("A moeda e a economia", "12/12/2014", "02/05/2015", autor1, areasDiarioEconomico, "1", "12345678912", "Presença");
		maravilha.criaLivro("A face da economia", "01/12/2012", "01/02/2013", autor2, areasDiarioEconomico, "1", "12366678912", "Presenca");
		
		maravilha.criaTese("A outra face da economia", "01/12/2012", "01/02/2013", autor2, areasRevista, "Carlos Pancinhas", TipoDeTese.Mestrado);
		
		System.out.println(maravilha);
		
		//Criar emprestimo
		maravilha.criaEmprestimo(1, 5);
		maravilha.criaEmprestimo(1, 9);
		
		
		//Criar emprestimos random
	
		
		Calendar calendar1=Calendar.getInstance();
		calendar1.set(2015, 11, 1);
		Date data1=calendar1.getTime();
		Calendar calendar2=Calendar.getInstance();
		calendar2.set(2016, 0, 1);
		Date data2=calendar1.getTime();
		
		Leitor leitor2=new Leitor("ABC", "123", "Manuel dos Santos", "12/09/2000", "1234567", "Coimbra", "manuel@gmail.com", "23453672");
		maravilha.adicionaUtilizador(leitor2);
		Revista revista1=new Revista("Normal", "12/09/2015", "12/11/2015", areasRevista, Periodicidade.Diaria, 345);		
		maravilha.adicionaPublicacao(revista1);	
		//como fazer?
		//Emprestimo em1=new Emprestimo(faculdadeNova.getListaDeUtilizadores().get(3), data1, 7);
		Emprestimo em3=new Emprestimo(leitor2, data1, revista1);
		maravilha.adicionaEmprestimo(em3);
		
		
		//testei que nao empresta jornal:
		//faculdadeNova.criaEmprestimo(1, 1);
		System.out.println("com emprestimo"+maravilha);
		
		
		//Devolve emprestimo
		maravilha.devolveEmprestimo(5);
		System.out.println("devolvidos"+maravilha);
		
		//LEITOR
		maravilha.imprimeListaTotalPublicacoes();	
	
		
		//Pesquisa por área
		maravilha.pesquisaPorArea("Economia");
		System.out.println(maravilha.pesquisaPorArea("Economia"));
		
		//Pesquisa os seus emprestimos por numero de leitor
		Leitor leitor= (Leitor) maravilha.pesquisaUtilizadorPorNumLeitor(1);
		leitor.getListaDeEmprestimo();
		System.out.println("Emprestimos do leitor" +leitor.getNome()+leitor.getListaDeEmprestimo());
		
		
		
		//Bibliotecario-chefe
		
		//Consultar informação de uma publicação por nome ou codigo de barras
//		faculdadeNova.pesquisaPublicacaoComParteNome("A moeda");
//		System.out.println(faculdadeNova.pesquisaPublicacaoComParteNome("A moeda"));
//		faculdadeNova.pesquisaPublicacaoPorCodBarras(4);
//		System.out.print(faculdadeNova.pesquisaPublicacaoPorCodBarras(4));
		
		//Consultar os empréstimos que já deviam ter sido devolvidos
		maravilha.consultaEmprestimoExpirado();
		System.out.println("Emprestimos expirados:" +leitor.getListaDeEmprestimo());
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
