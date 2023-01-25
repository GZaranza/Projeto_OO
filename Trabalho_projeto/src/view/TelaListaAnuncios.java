package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.ControleAnuncio;
import control.ControleCarro;
import control.ControleDados;
import control.ControleLoja;

public class TelaListaAnuncios implements ActionListener, ListSelectionListener{

	
	private JFrame janela;
	private JLabel titulo;
	private JList<String> listaAnunciosFeitos = new JList<String>();
	private JButton anunciaCarro= new JButton("Anunciar");
	private JButton aplicarFiltro = new JButton ("Filtrar");
	private JButton refresh = new JButton("Atualizar");
	private JLabel labelMin = new JLabel("Valor mínimo: ");
	private JTextField valorMin = new JTextField();
	private JLabel labelMax = new JLabel("Valor máximo: ");
	private JTextField valorMax = new JTextField();
	private JLabel labelMarca = new JLabel("Marca: ");
	private JTextField procuraMarca = new JTextField();
	private static ControleDados dados;
	private String[] listaStringAnuncios = new String[50];
	private int opcao;
	private String marcaFiltro = new String();
	private int minFiltro;
	private int maxFiltro;
	
	
	public TelaListaAnuncios(ControleDados d,int op) {
		
		dados = d;
		opcao=op;
		
		listaStringAnuncios = new ControleAnuncio(dados).getAnuncioString();
		listaAnunciosFeitos = new JList<String>(listaStringAnuncios);
		listaAnunciosFeitos.updateUI();
		
		if(op==1) {//mostrar a lista de anuncios para o Usuario Loja
			
			//listaStringAnuncios = new ControleAnuncio(dados).getAnuncioString();
			//listaAnunciosFeitos = new JList<String>(listaStringAnuncios);
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
			anunciaCarro.addActionListener(this);
			refresh.addActionListener(this);
			listaAnunciosFeitos.addListSelectionListener(this);
			
		}
			
		else {//mostrar a lista de anuncios para o usuario Pessoa	
			//listaStringAnuncios = new ControleAnuncio(dados).getAnuncioString();
			//listaAnunciosFeitos = new JList<String>(listaStringAnuncios);
			
			janela = new JFrame("Anúncios de Carros");
			titulo = new JLabel("Anúncios");
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(200, 10, 250, 30);
			listaAnunciosFeitos.setBounds(20, 70, 450, 250);
			labelMin.setBounds(140,50,90,10);
			valorMin.setBounds(220,50,70,15);
			labelMax.setBounds(300,50,90,10);
			valorMax.setBounds(385,50,70,15);
			labelMarca.setBounds(20, 50, 50, 10);
			procuraMarca.setBounds(60,50,70,15);
			refresh.setBounds(20, 330, 100, 30);
			aplicarFiltro.setBounds(20, 10, 100, 20);
			
			
			janela.setLayout(null);
			janela.add(titulo);
			janela.add(listaAnunciosFeitos);
			janela.add(refresh);
			janela.add(labelMarca);
			janela.add(procuraMarca);
			janela.add(labelMin);
			janela.add(valorMin);
			janela.add(labelMax);
			janela.add(valorMax);
			janela.add(aplicarFiltro);
			
			janela.setSize(600, 400);
			janela.setVisible(true);
			listaAnunciosFeitos.addListSelectionListener(this);
			refresh.addActionListener(this);
			aplicarFiltro.addActionListener(this);
			
			
		}	
	}
	
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		if(opcao==1) {		
			if(e.getValueIsAdjusting() && src == listaAnunciosFeitos) {
				new TelaAnuncio().inserirEditarAnuncio(2, dados, this, listaAnunciosFeitos.getSelectedIndex());
			}
		}
		
		else if(opcao==2) {
			if(e.getValueIsAdjusting() && src == listaAnunciosFeitos) {
				new TelaAnuncio().inserirEditarAnuncio(3, dados, this, listaAnunciosFeitos.getSelectedIndex());
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object src = e.getSource();
		if(opcao==1) {
			if(src == anunciaCarro) {
				new TelaAnuncio().inserirEditarAnuncio(1, dados, this, 0);
			}
			
		
			if(src== refresh) {
				listaAnunciosFeitos.setListData(new ControleAnuncio(dados).getAnuncioString());
				listaAnunciosFeitos.updateUI();
			}
		}
		if(opcao==2) {
			if(src== refresh) {
				listaAnunciosFeitos.setListData(new ControleAnuncio(dados).getAnuncioString());
				listaAnunciosFeitos.updateUI();
			}
			
			if(src == aplicarFiltro) {
				marcaFiltro = procuraMarca.getText();
				
				if(valorMin.getText().equals("")) {
					minFiltro = 0;
				}
				else {
					minFiltro = Integer.parseInt(valorMin.getText());
				}
				
				if(valorMax.getText().equals("")) {
					maxFiltro = 100000000;
				}
				else {
					maxFiltro = Integer.parseInt(valorMax.getText());
				}
				
				listaAnunciosFeitos.setListData(new ControleAnuncio(dados).filtrarLista(marcaFiltro,minFiltro,maxFiltro));
				listaAnunciosFeitos.updateUI();
			}
		}
	}

}
