package pt.uc.dei.ar;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Tese herda de não periódico e implementa o requisitável e o Serializable
 */

public class Tese extends NaoPeriodico implements Requisitavel, Serializable {


	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 5044302263170947142L;

	/**
     * Nome do orientador da tese
     */
	private String nomeDoOrientador;

	/**
     * Tipo de tese
     */
	private TipoDeTese tipoDeTese;

	
	/**
	 * Construtor da classe Tese
	 * @param titulo
	 * @param dataPublicacao
	 * @param dataReceçao
	 * @param autores
	 * @param areas
	 * @param nomeDoOrientador
	 * @param tipoDeTese
	 */
	public Tese(String titulo, String dataPublicacao, String dataReceçao, ArrayList<String> autores,
			ArrayList<String> areas, String nomeDoOrientador, TipoDeTese tipoDeTese) {
		super(titulo, dataPublicacao, dataReceçao, autores, areas);
		this.nomeDoOrientador = nomeDoOrientador;
		this.tipoDeTese = tipoDeTese;
	}



	/**
	 *
	 * @return o nome do orientador em formato String
	 */
	public String getNomeDoOrientador() {
		return nomeDoOrientador;
	}

	
	
	/**
	 *
	 * @return o tipo de tese em tipo de tese
	 */
	public TipoDeTese getTipoDeTese() {
		return tipoDeTese;
	}

	

	/**
	 * Implementa interface requisitável
     * @return o máximo de dias de requisição em formato inteiro
     */
	@Override
	public int maximoDiasRequisicao() {
		return 10;
	}
	

	/**
	 * Preenche detalhes da publicação no CSV
	 * @return detalhes da publicação
	 */
	public String detalhes(){
		return  getListaDeAreas() + ";" + getDataReceçao() + "; " + getListaDeAutores() + "; " + getNomeDoOrientador() + ";" + getTipoDeTese();

	}
	
	/* (non-Javadoc)
	 * Metódo toString é a representação textual do objeto.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tese [titulo=" + getTitulo() + ", dataPublicacao=" + getDataPublicacao() + ", listaDeAreas=" + getListaDeAreas()
				+ ", codBarras=" + getCodBarras() + ", dataReceçao=" + getDataReceçao() + ", listaDeAutores=" + getListaDeAutores() + ", nomeDoOrientador=" + nomeDoOrientador + ", tipoDeTese=" + tipoDeTese + "]";
	}

	

	
}
