package pt.uc.dei.ar;

import java.io.Serializable;

/**
 * BibliotecarioChefe herda da classe Utilizador e implementa o Serializable
 */
public class BibliotecarioChefe extends Utilizador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6026760943183249613L;
	/**
     * Número de colaborador.
     */
    private int numColaborador;
    
   
    

    /**
     * Construtor da classe BibliotecarioChefe.
	 * @param username
	 * @param hashedPassword
	 * @param nome
	 * @param numColaborador
	 */
	public BibliotecarioChefe(String username, String hashedPassword, String nome, int numColaborador) {
		super(username, hashedPassword, nome);
		this.numColaborador = numColaborador;
	}




	/**
     * @return o número de colaborador do utilizador em formato inteiro.
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