package pt.uc.dei.ar.ui;



import javax.swing.filechooser.FileFilter;

import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RelatorioPanel extends JPanel {

	private JTextArea txtArea;
	private Janela janela;
	/**
	 * Create the panel.
	 */
	public RelatorioPanel(Janela j) {
		
		this.janela=j;
		
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
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fs = new JFileChooser(new File("c:\\"));
				fs.setDialogTitle("Gravar um ficheiro");
				fs.setFileFilter(new SaveFile(".txt", "Text File"));
				int result = fs.showSaveDialog(null);
				
				if(result==JFileChooser.APPROVE_OPTION){
					String area= txtArea.getText();
					File fi=fs.getSelectedFile();
					try {
						FileWriter fw = new FileWriter(fi.getPath());
						fw.write(area);
						fw.flush();
						fw.close();
					} catch (Exception e2){
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
				
			}
		});
		btnNewButton_2.setBounds(26, 316, 117, 52);
		panel.add(btnNewButton_2);
		
		txtArea = new JTextArea();
		txtArea.setBounds(26, 24, 439, 280);
		panel.add(txtArea);

	}

}
