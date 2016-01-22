package pt.uc.dei.ar;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 * Leitor herda da classe Utilizador e implementa o Serializable
 */
public class Leitor extends Utilizador implements Serializable {

	/**
	 * Serial Version
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
	 *Data de nascimento e atributo do utilizador. 
	 */
	private Date dataNascimento;
	
	/**
	 * Cartao de Cidadao e atributo do utilizador.
	 */
	private String cartaoCidadao;
	
	/**
	 * Morada e atributo do utilizador.
	 */
	private String morada;
	
	/**
	 * E-mail e atributo do utilizador.
	 */
	private String email;
	
	/**
	 * Numero de telefone e atributo, contacto telefonico, do utilizador.
	 */
	private String telefone;

	/**
	 * Construtor da classe Leitor.
	 * @param username username do leitor
	 * @param nome nome do leitor
	 * @param dataNascimento data de nascimento do leitor
	 * @param cartaoCidadao cartao do cidadao do leitor
	 * @param morada morada do leitor
	 * @param email email do leitor
	 * @param telefone telefone do leitor
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
	 * Obtem a lista de emprestimos do leitor
	 * @return O arrayList de emprestimos do leitor
	 */
	public ArrayList<Emprestimo> getListaDeEmprestimo() {
		return listaDeEmprestimos;
	}

	/**
	 * Altera a lista de emprestimo
	 * @param listaDeEmprestimo the listaDeEmprestimo to set
	 */
	public void setListaDeEmprestimo(ArrayList<Emprestimo> listaDeEmprestimo) {
		this.listaDeEmprestimos = listaDeEmprestimo;
	}

	/**
	 * Obtem o numero de leitor
	 * @return O numero de leitor em formato inteiro
	 */
	public int getNumLeitor() {
		return numLeitor;
	}

	/**
	 * Altera o numero de leitor
	 * @param numLeitor the numLeitor to set
	 */
	public void setNumLeitor(int numLeitor) {
		this.numLeitor = numLeitor;
	}

	/**
	 * Obtem a data de nascimento
	 * @return A data de nascimento em formato data
	 */
	public Date getDataNascimento() {
		return dataNascimento;	
	}

	/**
	 * Obtem o cartao do cidadao
	 * @return O cartao do cidadao em formato String
	 */
	public String getCartaoCidadao() {
		return cartaoCidadao;
	}
	
	/**
	 * Obtem a morada
	 * @return A morada em formato String
	 */
	public String getMorada() {
		return morada;
	}

	/**
	 * Altera a morada
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
	 * Altera o email
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Obtem o telefone do leitor
	 * @return O telefone em formato string
	 */
	public String getTelefone() {
		return telefone;	
	}

	/**
	 * Altera o telefone do leitor
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Obtem o ultimo numero sequencial
	 * @return UltimoNumLeitorSequencial em formato inteiro
	 */
	public static int getUltimoNumLeitorSequencial() {
		return ultimoNumLeitorSequencial;
	}
	
	/**
	 * Altera o ultimo numero sequencial
	 * @param ultimoNumLeitorSequencial ultimo numero sequencial
	 */
	public static void setUltimoNumLeitorSequencial(int ultimoNumLeitorSequencial) {
		Leitor.ultimoNumLeitorSequencial = ultimoNumLeitorSequencial;
	}

	/**
	 * Adiciona um emprestimo novo
	 * @param Emprestimo emprestimo
	 */
	public void adicionaEmprestimo(Emprestimo emprestimo) {
		listaDeEmprestimos.add(emprestimo);
	}

	/**
	 * Consulta de emprestimos ativos do leitor
	 * @return Emprestimos Atuais
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
	 * Remove emprestimo do Leitor
	 * @param emprestimo emprestimo
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