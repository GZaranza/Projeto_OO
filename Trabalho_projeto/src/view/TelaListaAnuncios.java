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
	private JList<String> listaAnunciosFeitos;
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
	private String[] listaStringAnuncios;
	private int opcao;
	private String marcaFiltro = new String();
	private int minFiltro;
	private int maxFiltro;
	
	
	
	public void mostrarDados(ControleDados d,int op) {
		
		dados = d;
		opcao=op;
		
		if(op==1) {//mostrar a lista de anuncios para o Usuario Loja
			
			listaStringAnuncios = new ControleAnuncio(dados).getAnuncioString();
			listaAnunciosFeitos = new JList<String>(listaStringAnuncios);
			janela = new JFrame("Anúncios de Carros");
			titulo = new JLabel("Lista de Anúncios");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 30));
			listaAnunciosFeitos.setFont(new Font("Arial",Font.PLAIN, 18));
			anunciaCarro.setFont(new Font("Arial",Font.PLAIN, 18));
			refresh.setFont(new Font("Arial",Font.PLAIN, 18));
			
			titulo.setBounds(150, 10, 300, 40);
			anunciaCarro.setBounds(130, 520, 150, 30);
			refresh.setBounds(320, 520, 150, 30);
			listaAnunciosFeitos.setBounds(20, 70, 540, 430);
			
			janela.setLayout(null);
			janela.add(titulo);
			janela.add(listaAnunciosFeitos);
			janela.add(anunciaCarro);
			janela.add(refresh);
			
			janela.setSize(600, 600);
			janela.setVisible(true);
			janela.setLocationRelativeTo(null);
			anunciaCarro.addActionListener(this);
			refresh.addActionListener(this);
			listaAnunciosFeitos.addListSelectionListener(this);
			
		}
			
		else {//mostrar a lista de anuncios para o usuario Pessoa	
			
			listaStringAnuncios = new ControleAnuncio(dados).getAnuncioString();
			listaAnunciosFeitos = new JList<String>(listaStringAnuncios);
			janela = new JFrame("Anúncios de Carros");
			titulo = new JLabel("Anúncios");
			titulo.setFont(new Font("Arial", Font.BOLD, 30));
			labelMarca.setFont(new Font("Arial", Font.BOLD, 18));
			labelMin.setFont(new Font("Arial", Font.BOLD, 18));
			labelMax.setFont(new Font("Arial", Font.BOLD, 18));
			listaAnunciosFeitos.setFont(new Font("Arial",Font.PLAIN, 18));
			valorMin.setFont(new Font("Arial",Font.PLAIN, 18));
			valorMax.setFont(new Font("Arial",Font.PLAIN, 18));
			procuraMarca.setFont(new Font("Arial",Font.PLAIN, 18));
			aplicarFiltro.setFont(new Font("Arial",Font.PLAIN, 18));
			titulo.setBounds(240, 10, 150, 30);
			listaAnunciosFeitos.setBounds(20, 110, 540, 400);
			labelMin.setBounds(20,85,150,20);
			valorMin.setBounds(145,86,80,20);
			labelMax.setBounds(230,85,150,20);
			valorMax.setBounds(360,86,80,20);
			labelMarca.setBounds(20, 55, 80, 22);
			procuraMarca.setBounds(80,57,145,20);
			refresh.setBounds(20, 520, 100, 30);
			aplicarFiltro.setBounds(450, 85, 100, 20);
			janela.setLocationRelativeTo(null);
			
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
			
			janela.setSize(600, 600);
			janela.setVisible(true);
			janela.setLocationRelativeTo(null);
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
				new TelaAnuncio().mostrarDados(2, dados, this, listaAnunciosFeitos.getSelectedIndex());
			}
		}
		
		else if(opcao==2) {
			if(e.getValueIsAdjusting() && src == listaAnunciosFeitos) {
				new TelaAnuncio().mostrarDados(3, dados, this, listaAnunciosFeitos.getSelectedIndex());
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object src = e.getSource();
		if(opcao==1) {
			if(src == anunciaCarro) {
				new TelaAnuncio().mostrarDados(1, dados, this, 0);
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
