package pt.uc.dei.ar;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 * Estrutura de apoio ao calculo de media/maximo/minimo 
 * de emprestimos de uma Publicacao
 *
 */
public class MatematicaFuncoes {

	/**
	 * Maximo e atributo da classe MatematicaFuncoes
	 */
	private int maximo;

	/**
	 * Minimo e atributo da classe MatematicaFuncoes
	 */
	private int minimo;

	/**
	 * Media e atributo da classe MatematicaFuncoes
	 */
	private int media;

	/**
	 *  Construtor que dando a lista de inteiros constroi-se 
	 * ja com a media/minimo/maximo
	 * @param lista lista
	 */
	public MatematicaFuncoes(ArrayList<Integer> lista) {

		this.maximo = Collections.max(lista); // faz o maximo
		this.minimo = Collections.min(lista); // faz o maximo
		this.media  = this.calculaMedia(lista);
		
	}

	/**
	 * Obtem o maximo
	 * @return the maximo em formato inteiro
	 */
	public int getMaximo() {
		return maximo;
	}

	/**
	 * Altera o maximo
	 * @param maximo
	 * the maximo to set
	 */
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	/**
	 * Obtem o minimo
	 * @return The minimo em formato inteiro
	 */
	public int getMinimo() {
		return minimo;
	}

	/**
	 * Altera o minimo
	 * @param minimo
	 * the minimo to set
	 */
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	/**
	 * Obtem a media
	 * @return the media em formato double
	 */
	public int getMedia() {
		return media;
	}

	/**
	 * Altera a media
	 * @param media
	 * the media to set
	 */
	public void setMedia(int media) {
		this.media = media;
	}

	/**
	 * Calcula a media da lista fornecida
	 * @param list lista
	 * @return media em formato double
	 */

	private int calculaMedia(ArrayList<Integer> list) {
		int sum = 0;


		if (list == null || list.size() == 0) {

			return sum;
		}
		for (Integer i : list) {
			sum += i;
		}

		return Math.round(sum / list.size());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ContagensPublicacao [maximo=" + maximo + ", minimo=" + minimo + ", media=" + media + "]";
	}
}
