package pt.uc.dei.ar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Empréstimo representa o empréstimo de uma publicação requisitável
 */
public class Emprestimo {


	/**
	 * Número de empréstimo é atributo do empréstimo, sendo sequencial
	 */
	private int numEmp;

	/**
	 * Número de empréstimo último facilita a criação do número de empréstimo sequencial
	 */
	private  static int numEmpUltimo=0;

	/**
	 * Leitor é atributo de empréstimo
	 */
	private Leitor leitor;

	/**
	 * Data de empréstimo é atributo de empréstimo
	 */
	private Date dataEmp;

	/**
	 * Data de devolução é atributo de empréstimo, após devolução
	 */
	private Date dataDev;


	/**
	 * Publicação é atributo de empréstimo
	 */
	private Requisitavel publicacao;



	/**
	 * Construtor da classe Empréstimo
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
		this.dataEmp=dataEmp;
		this.leitor = leitor;
		this.publicacao=publicacao;
	}





	/**
	 * @return o número de empréstimo, em formato inteiro
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
	 * @return a data de empréstimo em formato data
	 */
	public Date getDataEmp() {
		return dataEmp;
	}


	/**
	 * @return a data de devolução em formato data
	 */
	public Date getDataDev() {
		return dataDev;
	}



	/**
	 * @param dataDev the dataDev to set
	 * a utilizar na devolução da publicação requisitável
	 */
	public void setDataDev(Date dataDev) {
		this.dataDev = dataDev;
	}



	/**
	 * @return a publicação que seja requisitável
	 */
	public Requisitavel getPublicacao() {
		return publicacao;
	}

	public Date dataMaximaEntrega(){
		
		Calendar c = Calendar.getInstance();
		c.setTime(this.dataEmp);
		c.add(Calendar.DATE, publicacao.maximoDiasRequisicao());

		
		Date dataMaximaEntrega = c.getTime();
		return dataMaximaEntrega;
		
	
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