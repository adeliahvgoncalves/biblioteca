package pt.uc.dei.ar;

import java.io.Serializable;

/**
 *  @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 * BibliotecarioChefe herda da classe Utilizador e implementa o Serializable
 */
public class BibliotecarioChefe extends Utilizador implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 6026760943183249613L;
	/**
     * Numero de colaborador do BibliotecarioChefe
     */
    private int numColaborador;

    /**
     * Construtor da classe BibliotecarioChefe.
	 * @param username
	 * @param hashedPassword
	 * @param nome
	 * @param numColaborador
	 */
	public BibliotecarioChefe(String username, String nome, int numColaborador) {
		super(username, nome);
		
		this.numColaborador = numColaborador;
		
	}

	/**
     * @return o numero de colaborador do utilizador em formato inteiro.
     */
    public int getNumColaborador() {
        return numColaborador;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BibliotecarioChefe [numColaborador=" + numColaborador + "]";
	}
}