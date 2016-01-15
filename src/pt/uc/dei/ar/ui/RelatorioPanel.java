package pt.uc.dei.ar.ui;

import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class RelatorioPanel extends FileFilter {

	
	private final String extension;
	private final String description;
	/**
	 * Create the panel.
	 */
	public RelatorioPanel(String extension, String description) {

		this.extension=extension;
		this.description=description;
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 488, 388);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setBounds(233, 316, 117, 52);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.setBounds(365, 316, 117, 52);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exportar");
		btnNewButton_2.setBounds(26, 316, 117, 52);
		panel.add(btnNewButton_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(26, 24, 439, 280);
		panel.add(textArea);

	}

	@Override
	public boolean accept(File f) {
		if(f.isDirectory()){
			return true;	
		}
		return f.getName().endsWith(extension);
	}

	@Override
	public String getDescription() {
		return description + String.format(" (*%s)", extension);
	}
}
