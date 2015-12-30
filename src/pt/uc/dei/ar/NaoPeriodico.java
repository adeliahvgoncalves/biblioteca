package pt.uc.dei.ar;

import java.util.*;

/**
 * O não periódico herda de Publicação.
 */
public class NaoPeriodico extends Publicacao {

	 /**
     * Lista de autores do não periódico
     */
    private ArrayList<String> listaDeAutores;
	
    

   

    /**
     * Construtor da classe Não Periódico
	 * @param titulo
	 * @param dataPublicacao
	 * @param codBarras
	 * @param dataReceçao
	 * @param listaDeAutores
	 */
	public NaoPeriodico(String titulo, Date dataPublicacao, int codBarras, Date dataReceçao) {
		super(titulo, dataPublicacao, codBarras, dataReceçao);
		this.listaDeAutores = new ArrayList<String>();
		
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