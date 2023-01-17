package view;

import javax.swing.*;

import control.ControleCarro;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;

public class TelaUsuLoja implements ActionListener{
		
	private JFrame janela = new JFrame("Loja");
	private JLabel titulo = new JLabel("Lojas");
	private static JButton carros = new JButton("Carros");
	private static JButton anuncios = new JButton("Anuncios");
	private static JButton vendas = new JButton("Vendas");
	private static JButton lojas = new JButton("Lojas");
	public static ControleCarro dados = new ControleCarro();
	
	
	
	public TelaUsuLoja() {
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(150, 0, 100, 35);
		carros.setBounds(150, 80, 100, 30);
		anuncios.setBounds(150, 120, 100, 30);
		vendas.setBounds(150, 160, 100, 30);
		lojas.setBounds(150, 40, 100, 30);
		
		
		janela.setLayout(null);
		janela.add(titulo);
		janela.add(carros);
		janela.add(anuncios);
		janela.add(vendas);
		janela.add(lojas);
		
		
		
		janela.setSize(400, 250);
		janela.setVisible(true);
		
		carros.addActionListener(this);
		anuncios.addActionListener(this);
		vendas.addActionListener(this);
		lojas.addActionListener(this);
		
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		TelaUsuLoja menu = new TelaUsuLoja();
		carros.addActionListener(menu);
		anuncios.addActionListener(menu);
		vendas.addActionListener(menu);
		lojas.addActionListener(menu);
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
				
				if(src == carros) {
					new TelaListaCarros(dados);
				}
				
				if(src == lojas) {
					new TelaLojas();
				}
				
				if(src == anuncios) {
					new TelaAnuncios(1);//mudar para 1
				}
				
				if(src == vendas) {
					// TelaListaLojas();
				}
	}

}
