package pt.uc.dei.ar;

import java.io.*;


public class BibliotecaSerializer {

	private ObjectInputStream iS;
	private ObjectOutputStream oS;

	private String filePath;

	private static BibliotecaSerializer instance;
	
	public BibliotecaSerializer() {
		super();
		String userHome = System.getProperty("user.home");
		this.filePath = userHome + "/Dropbox/biblioteca.dat";
	}

	public BibliotecaSerializer(String filePath){
		super();
		this.filePath = filePath;
	}
	
	public static BibliotecaSerializer getInstance(){

		if(instance == null)  {
			
			instance= new BibliotecaSerializer();
			// O valor é retornado para quem está a pedir
		}
		return instance;
		// Retorna o a instância do objeto

	}

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

	//Método para abrir um ficheiro para leitura
	private void abreLeitura(String nomeDoFicheiro) throws IOException {
		iS = new ObjectInputStream(new FileInputStream(nomeDoFicheiro));
	}

	//Método para abrir um ficheiro para escrita
	//Recebe o nome do ficheiro
	private void abreEscrita(String nomeDoFicheiro) throws IOException {
		oS = new ObjectOutputStream(new FileOutputStream(nomeDoFicheiro));
	}

	//Método para ler um objeto do ficheiro //Devolve o objeto lido
	private Object leObjeto() throws IOException, ClassNotFoundException{ 
		return iS.readObject();
	}

	//Método para escrever um objeto no ficheiro //Recebe o objeto a escrever
	private void escreveObjeto(Object o) throws IOException {
		oS.writeObject(o); 
	}

	//Método para fechar um ficheiro aberto em modo leitura 
	private void fechaLeitura() throws IOException
	{
		try {
			iS.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Método para fechar um ficheiro aberto em modo escrita 
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
