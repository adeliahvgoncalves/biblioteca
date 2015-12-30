package pt.uc.dei.ar;

import java.util.Date;

/**
 * A classe tese herda da classe não periódico e implementa o requisitável.
 */

public class Tese extends NaoPeriodico implements Requisitavel {


	/**
     * O nome do orientador é um atributo da classe tese.
     */
	private String nomeDoOrientador;

	/**
     * O tipo de tese é um atributo da classe tese.
     */
	private TipoDeTese tipoDeTese;

	/**
	 * A inicialização dos atributos da classe:
	 * @param titulo
	 * @param dataPublicacao
	 * @param codBarras
	 * @param dataReceçao
	 * @param nomeDoOrientador
	 * @param tipoDeTese
	 */
	public Tese(String titulo, Date dataPublicacao, int codBarras, Date dataReceçao, String nomeDoOrientador,
			TipoDeTese tipoDeTese) {
		super(titulo, dataPublicacao, codBarras, dataReceçao);
		this.nomeDoOrientador = nomeDoOrientador;
		this.tipoDeTese = tipoDeTese;
	}

	/**
	 * Método que permite aceder ao nome do orientador respeitando o encapsulamento.
	 * @return the nomeDoOrientador
	 */
	public String getNomeDoOrientador() {
		return nomeDoOrientador;
	}

	
	/**
	 * Método que permite à enumeração do tipo de tese respeitando o encapsulamento.
	 */
	public TipoDeTese getTipoDeTese() {
		return tipoDeTese;
	}

	

	/**
	 * Método que implementa a interface. Definido prazo de 10 dias de
	 * empréstimo da tese.
     * @return
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
