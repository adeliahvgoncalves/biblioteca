package pt.uc.dei.ar;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

/**
 * 
 * ExportadorCSV é uma classe auxiliar cuja responsabilidade é gerar o relatório
 *
 */
public class ExportadorCSV {
	
	/**
	 * A biblioteca é atributo do exportadorCSV
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
	 * Gera os dados do relatório
	 * @param now
	 * @return um objeto matriz
	 */
	public Object [][] geraDadosDoRelatório(Calendar now){

		ArrayList<Publicacao> publicacoes = this.biblioteca.getListaDePublicacoes();
		Object [][] data= new Object[publicacoes.size()][20];
		Biblioteca biblioteca = this.biblioteca;
		Map<Publicacao,Integer> totalEmprestimosPorPublicacaoNoAno = biblioteca.totalEmprestimosPorPublicacaoNoAno();
		Map<Publicacao,MatemáticaFuncoes> contagensPorPublicacao = biblioteca.obterDiasEmprestimoPorPublicacao(now);
		Map<String, Integer> mapaRepeticoesMensais = biblioteca.geraMapaRepeticoesMensais(now);
		
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
		
		int k;
		Publicacao pub;
		for (int i = 0; i < publicacoes.size(); i++) {
			
			k = 0;
			pub = publicacoes.get(i);
			
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
			MatemáticaFuncoes contagens = contagensPorPublicacao.get(pub);
			
			data[i][k++] = contagens != null ? contagens.getMinimo() : "-";
			data[i][k++] = contagens != null ? contagens.getMaximo() : "-";
			data[i][k++] = contagens != null ? contagens.getMedia() : "-";
			data[i][k++] = pub.getTitulo();
		}

		return data;
	}
	
	/**
	 * Método auxiliar para determinar o mês correspondente a 12 meses atrás
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
			if (i < 12 - 1) {
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
