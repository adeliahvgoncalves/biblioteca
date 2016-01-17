package pt.uc.dei.ar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Estrutura de apoio ao calculo de media/maximo/minimo 
 * de emprestimos de uma Publicacao
 * 
 * @author adelia
 *
 */
public class ContagensPublicacao {

	private int maximo;
	private int minimo;
	private double media;
	
	/**
	 * Construtor que dando a lista de inteiros constroi-se 
	 * já com a media/minimo/maximo
	 * 
	 * @param maximo
	 * @param minimo
	 * @param media
	 */
	public ContagensPublicacao(ArrayList<Integer> lista) {
		super();
		this.maximo =  Collections.max(lista); // faz o maximo
		this.minimo = Collections.min(lista); // faz o maximo
		this.media  = this.calculaMedia(lista);
	}
	
	/**
	 * @return the maximo
	 */
	public int getMaximo() {
		return maximo;
	}
	/**
	 * @param maximo the maximo to set
	 */
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
	/**
	 * @return the minimo
	 */
	public int getMinimo() {
		return minimo;
	}
	/**
	 * @param minimo the minimo to set
	 */
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}
	/**
	 * @return the media
	 */
	public double getMedia() {
		return media;
	}
	/**
	 * @param media the media to set
	 */
	public void setMedia(double media) {
		this.media = media;
	}
	
	
	/**
	 * Calcula a media da lista fornecida
	 * 
	 * @param list
	 * @return
	 */
	private double calculaMedia(ArrayList<Integer> list){
		double sum = 0.0;
		if (list == null|| list.size() == 0) {
			return sum;
		}
		for( Integer i : list) {
		  sum += i;
		}
		return sum / list.size();		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ContagensPublicacao [maximo=" + maximo + ", minimo=" + minimo + ", media=" + media + "]";
	}
	
	
}
