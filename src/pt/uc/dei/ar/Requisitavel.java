package pt.uc.dei.ar;

/**
 * A interface requisitável é a maneira que utilizamos para definir qual o objeto é requisitável.
 * Só as publicações que são requisitáveis implementam a interface.
 * 
 */
public interface Requisitavel {
	
    /**
     * Só as subclasse da publicação que implementam o métodomaximoDiasRequisicao()
     * são passiveis de ser emprestadas aos leitores.
     * @return
     */
    public int maximoDiasRequisicao();

}