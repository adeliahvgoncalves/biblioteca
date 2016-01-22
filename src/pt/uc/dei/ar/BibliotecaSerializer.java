package pt.uc.dei.ar;

import java.io.*;
/**
 * @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 * Gera o ficheiro de objetos, serializa a biblioteca
 */
public class BibliotecaSerializer {

	/**
	 * iS e atributo da classe BibliotecaSerializer
	 * "Deserializes" dados e objetos escritos previamente usando ObjectOutputStream
	 */
	private ObjectInputStream iS;
	
	/**
	 * oS e atributo da classe BibliotecaSerializer
	 */
	private ObjectOutputStream oS;

	/**
	 * filePath e atributo da classe BibliotecaSerializer
	 */
	private String filePath;

	/**
	 * 
	 */
	private static BibliotecaSerializer instance;
	
	/**
	 * Construtor da BibliotecaSerializer
	 */
	public BibliotecaSerializer() {
		String userHome = System.getProperty("user.home");
		this.filePath = userHome + "/Dropbox/AcertarRumo20152016/biblioteca.dat";
		//this.filePath ="bib.dat";
	}

	/**
	 * Construtor da BibliotecaSerializer
	 * @param filePath o path do ficheiro
	 */
	public BibliotecaSerializer(String filePath){
		super();
		this.filePath = filePath;
	}
	
	/**
	 *  Verifica se a biblioteca foi instanciada
	 * @return A instancia da biblioteca
	 */
	public static BibliotecaSerializer getInstance(){

		if(instance == null)  {
			
			instance= new BibliotecaSerializer();
			// O valor é retornado para quem está a pedir
		}
		return instance; // Retorna o a instância do objeto
	}

	/**
	 * Abre a biblioteca ou a partir do ficheiro de objetos ou 
	 * atraves dos dados inserido inicialmente, caso ainda nao haja o ficheiro
	 * @return A biblioteca
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
	 * @param biblioteca a biblioteca
	 * @return True se gravou corretamente no ficheiro de objetos, caso contrario false
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
	 * Metodo para abrir um ficheiro para leitura
	 * @param nomeDoFicheiro o nome do ficheiro para leitura
	 * @throws IOException lancada nas condicoes em que ObjectInputStream e lancado
	 */
	private void abreLeitura(String nomeDoFicheiro) throws IOException {
		iS = new ObjectInputStream(new FileInputStream(nomeDoFicheiro));
	}

	/**
	 * Metodo para abrir um ficheiro para escrita
	 * @param nomeDoFicheiro nome do ficheiro para escrita
	 * @throws IOException lancada nas condicoes em que ObjectOutputStream e lancado
	 */
	private void abreEscrita(String nomeDoFicheiro) throws IOException {
		oS = new ObjectOutputStream(new FileOutputStream(nomeDoFicheiro));
	}

	/**
	 * Metodo para ler um objeto do ficheiro
	 * @return O objeto lido
	 * @throws IOException caso nao se encontre o objeto
	 * @throws ClassNotFoundException caso nao se encontre a classe
	 */
	private Object leObjeto() throws IOException, ClassNotFoundException{ 
		return iS.readObject();
	}

	/**
	 * Metodo para escrever um objeto no ficheiro 
	 * @param o objeto a escrever
	 * @throws IOException caso nao se encontre o objeto para escrita
	 */
	private void escreveObjeto(Object o) throws IOException {
		oS.writeObject(o); 
	}

	/**
	 * Metodo para fechar um ficheiro aberto em modo leitura 
	 * @throws IOException caso nao se encontre o objeto
	 */
	private void fechaLeitura() throws IOException {
		try {
			iS.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para fechar um ficheiro aberto em modo escrita 
	 * @throws IOException caso nao se encontre o objeto
	 */
	private void fechaEscrita() throws IOException {
		try {
			oS.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
