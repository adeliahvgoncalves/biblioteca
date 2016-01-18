package pt.uc.dei.ar.ui;



import javax.swing.filechooser.FileFilter;

import pt.uc.dei.ar.Biblioteca;
import pt.uc.dei.ar.MatematicaFuncoes;
import pt.uc.dei.ar.ExportadorCSV;
import pt.uc.dei.ar.Publicacao;
import pt.uc.dei.ar.Revista;

import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RelatorioPanel extends JPanel implements ActionListener{

	private JTextArea txtArea;
	private Janela janela;
	private JButton btnSair;
	private JButton btnVoltar;
	private JButton btnExportar;
	/**
	 * Create the panel.
	 */
	public RelatorioPanel(Janela j) {

		this.janela=j;
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 488, 388);
		panel.setLayout(null);
		add(panel);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(this);
		btnVoltar.setBounds(267, 316, 93, 52);
		panel.add(btnVoltar);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(372, 316, 93, 52);
		panel.add(btnSair);

		btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(this);
		btnExportar.setBounds(26, 316, 117, 52);
		panel.add(btnExportar);

		txtArea = new JTextArea();
		txtArea.setBounds(26, 24, 439, 280);
		panel.add(txtArea);

		ExportadorCSV exportador = new ExportadorCSV(Biblioteca.getInstance());
		String csv = exportador.geraCSV(Calendar.getInstance());
		
		txtArea.setText(csv);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == this.btnSair){

			txtArea.setText("");
			janela.sairOK();

		}
		if(e.getSource()== this.btnVoltar){

			txtArea.setText("");
			janela.bibliotecarioChefeOK();

		}
		if(e.getSource()==this.btnExportar){

			JFileChooser fs = new JFileChooser(new File("c:\\"));
			fs.setDialogTitle("Gravar um ficheiro");
			fs.setFileFilter(new SaveFile(".csv", "Ficheiro CSV"));
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

	}

}
