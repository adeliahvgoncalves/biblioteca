package pt.uc.dei.ar;

import java.io.Serializable;
import java.util.*;

/**
 * Periódico herda de Publicação e implementa o Serializable
 */
public class Periodico extends Publicacao implements Serializable {

	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = -8255569193119008522L;
	/**
     * Periodicidade do periódico
     */
    private Periodicidade periodicidade;

	

	/**
	 * Construtor da classe Periódico
	 * @param titulo
	 * @param dataPublicacao
	 * @param dataReceçao
	 * @param areas
	 * @param periodicidade
	 */
	public Periodico(String titulo, String dataPublicacao, String dataReceçao, ArrayList<String> areas,
			Periodicidade periodicidade) {
		super(titulo, dataPublicacao, dataReceçao, areas);
		this.periodicidade = periodicidade;
	}




	/**
	 * 
	 * @return periodicidade devolve um tipo de periodicidade
	 */
	public Periodicidade getPeriodicidade() {
		return periodicidade;
	}




	/* (non-Javadoc)
	 * Metódo toString é a representação textual do objeto.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Periodico [periodicidade=" + periodicidade + "]";
	}



	
}