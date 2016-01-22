package pt.uc.dei.ar;

import java.io.Serializable;

/**
 * @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 * A classe Utilizador representa os utilizadores de uma Biblioteca e implementa o Serializable
 */
public class Utilizador implements Serializable {

	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = -5032289784271982472L;

	/**
     *Username e atributo do Utilizador.
     */
    private String username;

    /**
     * Password e atributo de entrada do utilizador
     */
    private String hashedPassword;

    /**
     * Nome e atributo do utilizador.
     */
    private String nome;

	/**
	 * Construtor da classe utilizador
	 * @param username username do utilizador
	 * @param nome nome do utilizador
	 */
	public Utilizador(String username, String nome) {
		
		this.username = username;
		this.hashedPassword = Biblioteca.getInstance().gerarPassword();
		this.nome = nome;
		
	}

	/**
	 * Obtem o username
	 * @return O username em formato String
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Obtem a password
	 * @return A password em formato String
	 */
	public String getHashedPassword() {
		return hashedPassword;
	}

	/**
	 * Obtem o nome do utilizador
	 * @return O nome do utilizador em formato String
	 */
	public String getNome() {
		return nome;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Utilizador [username=" + username + ", hashedPassword=" + hashedPassword + ", nome=" + nome + "]";
	}
}