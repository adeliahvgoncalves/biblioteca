package pt.uc.dei.ar;

import java.util.*;

/**
 * A subclass não periódica herda da classe Publicação.
 */
public class NaoPeriodico extends Publicacao {

	 /**
     * A lista de autores é um atributo da classe não periódico.
     */
    private ArrayList<String> listaDeAutores;
	
    

   

    /**
     * A inicialização dos atributos da classe:
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
	 * Método que permite aceder à lista de autores respeitando o encapsulamento.
	 * @return the listaDeAutores
	 */
	public ArrayList<String> getListaDeAutores() {
		return listaDeAutores;
	}


	/**
	 * Método que permite adicionar um novo autor à lista de autores.
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