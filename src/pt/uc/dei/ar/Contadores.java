package pt.uc.dei.ar;

import java.io.Serializable;
/**
 * @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 * Contadores, e uma classe auxiliar, que representa os contadores de variaveis da biblioteca
 * e implementa o Serializable
 */
public class Contadores implements Serializable{

	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = -1193456112707634684L;

	/**
	 * Contador do numero de leitor, e atributo do Contador
	 */
	private int contadorLeitor;

	/**
	 * Contador do numero sequencial da revista, atributo do Contador
	 */
	private int contadorRevista;

	/**
	 * Contador do codigo de barras das publicacoes, atributo do Contador
	 */
	private int contadorPublicacao;

	/**
	 * Contador do numero de emprestimo, atributo do Contador
	 */
	private int contadorEmprestimo;

	public Contadores() {
		super();
		
		this.contadorLeitor = 0;
		this.contadorRevista = 0;
		this.contadorPublicacao = 0;
		this.contadorEmprestimo = 0;
		
	}

	public Contadores(int contadorLeitor, int contadorRevista, int contadorPublicacao, int contadorEmprestimo) {
		super();
		
		this.contadorLeitor = contadorLeitor;
		this.contadorRevista = contadorRevista;
		this.contadorPublicacao = contadorPublicacao;
		this.contadorEmprestimo = contadorEmprestimo;
		
	}
	
	/**
	 * 
	 * @return contadorLeitor em formato inteiro
	 */
	public int getContadorLeitor() {
		return contadorLeitor;
	}

	public void setContadorLeitor(int contadorLeitor) {
		this.contadorLeitor = contadorLeitor;
	}

	/**
	 * 
	 * @return contadorRevista em formato inteiro
	 */
	public int getContadorRevista() {
		return contadorRevista;
	}

	/**
	 * 
	 * @param contadorRevista
	 */
	public void setContadorRevista(int contadorRevista) {
		this.contadorRevista = contadorRevista;
	}

	/**
	 * 
	 * @return contadorPublicacao em formato inteiro
	 */
	public int getContadorPublicacao() {
		return contadorPublicacao;
	}

	/**
	 * 
	 * @param contadorPublicacao
	 */
	public void setContadorPublicacao(int contadorPublicacao) {
		this.contadorPublicacao = contadorPublicacao;
	}

	/**
	 * 
	 * @return contadorEmprestimo em formato inteiro
	 */
	public int getContadorEmprestimo() {
		return contadorEmprestimo;
	}

	/**
	 * 
	 * @param contadorEmprestimo
	 */
	public void setContadorEmprestimo(int contadorEmprestimo) {
		this.contadorEmprestimo = contadorEmprestimo;
	}
}
