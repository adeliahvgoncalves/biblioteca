package pt.uc.dei.ar;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 * Livro herda de nao periodico e implementa o requisitavel e o  Serializable
 */
public class Livro extends NaoPeriodico implements Requisitavel, Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -6207854092828194070L;

	/**
	 * Numero de edicao e atributo do Livro.
	 * 
	 */
	private String numEdicao;

	/**
	 * ISBN e atributo do Livro.
	 */
	private String ISBN;

	/**
	 * Editor e atributo do Livro.
	 */
	private String editor;

	/**
	 * Construtor da classe Livro
	 * @param titulo
	 * @param dataPublicacao
	 * @param dataRececao
	 * @param autores
	 * @param areas
	 * @param numEdicao
	 * @param iSBN
	 * @param editor
	 */
	public Livro(String titulo, String dataPublicacao, String dataRececao, ArrayList<String> autores,
			ArrayList<String> areas, String numEdicao, String iSBN, String editor) {
		super(titulo, dataPublicacao, dataRececao, autores, areas);
		
		this.numEdicao = numEdicao;
		this.ISBN = iSBN;
		this.editor = editor;
		
	}

	/**
	 * @return o numero da edicao em formato string
	 */
	public String getNumEdicao() {
		return numEdicao;
	}

	/**
	 * @return o ISBN em formato String
	 */
	public String getISBN() {
		return ISBN;
	}

	/**
	 * @return o editor em formato String
	 */
	public String getEditor() {
		return editor;
	}

	/**
	 *Implementa interface requisitavel
	 * @return o maximo de dias de requisicao em formato inteiro
	 */
	public int maximoDiasRequisicao() {
		return 15;
	}

	/**
	 * Preenche detalhes da publicacao no CSV
	 * @return detalhes da publicacao
	 */
	public String detalhes(){
		return  getListaDeAreas() + ";" + getDataRececao() + "; " + getListaDeAutores() + "; " + numEdicao + ";" + ISBN + ";" + getEditor();
	}
	
	/* (non-Javadoc)
	 *  Metódo toString é a representação textual do objeto.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Livro [titulo=" + getTitulo() + ", dataPublicacao=" + getDataPublicacao() + ", listaDeAreas=" + getListaDeAreas()
		+ ", codBarras=" + getCodBarras() + ", dataReceçao=" + getDataRececao() + ", listaDeAutores=" + getListaDeAutores() + ", numEdicao=" + numEdicao + ", ISBN=" + ISBN + ", editor=" + getEditor() + "]";
	}
}