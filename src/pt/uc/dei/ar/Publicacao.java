package pt.uc.dei.ar;


import java.util.*;

/**
 * 
 */
public class Publicacao {

	 /**
     * Uma publicação tem um título.
     */
    private String titulo;

    /**
     * Uma publicação tem uma data em que foi publicada.
     */
    private Date dataPublicacao;

    /**
     * A publicação tem um conjunto de áreas em que se pode enquadrar. 
     */
    private ArrayList<String> listaDeAreas;

    /**
     * A publicação tem um código de barras para facilitar e agilizar o processo
     * de requisição e devolução da obra e para facilitar a sua identificação
     * no arquivo.
     */
    private int codBarras;

    /**
     * A publicação tem uma data de registo no sistema da biblioteca.
     */
    private Date dataReceçao;
	
    

    /**
     * A inicialização dos atributos da classe:
	 * @param titulo
	 * @param dataPublicacao
	 * @param areas
	 * @param codBarras
	 * @param dataReceçao
	 */
	public Publicacao(String titulo, Date dataPublicacao, int codBarras, Date dataReceçao) {
		super();
		this.titulo = titulo;
		this.dataPublicacao = dataPublicacao;
		this.listaDeAreas = new ArrayList<String>();
		this.codBarras = codBarras;
		this.dataReceçao = dataReceçao;
	}


	/**
	 * @return the titulo
	 * Método que permite aceder ao título, respeitando o encapsulamento.
	 */
	public String getTitulo() {
		return titulo;
	}


	/**
	 * @return the dataPublicacao
	 * Método que permite aceder à data de publicação, respeitando o encapsulamento.
	 */
	public Date getDataPublicacao() {
		return dataPublicacao;
	}



	/**
	 * @return the listaDeAreas
	 * Método que permite aceder à lista de áreas, respeitando o encapsulamento.
	 */
	public ArrayList<String> getListaDeAreas() {
		return listaDeAreas;
	}




	/**
	 * @param listaDeAreas the listaDeAreas to set
	 * Método que permite alterar ou substituir na lista de áreas, tornando-a mais explícita.
	 */
	public void setListaDeAreas(ArrayList<String> listaDeAreas) {
		this.listaDeAreas = listaDeAreas;
	}




	/**
	 * @return the codBarras
	 * Permite aceder ao código de barras, respeitando o encapsulamento.
	 */
	public int getCodBarras() {
		return codBarras;
	}


	/**
	 * @return the dataReceçao
	 * Método que permite aceder à data de receção da publicação, respeitando o encapsulamento.
	 */
	public Date getDataReceçao() {
		return dataReceçao;
	}

	
	/**
     * @param String
     * Método que permite adicionar novas áreas ao arrayList.
     */
    public void adicionaArea(String area) {
    	this.listaDeAreas.add(area);
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
    
    
    
}