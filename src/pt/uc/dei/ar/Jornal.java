package pt.uc.dei.ar;

import java.util.*;

/**
 * A classe jornal herda da classe periódico que por sua vez herda de publicação.
 */
public class Jornal extends Periodico {

	
	/**
     * O número de Edição é um atributo da classe jornal.
     */
    private int numEdicao;

   
	

    /**
     * A inicialização dos atributos da classe:
	 * @param titulo
	 * @param dataPublicacao
	 * @param codBarras
	 * @param dataReceçao
	 * @param periodicidade
	 * @param numEdicao
	 */
	public Jornal(String titulo, Date dataPublicacao, int codBarras, Date dataReceçao, Periodicidade periodicidade,
			int numEdicao) {
		super(titulo, dataPublicacao, codBarras, dataReceçao, periodicidade);
		this.numEdicao = numEdicao;
	}




	/**
	 * Método que permite aceder ao número da edição respeitando o encapsulamento.
	 * @return the numEdicao
	 */
	public int getNumEdicao() {
		return numEdicao;
	}




	/* (non-Javadoc)
	 * Metódo toString é a representação textual do objeto.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Jornal [numEdicao=" + numEdicao + "]";
	}


    

}