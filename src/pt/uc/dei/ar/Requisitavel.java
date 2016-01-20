package pt.uc.dei.ar;

/**
 * Requisitavel e uma interface que obriga a implementacao nas publicacoes de um 
 * metodo que devolve o maximo de dias de requisicao.
 *  @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 */
public interface Requisitavel {
	
    /**
     * As classes que implementam a interface sao
     * passiveis de ser emprestadas aos leitores.
     * 
     * @return um inteiro com o numero maximo de dias da requisicao.
     */
    public int maximoDiasRequisicao();
}