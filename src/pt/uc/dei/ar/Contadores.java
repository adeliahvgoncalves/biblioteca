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
	 * Obtem o contador do numero sequencial do leitor
	 * @return O contador Leitor
	 */
	public int getContadorLeitor() {
		return contadorLeitor;
	}

	/**
	 * Altera o contador do numero sequencial do leitor
	 * @param contadorLeitor o contador do numero sequencial do leitor novo
	 */
	public void setContadorLeitor(int contadorLeitor) {
		this.contadorLeitor = contadorLeitor;
	}

	/**
	 * Obtem o contador do numero sequencial da revista
	 * @return O contador do numero sequencial da revista
	 */
	public int getContadorRevista() {
		return contadorRevista;
	}

	/**
	 * Altera o contador do numero sequencial da revista
	 * @param contadorRevista o contador do numero sequencial da revista novo
	 */
	public void setContadorRevista(int contadorRevista) {
		this.contadorRevista = contadorRevista;
	}

	/**
	 * Obtem o contador do numero sequencial da publicacao
	 * @return O contador do numero sequencial da publicacao
	 */
	public int getContadorPublicacao() {
		return contadorPublicacao;
	}

	/**
	 * Altera o contador do numero sequencial da publicacao
	 * @param contadorPublicacao o contador do numero sequencial da publicacao novo
	 */
	public void setContadorPublicacao(int contadorPublicacao) {
		this.contadorPublicacao = contadorPublicacao;
	}

	/**
	 * Obtem o contador do numero sequencial do emprestimo
	 * @return O contador do numero sequencial do emprestimo
	 */
	public int getContadorEmprestimo() {
		return contadorEmprestimo;
	}

	/**
	 * Altera o contador do numero sequencial do emprestimo
	 * @param contadorEmprestimo o contador do numero sequencial do emprestimo novo
	 */
	public void setContadorEmprestimo(int contadorEmprestimo) {
		this.contadorEmprestimo = contadorEmprestimo;
	}
}
