package pt.uc.dei.ar;

import java.io.Serializable;
import java.util.*;

/**
 * Jornal herda de periodico que herda de publicacao e implementa o Serializable
 *  @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 */
public class Jornal extends Periodico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3200155503690447291L;
	/**
     * Numero de Edicao e um atributo da classe jornal.
     */
    private String numEdicao;
	
	/**
	 * Construtor da classe Jornal
	 * @param titulo
	 * @param dataPublicacao
	 * @param dataReceçao
	 * @param areas
	 * @param periodicidade
	 * @param numEdicao
	 */
	public Jornal(String titulo, String dataPublicacao, String dataReceçao, ArrayList<String> areas,
			Periodicidade periodicidade, String numEdicao) {
		super(titulo, dataPublicacao, dataReceçao, areas, periodicidade);
		
		this.numEdicao = numEdicao;
		
	}

	/**
	 *
	 * @return o numero de edicao em formato inteiro
	 */
	public String getNumEdicao() {
		
		return numEdicao;
		
	}

	/* (non-Javadoc)
	 * Metódo toString é a representação textual do objeto.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "Jornal [titulo=" + getTitulo() + ", dataPublicacao=" + getDataPublicacao() + ", listaDeAreas=" + getListaDeAreas()
				+ ", codBarras=" + getCodBarras() + ", dataReceçao=" + getDataReceçao() + ", periodicidade" + getPeriodicidade() + ", numEdicao=" + numEdicao + "]";
		
	}

}