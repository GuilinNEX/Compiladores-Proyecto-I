package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import domain.Generator;
import domain.HashStorage;
import domain.Lexer;
import domain.MainControl;
import domain.TokenStorage;
import enumeration.Token;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextArea textArea;
	private MainControl mainControl; //Constructor of the main controller
	private TokenStorage tokenStorage; //Constructor for the arrayList
	private HashStorage hashStorage; //Constructor for the hashmap

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		mainControl = MainControl.getInstance(); //Initialize the instance of the main controller
		tokenStorage = TokenStorage.getInstance();  //Initialize the instance of the token Array list
		hashStorage = HashStorage.getInstance(); //Initialize the instance of the hash storage
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTextoAAnalizar = new JLabel("Texto a analizar");
		lblTextoAAnalizar.setBounds(185, 13, 103, 16);
		contentPane.add(lblTextoAAnalizar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 38, 458, 106);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnAnalizar = new JButton("Analizar");
		btnAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cleanTable(); //Clean the table to reset the content
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					File file = new File ("file.txt");
					PrintWriter writer;
					try
					{
						writer = new PrintWriter(file);
						writer.print(textArea.getText());
						writer.close();
					}
					catch (FileNotFoundException e)
					{
						Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, e);
					}
					Reader reader = new BufferedReader(new FileReader("file.txt"));
					Lexer lexer = new Lexer(reader);
					while (true) //analyze every token from the text area
					{
						Token token = lexer.yylex();
						if (token == null) 
						{
							return;
						}
						switch(token)
						{
							case ERROR: //Detect the error
								model.addRow(new Object[]{token, ""});
								Generator generatorError = new Generator(token, "");
								mainControl.newToken(generatorError);
								break;
							case ID: case INTEGERLIT: case FLOATLIT: //Detect a identificator, int or float nummber
								model.addRow(new Object[]{token, lexer.lexeme});
								Generator generatorNum = new Generator(token, lexer.lexeme);
								mainControl.newToken(generatorNum);
								break;
							default: //In case of every other token
								model.addRow(new Object[]{token, lexer.lexeme});
								Generator generatorDef = new Generator(token, lexer.lexeme);
								mainControl.newToken(generatorDef);
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAnalizar.setBounds(185, 157, 97, 25);
		contentPane.add(btnAnalizar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 192, 458, 268);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tipo", "Valor"
			}
		));
		scrollPane_1.setViewportView(table);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save();
			}
		});
		btnGuardar.setBounds(185, 490, 97, 25);
		contentPane.add(btnGuardar);
	}
	
	/*
	 * Author: Esteban Coto Alfaro
	 * Creation Date: 16/09/2018
	 * Last Modification: 17/09/2018
	 * Description: Function that Save the result of the analyze of code
	 */
	public void save()
	{
		mainControl.fillHashMap(tokenStorage.getTokenList()); //fill the hash map
		System.out.println(hashStorage.getHashMap()); //Show by console the hash map
		
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showSaveDialog(null);
		String route = "";
		if (result == JFileChooser.APPROVE_OPTION)
		{
			route = fileChooser.getSelectedFile().getAbsolutePath();
			File file = new File(route);
			try
			{
				FileWriter auxFile = new FileWriter(file);
				for (int count = 0; count < model.getColumnCount(); count++)
				{
					auxFile.write(model.getColumnName(count) + "\t\t\t\t");
				}
				auxFile.write("\n\n");
				for (int i = 0; i < model.getRowCount(); i++)
				{
					for (int j = 0; j < model.getColumnCount(); j++)
					{
						auxFile.write(model.getValueAt(i, j).toString() + "\t\t\t\t");
					}
					auxFile.write("\n");
				}
				auxFile.close();
			}
			catch (Exception ex)
			{
				JOptionPane.showConfirmDialog(null, "Error al guardar el archivo" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/*
	 * Author: Esteban Coto Alfaro
	 * Creation Date: 16/09/2018
	 * Last Modification: 17/09/2018
	 * Description: Clean the table
	 */
	public void cleanTable()
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
