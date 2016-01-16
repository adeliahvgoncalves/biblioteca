package pt.uc.dei.ar;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Publicação representa uma publicação periódica ou não periódica.
 */
public class Publicacao {

	/**
	 * @title Título de uma publicação
	 */
	private String titulo;

	/**
	 * Data em que a publicação foi publicada
	 */
	private Date dataPublicacao;

	/**
	 * Áreas da publicação
	 */
	private ArrayList<String> listaDeAreas;

	/**
	 * Código de barras da publicação
	 */
	private int codBarras=0;


	/**
	 * é criada esta variável para facilitar a criação do número sequencial
	 */
	private static int ultimocodBarras=0;


	/**
	 * Data de receção da publicação
	 */
	private Date dataReceçao;
	
	/**
	 * Publicação requisitada ou não
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
	 * @return o título, em formato String
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
	 * @return a lista de áreas em formato String
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
	 * @return o código de barras em formato inteiro
	 * 
	 */
	public int getCodBarras() {
		return codBarras;
	}


	/**
	 * @return a data de receçao, em formato data
	 *
	 */
	public Date getDataReceçao() {
		return dataReceçao;
	}


	/**
	 * @param area
	 * Método que permite adicionar novas áreas ao arrayList
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


	/* (non-Javadoc)
	 * Metódo toString é a representação textual do objeto.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Publicacao [titulo=" + titulo + ", dataPublicacao=" + dataPublicacao + ", listaDeAreas=" + listaDeAreas
				+ ", codBarras=" + codBarras + ", dataReceçao=" + dataReceçao + "]";
	}

	@Override
    public int hashCode() {
        
        return this.codBarras + this.titulo.hashCode();
    }
	
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
}