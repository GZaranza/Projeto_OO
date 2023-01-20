package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.ControleAnuncio;
import control.ControleDados;
import control.ControleLoja;

public class TelaListaAnuncios implements ActionListener, ListSelectionListener{

	
	private JFrame janela;
	private JLabel titulo;
	private JList<String> listaAnunciosFeitos = new JList<String>();
	private JButton anunciaCarro= new JButton("Anunciar");
	private JButton refresh = new JButton("Atualizar");
	private JLabel labelMin = new JLabel("Valor mínimo: ");
	private JTextField valorMin = new JTextField();
	private JLabel labelMax = new JLabel("Valor máximo: ");
	private JTextField valorMax = new JTextField();
	private JLabel labelMarca = new JLabel("Marca: ");
	private JTextField procuraMarca = new JTextField();
	private static ControleDados dados;
	private String[] listaStringAnuncios = new String[50];
	
	
	public TelaListaAnuncios(ControleDados d,int op) {
		dados = d;
		
		switch(op) {
		case 1: //mostrar a lista de anuncios para o Usuario Loja
			
			listaStringAnuncios = new ControleAnuncio(dados).getAnuncioString();
			listaAnunciosFeitos = new JList<String>(listaStringAnuncios);
			janela = new JFrame("Anúncios das Lojas");
			titulo = new JLabel("Cadastro de anúncios");
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			anunciaCarro.setBounds(70, 177, 100, 30);
			refresh.setBounds(200, 177, 100, 30);
			listaAnunciosFeitos.setBounds(20, 50, 350, 120);

			
			
			janela.setLayout(null);
			janela.add(titulo);
			janela.add(listaAnunciosFeitos);
			janela.add(anunciaCarro);
			janela.add(refresh);
			
			janela.setSize(400, 250);
			janela.setVisible(true);
			
			break;
			
		case 2://mostrar a lista de anuncios para o usuario Pessoa	
			janela = new JFrame("Anúncios de Carros");
			titulo = new JLabel("Anúncios");
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaAnunciosFeitos.setBounds(20, 70, 450, 250);
			labelMin.setBounds(140,50,90,10);
			valorMin.setBounds(220,50,70,15);
			labelMax.setBounds(300,50,90,10);
			valorMax.setBounds(385,50,70,15);
			labelMarca.setBounds(20, 50, 50, 10);
			procuraMarca.setBounds(60,50,70,15);
			
			
			
			janela.setLayout(null);
			janela.add(titulo);
			janela.add(listaAnunciosFeitos);
			janela.add(anunciaCarro);
			janela.add(refresh);
			janela.add(labelMarca);
			janela.add(procuraMarca);
			janela.add(labelMin);
			janela.add(valorMin);
			janela.add(labelMax);
			janela.add(valorMax);
			
			
			
			
			
			
			janela.setSize(500, 400);
			janela.setVisible(true);
			break;
			
		}	
	}
	
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
