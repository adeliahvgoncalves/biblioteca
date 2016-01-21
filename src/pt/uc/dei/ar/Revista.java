package pt.uc.dei.ar;

import java.io.Serializable;
import java.util.*;

/**
 *  @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 * Revista herda do periodico que por sua vez herda de publicacao
 * Implementa a interface requisitavel, portanto, pode ser emprestada
 * e implementa o Serializable
 */
public class Revista extends Periodico implements Requisitavel, Serializable {

	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = -4452420023882536318L;

	/**
	 *  Volume e atributo da Revista
	 * 
	 */
	private String volume;

	/**
	 * Numero e atributo sequencial da Revista
	 */
	private int numeroSequencial;

	/**
	 * e criada esta variavel para facilitar a criacao do numero sequencial
	 */
	private static int ultimonumeroSequencial=0;

	/**
	 * Construtor da classe Revista
	 * @param titulo
	 * @param dataPublicacao
	 * @param dataRececao
	 * @param areas
	 * @param periodicidade
	 * @param volume
	 * @param numeroSequencial
	 */
	public Revista(String titulo, String dataPublicacao, String dataRececao, ArrayList<String> areas,
			Periodicidade periodicidade, String volume) {
		super(titulo, dataPublicacao, dataRececao, areas, periodicidade);
		
		ultimonumeroSequencial++;
		this.numeroSequencial = ultimonumeroSequencial;
		
	}

	/**
	 * @return o volume em formato inteiro
	 */
	public String getVolume() {
		return volume;
	}

	/**
	 * @return o numero sequencial em formato inteiro
	 */
	public int getNumeroSequencial() {
		return numeroSequencial;
	}

	/** 
	 * @return ultimonumeroSequencial em formato inteiro
	 */
	public static int getUltimonumeroSequencial() {
		return ultimonumeroSequencial;
	}

	/**
	 * @param ultimonumeroSequencial
	 */
	public static void setUltimonumeroSequencial(int ultimonumeroSequencial) {
		Revista.ultimonumeroSequencial = ultimonumeroSequencial;
	}

	/**
	 * Implementa interface requisitavel
	 * @return o maximo de dias de requisicao em formato inteiro
	 */
	public int maximoDiasRequisicao() {
		return 5;
	}

	/**
	 * Preenche detalhes da publicacao no CSV
	 * @return detalhes da publicacao
	 */
	public String detalhes(){
		return getDataRececao() +  ";" + getListaDeAreas() +";"+getPeriodicidade() +  ";" +getVolume()+";" +getNumeroSequencial();
	}

	/* (non-Javadoc)
	 * Metodo toString é a representacao textual do objeto.
	 * @see java.lang.Object#toString()
	 */
	@Override //acrescentar o supertostring
	public String toString() {
		return "Revista [titulo=" + getTitulo() + ", dataPublicacao=" + getDataPublicacao() + ", listaDeAreas=" + getListaDeAreas()
		+ ", codBarras=" + getCodBarras() + ", dataReceçao=" + getDataRececao() + ", periodicidade" + getPeriodicidade() + "volume=" + volume + ", numeroSequencial=" + numeroSequencial + "]";
	}
}