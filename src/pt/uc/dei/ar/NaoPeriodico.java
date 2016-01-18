package pt.uc.dei.ar;

import java.io.Serializable;
import java.util.*;

/**
 * O não periódico herda de Publicação e implementa o Serializable
 */
public class NaoPeriodico extends Publicacao implements Serializable {

	 /**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 9197568589647852671L;
	/**
     * Lista de autores do não periódico
     */
    private ArrayList<String> listaDeAutores;
	
  
	/**
	 * Construtor da classe Não Periódico
	 * @param titulo
	 * @param dataPublicacao
	 * @param dataReceçao
	 * @param listaDeAutores
	 */
	public NaoPeriodico(String titulo, String dataPublicacao,  String dataReceçao, ArrayList<String> autores,  ArrayList<String> areas) {
		super(titulo, dataPublicacao, dataReceçao, areas);
		
		this.listaDeAutores = new ArrayList<String>(autores);
		
	}


	/**
	 * 
	 * @return a lista de autores em formato String
	 */
	public ArrayList<String> getListaDeAutores() {
		return listaDeAutores;
	}


	/**
	 * Método que permite adicionar autores 
     * @param String
     */
    public void adicionaAutor(String autor) {
    	this.listaDeAutores.add(autor);
    }
    

    /* (non-Javadoc)
     * Metódo toString é a representação textual do objeto.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NaoPeriodico [listaDeAutores=" + listaDeAutores + "]";
	}

}