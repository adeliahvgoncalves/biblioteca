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
	 * Construtor que dando a lista de inteiros constroi-se 
	 * ja com a media/minimo/maximo
	 * @param maximo
	 * @param minimo
	 * @param media
	 */
	public MatematicaFuncoes(ArrayList<Integer> lista) {

		this.maximo = Collections.max(lista); // faz o maximo
		this.minimo = Collections.min(lista); // faz o maximo
		this.media  = this.calculaMedia(lista);
		
	}

	/**
	 * @return the maximo em formato inteiro
	 */
	public int getMaximo() {
		return maximo;
	}

	/**
	 * @param maximo
	 * the maximo to set
	 */
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	/**
	 * @return the minimo em formato inteiro
	 */
	public int getMinimo() {
		return minimo;
	}

	/**
	 * @param minimo
	 * the minimo to set
	 */
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	/**
	 * @return the media em formato double
	 */
	public int getMedia() {
		return media;
	}

	/**
	 * @param media
	 * the media to set
	 */
	public void setMedia(int media) {
		this.media = media;
	}

	/**
	 * Calcula a media da lista fornecida
	 * @param list
	 * @return media em formato double
	 */
<<<<<<< HEAD
	private double calculaMedia(ArrayList<Integer> list) {
		double sum = 0.00;
=======
	private int calculaMedia(ArrayList<Integer> list) {
		int sum = 0;
>>>>>>> origin/master

		if (list == null || list.size() == 0) {

			return sum;
		}
		for (Integer i : list) {
			sum += i;
		}
		
<<<<<<< HEAD
		return Math.ceil(sum / list.size());
=======
		return Math.round(sum / list.size());
>>>>>>> origin/master
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
