package pt.uc.dei.ar;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

import pt.uc.dei.ar.ui.Janela;

public class Main {

	public static void main(String[] args) {

		Biblioteca maravilha = Biblioteca.getInstance();

		if (!maravilha.temDados()) {

			//uso do mysingleton, construcao so para ter uma biblioteca

			maravilha.criaBibliotecarioChefe("dio", "João Francisco Sousa Andrade", 1237);
			maravilha.criaColaborador("AAZZ",  "Maria Teresa Boto Santos", 1456);
			maravilha.criaColaborador("AAZA", "Manuela Maria Costa Tavares", 1123);
			maravilha.criaLeitor("MariaMourao", "Maria Gabriela Tomaz Mourao", "25/08/1981", "123456", "Coimbra", "maria@gmail.com", "918989765");
			maravilha.criaLeitor("JC", "Jesus Cristo", "25/12/0000", "1235486", "Coimbra", "maria@gmail.com", "918989765");
			maravilha.criaLeitor("JoaoMiranda", "Joao Jose Da Costa Miranda", "25/12/1967", "12346656", "Coimbra", "maria@gmail.com", "918989765");
			maravilha.criaLeitor("JJ", "Jorge Jesus", "25/08/1946", "1233456", "Coimbra", "maria@gmail.com", "918989765");
			maravilha.criaLeitor("MonicaM", "Monica Maria Marcelino", "25/12/1987", "1253486", "Coimbra", "maria@gmail.com", "918989765");
			maravilha.criaLeitor("RitaMoura", "Rita Mariana Mourao Moura", "25/12/1995", "123556656", "Coimbra", "maria@gmail.com", "918989765");

			ArrayList<String>areas1 = new ArrayList<String>();
			areas1.add("Economia");
			areas1.add("Financas");
			ArrayList<String>area2 = new ArrayList<String>();
			area2.add("Cultura geral");
			area2.add("Informaçao atual");
			ArrayList<String>area3 = new ArrayList<String>();
			area3.add("Saude");
			area3.add("Medicina desportiva");


			maravilha.criaJornal("Diário Económico", "01/01/2016", "02/01/2016", areas1, Periodicidade.Diaria, 2);
			maravilha.criaJornal("Wall Street Journal", "09/01/2016", "10/01/2016",areas1,Periodicidade.Diaria, 9);
			maravilha.criaRevista("Times", "08/01/2016", "10/01/2016", areas1,Periodicidade.Quinzenal, 2);
			maravilha.criaRevista("Forbes", "05/01/2016", "10/01/2016",areas1, Periodicidade.Quinzenal, 1);
			maravilha.criaRevista("The economist", "24/12/2015", "02/01/2016",area2, Periodicidade.Quinzenal, 2);
			maravilha.criaRevista("The week", "12/12/2015", "24/12/2015", area2,Periodicidade.Semanal, 51);

			ArrayList<String>autor1 = new ArrayList<String>();
			autor1.add("Manuel Mota");
			autor1.add("Monica Santos");
			ArrayList<String>autor2 = new ArrayList<String>();
			autor2.add("Carlos Moedas");
			autor2.add("Monica Santos");
			ArrayList<String>autor3 = new ArrayList<String>();
			autor3.add("Carlos Moedas");
			autor3.add("Margarida Martins");
			ArrayList<String>autor4 = new ArrayList<String>();
			autor4.add("Joao Sousa");
			autor4.add("Carlos Santos");
			ArrayList<String>autor5 = new ArrayList<String>();
			autor5.add("Ricardo Gomes");

			maravilha.criaLivro("A moeda e a economia", "12/12/2014", "02/05/2015", autor1, areas1, "1", "12345678912", "Presença");
			maravilha.criaLivro("A face da economia", "01/12/2012", "01/02/2013", autor2, areas1, "1", "12366678912", "Presenca");
			maravilha.criaTese("A outra face da economia", "01/12/2012", "01/02/2013", autor2, area2, "Carlos Pancinhas", TipoDeTese.Mestrado);
			maravilha.criaLivro("O sonho comanda a vida", "12/12/2014", "02/05/2015", autor3, areas1, "1", "12345678912", "Presença");
			maravilha.criaLivro("Under the dome", "01/12/2012", "01/02/2013", autor4, areas1, "1", "12366678912", "Presenca");
			maravilha.criaTese("A influencia da tomada de decisão na qualidade de vida", "01/12/2012", "01/02/2013", autor5, area3, "Carlos Pancinhas", TipoDeTese.Mestrado);
			maravilha.criaLivro("O dinheiro e a pobreza", "12/12/2014", "02/05/2015", autor1, areas1, "1", "12345678912", "Presença");
			maravilha.criaLivro("A evolução da saúde portuguesa", "01/12/2012", "01/02/2013", autor5, areas1, "1", "12366678912", "Presenca");
			maravilha.criaTese("O bacalhau e a economia portuguesa", "01/12/2012", "01/02/2013", autor5, area3, "Carlos Pancinhas", TipoDeTese.Doutoramento);


			//Criar datas random

			Calendar calendar1=Calendar.getInstance();
			calendar1.set(2014, 11, 1);
			Date data1=calendar1.getTime();
			Calendar calendar22=Calendar.getInstance();
			calendar22.set(2014, 11, 18);
			Date data22=calendar22.getTime();
			Calendar calendar2=Calendar.getInstance();
			calendar2.set(2015, 0, 5);
			Date data2=calendar1.getTime();
			Calendar calendar3=Calendar.getInstance();
			calendar3.set(2015, 0, 9);
			Date data3=calendar1.getTime();
			Calendar calendar4=Calendar.getInstance();
			calendar4.set(2015, 1, 6);
			Date data4=calendar4.getTime();
			Calendar calendar5=Calendar.getInstance();
			calendar5.set(2015, 1, 15);
			Date data5=calendar5.getTime();
			Calendar calendar6=Calendar.getInstance();
			calendar6.set(2015, 2, 22);
			Date data6=calendar6.getTime();
			Calendar calendar7=Calendar.getInstance();
			calendar7.set(2015, 2, 28);
			Date data7=calendar7.getTime();
			Calendar calendar8=Calendar.getInstance();
			calendar8.set(2015, 3, 15);
			Date data8=calendar8.getTime();
			Calendar calendar9=Calendar.getInstance();
			calendar9.set(2015, 9, 15);
			Date data9=calendar9.getTime();
			Calendar calendar10=Calendar.getInstance();
			calendar10.set(2015, 9, 23);
			Date data10=calendar10.getTime();
			Calendar calendar11=Calendar.getInstance();
			calendar11.set(2015, 9, 30);
			Date data11=calendar8.getTime();		
			Calendar calendar12=Calendar.getInstance();
			calendar12.set(2015, 10, 30);
			Date data12=calendar12.getTime();
			Calendar calendar13=Calendar.getInstance();
			calendar13.set(2015, 10, 30);
			Date data13=calendar13.getTime();
			Calendar calendar14=Calendar.getInstance();
			calendar14.set(2015, 10, 30);
			Date data14=calendar14.getTime();
			Calendar calendar15=Calendar.getInstance();
			calendar15.set(2016, 01, 07);
			Date data15=calendar15.getTime();
			Calendar calendar16=Calendar.getInstance();
			calendar16.set(2015, 11, 8);
			Date data16=calendar16.getTime();
			Calendar calendar17=Calendar.getInstance();
			calendar17.set(2015, 11, 12);
			Date data17=calendar17.getTime();
			Calendar calendar18=Calendar.getInstance();
			calendar18.set(2015, 11, 16);
			Date data18=calendar18.getTime();
			Calendar calendar19=Calendar.getInstance();
			calendar19.set(2015, 11, 20);
			Date data19=calendar19.getTime();
			Calendar calendar20=Calendar.getInstance();
			calendar20.set(2016, 00, 05);
			Date data20=calendar20.getTime();
			Calendar calendar21=Calendar.getInstance();
			calendar21.set(2016, 00, 15);
			Date data21=calendar21.getTime();


			//Criar emprestimo e devoluçoes

			
			 maravilha.criaEmprestimoaMao(1, data1, 5);
			 maravilha.criaEmprestimoaMao(1, data22, 5);
			 maravilha.criaEmprestimoaMao(3, data1, 14);
			 maravilha.criaEmprestimoaMao(5, data1, 11);
			
			maravilha.devolveEmprestimoAMao(5, data1);
			maravilha.devolveEmprestimoAMao(5, data22);
			maravilha.devolveEmprestimoAMao(14, data22);

			maravilha.criaEmprestimoaMao(4, data2, 5);
			maravilha.criaEmprestimoaMao(3, data3, 5);
			maravilha.criaEmprestimoaMao(2, data2, 14);
			
			maravilha.devolveEmprestimoAMao(11, data2);
			maravilha.devolveEmprestimoAMao(4, data2);
			maravilha.devolveEmprestimoAMao(3, data3);
			maravilha.devolveEmprestimoAMao(2, data4);

		
			maravilha.criaEmprestimoaMao(1, data4, 9);
			
			maravilha.devolveEmprestimoAMao(5, data9);
			maravilha.criaEmprestimoaMao(1, data5, 11);
			maravilha.criaEmprestimoaMao(6, data5, 9);
			
			maravilha.devolveEmprestimoAMao(11, data5);
			maravilha.devolveEmprestimoAMao(9, data5);
			
			maravilha.criaEmprestimoaMao(1, data6, 9);
			maravilha.criaEmprestimoaMao(1, data6, 3);
			
			maravilha.devolveEmprestimoAMao(9, data7);
			maravilha.devolveEmprestimoAMao(3, data8);

			maravilha.criaEmprestimoaMao(1, data9, 9);
			maravilha.devolveEmprestimoAMao(9, data9);
			maravilha.criaEmprestimoaMao(1, data9, 5);
			
			maravilha.devolveEmprestimoAMao(5, data10);
			maravilha.criaEmprestimoaMao(1, data10, 9);
			maravilha.criaEmprestimoaMao(1, data11, 11);
			maravilha.criaEmprestimoaMao(1, data11, 5);
			
			maravilha.devolveEmprestimoAMao(9, data11);
			maravilha.devolveEmprestimoAMao(11, data12);
			maravilha.devolveEmprestimoAMao(5, data12);

			maravilha.criaEmprestimoaMao(1,data12,8);
			
			maravilha.devolveEmprestimoAMao(8, data12);
			maravilha.criaEmprestimoaMao(1,data12,7);
			
			maravilha.devolveEmprestimoAMao(7, data13);
			maravilha.criaEmprestimoaMao (5,data13,5);
			
			maravilha.devolveEmprestimoAMao(5, data14);
			maravilha.criaEmprestimoaMao (5,data14,5);
			
			maravilha.devolveEmprestimoAMao(5, data14);
			maravilha.criaEmprestimoaMao(1, data14, 9);
			
			maravilha.devolveEmprestimoAMao(9, data15);
			
			maravilha.criaEmprestimoaMao(1, data16, 5);
			
			maravilha.devolveEmprestimoAMao(5, data16);
			maravilha.criaEmprestimoaMao(6, data17, 5);
			
			maravilha.devolveEmprestimoAMao(5, data19);
			maravilha.criaEmprestimoaMao(4, data19, 5);
			
			maravilha.devolveEmprestimoAMao(5, data20);
			
			maravilha.criaEmprestimoaMao(2, data17, 9);
			
			maravilha.devolveEmprestimoAMao(9, data18);
			maravilha.criaEmprestimoaMao(3, data19, 9);
			
			maravilha.devolveEmprestimoAMao(9, data19);
			maravilha.criaEmprestimoaMao(1, data18,3);
			
			maravilha.criaEmprestimoaMao(1, data18,4);
			
			maravilha.criaEmprestimoaMao(1, data18,10);
			maravilha.criaEmprestimoaMao(1, data18,6);
			maravilha.devolveEmprestimoAMao(6, data18);
			maravilha.criaEmprestimoaMao(1, data19,8);		
			maravilha.devolveEmprestimoAMao(8, data20);	
			maravilha.criaEmprestimoaMao(2, data20,8);
			maravilha.criaEmprestimoaMao(4, data21,6);	
			maravilha.devolveEmprestimoAMao(6, data21);
			maravilha.criaEmprestimoaMao(6, data21,6);
			
		}


			//Pesquisa por área
			maravilha.pesquisaPorArea("Economia");
			System.out.println("area"+maravilha.pesquisaPorArea("Economia"));

			//Pesquisa os seus emprestimos por numero de leitor
			Leitor leitor= (Leitor) maravilha.pesquisaUtilizadorPorNumLeitor(2);
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


			//testar o gera utilizador e gerar password

			System.out.println("Password"+maravilha.gerarPassword());


			Map<Publicacao, Integer> repeticoesEmprestimos = maravilha.totalEmprestimosPorPublicacaoNoAno();

			for (Map.Entry<Publicacao, Integer> entry : repeticoesEmprestimos.entrySet()) { 

				System.out.println(((Publicacao)entry.getKey()).getTitulo() + ", emprestado " + entry.getValue()+"x"); 
			}

			Map<String, Integer> repeticaoMensal=maravilha.geraMapaRepeticoesMensais(new GregorianCalendar());

			for (Map.Entry<String, Integer> entry : repeticaoMensal.entrySet()) { 

				System.out.println(((String)entry.getKey()) + ", emprestado " + entry.getValue()+"x"); 
			}

			Map<Publicacao,MatematicaFuncoes> diasEmpPorPub=maravilha.obterDiasEmprestimoPorPublicacao(new GregorianCalendar());

			for (Map.Entry<Publicacao,MatematicaFuncoes> entry : diasEmpPorPub.entrySet()) { 

				System.out.println(((String)entry.getKey().getTitulo()) + ", emprestado " + entry.getValue() +"x"); 
			}
		
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