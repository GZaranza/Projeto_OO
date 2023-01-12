package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import java.awt.event.*;

public class TelaLojas implements ActionListener, ListSelectionListener{
	private JFrame janela = new JFrame("Lista Lojas");
	private JLabel titulo = new JLabel("Lojas cadastradas");
	private JButton cadastroLoja = new JButton("Cadastrar");
	private JButton refreshLoja = new JButton("Atualizar");
	private JList<String> listaLojaCadastradas = new JList<String>();
	
	
	public TelaLojas() {
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(90, 10, 250, 30);
		cadastroLoja.setBounds(70, 177, 100, 30);
		refreshLoja.setBounds(200, 177, 100, 30);
		listaLojaCadastradas.setBounds(20, 50, 350, 120);
		
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(listaLojaCadastradas);
		janela.add(cadastroLoja);
		janela.add(refreshLoja);
		
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
