package pt.uc.dei.ar;

import java.util.ArrayList;
import java.util.Date;

/**
 * Tese herda de não periódico e implementa o requisitável
 */

public class Tese extends NaoPeriodico implements Requisitavel {


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
	
	/* (non-Javadoc)
	 * Metódo toString é a representação textual do objeto.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tese [nomeDoOrientador=" + nomeDoOrientador + ", tipoDeTese=" + tipoDeTese + "]";
	}


	
}
