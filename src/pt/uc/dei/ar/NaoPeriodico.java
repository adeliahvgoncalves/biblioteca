package pt.uc.dei.ar;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 * O NaoPeriodico herda de Publicacao e implementa o Serializable
 */
public class NaoPeriodico extends Publicacao implements Serializable {

	 /**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 9197568589647852671L;
	
	/**
     * Lista de autores e atributo do NaoPeriodico
     */
    private ArrayList<String> listaDeAutores;
	
	/**
	 * Construtor da classe NaoPeriodico
	 * @param titulo titulo
	 * @param dataPublicacao data de publicacao
	 * @param dataRececao data de rececao
	 * @param autores lista de autores
	 *  @param areas lista de areas
	 */
	public NaoPeriodico(String titulo, String dataPublicacao,  String dataRececao, ArrayList<String> autores,  ArrayList<String> areas) {
		super(titulo, dataPublicacao, dataRececao, areas);
		
		this.listaDeAutores = new ArrayList<String>(autores);
		
	}

	/**
	 * Obtem a lista de autores
	 * @return A lista de autores em formato String
	 */
	public ArrayList<String> getListaDeAutores() {
		return listaDeAutores;
	}

	/**
	 * Metodo que permite adicionar autores 
     * @param autor autor
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