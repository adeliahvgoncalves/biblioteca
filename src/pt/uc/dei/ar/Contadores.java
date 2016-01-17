package pt.uc.dei.ar;

import java.io.Serializable;

public class Contadores implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1193456112707634684L;
	
	private int contadorLeitor;
	private int contadorRevista;
	private int contadorPublicacao;
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

	public int getContadorLeitor() {
		return contadorLeitor;
	}

	public void setContadorLeitor(int contadorLeitor) {
		this.contadorLeitor = contadorLeitor;
	}

	public int getContadorRevista() {
		return contadorRevista;
	}

	public void setContadorRevista(int contadorRevista) {
		this.contadorRevista = contadorRevista;
	}

	public int getContadorPublicacao() {
		return contadorPublicacao;
	}

	public void setContadorPublicacao(int contadorPublicacao) {
		this.contadorPublicacao = contadorPublicacao;
	}

	public int getContadorEmprestimo() {
		return contadorEmprestimo;
	}

	public void setContadorEmprestimo(int contadorEmprestimo) {
		this.contadorEmprestimo = contadorEmprestimo;
	}
	
}
