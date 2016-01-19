package pt.uc.dei.ar;

import java.io.*;
/**
 * 
 * Gera o ficheiro de objetos, serializa a biblioteca
 *
 */
public class BibliotecaSerializer {

	/**
	 * iS é atributo da classe BibliotecaSerializer
	 * "Deserializes" dados e objetos escitors previamente usando ObjectOutputStream
	 */
	private ObjectInputStream iS;
	
	/**
	 * oS é atributo da classe BibliotecaSerializer
	 */
	private ObjectOutputStream oS;

	/**
	 * filePath é atributo da classe BibliotecaSerializer
	 */
	private String filePath;

	/**
	 * 
	 */
	private static BibliotecaSerializer instance;
	
	/**
	 * Construtor da BibliotecaSerializer
	 * @param filePath
	 */
	public BibliotecaSerializer() {
		super();
		String userHome = System.getProperty("user.home");
		this.filePath = userHome + "/Dropbox/AcertarRumo20152016/biblioteca.dat";
	}

	/**
	 * Construtor da BibliotecaSerializer
	 * @param filePath
	 */
	public BibliotecaSerializer(String filePath){
		super();
		this.filePath = filePath;
	}
	
	/**
	 * Verifica se a biblioteca foi instanciada
	 */
	public static BibliotecaSerializer getInstance(){

		if(instance == null)  {
			
			instance= new BibliotecaSerializer();
			// O valor é retornado para quem está a pedir
		}
		return instance;
		// Retorna o a instância do objeto

	}

	/**
	 * Abre a biblioteca ou a partir do ficheiro de objetos ou 
	 * através dos dados inserido inicialmente, caso ainda não haja o ficheiro
	 * @return a biblioteca
	 */
	public Biblioteca abreBiblioteca(){

		try {
			this.abreLeitura(filePath);
			Object biblioteca = this.leObjeto();
			this.fechaLeitura();
			if (biblioteca != null && biblioteca instanceof Biblioteca) {
				
				Biblioteca bib = (Biblioteca)biblioteca;
				// repor contadores na biblioteca a partir do ficheiro gravado
				Revista.setUltimonumeroSequencial(bib.getContadores().getContadorRevista());
				Leitor.setUltimoNumLeitorSequencial(bib.getContadores().getContadorLeitor());
				Publicacao.setUltimocodBarras(bib.getContadores().getContadorPublicacao());
				Emprestimo.setNumEmpUltimo(bib.getContadores().getContadorEmprestimo());
				
				return (Biblioteca) biblioteca;
			}
			return null;

		} catch (IOException | ClassNotFoundException e) {
			return null;
		}
	}

	/**
	 * Grava no ficheiro de objetos
	 * @param biblioteca
	 * @return true se gravou corretamente no ficheiro de objetos
	 */
	public boolean gravaBiblioteca(Biblioteca biblioteca){

		try {
			this.abreEscrita(filePath);

			Contadores cont = new Contadores(
					Leitor.getUltimoNumLeitorSequencial(), 
					Revista.getUltimonumeroSequencial(), 
					Publicacao.getUltimocodBarras(), 
					Emprestimo.getNumEmpUltimo()
					);
			biblioteca.setContadores(cont);
			this.escreveObjeto(biblioteca);
			this.fechaEscrita();
			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Método para abrir um ficheiro para leitura
	 * @param nomeDoFicheiro
	 * @throws IOException
	 */
	private void abreLeitura(String nomeDoFicheiro) throws IOException {
		iS = new ObjectInputStream(new FileInputStream(nomeDoFicheiro));
	}

	/**
	 * Método para abrir um ficheiro para escrita
	 * @param nomeDoFicheiro
	 * @throws IOException
	 */
	private void abreEscrita(String nomeDoFicheiro) throws IOException {
		oS = new ObjectOutputStream(new FileOutputStream(nomeDoFicheiro));
	}

	
	/**
	 * Método para ler um objeto do ficheiro
	 * @return o objeto lido
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private Object leObjeto() throws IOException, ClassNotFoundException{ 
		return iS.readObject();
	}

	/**
	 * Método para escrever um objeto no ficheiro 
	 * @param o (objeto a escrever)
	 * @throws IOException
	 */
	private void escreveObjeto(Object o) throws IOException {
		oS.writeObject(o); 
	}

	/**
	 * Método para fechar um ficheiro aberto em modo leitura 
	 * @throws IOException
	 */
	private void fechaLeitura() throws IOException
	{
		try {
			iS.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Método para fechar um ficheiro aberto em modo escrita 
	 * @throws IOException
	 */
	private void fechaEscrita() throws IOException
	{
		try {
			oS.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
