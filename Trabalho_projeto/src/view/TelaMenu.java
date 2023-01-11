package view;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class TelaMenu implements ActionListener{
	
	private static JFrame janela = new JFrame("Sistema de venda de carros");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton loja = new JButton("Lojas");
	private static JButton usuario = new JButton("Usuarios");
	
	public TelaMenu() {
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(120, 10, 150, 30);
		loja.setBounds(140, 100, 100, 30);
		usuario.setBounds(140, 150, 100, 30);
		
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(loja);
		janela.add(usuario);
		;
		
		janela.setSize(400, 250);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TelaMenu menu = new TelaMenu();
		loja.addActionListener(menu);
		usuario.addActionListener(menu);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		
		if(src == loja) {
			new TelaUsuLoja();
			
		}
		
		if(src == usuario) {
			JFrame testeUsu = new JFrame("Teste Loja");
			JLabel msgUsu = new JLabel("VOCÊ SELECIONOU A OPÇÃO DE USUARIO");
			msgUsu.setBounds(120, 10, 150, 30);
			testeUsu.add(msgUsu);
			
			testeUsu.setSize(400, 250);
			testeUsu.setVisible(true);
		}
	}

}
