package pt.uc.dei.ar;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Biblioteca faculdadeNova= new Biblioteca();
		
		faculdadeNova.criaBibliotecarioChefe("abc", "123", "João Francisco Sousa Andrade", 1237);
		faculdadeNova.criaColaborador("AAZZ", "123", "Maria Teresa Boto Santos", 1456);
		faculdadeNova.criaColaborador("AAZA", "124", "Manuela Maria Costa Tavares", 1123);
		faculdadeNova.criaLeitor("AAA", "123", "Maria Gabriela Tomaz Mourao", "25/08/1981", "123456", "Coimbra", "maria@gmail.com", "918989765");
		faculdadeNova.criaLeitor("AAB", "123", "Jesus Cristo", "25/12/0000", "123456", "Coimbra", "maria@gmail.com", "918989765");
		
		ArrayList<String>areasDiarioEconomico = new ArrayList<String>();
		areasDiarioEconomico.add("Economia");
		areasDiarioEconomico.add("Financas");
		ArrayList<String>areasRevista = new ArrayList<String>();
		areasRevista.add("Cultura geral");
		areasRevista.add("Informaçao atual");
		
		faculdadeNova.criaJornal("Diário Económico", "01/01/2016", "02/01/2016", areasDiarioEconomico, Periodicidade.Diaria, 2);
		faculdadeNova.criaJornal("Wall Street Journal", "09/01/2016", "10/01/2016",areasDiarioEconomico,Periodicidade.Diaria, 9);
		faculdadeNova.criaRevista("Times", "08/01/2016", "10/01/2016", areasDiarioEconomico,Periodicidade.Quinzenal, 2);
		faculdadeNova.criaRevista("Forbes", "05/01/2016", "10/01/2016",areasDiarioEconomico, Periodicidade.Quinzenal, 1);
		faculdadeNova.criaRevista("The economist", "24/12/2015", "02/01/2016",areasRevista, Periodicidade.Quinzenal, 2);
		faculdadeNova.criaRevista("The week", "12/12/2015", "24/12/2015", areasRevista,Periodicidade.Semanal, 51);
		
		ArrayList<String>autor1 = new ArrayList<String>();
		autor1.add("Manuel Mota");
		autor1.add("Monica Santos");
		
		ArrayList<String>autor2 = new ArrayList<String>();
		autor2.add("Carlos Moedas");
		autor2.add("Monica Santos");
		
		faculdadeNova.criaLivro("A moeda e a economia", "12/12/2014", "02/05/2015", autor1, areasDiarioEconomico, "1", "12345678912", "Presença");
		faculdadeNova.criaLivro("A face da economia", "01/12/2012", "01/02/2013", autor2, areasDiarioEconomico, "1", "12366678912", "Presenca");
		
		faculdadeNova.criaTese("A outra face da economia", "01/12/2012", "01/02/2013", autor2, areasRevista, "Carlos Pancinhas", TipoDeTese.Mestrado);
		
		System.out.println(faculdadeNova);
		
		//Criar emprestimo
	//	faculdadeNova.criaEmprestimo(1, 5);
	//	faculdadeNova.criaEmprestimo(1, 9);
	//	faculdadeNova.criaEmprestimo(1, 1);
	//	System.out.println(faculdadeNova);
		
		//Devolve emprestimo
	//	faculdadeNova.devolveEmprestimo(5);
		
		
		//LEITOR
		//TODO: Consultar lista total de publicações
		
		//Pesquisa por área
		faculdadeNova.pesquisaPorArea("Economia");
		System.out.println(faculdadeNova.pesquisaPorArea("Economia"));
		
		//Pesquisa os seus emprestimos
		
		
		
		//Bibliotecario-chefe
		
		//Consultar informação de uma publicação por nome ou codigo de barras
		faculdadeNova.pesquisaPublicacaoComParteNome("A moeda");
		System.out.println(faculdadeNova.pesquisaPublicacaoComParteNome("A moeda"));
		faculdadeNova.pesquisaPublicacaoPorCodBarras(4);
		System.out.print(faculdadeNova.pesquisaPublicacaoPorCodBarras(4));
		
		//Consultar os empréstimos que já deviam ter sido devolvidos
		faculdadeNova.consultaEmprestimoExpirado();
		
		
		
		
		
	}
}
