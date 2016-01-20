package pt.uc.dei.ar;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Periodico herda de Publicacao e implementa o Serializable
 *  @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 */
public class Periodico extends Publicacao implements Serializable {

	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = -8255569193119008522L;
	
	/**
     * Periodicidade do periodico
     */
    private Periodicidade periodicidade;

	/**
	 * Construtor da classe Periodico
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
	 * Metodo toString e a representação textual do objeto.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Periodico [periodicidade=" + periodicidade + "]";
	}
}