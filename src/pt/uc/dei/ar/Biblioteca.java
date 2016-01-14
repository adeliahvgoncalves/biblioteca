package pt.uc.dei.ar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	 * 
	 */
	private static Biblioteca instance;


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
	 * Método público estático de acesso único ao objeto
	 * @param 
	 */
	public static Biblioteca getInstance(){

		if(instance == null) 
		{
			instance= new Biblioteca();
			// O valor é retornado para quem está a pedir

		}
		return instance;
		// Retorna o a instância do objeto

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
	 * Pesquisa utilizador por username
	 * @param string  username
	 * @return um utilizador  com esse username
	 */
	public Utilizador pesquisaUtilizadorPorUsername(String username) {
		Utilizador utilizadorPorUsername = null;

		for (Utilizador utilizador : listaDeUtilizadores) {
			if(utilizador.getUsername().equalsIgnoreCase(username)){
				utilizadorPorUsername= utilizador;
			}
		}
		System.out.println(utilizadorPorUsername);
		return utilizadorPorUsername;
	}

	/**
	 * Gerar username para o utilizador
	 * @param nome
	 * @return username em formto String
	 */
	public String gerarUsername(String nome){

		//TODO: acrescentar ao username o codigo de leitor?
		String string = nome;
		String [] result = string.split(" ");
		String palavra1 = null, palavra2 = null;
		int indiceDoUltimo = result.length -1;

		for (int x = 0; x < result.length; x++){
			
			if (x == 0 ) {
				
				palavra1 = result[x].substring(0,3); 
			}
			if( x== indiceDoUltimo){
				palavra2 = result[x].substring(0,2);
			}

		}
		return palavra1+palavra2;
	}


	/**
	 * Gerar password random para o utilizador
	 * @return password com 4 digitos 
	 */
	public int gerarPassword(){
		Random gerador = new Random();
		int password=0;
		
		for (int i = 0; i < 10; i++) {
			password = gerador.nextInt(10000); 
		}
		return password;
	}


	/**
	 * Login encontrado
	 * @param username
	 * @param password
	 * @return se encontrou o utilizador registado é devolvido, se não devolve null
	 */
	public Utilizador login(String username, String password){

		Utilizador utilizador=pesquisaUtilizadorPorUsername(username);

		if(utilizador != null && utilizador.getHashedPassword().equals(password)){
			return utilizador;
		}
		System.out.println(utilizador);
		return null;
	}


	/**
	 * Pesquisa utilizador com cartão do cidadão
	 * @param string  cartão do cidadão
	 * @return um Leitor  com esse cartão do cidadão
	 */
	public Utilizador pesquisaUtilizadorPorCartaoCidadao(String cartaoCidadao) {
		Leitor leitorNumLeitor = null;
		for (Utilizador utilizador : listaDeUtilizadores) {
			if(utilizador instanceof Leitor)

				if(((Leitor) utilizador).getCartaoCidadao().equalsIgnoreCase(cartaoCidadao)){
					leitorNumLeitor=(Leitor) utilizador;
				}
		}

		return leitorNumLeitor;
	}


	/**
	 * Cria leitor e adiciona ao arrayList utilizador
	 * @param username
	 * @param hashedPassword
	 * @param nome
	 * @param numLeitor
	 * @param dataNascimento
	 * @param cartaoCidadao
	 * @param morada
	 * @param email
	 * @param telefone
	 * @return true se criado corretamente
	 */
	public boolean criaLeitor(String username, String hashedPassword, String nome,
			String dataNascimento, String cartaoCidadao, String morada, String email, String telefone){
		Leitor leitor1=(Leitor) pesquisaUtilizadorPorCartaoCidadao(cartaoCidadao);
		if(leitor1==null){
			Leitor leitor= new Leitor(username, hashedPassword, nome, dataNascimento, cartaoCidadao, morada, email, telefone);
			this.adicionaUtilizador(leitor);
			System.out.println(leitor.getNome() +"  " + "Leitor com o numero" + leitor.getNumLeitor());
		}else {System.out.print("já existe!");
		}
		return true;

	}

	/**
	 * Cria colaborador e adiciona ao arrayList utilizador
	 * @param username
	 * @param hashedPassword
	 * @param nome
	 * @param numColaborador
	 * @return true se criado corretamente
	 */
	public boolean criaColaborador(String username, String hashedPassword, String nome, int numColaborador){
		Colaborador colaborador=new Colaborador(username, hashedPassword, nome, numColaborador);
		this.adicionaUtilizador(colaborador);
		return true;
	}

	/**
	 * Cria bibliotecario chefe e adiciona ao arrayList utilizador
	 * @param username
	 * @param hashedPassword
	 * @param nome
	 * @param numColaborador
	 * @return true se criado corretamente
	 */
	public boolean criaBibliotecarioChefe(String username, String hashedPassword, String nome, int numColaborador){
		BibliotecarioChefe bibliotecarioChefe=new BibliotecarioChefe(username, hashedPassword, nome, numColaborador);
		this.adicionaUtilizador(bibliotecarioChefe);
		return true;

	}


	/**
	 * Cria revista e adiciona ao arrayList Publicação
	 * @param titulo
	 * @param dataPublicacao
	 * @param dataReceçao
	 * @param areas
	 * @param periodicidade
	 * @param volume
	 * @param numeroSequencial
	 * @return
	 */

	public boolean criaRevista(String titulo, String dataPublicacao, String dataReceçao, ArrayList<String> areas,
			Periodicidade periodicidade, int volume){

		Revista revista= new Revista(titulo, dataPublicacao, dataReceçao, areas, periodicidade, volume);
		this.adicionaPublicacao(revista);
		System.out.println(revista.getTitulo()+"codigo de barras"+revista.getCodBarras());
		return true;
	}


	/**
	 * Cria Jornal e adiciona ao arrayList Publicação
	 * @param titulo
	 * @param dataPublicacao
	 * @param dataReceçao
	 * @param areas
	 * @param periodicidade
	 * @param numEdicao
	 * @return
	 */

	public boolean criaJornal(String titulo, String dataPublicacao, String dataReceçao, ArrayList<String> areas,
			Periodicidade periodicidade, int numEdicao){
		Jornal jornal = new Jornal(titulo, dataPublicacao, dataReceçao, areas, periodicidade, numEdicao);
		this.adicionaPublicacao(jornal);
		System.out.println(jornal.getTitulo()+"  "+"codigo de barras"+jornal.getCodBarras());
		return true;
	}

	/**
	 * Cria tese e adiciona ao arrayList Publicação
	 * @param titulo
	 * @param dataPublicacao
	 * @param dataReceçao
	 * @param autores
	 * @param areas
	 * @param nomeDoOrientador
	 * @param tipoDeTese
	 * @return
	 */
	public boolean criaTese(String titulo, String dataPublicacao, String dataReceçao, ArrayList<String> autores,
			ArrayList<String> areas, String nomeDoOrientador, TipoDeTese tipoDeTese){
		Tese tese = new Tese(titulo, dataPublicacao, dataReceçao, autores, areas, nomeDoOrientador, tipoDeTese);
		this.adicionaPublicacao(tese);
		System.out.println(tese.getTitulo()+"  "+"codigo de barras"+tese.getCodBarras());
		return true;
	}

	/**
	 * Cria livro e adiciona ao arrayList Publicação
	 * @param titulo
	 * @param dataPublicacao
	 * @param dataReceçao
	 * @param autores
	 * @param areas
	 * @param numEdicao
	 * @param iSBN
	 * @param editor
	 * @return
	 */
	public boolean criaLivro(String titulo, String dataPublicacao, String dataReceçao, ArrayList<String> autores,
			ArrayList<String> areas, String numEdicao, String iSBN, String editor){
		Livro livro = new Livro(titulo, dataPublicacao, dataReceçao, autores, areas, numEdicao, iSBN, editor);
		this.adicionaPublicacao(livro);
		System.out.println(livro.getTitulo()+"  "+"codigo de barras"+livro.getCodBarras());
		return true;

	}

	/**
	 * Pesquisa utilizador com número de colaborador
	 * @param int número de colaborador
	 * @return um Utilizador utilizador com esse número de colaborador
	 */
	public Utilizador pesquisaUtilizadorPorNumColaborador(int numCol) {
		Utilizador utilizadorColaborador = null;
		for (Utilizador utilizador : listaDeUtilizadores) {

			if(utilizador instanceof Colaborador ||utilizador instanceof BibliotecarioChefe){

				if(((Colaborador) utilizador).getNumColaborador()==numCol ||
						((BibliotecarioChefe) utilizador).getNumColaborador()==numCol){
					utilizadorColaborador=utilizador;
				}

			}
		}

		return utilizadorColaborador;
	}




	/**
	 * Pesquisa utilizador com número de leitor
	 * @param int número de leitor
	 * @return um Utilizador utilizador com esse número de leitor
	 */
	public Utilizador pesquisaUtilizadorPorNumLeitor(int numLeitor) {
		Leitor leitorNumLeitor = null;
		for (Utilizador utilizador : listaDeUtilizadores) {
			if(utilizador instanceof Leitor)

				if(((Leitor) utilizador).getNumLeitor()==numLeitor){
					leitorNumLeitor=(Leitor) utilizador;
				}
		}

		return leitorNumLeitor;
	}


	/**
	 * Pesquisa pubicação por código de barras
	 * @param int codigoBarras 
	 * @return uma Publicação publicaçãoComCodigoBarras
	 */
	public Publicacao pesquisaPublicacaoPorCodBarras(int codigoBarras) {

		Publicacao publicaçãoComCodigoBarras = null;

		for (Publicacao publicacao : listaDePublicacoes) {
			if(publicacao.getCodBarras() == codigoBarras ){
				publicaçãoComCodigoBarras=publicacao;
			}
		}
		return publicaçãoComCodigoBarras;	

	}


	/**
	 * Cria emprestimo
	 * @param codigoBarras
	 * @param cc
	 * @return true se criado corretamente
	 */
	public boolean criaEmprestimo(int numLeitor, int codigoBarras) {
		Leitor utilizador = (Leitor) pesquisaUtilizadorPorNumLeitor(numLeitor);
		Publicacao publicacao = pesquisaPublicacaoPorCodBarras(codigoBarras);

		if (publicacao.isOcupado()) {

			return false;
		}

		Emprestimo emprestimo= new Emprestimo(utilizador, new Date(), (Requisitavel) publicacao);
		this.adicionaEmprestimo(emprestimo);
		((Leitor) utilizador).adicionaEmprestimo(emprestimo);
		publicacao.setOcupado(true);
		System.out.println("Criei emprestimo "+emprestimo);

		return true;
	}


	public void devolveEmprestimoAMao(int codigoBarras, Date Date){
		for (Emprestimo emprestimo : listaDeEmprestimo) {
			Publicacao publicacaoParaDevolver=(Publicacao) emprestimo.getPublicacao();
			if(publicacaoParaDevolver.getCodBarras()==codigoBarras){
				emprestimo.setDataDev(new Date());
				publicacaoParaDevolver.setOcupado(false);
			}

		}

	}

	/**
	 * Devolve empréstimo
	 * @param codigoBarras
	 * @return false se nao existir o empréstimo
	 */
	public boolean devolveEmprestimo(int codigoBarras) {

		for (Emprestimo emprestimo : listaDeEmprestimo) {
			Publicacao publicacaoParaDevolver=(Publicacao) emprestimo.getPublicacao();

			if(publicacaoParaDevolver.getCodBarras()==codigoBarras){

				if (!publicacaoParaDevolver.isOcupado()) {

					return false;

				} else {
					emprestimo.setDataDev(new Date());
					publicacaoParaDevolver.setOcupado(false);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Imprime a listagem de publicações
	 */
	public void imprimeListaTotalPublicacoes(){
		System.out.println("Listagem total de publicacções:");
		for (Publicacao publicacao : listaDePublicacoes) {
			System.out.println(publicacao);
		}
	}



	/**
	 * Pesquisa por área
	 * @param String area 
	 * @return arrayList de publicações daquela área 
	 */
	public ArrayList<Publicacao> pesquisaPorArea(String area) {
		ArrayList<Publicacao> publicacaoPorArea= new ArrayList<Publicacao>();

		for(Publicacao publicacao: listaDePublicacoes){

			if(publicacao.getListaDeAreas().contains(area)){
				publicacaoPorArea.add(publicacao);
			}
		}
		return publicacaoPorArea;
	}



	/**
	 * @param emprestimo 
	 * @return Publicações que contém parte nome de autor
	 */
	public ArrayList<Publicacao> pesquisaPublicacaoComParteNomeAutor(String nome) {
		ArrayList<Publicacao> publicacaoComParteNome=new ArrayList<Publicacao>();

		for (Publicacao publicacao: listaDePublicacoes){

			if(publicacao instanceof NaoPeriodico && ((NaoPeriodico) publicacao).getListaDeAutores().contains(nome)){	
				publicacaoComParteNome.add(publicacao);
			}

		}
		return publicacaoComParteNome;

	}


	/**
	 * @param emprestimo 
	 * @return Publicações que contém esse nome
	 */
	public ArrayList<Publicacao> pesquisaPublicacaoComParteNome(String nome) {
		ArrayList<Publicacao> publicacaoComParteNome=new ArrayList<Publicacao>();

		for (Publicacao publicacao: listaDePublicacoes){
			if(publicacao.getTitulo().contains(nome))	{	
				publicacaoComParteNome.add(publicacao);
			}

		}
		return publicacaoComParteNome;

	}


	/**
	 * @param String nome 
	 * @return Publicacao
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
	 * Lista os empréstimos que já deveriam ter sido devolvidos
	 * @return empréstimo expirados
	 */
	public ArrayList<Emprestimo> consultaEmprestimoExpirado() {

		ArrayList<Emprestimo> emprestimosDataExpirada=new ArrayList<Emprestimo>();
		Date now=new Date();
		long dataAtual=now.getTime();

		for (Emprestimo emprestimo : listaDeEmprestimo) {

			Date dataMaximaEntrega = emprestimo.getDataEmp();			
			Calendar c = Calendar.getInstance();
			c.setTime(dataMaximaEntrega);
			c.add(Calendar.DATE, emprestimo.getPublicacao().maximoDiasRequisicao());
			long dataMaximaEntrega1 = c.getTimeInMillis();

			if(emprestimo.getDataDev() == null){

				if(dataMaximaEntrega1 < dataAtual){
					emprestimosDataExpirada.add(emprestimo);

				}
			}

		}
		return emprestimosDataExpirada;
	}

	/**
	 * @return
	 */
	public ArrayList<Emprestimo> consultaEmprestimoGlobal() {
		for (Emprestimo emprestimo : listaDeEmprestimo) {

		}
		return null;
	}

	/**
	 * @return
	 */
	public int mediaEmprestimo() {
		// TODO implement here
		return 0;
	}


	public long diasDeEmprestimo(Emprestimo emprestimo){
		long diasEmprestimo = 0;
		return diasEmprestimo=emprestimo.getDataDev().getTime()-emprestimo.getDataEmp().getTime();

		//	}
		//	return diasEmprestimo;
	}

	/**
	 * @return
	 */
	public int duracaoMinimaEmprestimo() {
		for (Emprestimo emprestimo : listaDeEmprestimo) {
			//	emprestimo.getPublicacao()

		}
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Biblioteca [listaDeUtilizadores=" + listaDeUtilizadores + ", listaDePublicacoes=" + listaDePublicacoes
				+ ", listaDeEmprestimo=" + listaDeEmprestimo + "]";
	}



}