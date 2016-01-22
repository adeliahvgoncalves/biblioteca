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
	 * @param titulo titulo do livro
	 * @param dataPublicacao data de publicacao do livro
	 * @param dataRececao data de rececao do livro
	 * @param autores autores do livro
	 * @param areas areas  do livro
	 * @param numEdicao numero de edicao do livro
	 * @param iSBN ISBN do livro
	 * @param editor editor do livro
	 */
	public Livro(String titulo, String dataPublicacao, String dataRececao, ArrayList<String> autores,
			ArrayList<String> areas, String numEdicao, String iSBN, String editor) {
		super(titulo, dataPublicacao, dataRececao, autores, areas);
		
		this.numEdicao = numEdicao;
		this.ISBN = iSBN;
		this.editor = editor;
		
	}

	/**
	 * Obtem o numeor de edicao
	 * @return O numero da edicao em formato string
	 */
	public String getNumEdicao() {
		return numEdicao;
	}

	/**
	 * Obtem o ISBN
	 * @return O ISBN em formato String
	 */
	public String getISBN() {
		return ISBN;
	}

	/**
	 * Obtem o editor
	 * @return O editor em formato String
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
	 * @return Detalhes da publicacao
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