package pt.uc.dei.ar;

import java.io.Serializable;
import java.util.*;

/**
 * Emprestimo representa o empréstimo de uma publicação requisitável e implementa o Serializable
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
	 * @param numEmp
	 * @param numEmpUltimo
	 * @param leitor
	 * @param dataEmp
	 * @param dataDev
	 * @param publicacao
	 */
	public Emprestimo( Leitor leitor, Date dataEmp, Requisitavel publicacao) {
		super();
		numEmpUltimo++;
		this.numEmp = numEmpUltimo;
		this.dataEmp = dataEmp;
		this.leitor = leitor;
		this.publicacao = publicacao;
	}

	/**
	 * @return o numero de emprestimo, em formato inteiro
	 */
	public int getNumEmp() {
		return numEmp;
	}

	/**
	 * @return o leitor em formato leitor
	 */
	public Leitor getLeitor() {
		return leitor;
	}

	/**
	 * @return a data de emprestimo em formato data
	 */
	public Date getDataEmp() {
		return dataEmp;
	}

	/**
	 * @return a data de devolucao em formato data
	 */
	public Date getDataDev() {
		return dataDev;
	}

	/**
	 * @param dataDev the dataDev to set
	 * a utilizar na devolucao da publicacao requisitavel
	 */
	public void setDataDev(Date dataDev) {
		this.dataDev = dataDev;
	}

	/**
	 * @return a publicacao que seja requisitavel
	 */
	public Requisitavel getPublicacao() {
		return publicacao;
	}

	/**
	 * 
	 * @return numEmpUltimo
	 */
	public static int getNumEmpUltimo() {
		return numEmpUltimo;
	}

	/**
	 * 
	 * @param numEmpUltimo
	 */
	public static void setNumEmpUltimo(int numEmpUltimo) {
		Emprestimo.numEmpUltimo = numEmpUltimo;
	}

	/**
	 * Determina a data maxima de emprestimo
	 * @return dataMaximaEntrega
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
	 * @param emprestimo
	 * @return dias que a publicacao esteve emprestada em formato inteiro
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