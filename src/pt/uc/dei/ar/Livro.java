package pt.uc.dei.ar;

import java.util.Date;

/**
 * Livro herda de não periódico e implementa o requisitável.
 */
public class Livro extends NaoPeriodico implements Requisitavel {

	
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
	 * @param codBarras
	 * @param dataReceçao
	 * @param numEdicao
	 * @param iSBN
	 * @param editor
	 */
	public Livro(String titulo, Date dataPublicacao, int codBarras, Date dataReceçao, String numEdicao, String iSBN,
			String editor) {
		super(titulo, dataPublicacao, codBarras, dataReceçao);
		this.numEdicao = numEdicao;
		ISBN = iSBN;
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
		return "Livro [numEdicao=" + numEdicao + ", ISBN=" + ISBN + ", editor=" + editor + "]";
	}
    
    

}