package pt.uc.dei.ar;


import java.util.*;

/**
 * Biblioteca representa a biblioteca e todos os seus recursos
 */
public class Biblioteca {

	/**
     * Lista de utilizadores é atributo da classe biblioteca
     */
    private ArrayList<Utilizador> listaDeUtilizadores;

	

    /**
     * Lista de publicações é atributo da classe biblioteca
     */
    private ArrayList<Publicacao> listaDePublicacoes;

   

    /**
     * Lista de empréstimos é atributo da classe biblioteca
     */
    private ArrayList<Emprestimo> listaDeEmprestimo;
    
    
    

    /**
     * Construtor da classe biblioteca
	 * @param listaDeUtilizadores
	 * @param listaDePublicacoes
	 * @param listaDeEmprestimo
	 */
	public Biblioteca() {
		super();
		this.listaDeUtilizadores = new ArrayList<Utilizador>();
		this.listaDePublicacoes =new ArrayList<Publicacao>();
		this.listaDeEmprestimo = new ArrayList<Emprestimo>();
	}

	/**
     * Adiciona uma publicação nova
     * @param Publicacao
     */
    public void adicionaPublicacao(Publicacao publicacao) {
    	listaDePublicacoes.add(publicacao);
    }

    /**
     * Adiciona um utilizador novo
     * @param Utilizador
     */
    public void adicionaUtilizador(Utilizador utilizador) {
        listaDeUtilizadores.add(utilizador);
    }

    /**
     * Adiciona um empréstimo novo
     * @param Emprestimo
     */
    public void adicionaEmprestimo(Emprestimo emprestimo) {
    	listaDeEmprestimo.add(emprestimo);
    }

    /**
     * Remove uma publicação
     * @param publicacao
     */
    public void removePublicacao(Publicacao publicacao) {
        listaDePublicacoes.remove(publicacao);
    }

    /**
     * Remove utilizador
     * @param utilizador
     */
    public void removeUtilizador(Utilizador utilizador) {
    	listaDeUtilizadores.remove(utilizador);
    }

    /**
     * @param emprestimo 
     * @return
     */
    public Emprestimo devolveEmprestimo(Emprestimo emprestimo) {
        // TODO implement here
        return null;
    }

    
    // faz sentido?! pesquisa por nome com todos os resultados duma palavra
  
//    public ArrayList<Publicacao> pesquisaPublicacaoComParteNome(String nome) {
//    	ArrayList<Publicacao> publicacaoComParteNome=new ArrayList<Publicacao>();
//
//		for (Publicacao publicacao: listaDePublicacoes){
//			if(publicacao.getTitulo().contains(nome))	{	
//				publicacaoComParteNome.add(publicacao);
//			}
//
//		}
//		return publicacaoComParteNome;
//      
//    }
      
    

    /**
     * @param String nome 
     * @return
     */
    public Publicacao pesquisaPublicacao(String nome) {
    	Publicacao pesquisaNome=null;
		for (Publicacao publicacao: listaDePublicacoes){
			if(publicacao.getTitulo().equalsIgnoreCase(nome))	{	
				
				 pesquisaNome=publicacao;
			}

		}
		return pesquisaNome;
      
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

	/**
	 * @return the listaDeUtilizadores
	 */
	public ArrayList<Utilizador> getListaDeUtilizadores() {
		return listaDeUtilizadores;
	}

	/**
	 * @param listaDeUtilizadores the listaDeUtilizadores to set
	 */
	public void setListaDeUtilizadores(ArrayList<Utilizador> listaDeUtilizadores) {
		this.listaDeUtilizadores = listaDeUtilizadores;
	}

	/**
	 * @return the listaDePublicacoes
	 */
	public ArrayList<Publicacao> getListaDePublicacoes() {
		return listaDePublicacoes;
	}

	/**
	 * @param listaDePublicacoes the listaDePublicacoes to set
	 */
	public void setListaDePublicacoes(ArrayList<Publicacao> listaDePublicacoes) {
		this.listaDePublicacoes = listaDePublicacoes;
	}

	/**
	 * @return the listaDeEmprestimo
	 */
	public ArrayList<Emprestimo> getListaDeEmprestimo() {
		return listaDeEmprestimo;
	}

	/**
	 * @param listaDeEmprestimo the listaDeEmprestimo to set
	 */
	public void setListaDeEmprestimo(ArrayList<Emprestimo> listaDeEmprestimo) {
		this.listaDeEmprestimo = listaDeEmprestimo;
	}

	

}