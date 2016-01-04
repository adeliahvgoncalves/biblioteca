package pt.uc.dei.ar;

import java.util.*;

/**
 * BibliotecarioChefe herda da classe Utilizador.
 */
public class BibliotecarioChefe extends Utilizador {

	/**
     * Número de colaborador.
     */
    private int numColaborador;
	
    /**
     * Construtor da classe BibliotecarioChefe.
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
    public BibliotecarioChefe(String username, String hashedPassword, String nome, Date dataNascimento, String cartaoCidadao, String morada, String telefone, String email, int numColaborador) {
    	super(username, hashedPassword, nome, dataNascimento, cartaoCidadao, morada, email, telefone); 
    	
    	//verificar se se coloca o numero de colaborador sequencial ou normalmente.
    	this.numColaborador=numColaborador;
    }

    

    /**
     * @return o número de colaborador do utilizador em formato inteiro.
     */
    public int getNumColaborador() {
        return numColaborador;
    }

}