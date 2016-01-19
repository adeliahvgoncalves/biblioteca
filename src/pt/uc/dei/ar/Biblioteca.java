package pt.uc.dei.ar;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

/**
 * Biblioteca representa a biblioteca e todos os seus recursos e implementa o Serializable
 */
public class Biblioteca implements Serializable{

	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = -459669107686914825L;



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
	 * Contadores da biblioteca  que guardam  números sequenciais
	 */
	private Contadores contadores;


	/**
	 * Instanciar a biblioteca
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
			instance = BibliotecaSerializer.getInstance().abreBiblioteca();
			if (instance == null) {

				instance = new Biblioteca();
			}
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
	 * Pesquisa utilizador por username
	 * @param string  username
	 * @return um utilizador  com esse username
	 */
	public Utilizador pesquisaUtilizadorPorUsername(String username) {
		Utilizador utilizadorPorUsername = null;

		for (Utilizador utilizador : listaDeUtilizadores) {
			if(utilizador.getUsername().equalsIgnoreCase(username)){
				utilizadorPorUsername = utilizador;
			}
		}

		return utilizadorPorUsername;
	}


	/**
	 * Verifica se a publicação é requisitavel
	 * @param publicacao
	 * @return true se implementa o requisitável
	 */
	public boolean autorizaRequisitavel(Publicacao publicacao){

		if(publicacao instanceof Requisitavel ){

			return true;
		} 
		return false;
	}



	/**
	 * Gerar password random para o utilizador
	 * @return password com 4 digitos 
	 */
	public String gerarPassword(){
		Random gerador = new Random();
		int password=0;

		for (int i = 0; i < 10; i++) {
			password = gerador.nextInt(10000); 
		}

		return Integer.toString(password);
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
					leitorNumLeitor = (Leitor) utilizador;
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
	 * @return número de leitor
	 */
	public int criaLeitor(String username,  String nome,
			String dataNascimento, String cartaoCidadao, String morada, String email, String telefone){
		//	Leitor leitor1 = (Leitor) pesquisaUtilizadorPorCartaoCidadao(cartaoCidadao);
		//	Leitor leitor = null;
		//if(leitor1 == null){
		Leitor leitor=null;
		leitor = new Leitor(username, nome, dataNascimento, cartaoCidadao, morada, email, telefone);
		this.adicionaUtilizador(leitor);

		//System.out.println("num leitor:"+leitor.getNumLeitor() + "Password"+leitor.getHashedPassword());
		return leitor.getNumLeitor();

	}

	/**
	 * Cria colaborador e adiciona ao arrayList utilizador
	 * @param username
	 * @param hashedPassword
	 * @param nome
	 * @param numColaborador
	 * @return true se criado corretamente
	 */
	public boolean criaColaborador(String username,  String nome, int numColaborador){
		Colaborador colaborador = new Colaborador(username,  nome, numColaborador);
		this.adicionaUtilizador(colaborador);
		System.out.println( "Password"+colaborador.getHashedPassword());
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
	public boolean criaBibliotecarioChefe(String username, String nome, int numColaborador){
		BibliotecarioChefe bibliotecarioChefe = new BibliotecarioChefe(username, nome, numColaborador);
		this.adicionaUtilizador(bibliotecarioChefe);
		//System.out.println( "Password"+bibliotecarioChefe.getHashedPassword());
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
	 * @return código de barras
	 */
	public int criaRevista(String titulo, String dataPublicacao, String dataReceçao, ArrayList<String> areas,
			Periodicidade periodicidade, int volume){

		Revista revista = new Revista(titulo, dataPublicacao, dataReceçao, areas, periodicidade, volume);
		this.adicionaPublicacao(revista);
		System.out.print ( revista.getCodBarras());
		return revista.getCodBarras();
	}


	/**
	 * Cria Jornal e adiciona ao arrayList Publicação
	 * @param titulo
	 * @param dataPublicacao
	 * @param dataReceçao
	 * @param areas
	 * @param periodicidade
	 * @param numEdicao
	 * @return código de barras
	 */
	public int criaJornal(String titulo, String dataPublicacao, String dataReceçao, ArrayList<String> areas,
			Periodicidade periodicidade, int numEdicao){
		Jornal jornal = new Jornal(titulo, dataPublicacao, dataReceçao, areas, periodicidade, numEdicao);
		this.adicionaPublicacao(jornal);
		System.out.print ( jornal.getCodBarras());
		return jornal.getCodBarras();
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
	 * @return código de barras
	 */
	public int criaTese(String titulo, String dataPublicacao, String dataReceçao, ArrayList<String> autores,
			ArrayList<String> areas, String nomeDoOrientador, TipoDeTese tipoDeTese){
		Tese tese = new Tese(titulo, dataPublicacao, dataReceçao, autores, areas, nomeDoOrientador, tipoDeTese);
		this.adicionaPublicacao(tese);
		System.out.print ( tese.getCodBarras());
		return tese.getCodBarras();
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
	 * @return código de barras
	 */
	public int criaLivro(String titulo, String dataPublicacao, String dataReceçao, ArrayList<String> autores,
			ArrayList<String> areas, String numEdicao, String iSBN, String editor){
		Livro livro = new Livro(titulo, dataPublicacao, dataReceçao, autores, areas, numEdicao, iSBN, editor);
		this.adicionaPublicacao(livro);
		System.out.print ( livro.getCodBarras());
		return livro.getCodBarras();

	}

	/**
	 * Pesquisa utilizador com número de colaborador
	 * @param int número de colaborador
	 * @return um Utilizador utilizador com esse número de colaborador
	 */
	public Utilizador pesquisaUtilizadorPorNumColaborador(int numCol) {
		Utilizador utilizadorColaborador = null;
		for (Utilizador utilizador : listaDeUtilizadores) {

			if(utilizador instanceof Colaborador){

				if(((Colaborador) utilizador).getNumColaborador() == numCol){
					utilizadorColaborador = utilizador;
				}
			}
			else if (utilizador instanceof BibliotecarioChefe)

				if(((BibliotecarioChefe) utilizador).getNumColaborador() == numCol){

					utilizadorColaborador = utilizador;
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

				if(((Leitor) utilizador).getNumLeitor() == numLeitor){
					leitorNumLeitor = (Leitor) utilizador;
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
				publicaçãoComCodigoBarras = publicacao;
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

		Emprestimo emprestimo = new Emprestimo(utilizador, new Date(), (Requisitavel) publicacao);
		this.adicionaEmprestimo(emprestimo);
		((Leitor) utilizador).adicionaEmprestimo(emprestimo);
		publicacao.setOcupado(true);


		return true;
	}


	/**
	 * Devolve empréstimo
	 * @param codigoBarras
	 * @return false se nao existir o empréstimo
	 */
	public boolean devolveEmprestimo(int codigoBarras) {

		for (Emprestimo emprestimo : listaDeEmprestimo) {
			Publicacao publicacaoParaDevolver = (Publicacao) emprestimo.getPublicacao();

			if(publicacaoParaDevolver.getCodBarras() == codigoBarras && emprestimo.getDataDev()==null){

				if (!publicacaoParaDevolver.isOcupado()) {

					return false;

				} else {
					emprestimo.setDataDev(new Date());
					publicacaoParaDevolver.setOcupado(false);
					Leitor leitor = emprestimo.getLeitor();
					Leitor leitor2 = (Leitor)this.pesquisaUtilizadorPorNumLeitor(leitor.getNumLeitor());
					leitor.removeEmprestimo(emprestimo);
					return true;
				}
			}
		}
		return false;
	}


	/**
	 * Pesquisa por área
	 * @param String area 
	 * @return arrayList de publicações daquela área 
	 */
	public ArrayList<Publicacao> pesquisaPorArea(String area) {

		ArrayList<Publicacao> publicacaoPorArea= new ArrayList<Publicacao>();
		for(Publicacao publicacao: listaDePublicacoes){
			ArrayList<String> areas=publicacao.getListaDeAreas();

			for (String areaProcura : areas) {

				if(areaProcura.equalsIgnoreCase(area)){
					publicacaoPorArea.add(publicacao);
				}
			}
		}
		return publicacaoPorArea;
	}


	/**
	 * Pesquisa publicação por autor
	 * @param emprestimo 
	 * @return Publicações que contém nome do autor
	 */
	public ArrayList<Publicacao> pesquisaPublicacaoComParteNomeAutor(String nome) {

		ArrayList<Publicacao> publicacaoAutor= new ArrayList<Publicacao>();
		for(Publicacao publicacao: listaDePublicacoes){
			if(publicacao instanceof NaoPeriodico){
				ArrayList<String> autores=((NaoPeriodico) publicacao).getListaDeAutores();


				for (String autorProcura : autores) {
					if(autorProcura.equalsIgnoreCase(nome)){
						publicacaoAutor.add(publicacao);
					}
				}
			}
		}
		return publicacaoAutor;
	}

	/**
	 * Pesquisa publicação por título
	 * @param emprestimo 
	 * @return Publicações que contém parte de título
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
	 * Pesquisa publicação por título
	 * @param String nome 
	 * @return Publicacao
	 */
	public Publicacao pesquisaPublicacao(String nome) {
		Publicacao pesquisaNome = null;
		for (Publicacao publicacao: listaDePublicacoes){
			if(publicacao.getTitulo().equalsIgnoreCase(nome))	{	

				pesquisaNome = publicacao;
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
	 * Determina o total de empréstimos nos últimos 12 meses
	 * @return número total de empréstimos do último ano em formato inteiro
	 */
	public int totalEmprestimosUltimoAno() {

		Calendar dataAtual = new GregorianCalendar(); 
		dataAtual.get(Calendar.YEAR);
		Calendar dataAnoAnterior = Calendar.getInstance();
		dataAnoAnterior.set(Calendar.MONTH, -12);

		ArrayList<Emprestimo> emprestimosUltimoAno= new ArrayList<Emprestimo>();
		for (Emprestimo emprestimo : listaDeEmprestimo) {
			Calendar dataDeEmp = Calendar.getInstance();
			dataDeEmp.setTime(emprestimo.getDataEmp());

			if(dataDeEmp.after(dataAnoAnterior) && dataDeEmp.before(dataAtual)){
				emprestimosUltimoAno.add(emprestimo);

			}
		}
		return emprestimosUltimoAno.size();
	}

	/**
	 *Gera um Map que indica quantos empréstimos houve para cada obra em cada um dos últimos 12 meses
	 * @param dataAtual
	 * @return um dicionario com a contagem de repeticoes mensais por cada Publicacao
	 */
	public Map<String, Integer>  geraMapaRepeticoesMensais(Calendar dataAtual){


		Calendar dataAnoAnterior = Calendar.getInstance();
		dataAnoAnterior.set(Calendar.MONTH, -12);
		Date data1=dataAnoAnterior.getTime();
		System.out.println("NAO VEJOUM CU"+data1);
		Map<String, Integer> countMap = new HashMap<String, Integer>();

		for (Emprestimo emprestimo : listaDeEmprestimo) {
			Calendar dataDeEmp= Calendar.getInstance();
			dataDeEmp.setTime(emprestimo.getDataEmp());
		
			if(dataDeEmp.after(dataAnoAnterior) && dataDeEmp.before(dataAtual)){

				Publicacao pub = (Publicacao) emprestimo.getPublicacao();

				String chave = pub.getCodBarras() + "-" + dataDeEmp.get(Calendar.MONTH);
				if (!countMap.containsKey(chave)) {
					countMap.put(chave, 1);
				} else {
					Integer count = countMap.get(chave);
					count = count + 1;
					countMap.put(chave, count);
				}	
			}
		}
		return countMap;
	}


	/**
	 * Gera um Map que indica quantos empréstimos houve para cada obra  no total dos últimos 12 meses
	 * @param ArrayList Emprestimo 
	 * @return um dicionario com a contagem de repeticoes por cada Publicacao
	 */
	public Map<Publicacao, Integer> totalEmprestimosPorPublicacaoNoAno() {

		Calendar dataAtual= new GregorianCalendar();
		Calendar dataAnoAnterior = Calendar.getInstance();
		dataAnoAnterior.set(Calendar.MONTH, -12);
		Map<Publicacao, Integer> countMap = new HashMap<Publicacao, Integer>();

		for (Emprestimo emprestimo : listaDeEmprestimo) {
			Calendar dataDeEmp= Calendar.getInstance();
			dataDeEmp.setTime(emprestimo.getDataEmp());

			if(dataDeEmp.after(dataAnoAnterior) && dataDeEmp.before(dataAtual)){

				Publicacao pub = (Publicacao) emprestimo.getPublicacao();

				if (!countMap.containsKey(pub)) {
					countMap.put(pub, 1);
				} else {
					Integer count = countMap.get(pub);
					count = count + 1;
					countMap.put(pub, count);
				}	
			}
		}	

		return countMap;
	}

	/**
	 * Para os últimos 12 meses, devolve um Map que relaciona as Publicacoes com os dias 
	 * que esteve emprestado
	 * de forma a fazermos o maximo, mínimo e média
	 * 
	 * @param dataAtual
	 * @return um map publicacao, dias de empréstimo
	 */
	public Map<Publicacao,MatematicaFuncoes> obterDiasEmprestimoPorPublicacao(Calendar dataAtual){

		Calendar dataAnoAnterior = Calendar.getInstance();
		dataAnoAnterior.set(Calendar.MONTH, -12);

		Map<Publicacao,ArrayList<Integer>> countMap = new HashMap<Publicacao,ArrayList<Integer>>();

		for (Emprestimo emprestimo : listaDeEmprestimo) {
			Calendar dataDeEmp= Calendar.getInstance();
			dataDeEmp.setTime(emprestimo.getDataEmp());

			if(dataDeEmp.after(dataAnoAnterior) && dataDeEmp.before(dataAtual)){
				Publicacao pub = (Publicacao) emprestimo.getPublicacao();

				int diasEmprestimo = emprestimo.diasDeEmprestimo();

				System.out.println("dias emprestimo" + diasEmprestimo);
				if (!countMap.containsKey(pub)) {
					ArrayList<Integer>daysArray = new ArrayList<Integer>(1);
					daysArray.add( new Integer(diasEmprestimo) );
					countMap.put(pub,daysArray);
				} else {
					ArrayList<Integer>daysArray = countMap.get(pub);
					daysArray.add( new Integer(diasEmprestimo) );

				}	
			}
		}
		// pegar no hash já calculado com arrays de dias por poblicacao e converter num novo hash
		// que associe à publicacao o Contagens com o maximo/minimo/media
		Map<Publicacao, MatematicaFuncoes> counts = new HashMap<Publicacao,MatematicaFuncoes>();
		for (Entry<Publicacao, ArrayList<Integer>> entry : countMap.entrySet()) {
			Publicacao publicacao = entry.getKey(); // chave 

			ArrayList<Integer> arrayInteiros = entry.getValue(); // valor
			MatematicaFuncoes contagens = new MatematicaFuncoes(arrayInteiros); // cria a nova estrutura de dados
			counts.put(publicacao, contagens); // põe a contagem para a public no hash

		}
		return counts;
	}

	/**
	 * Verifica se a biblioteca a inicializar tem dados
	 * @return boolean
	 */
	public boolean temDados(){
		return this.listaDeUtilizadores.size()>0;
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
	/**
	 * 
	 * @return contador em formato Contadores
	 */
	public Contadores getContadores() {
		return contadores;
	}

	/**
	 * 
	 * @param contadores
	 */
	public void setContadores(Contadores contadores) {
		this.contadores = contadores;
	}


	//	public Utilizador criaUtilizador1(String username, String password, String nome, int numColaborador){
	//	
	//		
	//		BiliotecarioChefe bibChefe= new Utilizador("dio", "123", "João Francisco Sousa Andrade", 1237);
	//		listaDeUtilizadores.add(bibChefe);
	//	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Biblioteca [listaDeUtilizadores=" + listaDeUtilizadores + ", listaDePublicacoes=" + listaDePublicacoes
				+ ", listaDeEmprestimo=" + listaDeEmprestimo + "]";
	}


	public boolean criaEmprestimoaMao(int numLeitor,Date dataEmp, int codBarras){
		Leitor leitor1 = (Leitor) pesquisaUtilizadorPorNumLeitor(numLeitor);
		Requisitavel pub1= (Requisitavel)pesquisaPublicacaoPorCodBarras(codBarras);
		Emprestimo	emprestimo=new Emprestimo(leitor1, dataEmp, pub1);
		this.adicionaEmprestimo(emprestimo);
		((Leitor) leitor1).adicionaEmprestimo(emprestimo);
		Publicacao pub=(Publicacao) pub1;
		pub.setOcupado(true);
		return true;
	}




	public void devolveEmprestimoAMao(int numEmp, Date Date){


		Emprestimo publicacaoParaDevolver = pesquisaEmprestimo(numEmp);

		publicacaoParaDevolver.setDataDev(Date);
		Leitor leitor = publicacaoParaDevolver.getLeitor();
		Leitor leitor2 = (Leitor)this.pesquisaUtilizadorPorNumLeitor(leitor.getNumLeitor());
		leitor.removeEmprestimo(publicacaoParaDevolver);

	}






	public Emprestimo pesquisaEmprestimo(int numEmp) {

		Emprestimo emprestimoNum=null;
		for (Emprestimo emprestimo : listaDeEmprestimo) {

			if(emprestimo.getNumEmp() == numEmp )
				emprestimoNum=emprestimo;


		}
		return emprestimoNum;


	}

	//Lista emprestimos

	public String emprestimosListagem(){
		for (Emprestimo emprestimo : listaDeEmprestimo) {
			Publicacao pub= (Publicacao) emprestimo.getPublicacao();

			System.out.println(pub.getCodBarras()+"Emp"+emprestimo.getNumEmp()+"Data Emp"+emprestimo.getDataEmp()+"Data Dev"+emprestimo.getDataDev());


		}
		return null;
	}
}