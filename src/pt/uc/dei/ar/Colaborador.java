package pt.uc.dei.ar;

import java.io.Serializable;

/**
 * @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 * Colaborador herda da classe Utilizador e implementa o Serializable
 */
public class Colaborador extends Utilizador implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -3819311207656290305L;
	/**
     * Numero de colaborador e atributo de Colaborador
     */
    private int numColaborador;
	
    /**
     * Construtor da classe Colaborador.
	 * @param username username do colaborador
	 * @param nome nome do colaborador
	 * @param numColaborador numero de colaborador do colaborador
	 */
	public Colaborador(String username,  String nome, int numColaborador) {
		super(username, nome);
		
		this.numColaborador = numColaborador;
		
	}

	/**
	 * Obtem o numero de colaborador do utilizador (colaborador)
     * @return O numero de colaborador do utilizador (colaborador)
     */
    public int getNumColaborador() {
        return numColaborador;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Colaborador [numColaborador=" + numColaborador + "]";
	}
}