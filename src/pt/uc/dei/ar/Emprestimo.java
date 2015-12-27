package pt.uc.dei.ar;

import java.util.*;

/**
 * 
 */
public class Emprestimo implements Requisitavel {

    /**
     * Default constructor
     */
    public Emprestimo() {
    }

    /**
     * 
     */
    private int numEmp;

    /**
     * 
     */
    private Leitor leitor;

    /**
     * 
     */
    private Date dataEmp;

    /**
     * 
     */
    private Date dataDev;

    /**
     * 
     */
    private Requisitavel publicacao;





    /**
     * @return
     */
    public Date getDataEmp() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Date getDataDev() {
        // TODO implement here
        return null;
    }

    /**
     * @param Date data
     */
    public void setDataDev(Date data) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Leitor getLeitor() {
        // TODO implement here
        return null;
    }

    /**
     * @param Date dataEmp 
     * @return
     */
    public Date dataLimiteEntrega(Date dataEmp) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int maximoDiasRequisicao() {
        // TODO implement here
        return 0;
    }

}