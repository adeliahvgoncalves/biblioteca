package pt.uc.dei.ar;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Livro herda de não periódico e implementa o requisitável.
 */
public class Livro extends NaoPeriodico implements Requisitavel, Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6207854092828194070L;

	/**
     * Número de edição do livro.
     * 
     */
    private String numEdicao;

    /**
     * ISBN do livro.
     */
    private String ISBN;

    /**
     * Editor do livro.
     */
    private String editor;

    

	

	/**
	 * Construtor da classe Livro
	 * @param titulo
	 * @param dataPublicacao
	 * @param dataReceçao
	 * @param autores
	 * @param areas
	 * @param numEdicao
	 * @param iSBN
	 * @param editor
	 */
	public Livro(String titulo, String dataPublicacao, String dataReceçao, ArrayList<String> autores,
			ArrayList<String> areas, String numEdicao, String iSBN, String editor) {
		super(titulo, dataPublicacao, dataReceçao, autores, areas);
		this.numEdicao = numEdicao;
		this.ISBN = iSBN;
		this.editor = editor;
	}




	/**
	 *  
	 * @return o número da edição em formato string
	 */
	public String getNumEdicao() {
		return numEdicao;
	}




	/**
	 *
	 * @return o ISBN em formato String
	 */
	public String getISBN() {
		return ISBN;
	}




	/**
	 * 
	 * @return o editor em formato String
	 */
	public String getEditor() {
		return editor;
	}

	
	/**
	 Implementa interface requisitável
     * @return o máximo de dias de requisição em formato inteiro
     */
    public int maximoDiasRequisicao() {
        return 15;
    }

    



	/* (non-Javadoc)
	 *  Metódo toString é a representação textual do objeto.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Livro [titulo=" + getTitulo() + ", dataPublicacao=" + getDataPublicacao() + ", listaDeAreas=" + getListaDeAreas()
				+ ", codBarras=" + getCodBarras() + ", dataReceçao=" + getDataReceçao() + ", listaDeAutores=" + getListaDeAutores() + ", numEdicao=" + numEdicao + ", ISBN=" + ISBN + ", editor=" + editor + "]";
	}
    
    

}