package pt.uc.dei.ar;

import java.io.Serializable;
import java.util.*;

/**
 * Jornal herda de periódico que herda de publicação e implementa o Serializable
 */
public class Jornal extends Periodico implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3200155503690447291L;
	/**
     * Número de Edição é um atributo da classe jornal.
     */
    private int numEdicao;
	



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
			Periodicidade periodicidade, int numEdicao) {
		super(titulo, dataPublicacao, dataReceçao, areas, periodicidade);
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
		return "Jornal [titulo=" + getTitulo() + ", dataPublicacao=" + getDataPublicacao() + ", listaDeAreas=" + getListaDeAreas()
				+ ", codBarras=" + getCodBarras() + ", dataReceçao=" + getDataReceçao() + ", periodicidade" + getPeriodicidade() + ", numEdicao=" + numEdicao + "]";
	}


    

}