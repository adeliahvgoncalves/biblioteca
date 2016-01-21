package pt.uc.dei.ar;

/**
 * @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 * Requisitavel e uma interface que obriga a implementacao nas publicacoes de um 
 * metodo que devolve o maximo de dias de requisicao.
 */
public interface Requisitavel {
	
    /**
     * As classes que implementam a interface sao
     * passiveis de ser emprestadas aos leitores.
     * @return um inteiro com o numero maximo de dias da requisicao.
     */
    public int maximoDiasRequisicao();
    
}