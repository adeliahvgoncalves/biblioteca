package pt.uc.dei.ar;


import java.util.*;

/**
 * 
 */
public class Biblioteca {

	/**
     * 
     */
    private ArrayList<Emprestimo> listaDeEmprestimo;

    /**
     * 
     */
    private ArrayList<Publicacao> listaDePublicacoes;

    /**
     * 
     */
    private ArrayList<Utilizador> listaDeUtilizadores;

    
    
    
    /**
     * Default constructor
     */
    public Biblioteca() {
    }

    /**
     * @param Publicacao
     */
    public void adicionaPublicacao(Publicacao publicacao) {
        // TODO implement here
    }

    /**
     * @param Utilizador
     */
    public void adicionaUtilizador(Utilizador utlizador) {
        // TODO implement here
    }

    /**
     * @param Emprestimo
     */
    public void adicionaEmprestimo(Emprestimo emprestimo) {
        // TODO implement here
    }

    /**
     * @param Publicacao
     */
    public void removePublicacao(Publicacao publicacao) {
        // TODO implement here
    }

    /**
     * @param Utilizador
     */
    public void removeUtilizador(Utilizador utilizador) {
        // TODO implement here
    }

    /**
     * @param Emprestimo 
     * @return
     */
    public Emprestimo devolveEmprestimo(Emprestimo emprestimo) {
        // TODO implement here
        return null;
    }

    /**
     * @param String nome 
     * @return
     */
    public Publicacao pesquisaPublicacao(String nome) {
        // TODO implement here
        return null;
    }

    /**
     * @param int codigoBarras 
     * @return
     */
    public Publicacao pesquisaPublicacao(int codigoBarras) {
        // TODO implement here
        return null;
    }

    /**
     * @param String Nome 
     * @return
     */
    public ArrayList<Emprestimo> consultaEmprestimosLeitor(String Nome) {
        // TODO implement here
        return null;
    }

    /**
     * @param String area 
     * @return
     */
    public ArrayList<Publicacao> pesquisaPorArea(String area) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public ArrayList<Emprestimo> consultaEmprestimoExpirado() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public ArrayList<Emprestimo> consultaEmprestimoGlobal() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int mediaEmprestimo() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int duracaoMinimaEmprestimo() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int duracacaoMaximaEmprestimo() {
        // TODO implement here
        return 0;
    }

    /**
     * @param ArrayList Emprestimo 
     * @return
     */
    public int totalEmprestimoglobal(ArrayList<Emprestimo> emprestimos) {
        // TODO implement here
        return 0;
    }

    /**
     * @param String nome 
     * @return
     */
    public Utilizador pesquisaUtilizadorPorNome(String nome) {
        // TODO implement here
        return null;
    }

    /**
     * @param String cartaoCidadao 
     * @return
     */
    public Utilizador pesquisaUtilizadorPorCC(String cartaoCidadao) {
        // TODO implement here
        return null;
    }

    /**
     * @param dataLimiteEntrega 
     * @param Date now 
     * @return
     */
    public int diasEmAtraso(Date dataLimiteEntrega) {
        // TODO implement here
        return 0;
    }

	public ArrayList<Publicacao> getListaDePublicacoes() {
		return listaDePublicacoes;
	}

	public void setListaDePublicacoes(ArrayList<Publicacao> listaDePublicacoes) {
		this.listaDePublicacoes = listaDePublicacoes;
	}

	public ArrayList<Utilizador> getListaDeUtilizadores() {
		return listaDeUtilizadores;
	}

	public void setListaDeUtilizadores(ArrayList<Utilizador> listaDeUtilizadores) {
		this.listaDeUtilizadores = listaDeUtilizadores;
	}

	public ArrayList<Emprestimo> getListaDeEmprestimo() {
		return listaDeEmprestimo;
	}

	public void setListaDeEmprestimo(ArrayList<Emprestimo> listaDeEmprestimo) {
		this.listaDeEmprestimo = listaDeEmprestimo;
	}

}