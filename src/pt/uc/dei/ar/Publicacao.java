package pt.uc.dei.ar;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Publicacao representa uma publicacao periodica ou nao periodica e implementa o Serializable
 *  @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 */
public class Publicacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9149749963203341928L;

	/**
	 * @title iítulo de uma publicacao
	 */
	private String titulo;

	/**
	 * Data em que a publicacao foi publicada
	 */
	private Date dataPublicacao;

	/**
	 * Areas da publicacao
	 */
	private ArrayList<String> listaDeAreas;

	/**
	 * Codigo de barras da publicacao
	 */
	private int codBarras=0;

	/**
	 * e criada esta variavel para facilitar a criacao do numero sequencial
	 */
	private static int ultimocodBarras=0;

	/**
	 * Data de rececao da publicacao
	 */
	private Date dataReceçao;

	/**
	 * Publicacao requisitada ou nao
	 */
	private boolean ocupado;

	/**
	 * Construtor da classe Publicação
	 * @param titulo
	 * @param dataPublicacao
	 * @param areas
	 * @param codBarras
	 * @param dataReceçao
	 */
	public Publicacao(String titulo, String dataPublicacao, String dataReceçao, ArrayList<String> areas) {
		super();
		
		this.titulo = titulo;
		
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		try{
			this.dataPublicacao=df.parse(dataPublicacao);
		} catch (ParseException e){
			e.printStackTrace();
		}	

		this.listaDeAreas = new ArrayList<String>(areas);
		this.ocupado=false;

		ultimocodBarras++;
		this.codBarras = ultimocodBarras;
		
		DateFormat dp=new SimpleDateFormat("dd/MM/yyyy");
		try{
			this.dataReceçao=dp.parse(dataReceçao);
		} catch (ParseException e){
			e.printStackTrace();
		}	
	}

	/**
	 * @return o titulo, em formato String
	 * 
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @return a data da publicacao, em formato de Data
	 *
	 */
	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	/**
	 * @return a lista de areas em formato String
	 * 
	 */
	public ArrayList<String> getListaDeAreas() {
		return listaDeAreas;
	}

	/**
	 * @param listaDeAreas define a nova lista de areas 
	 * 
	 */
	public void setListaDeAreas(ArrayList<String> listaDeAreas) {
		this.listaDeAreas = listaDeAreas;
	}

	/**
	 * @return o codigo de barras em formato inteiro
	 * 
	 */
	public int getCodBarras() {
		return codBarras;
	}

	/**
	 * @return a data de rececao, em formato data
	 *
	 */
	public Date getDataReceçao() {
		return dataReceçao;
	}

	/**
	 * @param area
	 * Metodo que permite adicionar novas areas ao arrayList
	 */
	public void adicionaArea(String area) {
		this.listaDeAreas.add(area);
	}

	/**
	 * @return the ocupado
	 */
	public boolean isOcupado() {
		return ocupado;
	}

	/**
	 * @param ocupado the ocupado to set
	 */
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	/**
	 * 
	 * @return ultimocodBarras em formato inteiro
	 */
	public static int getUltimocodBarras() {
		return ultimocodBarras;
	}

	/**
	 * 
	 * @param ultimocodBarras
	 */
	public static void setUltimocodBarras(int ultimocodBarras) {
		Publicacao.ultimocodBarras = ultimocodBarras;
	}

	/**
	 * Definir chave de um Map
	 * @return this.codBarras + this.titulo.hashCode()
	 */
	@Override
	public int hashCode() {

		return this.codBarras + this.titulo.hashCode();
	}

	/**
	 * Verificacao da chave 
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Publicacao other = (Publicacao) obj;
		if (codBarras != other.codBarras)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * Metodo toString e a representação textual do objeto.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Publicacao [titulo=" + titulo + ", dataPublicacao=" + dataPublicacao + ", listaDeAreas=" + listaDeAreas
				+ ", codBarras=" + codBarras + ", dataReceçao=" + dataReceçao + "]";
	}
}