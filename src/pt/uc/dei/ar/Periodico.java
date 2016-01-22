package pt.uc.dei.ar;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 * Periodico herda de Publicacao e implementa o Serializable
 */
public class Periodico extends Publicacao implements Serializable {

	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = -8255569193119008522L;
	
	/**
     * Periodicidade e atributo do Periodico
     */
    private Periodicidade periodicidade;

	/**
	 * Construtor da classe Periodico
	 * @param titulo titulo
	 * @param dataPublicacao data de publicacao
	 * @param dataRececao data de rececao
	 * @param areas areas
	 * @param periodicidade periodicidade
	 */
	public Periodico(String titulo, String dataPublicacao, String dataRececao, ArrayList<String> areas,
			Periodicidade periodicidade) {
		super(titulo, dataPublicacao, dataRececao, areas);
		
		this.periodicidade = periodicidade;	
		
	}

	/**
	 * Obtem a periodicidade
	 * @return periodicidade Devolve um tipo de periodicidade
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