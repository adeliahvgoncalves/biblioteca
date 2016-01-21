package pt.uc.dei.ar.ui;
import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 *SaveFilter e uma class usada pelo JFileChooser do BibliotecarioChefePanel
 *para filtrar a extencao dos ficheiros mostrados ao Utilizador
 */
public class SaveFile extends FileFilter {

	/**
	 * extension é atributo da SaveFile
	 */
	private final String extension;
	/**
	 * description é atributo da SaveFile
	 */
	private final String description;
	/**
	 * Create the panel.
	 * @param extension
	 * @param description
	 */
	public SaveFile(String extension, String description) {

		this.extension=extension;
		this.description=description;
	}

	/* (non-Javadoc)
	 * @see javax.swing.filechooser.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File file) {
		if(file.isDirectory()){
			return true;
		}
		return file.getName().endsWith(extension);
	}

	/* (non-Javadoc)
	 * @see javax.swing.filechooser.FileFilter#getDescription()
	 */
	@Override
	public String getDescription() {
		return description + String.format(" (*%s)",extension);
	}
}
