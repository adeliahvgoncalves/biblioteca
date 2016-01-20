package pt.uc.dei.ar;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

/**
 * 
 * ExportadorCSV e uma classe auxiliar cuja responsabilidade e gerar o relatório
 * @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 */
public class ExportadorCSV {

	/**
	 * A biblioteca e atributo do exportadorCSV
	 */
	private Biblioteca biblioteca;



	/**
	 * Construtor do ExportadorCSV:
	 * @param biblioteca
	 */
	public ExportadorCSV(Biblioteca biblioteca) {
		super();
		this.biblioteca = biblioteca;
	}

	/**
	 * Gera os dados do relatorio
	 * @param now
	 * @return um objeto matriz
	 */
	public Object [][] geraDadosDoRelatório(Calendar now){

	
		ArrayList<Publicacao> publicacoes = this.biblioteca.getListaDePublicacoes();
		ArrayList<Publicacao> publicacoesSemJornal=new ArrayList<Publicacao>();
		for (Publicacao publicacao : publicacoes) {
			if(publicacao instanceof Livro || publicacao instanceof Tese || publicacao instanceof Revista){
				
				publicacoesSemJornal.add(publicacao);
			}
			
		}
		Object [][] data= new Object[publicacoesSemJornal.size()][20];
		Biblioteca biblioteca = this.biblioteca;
		Map<Publicacao,Integer> totalEmprestimosPorPublicacaoNoAno = biblioteca.totalEmprestimosPorPublicacaoNoAno();
		Map<Publicacao,MatematicaFuncoes> contagensPorPublicacao = biblioteca.obterDiasEmprestimoPorPublicacao(now);
		Map<String, Integer> mapaRepeticoesMensais = biblioteca.geraMapaRepeticoesMensais(now);

		DateFormat formatter = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());

		int k;
		Publicacao pub;

		for (int i = 0; i < publicacoesSemJornal.size(); i++) {

			k = 0;
			pub = publicacoesSemJornal.get(i);

			if(pub instanceof Livro || pub instanceof Tese || pub instanceof Revista){

				data[i][k++] = pub.getCodBarras();
				data[i][k++] = pub.getTitulo();
				data[i][k++] = formatter.format(pub.getDataPublicacao());

				// Preenche dados dos meses usando o mapa de repeticoes
				int mesAtual = this.indiceDoMesDoAnoAnterior(now);
				int indiceTemp = k;
				for (int j = indiceTemp; j < indiceTemp + 12; j++) {
					String chavePublicacaoMes = pub.getCodBarras()+"-"+mesAtual;
					Integer repeticoes = mapaRepeticoesMensais.get(chavePublicacaoMes);
					data[i][j] = repeticoes != null ? repeticoes : "0";
					mesAtual = (mesAtual+1) % 12;
					k++;
				}

				Integer total = totalEmprestimosPorPublicacaoNoAno.get(pub);
				data[i][k++] = total != null ? total : "0";
				MatematicaFuncoes contagens = contagensPorPublicacao.get(pub);

				data[i][k++] = contagens != null ? contagens.getMinimo() : "-";
				data[i][k++] = contagens != null ? contagens.getMaximo() : "-";
				data[i][k++] = contagens != null ? contagens.getMedia() : "-";
				if(pub instanceof Revista){
					data[i][k++] = ((Revista) pub).detalhes();
				} else if(pub instanceof Livro){
					data[i][k++] = ((Livro) pub).detalhes();
				}
				else if(pub instanceof Tese){
					data[i][k++] = ((Tese) pub).detalhes();
				}
			}
		}
		return data;
	}

	/**
	 * Metodo auxiliar para determinar o mes correspondente a 12 meses atras
	 * @param now
	 * @return mesAtual em formato inteiro
	 */
	private int indiceDoMesDoAnoAnterior(Calendar now){

		Calendar dataAnoAnterior = (Calendar) now.clone();
		dataAnoAnterior.set(Calendar.MONTH, -12);
		int mesAtual = dataAnoAnterior.get(Calendar.MONTH);
		return mesAtual;
	}

	/**
	 * Gera o CSV
	 * @param now
	 * @return builder em formato string
	 */
	public String geraCSV(Calendar now){

		StringBuilder builder = new StringBuilder("");

		builder.append("Código de barras,"+ "Título,"+ "Data publicacao,");

		int mesAtual = this.indiceDoMesDoAnoAnterior(now);
		for (int i = 0; i < 12; i++) {
			mesAtual = mesAtual + 1 % 12;
			builder.append("Mês "+ mesAtual);
			if (i < 12 ) {
				builder.append(",");
			}
		}

		builder.append("Total empréstimos último ano,"+ "Duraçao mínima empréstimo,"+ 
				"Duração máxima empréstimo,"+ "Duração média empréstimo,"+ 
				"Detalhes da publicação\n");

		Object [][] csv = this.geraDadosDoRelatório(now);
		for (int i = 0; i < csv.length; i++) {
			for (int j = 0; j < csv[0].length; j++) {
				builder.append(csv[i][j]);
				if (j < csv[0].length - 1) {
					builder.append(",");
				}
			}
			builder.append("\n");
		}
		return builder.toString();
	}

}
