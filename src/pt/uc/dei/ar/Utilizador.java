package pt.uc.dei.ar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * A classe Utilizador representa os utilizadores de uma Biblioteca.
 */
public class Utilizador {

	/**
     * Username do utilizador.
     */
    private String username;

    /**
     * Password de entrada do utilizador, a ser escolhida pelo utilizador.
     */
    private String hashedPassword;

    /**
     * Nome do utilizador.
     */
    private String nome;

	/**
	 * Construtor da classe utilizador
	 * @param username
	 * @param hashedPassword
	 * @param nome
	 */
	public Utilizador(String username, String hashedPassword, String nome) {
		super();
		this.username = username;
		this.hashedPassword = hashedPassword;
		this.nome = nome;
	}

	/**
	 * @return o username em formato String
	 */
	public String getUsername() {
		return username;
	}

	

	/**
	 * @return a password em formato String
	 */
	public String getHashedPassword() {
		return hashedPassword;
	}

	
	/**
	 * @return o nome do utilizador em formato String
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