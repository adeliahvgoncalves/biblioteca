package pt.uc.dei.ar;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *  @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 * Publicacao representa uma publicacao periodica ou nao periodica e implementa o Serializable
 */
public class Publicacao implements Serializable{

	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 9149749963203341928L;

	/**
	 * Titulo e atributo de uma publicacao
	 */
	private String titulo;

	/**
	 * DataPublicacao e atributo de Publicacao, data em que foi publicada
	 */
	private Date dataPublicacao;

	/**
	 * Areas da publicacao e atributo da Publicacao
	 */
	private ArrayList<String> listaDeAreas;

	/**
	 * Codigo de barras e atributo da Publicacao
	 */
	private int codBarras=0;

	/**
	 * Criado esta variavel para facilitar a criacao do numero sequencial
	 */
	private static int ultimocodBarras=0;

	/**
	 * DateRececaoData e atributo da Publicacao, data de rececao da publicacao
	 */
	private Date dataRececao;

	/**
	 * Ocupado e atributo da Publicacao, requisitada ou nao
	 */
	private boolean ocupado;

	/**
	 * Construtor da classe Publicacao
	 * @param titulo titulo da publicacao
	 * @param dataPublicacao data da publicacao
	 * @param areas  areas da publicacao
	 * @param dataRececao data de rececao da publicacao
	 */
	public Publicacao(String titulo, String dataPublicacao, String dataRececao, ArrayList<String> areas) {
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
			this.dataRececao=dp.parse(dataRececao);
		} catch (ParseException e){
			e.printStackTrace();
		}
		
	}

	/**
	 * Retorna o titulo da publicacao
	 * @return O titulo, em formato String
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Retorna a data da publicacao
	 * @return A data da publicacao, em formato de Data
	 */
	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	/**
	 * Obtem a lista de areas
	 * @return A lista de areas em formato String
	 */
	public ArrayList<String> getListaDeAreas() {
		return listaDeAreas;
	}

	/**
	 * Altera as areas
	 * @param listaDeAreas define  lista de areas 
	 */
	public void setListaDeAreas(ArrayList<String> listaDeAreas) {
		this.listaDeAreas = listaDeAreas;
	}

	/**
	 * Obtem o codigo de barras
	 * @return O codigo de barras em formato inteiro
	 */
	public int getCodBarras() {
		return codBarras;
	}

	/**
	 * Obtem a data de rececao
	 * @return A data de rececao, em formato data
	 */
	public Date getDataRececao() {
		return dataRececao;
	}

	/**
	 * Metodo que permite adicionar novas areas ao arrayList
	 * @param area area
	 */
	public void adicionaArea(String area) {
		this.listaDeAreas.add(area);
	}

	/**
	 * Metodo que verifica se a publicacao esta ocupada(requisitada)
	 * @return the ocupado Se está ocupado
	 */
	public boolean isOcupado() {
		return ocupado;
	}

	/**
	 * Altera o estado para ocupado
	 * @param ocupado the ocupado to set
	 */
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	/**
	 * Obtem o ultimo codigo de barars
	 * @return ultimocodBarras em formato inteiro
	 */
	public static int getUltimocodBarras() {
		return ultimocodBarras;
	}

	/**
	 * Altera o ultimo codigo de barras
	 * @param ultimocodBarras o ultimo codigo de barras
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
	 * Verificacao da chave do Map
	 * @return boolean Um boolean
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
				+ ", codBarras=" + codBarras + ", dataReceçao=" + dataRececao + "]";
	}
}