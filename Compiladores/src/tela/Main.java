package tela;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import compiladores.lexico.Analisador;

public class Main {

	private JFrame frame;
	private JTable tblToken;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 831, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JEditorPane txtCode = new JEditorPane();
		txtCode.setBounds(12, 35, 432, 426);
		frame.getContentPane().add(txtCode);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(112, 473, 1, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblAnalisando = new JLabel("Erros: ");
		lblAnalisando.setBounds(12, 488, 101, 15);
		frame.getContentPane().add(lblAnalisando);
		
		JTextPane txtErros = new JTextPane();
		txtErros.setBounds(12, 516, 432, 47);
		
		JButton btnAnalise = new JButton("Analisar");
		btnAnalise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblToken.setModel(new DefaultTableModel(0, 2));
				gerarArquivo(txtCode.getText());
				popularTabela(txtErros);
			}
		});
		
		btnAnalise.setBounds(456, 154, 92, 25);
		frame.getContentPane().add(btnAnalise);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(560, 35, 256, 426);
		frame.getContentPane().add(scrollPane);
		
		tblToken = new JTable();
		scrollPane.setViewportView(tblToken);
	}

	protected void popularTabela(JTextPane jtp) {
		Object[] indice = {"Token","Quantidade"};
		Object[][] valores = Analisador.analisar(jtp);
		tblToken.setModel(new DefaultTableModel(valores,indice));
	}

	protected void gerarArquivo(String text) {
		try {
			FileWriter arquivo = new FileWriter("arquivo/jayBR.jbr");
			PrintWriter gravaArq = new PrintWriter(arquivo);
			
			gravaArq.printf(text);
			arquivo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}