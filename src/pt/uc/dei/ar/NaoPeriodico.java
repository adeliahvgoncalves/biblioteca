package pt.uc.dei.ar;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * O não periódico herda de Publicação e implementa o Serializable
 *  @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 */
public class NaoPeriodico extends Publicacao implements Serializable {

	 /**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 9197568589647852671L;
	
	/**
     * Lista de autores do nao periodico
     */
    private ArrayList<String> listaDeAutores;
	
	/**
	 * Construtor da classe Nao Periodico
	 * @param titulo
	 * @param dataPublicacao
	 * @param dataRececao
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
	 * Metodo que permite adicionar autores 
     * @param String
     */
    public void adicionaAutor(String autor) {
    	this.listaDeAutores.add(autor);
    }

    /* (non-Javadoc)
     * Metodo toString e a representação textual do objeto.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NaoPeriodico [listaDeAutores=" + listaDeAutores + "]";
	}
}