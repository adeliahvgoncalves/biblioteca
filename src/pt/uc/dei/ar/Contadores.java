package pt.uc.dei.ar;

import java.io.Serializable;
/**
 * 
 * Contadores, é uma classe auxiliar, que representa os contadores de variáveis da biblioteca
 * e implementa o Serializable
 *
 */
public class Contadores implements Serializable{

	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = -1193456112707634684L;

	/**
	 * Contador do número de leitor
	 */
	private int contadorLeitor;

	/**
	 * Contador do número sequencial da revista
	 */
	private int contadorRevista;

	/**
	 * Contador do código de barras das publicações
	 */
	private int contadorPublicacao;

	/**
	 * Contador do número de empréstimo
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
