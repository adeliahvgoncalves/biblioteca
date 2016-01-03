package pt.uc.dei.ar;

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
     *Data de nascimento do utilizador. 
     */
    private Date dataNascimento;

    /**
     * Cartao de Cidadão do utilizador.
     */
    private String cartaoCidadao;

    /**
     * Morada do utilizador.
     */
    private String morada;

    /**
     * E-mail do utilizador.
     */
    private String email;

    /**
     * Número de telefone, contacto telefónico do utilizador.
     */
    private String telefone;
	
	
    /**
     * Construtor da classe Utilizador
     * @param username
	 * @param hashedPassword
	 * @param nome
	 * @param dataNascimento
	 * @param cartaoCidadao
	 * @param morada
	 * @param email
	 * @param telefone 
     */
    public Utilizador(String username, String hashedPassword, String nome, Date dataNascimento, String cartaoCidadao, String morada, String telefone, String email) {
    	
    	this.username=username;
    	this.hashedPassword=hashedPassword;
    	this.nome=nome;
    	this.dataNascimento=dataNascimento;
    	this.cartaoCidadao=cartaoCidadao;
    	this.morada=morada;
    	this.email=email;
    	this.telefone=telefone;
    	
    }

    


    /**
     * @return utilizador, em formato String.
     */
    @Override
	public String toString() {
		return "Utilizador [username=" + username + ", hashedPassword=" + hashedPassword + ", nome=" + nome
				+ ", dataNascimento=" + dataNascimento + ", cartaoCidadao=" + cartaoCidadao + ", morada=" + morada
				+ ", email=" + email + ", telefone=" + telefone + "]";
	}

    /**
     * @return nome do utilizador, em formato String.
     */
    public String getNome() {
        // TODO implement here
        return nome;
    }

    /**
     * @return username do utilizador, em formato String.
     */
    public String getUsername() {
        // TODO implement here
        return username;
    }

    /**
     * @return número do Cartão de Cidadão do utilizador, em formato String.
     */
    public String getCartaoCidadao() {
        // TODO implement here
        return cartaoCidadao;
    }

    /**
     * @param String morada
     * Método que permite alterar a morada do utilizador.
     */
    public void setMorada(String morada) {
        // TODO implement here
    	this.morada=morada;
    }

    /**
     * @param String email
     * Método que permite alterar o e-mail do utilizador.
     */
    public void setEmail(String email) {
        // TODO implement here
    	this.email=email;
    }

    /**
     * @param String telemovel
     * Método que permite alterar o número de telefone do utilizador.
     */
    public void setTelefone(String telefone) {
        // TODO implement here
    	this.telefone=telefone;
    }

    /**
     * @return password do utilizador.
     */
    public String getHashedPassword() {
        // TODO implement here
        return hashedPassword;
    }

    /**
     * 
     */
    public interface Interface1 {

    }

}