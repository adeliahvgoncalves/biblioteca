package pt.uc.dei.ar;

import java.io.Serializable;
import java.util.*;

/**
 * @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 * Jornal herda de periodico que herda de publicacao e implementa o Serializable
 */
public class Jornal extends Periodico implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 3200155503690447291L;
	/**
     * Numero de Edicao e um atributo da classe jornal.
     */
    private String numEdicao;
	
	/**
	 * Construtor da classe Jornal
	 * @param titulo titulo do jornal
	 * @param dataPublicacao data de publicacao do jornal
	 * @param dataRececao data de rececao do jornal
	 * @param areas areas do jornal
	 * @param periodicidade periodicidade do jornal
	 * @param numEdicao numero de edicao do jornal
	 */
	public Jornal(String titulo, String dataPublicacao, String dataRececao, ArrayList<String> areas,
			Periodicidade periodicidade, String numEdicao) {
		super(titulo, dataPublicacao, dataRececao, areas, periodicidade);
		
		this.numEdicao = numEdicao;
		
	}

	/**
	 *Obtem o numero de edicao
	 * @return O numero de edicao em formato inteiro
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
				+ ", codBarras=" + getCodBarras() + ", dataReceçao=" + getDataRececao() + ", periodicidade" + getPeriodicidade() + ", numEdicao=" + numEdicao + "]";
		
	}
}