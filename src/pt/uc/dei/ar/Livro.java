package pt.uc.dei.ar;

/**
 * 
 */
public class Livro extends NaoPeriodico implements Requisitavel {

    /**
     * Default constructor
     */
    public Livro() {
    }

    /**
     * 
     */
    private String numEdicao;

    /**
     * 
     */
    private String ISBN;

    /**
     * 
     */
    private String editor;

    /**
     * @return
     */
    public String getISBN() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String getNumEdicao() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String getEditor() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public int maximoDiasRequisicao() {
        // TODO implement here
        return 0;
    }

}