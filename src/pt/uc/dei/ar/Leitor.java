package pt.uc.dei.ar;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Leitor herda da classe Utilizador e implementa o Serializable
 *  @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 */
public class Leitor extends Utilizador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5729849162098592996L;
	
	/**
	 * Lista de emprestimos e atributo da classe Leitor
	 */
	private ArrayList<Emprestimo> listaDeEmprestimos;
	
	/**
	 * Numero de leitor e atributo da classe leitor
	 */
	private int numLeitor=0;
	
	/**
	 * Numero de leitor sequencial permite a criacao de numeros sequenciais
	 */
	private static int ultimoNumLeitorSequencial=0;
	
	/**
	 *Data de nascimento do utilizador. 
	 */
	private Date dataNascimento;
	
	/**
	 * Cartao de Cidadao do utilizador.
	 */
	private String cartaoCidadao;
	
	/**
	 * Morada do utilizador.
	 */
	private String morada;
	
	/**
	 * E-mail do utilizador.
	 */
	private String email;
	
	/**
	 * Numero de telefone, contacto telefonico do utilizador.
	 */
	private String telefone;

	/**
	 * Construtor da classe Leitor.
	 * @param username
	 * @param hashedPassword
	 * @param nome
	 * @param listaDeEmprestimo
	 * @param numLeitor
	 * @param dataNascimento
	 * @param cartaoCidadao
	 * @param morada
	 * @param email
	 * @param telefone
	 */
	public Leitor(String username, String nome,
			String dataNascimento, String cartaoCidadao, String morada, String email, String telefone) {
		super(username, nome);
		
		this.listaDeEmprestimos = new ArrayList<Emprestimo>();
		ultimoNumLeitorSequencial++;
		this.numLeitor = ultimoNumLeitorSequencial;
		
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		try{
			this.dataNascimento=df.parse(dataNascimento);
		} catch (ParseException e){
			e.printStackTrace();
		}	
		
		this.cartaoCidadao = cartaoCidadao;
		this.morada = morada;
		this.email = email;
		this.telefone = telefone;
	}

	/**
	 * @return o arrayList de emprestimos do leitor
	 */
	public ArrayList<Emprestimo> getListaDeEmprestimo() {
		return listaDeEmprestimos;
	}

	/**
	 * @param listaDeEmprestimo the listaDeEmprestimo to set
	 */
	public void setListaDeEmprestimo(ArrayList<Emprestimo> listaDeEmprestimo) {
		this.listaDeEmprestimos = listaDeEmprestimo;
	}

	/**
	 * @return o numero de leitor em formato inteiro
	 */
	public int getNumLeitor() {
		return numLeitor;
	}

	/**
	 * @param numLeitor the numLeitor to set
	 */
	public void setNumLeitor(int numLeitor) {
		this.numLeitor = numLeitor;
	}

	/**
	 * @return a data de nascimento em formato data
	 */
	public Date getDataNascimento() {
		return dataNascimento;	
	}

	/**
	 * @return o cartao do cidadao em formato String
	 */
	public String getCartaoCidadao() {
		return cartaoCidadao;
	}
	
	/**
	 * @return a morada em formato String
	 */
	public String getMorada() {
		return morada;
	}

	/**
	 * @param morada the morada to set
	 */
	public void setMorada(String morada) {
		this.morada = morada;	
	}

	/**
	 * @return o email em formato string
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return o telefone em formato string
	 */
	public String getTelefone() {
		return telefone;	
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * 
	 * @return ultimoNumLeitorSequencial em formato inteiro
	 */
	public static int getUltimoNumLeitorSequencial() {
		return ultimoNumLeitorSequencial;
	}
	
	/**
	 * 
	 * @param ultimoNumLeitorSequencial
	 */
	public static void setUltimoNumLeitorSequencial(int ultimoNumLeitorSequencial) {
		Leitor.ultimoNumLeitorSequencial = ultimoNumLeitorSequencial;
	}

	/**
	 * Adiciona um emprestimo novo
	 * @param Emprestimo
	 */
	public void adicionaEmprestimo(Emprestimo emprestimo) {
		listaDeEmprestimos.add(emprestimo);
	}

	/**
	 * Consulta de emprestimos ativos do leitor
	 * @param String Nome 
	 * @return emprestimosAtuais
	 */
	public ArrayList<Emprestimo> consultaEmprestimosLeitor() {
		
		ArrayList<Emprestimo> emprestimosAtuais= new ArrayList<Emprestimo>();
		
		for (Emprestimo emprestimo : listaDeEmprestimos) {
			if(emprestimo.getDataDev()==null){
				emprestimosAtuais.add(emprestimo);
			}
		}
		return emprestimosAtuais;
	}
	
	/**
	 * Remove emprestimo
	 * @param emprestimo
	 */
	public void removeEmprestimo(Emprestimo emprestimo) {
		listaDeEmprestimos.remove(emprestimo);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Leitor [numLeitor=" + numLeitor + ", dataNascimento="
				+ dataNascimento + ", cartaoCidadao=" + cartaoCidadao + ", morada=" + morada + ", email=" + email
				+ ", telefone=" + telefone + "]";
	}
}