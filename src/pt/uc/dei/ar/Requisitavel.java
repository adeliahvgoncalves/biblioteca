package pt.uc.dei.ar;

/**
 * Requisitável é uma interface que obriga à implementação nas publicações de um 
 * método que devolve o máximo de dias de requisição.
 * 
 */
public interface Requisitavel {
	
    /**
     * As classes que implementam a interface são
     * passiveis de ser emprestadas aos leitores.
     * 
     * @return um inteiro com o número máximo de dias da requisição.
     */
    public int maximoDiasRequisicao();

}