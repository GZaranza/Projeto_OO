package view;

import java.awt.Font;

import java.awt.event.*;

import javax.swing.*;


import control.*;
/**
 * Classe TelaMenu cria a interface gráfica do menu principal do programa
 * @author Gabriel Zaranza
 *
 */
public class TelaMenu implements ActionListener{
	
	private static JFrame janela = new JFrame("Sistema de venda de carros");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton loja = new JButton("Login loja");
	private static JButton usuario = new JButton("Ver anúncios");
	public static ControleDados dados = new ControleDados();
	/**
	 * Contrutor da Classe TelaMenu
	 */
	public TelaMenu() {
		titulo.setFont(new Font("Arial", Font.BOLD, 40));
		loja.setFont(new Font("Arial", Font.BOLD, 30));
		usuario.setFont(new Font("Arial", Font.BOLD, 30));
		
		titulo.setBounds(155, 10, 290, 40);
		loja.setBounds(175, 200, 250, 40);
		usuario.setBounds(175, 100, 250, 40);

		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(loja);
		janela.add(usuario);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(600, 600);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
	}
	/**
	 * Método Main do pacote View
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TelaMenu menu = new TelaMenu();
		loja.addActionListener(menu);
		usuario.addActionListener(menu);
	}


	//Método que reconhece alguma ação realizada na interface gráfica
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Armazena o objeto que sofreu ação, nesse caso o botão "Login loja" ou "Ver Anuncios"
		Object src = e.getSource();
		
		//Caso a ação foi apertar o botão "Login loja"
		if(src == loja) {
			//Chama o contrutor da Classe TelaUsuLoja
			new TelaUsuLoja().mostrarDados(dados);;
			
		}
		
		//Caso a ação foi apertar o botão "Ver Anuncios"
		if(src == usuario) {
			//Chama o contrutor da Classe TelaListaAnuncios
			new TelaListaAnuncios().mostrarDados(dados,2);
		}
	}

}
