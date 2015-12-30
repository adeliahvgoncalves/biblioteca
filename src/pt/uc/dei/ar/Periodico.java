package pt.uc.dei.ar;

import java.util.*;

/**
 * A subclass periódica herda da classe Publicação.
 */
public class Periodico extends Publicacao {

	/**
     * A periodicidade é um atributo da classe periódico.
     */
    private Periodicidade periodicidade;


    

    /**
     * A inicialização dos atributos da classe:
	 * @param titulo
	 * @param dataPublicacao
	 * @param codBarras
	 * @param dataReceçao
	 * @param periodicidade
	 */
	public Periodico(String titulo, Date dataPublicacao, int codBarras, Date dataReceçao, Periodicidade periodicidade) {
		super(titulo, dataPublicacao, codBarras, dataReceçao);
		this.periodicidade = periodicidade;
	}




	/**
	 * Método que permite aceder à periodicidade respeitando o encapsulamento.
	 * @return the periodicidade
	 */
	public Periodicidade getPeriodicidade() {
		return periodicidade;
	}




	/* (non-Javadoc)
	 * Metódo toString é a representação textual do objeto.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Periodico [periodicidade=" + periodicidade + "]";
	}



	
}