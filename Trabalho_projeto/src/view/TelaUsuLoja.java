package view;

import javax.swing.*;


import control.*;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;

public class TelaUsuLoja implements ActionListener{
		
	private JFrame janela = new JFrame("Loja");
	private JLabel titulo = new JLabel("Menu lojas");
	private static JButton carros = new JButton("Carros");
	private static JButton anuncios = new JButton("Anuncios");
	private static JButton vendas = new JButton("Vendas");
	private static JButton lojas = new JButton("Lojas");
	public static ControleDados dados = new ControleDados();
	
	
	
	public void mostrarDados(ControleDados d) {
		dados =d;
		titulo.setFont(new Font("Arial", Font.BOLD, 40));
		carros.setFont(new Font("Arial", Font.BOLD, 40));
		anuncios.setFont(new Font("Arial", Font.BOLD, 40));
		vendas.setFont(new Font("Arial", Font.BOLD, 40));
		lojas.setFont(new Font("Arial", Font.BOLD, 40));
		
		titulo.setBounds(190, 10, 220, 45);
		carros.setBounds(175, 100, 250, 40);
		anuncios.setBounds(175, 200, 250, 40);
		vendas.setBounds(175, 300, 250, 40);
		lojas.setBounds(175, 400, 250, 40);
		janela.setLocationRelativeTo(null);
		
		janela.setLayout(null);
		janela.add(titulo);
		janela.add(carros);
		janela.add(anuncios);
		janela.add(vendas);
		janela.add(lojas);
		
		
		
		janela.setSize(600, 600);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		
		carros.addActionListener(this);
		anuncios.addActionListener(this);
		vendas.addActionListener(this);
		lojas.addActionListener(this);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
				
				if(src == carros) {
					new TelaListaCarros().mostrarDados(dados);
				}
				
				if(src == lojas) {
					new TelaLojas().mostrarDados(dados);
				}
				
				if(src == anuncios) {
					new TelaListaAnuncios().mostrarDados(dados,1);//mudar para 1
				}
				
				if(src == vendas) {
					new TelaListaVendas().mostrarDados(dados);
				}
	}

}
