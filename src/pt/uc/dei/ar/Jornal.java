package pt.uc.dei.ar;

import java.util.*;

/**
 * Jornal herda de periódico que herda de publicação.
 */
public class Jornal extends Periodico {

	
	/**
     * Número de Edição é um atributo da classe jornal.
     */
    private int numEdicao;
	

    /**
     * Construtor da classe Jornal
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
	 *
	 * @return o número de edição em formato inteiro
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