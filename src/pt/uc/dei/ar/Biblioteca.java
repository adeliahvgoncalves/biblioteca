package pt.uc.dei.ar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

/**
 * @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 * Biblioteca representa a biblioteca e todos os seus recursos e implementa o Serializable
 */
public class Biblioteca implements Serializable{

	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = -459669107686914825L;

	/**
	 * Lista de utilizadores e atributo da classe biblioteca
	 */
	private ArrayList<Utilizador> listaDeUtilizadores;

	/**
	 * Lista de publicacoes e atributo da classe biblioteca
	 */
	private ArrayList<Publicacao> listaDePublicacoes;

	/**
	 * Lista de emprestimos e atributo da classe biblioteca
	 */
	private ArrayList<Emprestimo> listaDeEmprestimo;

	/**
	 * Contadores da biblioteca  que guardam  numeros sequenciais
	 */
	private Contadores contadores;

	/**
	 * Instanciar a biblioteca
	 */
	private static Biblioteca instance;

	/**
	 * Construtor da classe biblioteca
	 * @param listaDeUtilizadores ArrayList com os Utilizadores da Biblioteca
	 * @param listaDePublicacoes ArrayList com as Publicacoes da Biblioteca
	 * @param listaDeEmprestimo ArrayList com os Emprestimos da Biblioteca
	 */
	public Biblioteca() {
		this.listaDeUtilizadores = new ArrayList<Utilizador>();
		this.listaDePublicacoes =new ArrayList<Publicacao>();
		this.listaDeEmprestimo = new ArrayList<Emprestimo>();
	}

	/**
	 * Metodo publico estatico de acesso unico ao objeto
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
		return instance; // Retorna a instância do objeto
	}

	/**
	 * Adiciona uma publicacao nova
	 * @param Publicacao publicacao que vai ser adicionada
	 */
	public void adicionaPublicacao(Publicacao publicacao) {
		
		listaDePublicacoes.add(publicacao);

	}

	/**
	 * Adiciona um utilizador novo
	 * @param Utilizador utilizador que vai ser adicionado
	 */
	public void adicionaUtilizador(Utilizador utilizador) {
		
		listaDeUtilizadores.add(utilizador);
		
	}

	/**
	 * Adiciona um emprestimo novo
	 * @param Emprestimo emprestimo que vai ser adicionado
	 */
	public void adicionaEmprestimo(Emprestimo emprestimo) {
		
		listaDeEmprestimo.add(emprestimo);
		
	}

	/**
	 * Pesquisa utilizador por username
	 * @param string  username do utilizador a ser pesquisado
	 * @return Caso encontre retorna um utilizador com esse username, caso contrario retorna null
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
	 * Verifica se a publicacao e requisitavel
	 * @param publicacao publicacao a ser verificada
	 * @return True se implementa o requisitavel, pode ser requisitada, false se nao for requisitavel
	 */
	public boolean autorizaRequisitavel(Publicacao publicacao){

		if(publicacao instanceof Requisitavel ){
			
			return true;
		} 
		return false;
	}

	/**
	 * Gera password random para o utilizador
	 * @return Password que vai ser criada
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
	 * Metodo que verifica se o username e a password do Utilizador estao correctos
	 * @param username username do utilizador a verificar
	 * @param password password do utilizador a verificar
	 * @return Se encontrou o utilizador registado e devolvido esse utilizador, caso contrario devolve null
	 */
	public Utilizador login(String username, String password){

		Utilizador utilizador=pesquisaUtilizadorPorUsername(username);

		if(utilizador != null && utilizador.getHashedPassword().equals(password)){
			return utilizador;
		}
	
		return null;
	}

	/**
	 * Pesquisa um leitor pelo cartao do cidadao
	 * @param string cartao do cidadao do leitor
	 * @return Se encontrar um Leitor com esse cartao do cidadao retorna esse leitor, caso contrario retorna null
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
	 * Cria leitor na Biblioteca e adiciona ao arrayList do utilizador
	 * @param username username do leitor a criar na Biblioteca
	 * @param nome nome do leitor a criar na Biblioteca
	 * @param dataNascimento a data de nascimento do leitor a criar na Biblioteca
	 * @param cartaoCidadao o Cartao do Cidadao do leitor a criar na Biblioteca
	 * @param morada morada do leitor a criar na Biblioteca
	 * @param email e-mail do leitor a criar na Biblioteca
	 * @param telefone telefone do leitor a criar na Biblioteca
	 * @return Numero de leitor que foi criado na biblioteca
	 */
	public int criaLeitor(String username,  String nome,
			String dataNascimento, String cartaoCidadao, String morada, String email, String telefone){
		
		Leitor leitor=null;
		leitor = new Leitor(username, nome, dataNascimento, cartaoCidadao, morada, email, telefone);
		
		this.adicionaUtilizador(leitor);
		System.out.println("Leitor"+"  username:  "+leitor.getUsername() + "   Password  "+leitor.getHashedPassword());
		return leitor.getNumLeitor();
		
	}

	/**
	 * Cria colaborador e adiciona ao arrayList utilizador
	 * @param username username do colaborador a criar na biblioteca
	 * @param nome nome do colaborador a criar na biblioteca
	 * @param numColaborador numero de colaborador a criar na biblioteca
	 * @return True se criado corretamente
	 */
	public Colaborador criaColaborador(String username,  String nome, int numColaborador){
		
		Colaborador colaborador = new Colaborador(username,  nome, numColaborador);
		this.adicionaUtilizador(colaborador);
		System.out.println( "Colaborador  "  + "Username:   "+colaborador.getUsername()+"  Password"+colaborador.getHashedPassword());
		return colaborador;
		
	}

	/**
	 * Cria bibliotecario chefe e adiciona ao arrayList utilizador
	 * @param username username do bilbiotecario chefe a criar na biblioteca
	 * @param nome nome do bilbiotecario chefe a criar na biblioteca
	 * @param numColaborador numero de colaborador do bilbiotecario chefe a criar na biblioteca
	 * @return True se criado corretamente
	 */
	public BibliotecarioChefe criaBibliotecarioChefe(String username, String nome, int numColaborador){
		
		BibliotecarioChefe bibliotecarioChefe = new BibliotecarioChefe(username, nome, numColaborador);
		this.adicionaUtilizador(bibliotecarioChefe);
		System.out.println( "Bibliotecário-Chefe  "  +  "  Username  "  +bibliotecarioChefe.getUsername()+  "  Password  "  +   bibliotecarioChefe.getHashedPassword());
		return bibliotecarioChefe;

	}

	/**
	 * Cria revista e adiciona ao arrayList Publicacao
	 * @param titulo titulo da revista a criar 
	 * @param dataPublicacao data de publicacao da revista a criar 
	 * @param dataRececao data de rececao da revista a criar 
	 * @param areas areas da revista a criar 
	 * @param periodicidade periodicidade da revista a criar 
	 * @param volume colume da revista a criar 
	 * @return Codigo de barras da revista que foi criada, numero sequencial e unico
	 */
	public int criaRevista(String titulo, String dataPublicacao, String dataRececao, ArrayList<String> areas,
			Periodicidade periodicidade, String volume){

		Revista revista = new Revista(titulo, dataPublicacao, dataRececao, areas, periodicidade, volume);
		this.adicionaPublicacao(revista);
		return revista.getCodBarras();
		
	}

	/**
	 * Cria Jornal e adiciona ao arrayList Publicacao
	 * @param titulo titulo do jornal a criar
	 * @param dataPublicacao data do jornal a criar
	 * @param dataRececao data de rececao do jornal a criar
	 * @param areas areas do jornal a criar
	 * @param periodicidade periodicidade do jornal a criar
	 * @param numEdicao numero de edicao do jornal a criar
	 * @return Codigo de barras da revista que foi criada, numero sequencial e unico
	 */
	public int criaJornal(String titulo, String dataPublicacao, String dataRececao, ArrayList<String> areas,
			Periodicidade periodicidade, String numEdicao){
		
		Jornal jornal = new Jornal(titulo, dataPublicacao, dataRececao, areas, periodicidade, numEdicao);
		this.adicionaPublicacao(jornal);
		return jornal.getCodBarras();
		
	}

	/**
	 * Cria tese e adiciona ao arrayList Publicacao
	 * @param titulo titulo da tese a criar
	 * @param dataPublicacao data de publicacao da tese a criar
	 * @param dataRececao data de rececao da tese a criar
	 * @param autor autor da tese a criar
	 * @param areas areas da tese a criar
	 * @param nomeDoOrientador nome do orientador da tese a criar
	 * @param tipoDeTese tipo de tese a criar, mestrado ou doutoramento
	 * @return Codigo de barras da tese que foi criada, numero sequencial e unico
	 */
	public int criaTese(String titulo, String dataPublicacao, String dataRececao, ArrayList<String> autor,
			ArrayList<String> areas, String nomeDoOrientador, TipoDeTese tipoDeTese){
		
		Tese tese = new Tese(titulo, dataPublicacao, dataRececao, autor, areas, nomeDoOrientador, tipoDeTese);
		this.adicionaPublicacao(tese);
		return tese.getCodBarras();
		
	}

	/**
	 * Cria livro e adiciona ao arrayList Publicacao
	 * @param titulo titulo do livro a criar
	 * @param dataPublicacao data de publicacao do livro a criar
	 * @param dataRececao data de rececao do livro a criar
	 * @param autores autores do livro a criar
	 * @param areas areas do livro a criar
	 * @param numEdicao numero de edicao do livro a criar
	 * @param iSBN isbn do livro a criar
	 * @param editor editor do livro a criar
	 * @return Codigo de barras do livro que foi criado, numero sequencial e unico
	 */
	public int criaLivro(String titulo, String dataPublicacao, String dataRececao, ArrayList<String> autores,
			ArrayList<String> areas, String numEdicao, String iSBN, String editor){
		
		Livro livro = new Livro(titulo, dataPublicacao, dataRececao, autores, areas, numEdicao, iSBN, editor);
		this.adicionaPublicacao(livro);
		return livro.getCodBarras();

	}

	/**
	 * Pesquisa utilizador pelo numero de colaborador
	 * @param int numero de colaborador a pesquisar
	 * @return Um utilizador com esse numero de colaborador, caso nao encontre retorna null
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
	 * Pesquisa utilizador pelo numero de leitor
	 * @param numLeitor de leitor a pesquisar
	 * @return Um Utilizador utilizador com esse numero de leitor
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
	 * Pesquisa pubicacao por codigo de barras.
	 * @param codigoBarras codigo de barras da publicacao a pesquisar  
	 * @return Uma publicacao caso encontre, se nao retorna null
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
	 * Cria um emprestimo na biblioteca.
	 * @param codigoBarras codigo de barras da publicacao
	 * @param numLeitor numero de leitor que vai fazer o emprestimo
	 * @return Se criado correctamente retorna true, se nao retorna false.
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
	 * Devolve um emprestimo na biblioteca
	 * @param codigoBarras codigo de barras da publicacao a ser devolvida
	 * @return True de criada correctamente, false se nao existir o emprestimo
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
					leitor.removeEmprestimo(emprestimo);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Pesquisa publicacoes por area
	 * @param area area a pesquisar
	 * @return Um arrayList de publicacoes com a area pesquisada
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
	 * Pesquisa publicacao por autor
	 * @param nome nome do autor a pesquisar
	 * @return Publicacoes que contem nome do autor pesquisado
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
	 * Pesquisa publicacao por titulo
	 * @param nome parte do titulo da publicacao a pesquisar 
	 * @return Publicacoes que contem parte de titulo que foi pesquisado
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
	 * Pesquisa publicacao por titulo
	 * @param titulo titulo da publicacao a pesquisar 
	 * @return Uma publicacao caso encontre, caso contrario devolve null
	 */
	public Publicacao pesquisaPublicacao(String titulo) {
		Publicacao pesquisaNome = null;
		for (Publicacao publicacao: listaDePublicacoes){
			if(publicacao.getTitulo().equalsIgnoreCase(titulo))	{	

				pesquisaNome = publicacao;
			}
		}
		return pesquisaNome;
	}

	/**
	 * Lista os emprestimos que ja deveriam ter sido devolvidos
	 * @return Lista de emprestimos expirados
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
	 * Determina o total de emprestimos nos ultimos 12 meses
	 * @return Numero total de emprestimos do ultimo ano em formato inteiro
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
	 *Gera um Map que indica quantos emprestimos houve para cada obra em cada um dos ultimos 12 meses
	 * @param dataAtual data actual do sistema
	 * @return Um dicionario com a contagem de repeticoes mensais por cada publicacao
	 */
	public Map<String, Integer>  geraMapaRepeticoesMensais(Calendar dataAtual){

		Calendar dataAnoAnterior = Calendar.getInstance();
		dataAnoAnterior.set(Calendar.MONTH, -12);
		
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
	 * Gera um Map que indica quantos emprestimos houve para cada obra  no total dos ultimos 12 meses
	 * @return Um dicionario com a contagem de repeticoes por cada Publicacao
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
	 * Para os ultimos 12 meses, devolve um Map que relaciona as Publicacoes com os dias 
	 * que esteve emprestado
	 * de forma a fazermos o maximo, minimo e media
	 * @param dataAtual data actual do sistema
	 * @return Um map com publicacao, dias de emprestimo
	 */
	public Map<Publicacao,MatematicaFuncoes> obterDiasEmprestimoPorPublicacao(Calendar dataAtual){

		Calendar dataAnoAnterior = Calendar.getInstance();
		dataAnoAnterior.set(Calendar.MONTH, -12);
		dataAnoAnterior.set(Calendar.DAY_OF_MONTH, 1);

		Calendar dataMesAnterior = (Calendar) dataAtual.clone();
		dataMesAnterior.set(Calendar.DAY_OF_MONTH, 1);
		dataMesAnterior.add(Calendar.DAY_OF_MONTH, -1);

		Map<Publicacao,ArrayList<Integer>> countMap = new HashMap<Publicacao,ArrayList<Integer>>();

		for (Emprestimo emprestimo : listaDeEmprestimo) {
			Calendar dataDeEmp= Calendar.getInstance();
			dataDeEmp.setTime(emprestimo.getDataEmp());

			if(dataDeEmp.after(dataAnoAnterior) && dataDeEmp.before(dataMesAnterior)){
				Publicacao pub = (Publicacao) emprestimo.getPublicacao();

				int diasEmprestimo = emprestimo.diasDeEmprestimo();

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
		// pegar no hash ja calculado com arrays de dias por poblicacao e converter num novo hash
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
	 * Verifica se a biblioteca a inicializar tem dados.
	 * @return True se encontrar dados, false se nao encontrar.
	 */
	public boolean temDados(){
		
		return this.listaDeUtilizadores.size()>0;
		
	}

	/**
	 * Obtem a lista de utilizadores
	 * @return A lista de utilizadores da biblioteca.
	 */
	public ArrayList<Utilizador> getListaDeUtilizadores() {
		
		return listaDeUtilizadores;
		
	}

	/**
	 * Altera a lista de utilizadores da biblioteca
	 * @param listaUtilizadores lista de utilizadores nova
	 */
	public void setListaDeUtilizadores(ArrayList<Utilizador> listaDeUtilizadores) {
		
		this.listaDeUtilizadores = listaDeUtilizadores;
		
	}

	/**
	 * Obtem a lista de publicacoes
	 * @return A lista de publicacoes da biblioteca
	 */
	public ArrayList<Publicacao> getListaDePublicacoes() {
		
		return listaDePublicacoes;
		
	}

	/**
	 * Altera a lista de publivavoes na biblioteca
	 * @param listaDePublicacoes lista de publicacoes nova
	 */
	public void setListaDePublicacoes(ArrayList<Publicacao> listaDePublicacoes) {
		
		this.listaDePublicacoes = listaDePublicacoes;
		
	}

	/**
	 * Obtem a lista de emprestimos da biblioteca
	 * @return A lista de emprestimos da biblioteca
	 */
	public ArrayList<Emprestimo> getListaDeEmprestimo() {
		
		return listaDeEmprestimo;
		
	}

	/**
	 * Altera a lista de emprestimos na biblioteca
	 * @param listaDeEmprestimo lista de emprestimo nova
	 */
	public void setListaDeEmprestimo(ArrayList<Emprestimo> listaDeEmprestimo) {
		
		this.listaDeEmprestimo = listaDeEmprestimo;
		
	}
	/**
	 * Obtem os contadores 
	 * @return Os contadores
	 */
	public Contadores getContadores() {
		
		return contadores;
		
	}

	/**
	 * Altera os contadores
	 * @param contadores os contadores novos
	 */
	public void setContadores(Contadores contadores) {
		
		this.contadores = contadores;
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Biblioteca [listaDeUtilizadores=" + listaDeUtilizadores + ", listaDePublicacoes=" + listaDePublicacoes
				+ ", listaDeEmprestimo=" + listaDeEmprestimo + "]";
	}

	// Método de apoio à criação de empréstimos no main
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

	// Método de apoio àdevolução de empréstimos no main
	public void devolveEmprestimoAMao(int numEmp, Date Date){
		Emprestimo publicacaoParaDevolver = pesquisaEmprestimo(numEmp);
		publicacaoParaDevolver.setDataDev(Date);
		Leitor leitor = (Leitor)this.pesquisaUtilizadorPorNumLeitor(publicacaoParaDevolver.getLeitor().getNumLeitor());
		leitor.removeEmprestimo(publicacaoParaDevolver);

	}
	
	// Método de apoio ao método anterior
	public Emprestimo pesquisaEmprestimo(int numEmp) {
		Emprestimo emprestimoNum=null;
		for (Emprestimo emprestimo : listaDeEmprestimo) {
			if(emprestimo.getNumEmp() == numEmp )
				emprestimoNum=emprestimo;

		}
		return emprestimoNum;

	}
}