package pt.uc.dei.ar;

import java.io.*;
public class FicheiroDeObjetos {
	
	private ObjectInputStream iS;
	private ObjectOutputStream oS; 


	//Método para abrir um ficheiro para leitura
	public void abreLeitura(String nomeDoFicheiro) throws IOException {
		iS = new ObjectInputStream(new FileInputStream(nomeDoFicheiro));
	}

	//Método para abrir um ficheiro para escrita
	//Recebe o nome do ficheiro
	public void abreEscrita(String nomeDoFicheiro) throws IOException {
		oS = new ObjectOutputStream(new FileOutputStream(nomeDoFicheiro));
	}

	//Método para ler um objeto do ficheiro //Devolve o objeto lido
	public Object leObjeto() throws IOException, ClassNotFoundException{ 
		return iS.readObject();
	}

	//Método para escrever um objeto no ficheiro //Recebe o objeto a escrever
	public void escreveObjeto(Object o) throws IOException {
		oS.writeObject(o); 
	}

	//Método para fechar um ficheiro aberto em modo leitura 
	public void fechaLeitura() throws IOException
	{
		try {
			iS.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Método para fechar um ficheiro aberto em modo escrita 
	public void fechaEscrita() throws IOException
	{
		try {
			oS.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
