package pt.uc.dei.ar;

import java.io.Serializable;
import java.util.*;

/**
 * 
 * Revista herda do periódico que por sua vez herda de publicação
 * Implementa a interface requisitavel, portanto, pode ser emprestada
 */
public class Revista extends Periodico implements Requisitavel, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4452420023882536318L;

	/**
     *  Volume da revista
     * 
     */
    private int volume;

    /**
     * Número sequencial da revista
     */
    private int numeroSequencial;
    
    /**
     * é criada esta variável para facilitar a criação do número sequencial
     */
    private static int ultimonumeroSequencial=0;
    
    

 
		
		
	/**
	 * Construtor da classe Revista
	 * @param titulo
	 * @param dataPublicacao
	 * @param dataReceçao
	 * @param areas
	 * @param periodicidade
	 * @param volume
	 * @param numeroSequencial
	 */
	public Revista(String titulo, String dataPublicacao, String dataReceçao, ArrayList<String> areas,
			Periodicidade periodicidade, int volume) {
		super(titulo, dataPublicacao, dataReceçao, areas, periodicidade);
		ultimonumeroSequencial++;
		this.numeroSequencial = ultimonumeroSequencial;
	}




	/**
     * 
	 * @return o volume em formato inteiro
	 */
	public int getVolume() {
		return volume;
	}



	/**
	 * @return o número sequencial em formato inteiro
	 */
	public int getNumeroSequencial() {
		return numeroSequencial;
	}

	public static int getUltimonumeroSequencial() {
		return ultimonumeroSequencial;
	}




	public static void setUltimonumeroSequencial(int ultimonumeroSequencial) {
		Revista.ultimonumeroSequencial = ultimonumeroSequencial;
	}




	/**
	 * Implementa interface requisitável
     * @return o máximo de dias de requisição em formato inteiro
     */
    public int maximoDiasRequisicao() {
        return 5;
    }



	/* (non-Javadoc)
	 * Metódo toString é a representação textual do objeto.
	 * @see java.lang.Object#toString()
	 */
	@Override //acrescentar o supertostring
	public String toString() {
		return "Revista [titulo=" + getTitulo() + ", dataPublicacao=" + getDataPublicacao() + ", listaDeAreas=" + getListaDeAreas()
				+ ", codBarras=" + getCodBarras() + ", dataReceçao=" + getDataReceçao() + ", periodicidade" + getPeriodicidade() + "volume=" + volume + ", numeroSequencial=" + numeroSequencial + "]";
	}
    
    

}