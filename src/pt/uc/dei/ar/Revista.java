package pt.uc.dei.ar;

import java.util.*;

/**
 * 
 * A classe revista herda da classe periódico que por sua vez herda de publicação.
 * Implementa a interface requisitavel, portanto, pode ser emprestada.
 */
public class Revista extends Periodico implements Requisitavel {

	
	/**
     * A volume é um atributo da classe revista.
     * 
     */
    private int volume;

    /**
     * O número sequencial é um atributo da classe revista.
     */
    private int numeroSequencial;
    
    /**
     * è criada esta variável para permitir a criação do número sequencial.
     */
    private int ultimonumeroSequencial=0;
    
    
   
    

    /**
     * A inicialização dos atributos da classe:
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
     * Método que permite aceder ao volume da revista respeitando o encapsulamento.
	 * @return the volume
	 */
	public int getVolume() {
		return volume;
	}



	/**
	 * Método que permite aceder ao número sequencial da revista respeitando o encapsulamento.

	 * @return the numeroSequencial
	 */
	public int getNumeroSequencial() {
		return numeroSequencial;
	}

	/**
	 * Método que implementa a interface. Definido prazo de 5 dias de
	 * empréstimo da revista.
     * @return
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