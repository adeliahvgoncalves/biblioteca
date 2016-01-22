package pt.uc.dei.ar;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 * Tese herda de nao periodico e implementa o requisitavel e o Serializable
 */
public class Tese extends NaoPeriodico implements Requisitavel, Serializable {

	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 5044302263170947142L;

	/**
     * Nome e atributo do orientador da Tese
     */
	private String nomeDoOrientador;

	/**
     * Tipo de tese e atributo de Tese
     */
	private TipoDeTese tipoDeTese;

	/**
	 * Construtor da classe Tese
	 * @param titulo titulo da tese
	 * @param dataPublicacao data da publicacao da tese
	 * @param dataRececao data de rececao da tese
	 * @param autor autor da tese
	 * @param areas areas da tese
	 * @param nomeDoOrientador nome do orientador da tese
	 * @param tipoDeTese tipo de tese
	 */
	public Tese(String titulo, String dataPublicacao, String dataRececao, ArrayList<String> autor,
			ArrayList<String> areas, String nomeDoOrientador, TipoDeTese tipoDeTese) {
		super(titulo, dataPublicacao, dataRececao, autor, areas);
		
		this.nomeDoOrientador = nomeDoOrientador;
		this.tipoDeTese = tipoDeTese;
		
	}

	/**
	 * Obtem o nome do orientador
	 * @return O nome do orientador em formato String
	 */
	public String getNomeDoOrientador() {
		return nomeDoOrientador;
	}

	/**
	 * Obtem o tipo de tese
	 * @return O tipo de tese em tipo de tese
	 */
	public TipoDeTese getTipoDeTese() {
		return tipoDeTese;
	}

	/**
	 * Implementa interface requisitavel
     * @return O maximo de dias de requisiçao em formato inteiro
     */
	@Override
	public int maximoDiasRequisicao() {
		return 10;
	}

	/**
	 * Preenche detalhes da publicacao no CSV
	 * @return Detalhes da publicacao
	 */
	public String detalhes(){
		return  getListaDeAreas() + ";" + getDataRececao() + "; " + getListaDeAutores() + "; " + getNomeDoOrientador() + ";" + getTipoDeTese();

	}
	
	/* (non-Javadoc)
	 * Metodo toString e a representacao textual do objeto.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tese [titulo=" + getTitulo() + ", dataPublicacao=" + getDataPublicacao() + ", listaDeAreas=" + getListaDeAreas()
				+ ", codBarras=" + getCodBarras() + ", dataReceçao=" + getDataRececao() + ", listaDeAutores=" + getListaDeAutores() + ", nomeDoOrientador=" + nomeDoOrientador + ", tipoDeTese=" + tipoDeTese + "]";
	}
}
