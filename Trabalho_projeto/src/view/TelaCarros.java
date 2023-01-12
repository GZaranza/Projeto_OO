package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import java.awt.event.*;

public class TelaCarros implements ActionListener, ListSelectionListener {

	private JFrame janela = new JFrame("Carros");
	private JLabel titulo = new JLabel("Carros cadastrados");
	private JButton cadastroCarro = new JButton("Cadastrar");
	private JButton refreshCarro = new JButton("Atualizar");
	private JList<String> listaCarrosCadastrados = new JList<String>();
	
	
	public TelaCarros() {
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(90, 10, 250, 30);
		cadastroCarro.setBounds(70, 177, 100, 30);
		refreshCarro.setBounds(200, 177, 100, 30);
		listaCarrosCadastrados.setBounds(20, 50, 350, 120);
		
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(listaCarrosCadastrados);
		janela.add(cadastroCarro);
		janela.add(refreshCarro);
		
		janela.setSize(400, 250);
		janela.setVisible(true);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
