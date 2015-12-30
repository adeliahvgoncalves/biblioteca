package pt.uc.dei.ar;

import java.util.*;

/**
 * 
 * Revista herda do periódico que por sua vez herda de publicação
 * Implementa a interface requisitavel, portanto, pode ser emprestada
 */
public class Revista extends Periodico implements Requisitavel {

	
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
    private int ultimonumeroSequencial=0;
    
    
   
    

    /**
     * Construtor da classe Revista
	 * @param titulo
	 * @param dataPublicacao
	 * @param codBarras
	 * @param dataReceçao
	 * @param periodicidade
	 * @param volume
	 * @param numeroSequencial
	 */
	public Revista(String titulo, Date dataPublicacao, int codBarras, Date dataReceçao, Periodicidade periodicidade,
			int volume, int numeroSequencial) {
		super(titulo, dataPublicacao, codBarras, dataReceçao, periodicidade);
		this.volume = volume;
		this.ultimonumeroSequencial=ultimonumeroSequencial+1;
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
	@Override
	public String toString() {
		return "Revista [volume=" + volume + ", numeroSequencial=" + numeroSequencial + ", ultimonumeroSequencial="
				+ ultimonumeroSequencial + "]";
	}
    
    

}