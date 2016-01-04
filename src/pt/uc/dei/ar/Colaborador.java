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
	 * @param dataNascimento
	 * @param cartaoCidadao
	 * @param morada
	 * @param email
	 * @param telefone
	 * @param numColaborador 
     */
    public Colaborador(String username, String hashedPassword, String nome, Date dataNascimento, String cartaoCidadao, String morada, String telefone, String email, int numColaborador) {
    	super(username, hashedPassword, nome, dataNascimento, cartaoCidadao, morada, email, telefone);
    	
    	this.numColaborador=numColaborador;
    }

    

    /**
     * @return o número de colaborador do utilizador em formato inteiro
     */
    public int getNumColaborador() {
        return numColaborador;
    }

}