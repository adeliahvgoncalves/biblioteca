package pt.uc.dei.ar;

import java.util.*;

/**
 * Leitor herda da classe Utilizador.
 */
public class Leitor extends Utilizador {

	/**
     * Construtor da classe Leitor.
     * @param username
	 * @param hashedPassword
	 * @param nome
	 * @param dataNascimento
	 * @param cartaoCidadao
	 * @param morada
	 * @param email
	 * @param telefone 
     */
    public Leitor(String username, String hashedPassword, String nome, Date dataNascimento, String cartaoCidadao, String morada, String telefone, String email) {
    	super(username, hashedPassword, nome, dataNascimento, cartaoCidadao, morada, email, telefone); 
    	
    }

}