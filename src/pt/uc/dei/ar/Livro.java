package pt.uc.dei.ar;

import java.util.Date;

/**
 * A classe livro herda da classe não periódico e implementa o requisitável.
 */
public class Livro extends NaoPeriodico implements Requisitavel {

	
	/**
     * O número de edição é um atributo da classe livro.
     * 
     */
    private String numEdicao;

    /**
     * O ISBN é um atributo da classe livro.
     */
    private String ISBN;

    /**
     * O editor é um atributo da classe livro.
     */
    private String editor;

    

    /**
     * A inicialização dos atributos da classe:
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
	 *  Método que permite aceder ao número de edição respeitando o encapsulamento.
	 * @return the numEdicao
	 */
	public String getNumEdicao() {
		return numEdicao;
	}




	/**
	 * Método que permite aceder ao ISBN respeitando o encapsulamento.
	 * @return the iSBN
	 */
	public String getISBN() {
		return ISBN;
	}




	/**
	 * Método que permite aceder ao editor respeitando o encapsulamento.
	 * @return the editor
	 */
	public String getEditor() {
		return editor;
	}

	
	/**
	 * Método que implementa a interface. Definido prazo de 15 dias de
	 * empréstimo do livro.
     * @return
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