package pt.uc.dei.ar;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import pt.uc.dei.ar.ui.Janela;

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
		//maravilha.criaEmprestimo(1, 5);


		//Criar emprestimos random


		Calendar calendar1=Calendar.getInstance();
		calendar1.set(2015, 11, 1);
		Date data1=calendar1.getTime();
		Calendar calendar2=Calendar.getInstance();
		calendar2.set(2015, 10, 1);
		Date data2=calendar2.getTime();
		Calendar calendar3=Calendar.getInstance();
		calendar3.set(2015, 11, 18);
		Date data3=calendar3.getTime();
		Calendar calendar7=Calendar.getInstance();
		calendar7.set(2015, 11, 18);
		Date data7=calendar7.getTime();


		Leitor leitor2=new Leitor("ABC", "123", "Manuel dos Santos", "12/09/2000", "1234567", "Coimbra", "manuel@gmail.com", "23453672");
		maravilha.adicionaUtilizador(leitor2);
		Revista revista1=new Revista("Normal", "12/09/2015", "12/11/2015", areasRevista, Periodicidade.Diaria, 345);		
		maravilha.adicionaPublicacao(revista1);	
		System.out.println("revista1"+revista1.getCodBarras());	
		Revista revista2=new Revista("NormalMEnte", "12/09/2015", "12/11/2015", areasRevista, Periodicidade.Diaria, 345);
		maravilha.adicionaPublicacao(revista2);	
		
		//crio emprestimo
		Emprestimo em3=new Emprestimo(leitor2, data1, revista1);
		maravilha.adicionaEmprestimo(em3);
		Emprestimo em4=new Emprestimo(leitor2, data2, revista1);
		maravilha.adicionaEmprestimo(em3);
		Emprestimo em5=new Emprestimo(leitor2, data3, revista1);
		maravilha.adicionaEmprestimo(em3);
		Emprestimo em7=new Emprestimo(leitor2, data7, revista2);
		maravilha.adicionaEmprestimo(em7);
		
		//crio devolucao

		Calendar calendar4=Calendar.getInstance();
		calendar4.set(2015, 11, 6);
		Date data4=calendar4.getTime();
		Calendar calendar5=Calendar.getInstance();
		calendar5.set(2015, 10, 9);
		Date data5=calendar5.getTime();
		Calendar calendar6=Calendar.getInstance();
		calendar6.set(2015, 11, 22);
		Date data6=calendar6.getTime();
		maravilha.devolveEmprestimoAMao(10, data4);
		maravilha.devolveEmprestimoAMao(10, data5);
		maravilha.devolveEmprestimoAMao(10, data6);

	//	maravilha.diasDeEmprestimo(em4);

		//testei que nao empresta jornal:
		//faculdadeNova.criaEmprestimo(1, 1);
		System.out.println("com emprestimo"+maravilha);


		//Devolve emprestimo
		maravilha.devolveEmprestimo(5);
		System.out.println("devolvidos"+maravilha);
		maravilha.devolveEmprestimo(5);
		System.out.println("devolvidos2"+maravilha);

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
		ArrayList<Emprestimo> emprestimosExpirados = maravilha.consultaEmprestimoExpirado();
		System.out.println("Emprestimos expirados:" +emprestimosExpirados);

		//Emprestimos do leitor
		System.out.println("Emprestimos do leitor:" +leitor.getNome()+leitor.getListaDeEmprestimo());


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
