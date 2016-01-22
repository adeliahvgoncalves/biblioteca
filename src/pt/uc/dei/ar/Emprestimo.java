package pt.uc.dei.ar;

import java.io.Serializable;
import java.util.*;

/**
 * Emprestimo representa o emprestimo de uma publicação requisitavel e implementa o Serializable
 *  @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 */
public class Emprestimo implements Serializable {

	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = -5436843370567100689L;

	/**
	 * Numero de emprestimo e atributo do emprestimo, sendo sequencial
	 */
	private int numEmp;

	/**
	 * Numero de emprestimo ultimo facilita a criacao do numero de emprestimo sequencial
	 */
	private  static int numEmpUltimo=0;

	/**
	 * Leitor e atributo de emprestimo
	 */
	private Leitor leitor;

	/**
	 * Data de emprestimo e atributo de emprestimo
	 */
	private Date dataEmp;

	/**
	 * Data de devolucao e atributo de emprestimo, apos devolucao
	 */
	private Date dataDev;

	/**
	 * Publicacao e atributo de emprestimo
	 */
	private Requisitavel publicacao;

	/**
	 * Construtor da classe Emprestimo
	 * @param leitor leitor que vai fazer o emprestimo
	 * @param dataEmp data de emprestimo da publicacao
	 * @param publicacao a publicacao a ser emprestada
	 */
	public Emprestimo( Leitor leitor, Date dataEmp, Requisitavel publicacao) {
		numEmpUltimo++;
		this.numEmp = numEmpUltimo;
		this.dataEmp = dataEmp;
		this.leitor = leitor;
		this.publicacao = publicacao;
	}

	/**
	 * Obtem o numero de emprestimo
	 * @return O numero de emprestimo
	 */
	public int getNumEmp() {
		return numEmp;
	}

	/**
	 * Obtem o leitor que fez o emprestimo
	 * @return O leitor em formato leitor
	 */
	public Leitor getLeitor() {
		return leitor;
	}

	/**
	 * Obtem a data em que a publicacao foi emprestada
	 * @return A data de emprestimo em formato data
	 */
	public Date getDataEmp() {
		return dataEmp;
	}

	/**
	 * Obtem a data de devolucao em que a publicacao foi devolvida
	 * @return A data de devolucao 
	 */
	public Date getDataDev() {
		return dataDev;
	}

	/**
	 * Altera a data de devolucao em que a publicacao foi devolvida
	 * @param dataDev a data de devolucao nova
	 * a utilizar na devolucao da publicacao requisitavel
	 */
	public void setDataDev(Date dataDev) {
		this.dataDev = dataDev;
	}

	/**
	 * Obtem a publicacao requisitavel do emprestimo 
	 * @return A publicacao que seja requisitavel
	 */
	public Requisitavel getPublicacao() {
		return publicacao;
	}

	/**
	 * Obtem o ultimo numero sequencial do emprestimo
	 * @return O ultimo numero sequencial do emprestimo
	 */
	public static int getNumEmpUltimo() {
		return numEmpUltimo;
	}

	/**
	 * Altera o ultimo numero sequencial do emprestimo
	 * @param numEmpUltimo o ultimo numero sequencial do emprestimo novo
	 */
	public static void setNumEmpUltimo(int numEmpUltimo) {
		Emprestimo.numEmpUltimo = numEmpUltimo;
	}

	/**
	 * Determina a data maxima de emprestimo
	 * @return A data maxima em que o emprestimo pode ser devolvido
	 */
	public Date dataMaximaEntrega(){

		Calendar c = Calendar.getInstance();
		c.setTime(this.dataEmp);
		c.add(Calendar.DATE, publicacao.maximoDiasRequisicao());
		Date dataMaximaEntrega = c.getTime();
		return dataMaximaEntrega;
	}

	/**
	 * Determina o numero de dias que esteve emprestado
	 * @return Dias que a publicacao esteve emprestada em formato inteiro
	 */
	public int diasDeEmprestimo(){ 
		long m1 = 0;
		long m2 = 0;
		int diasEmprestimo=0;
		m1 = this.getDataEmp().getTime();
		if(this.getDataDev() != null){
			m2 = this.getDataDev().getTime();
		} else {
			Calendar dataMesAnterior = Calendar.getInstance();
			dataMesAnterior.set(Calendar.DAY_OF_MONTH, 1);
			dataMesAnterior.add(Calendar.DAY_OF_MONTH, -1);
			m2 = dataMesAnterior.getTimeInMillis();
		}
		diasEmprestimo=  (int) ((m2 - m1) / 1000 / 60 / 60 / 24);
		if (diasEmprestimo == 0){
			diasEmprestimo = 1;
		}
		return  diasEmprestimo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Emprestimo [numEmp=" + numEmp + ", leitor=" + leitor + ", dataEmp=" + dataEmp + ", dataDev=" + dataDev
				+ ", publicacao=" + publicacao + "]";
	}
}