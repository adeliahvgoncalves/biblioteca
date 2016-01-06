package pt.uc.dei.ar;


import java.util.*;

/**
 * Colaborador herda da classe Utilizador.
 */
public class Colaborador extends Utilizador {

	/**
     * Número de colaborador.
     */
    private int numColaborador;
	
    
    

    /**
     * Construtor da classe Colaborador.
	 * @param username
	 * @param hashedPassword
	 * @param nome
	 * @param numColaborador
	 */
	public Colaborador(String username, String hashedPassword, String nome, int numColaborador) {
		super(username, hashedPassword, nome);
		this.numColaborador = numColaborador;
	}




	/**
     * @return o número de colaborador do utilizador em formato inteiro
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