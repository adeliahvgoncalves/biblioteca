package pt.uc.dei.ar;


import java.io.Serializable;

/**
 * Colaborador herda da classe Utilizador e implementa o Serializable
 *  @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 */
public class Colaborador extends Utilizador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3819311207656290305L;
	/**
     * Numero de colaborador.
     */
    private int numColaborador;
	
    
    

    /**
     * Construtor da classe Colaborador.
	 * @param username
	 * @param hashedPassword
	 * @param nome
	 * @param numColaborador
	 */
	public Colaborador(String username,  String nome, int numColaborador) {
		super(username, nome);
		this.numColaborador = numColaborador;
	}




	/**
     * @return o numero de colaborador do utilizador em formato inteiro
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