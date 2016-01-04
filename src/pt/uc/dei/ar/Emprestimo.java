package pt.uc.dei.ar;

import java.util.*;

/**
 * Empréstimo representa o empréstimo de uma publicação requisitável
 */
public class Emprestimo {

  
    /**
     * Número de empréstimo é atributo do empréstimo, sendo sequencial
     */
    private int numEmp=0;
    
    /**
     * Número de empréstimo último facilita a criação do número de empréstimo sequencial
     */
    private int numEmpUltimo=0;

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
	public Emprestimo( Leitor leitor, Date dataEmp, 
			Requisitavel publicacao) {
		super();
		this.numEmp = numEmpUltimo;
		this.numEmpUltimo = numEmp+1;
		this.leitor = leitor;
		this.dataEmp = dataEmp;
		this.publicacao = publicacao;
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



}