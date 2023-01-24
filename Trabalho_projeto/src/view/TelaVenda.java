package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.ControleAnuncio;
import control.ControleDados;
import control.ControleLoja;
import control.ControleUsuario;
import pacote.Anuncio;
import pacote.Loja;
import pacote.Usuario;

public class TelaVenda implements ActionListener{

	private JFrame janela = new JFrame("Venda");
	private JLabel labelAnuncio = new JLabel("Anuncio: ");
	private JComboBox<Anuncio> listaAnuncio = new JComboBox<Anuncio>();
	private String[] listaTitloAnuncio = new String[50];
	private JLabel labelValorVenda = new JLabel("Valor Venda: ");
	private JTextField valorValorVenda ;
	private JLabel labelComprador = new JLabel("Comprador: ");
	private JTextField valorComprador;
	private JLabel labelFormaPag = new JLabel("Forma de Pagamento: ");
	private JTextField valorFormaPag;
	private JLabel labelDataVenda = new JLabel("Data da Venda : ");
	private JTextField valorDataVenda;
	private String[] listaNomeCliente = new String[50];
	private JComboBox<Usuario> listaCliente = new JComboBox<Usuario>();
	private JButton botExcluir = new JButton("Excluir");
	private JButton botSalvar = new JButton("Salvar");
	private int opcao;
	private static ControleDados dados;
	private int posicao;
	private String[] novoDado = new String [9];
	private Anuncio anuncioEscolhido ;
	private Usuario compradorEscolhido;
	
	
	public void inserirEditarVenda(int op, ControleDados d,TelaListaVendas p, int pos) {
		
		
		
		
		
		
		opcao = op;
		posicao=pos;
		dados=d;
		
		listaNomeCliente = new ControleUsuario(dados).getNomeUsuario();
		listaCliente = new JComboBox<Usuario>();
		
		if(op==1) {//fazer uma nova venda
		listaAnuncio = new JComboBox<Anuncio>(new ControleAnuncio(dados).listaNaoVendidos());
		valorValorVenda = new JTextField(4);
		valorComprador = new JTextField(200);
		valorFormaPag = new JTextField(200);
		valorDataVenda = new JTextField(6);
		listaCliente = new JComboBox<Usuario>(dados.getUsuarios());
		listaCliente.setSelectedIndex(-1);
		//listaAnuncio.setSelectedIndex();
		
		
		labelAnuncio.setBounds(30, 20, 150, 25);
		listaAnuncio.setBounds(180,20,180,25);
		labelValorVenda.setBounds(30, 50, 150, 25);
		valorValorVenda.setBounds(180,50,180,25);
		labelComprador.setBounds(30, 80, 150, 25);
		listaCliente.setBounds(180,80,180,25);
		labelFormaPag.setBounds(30, 110, 150, 25);
		valorFormaPag.setBounds(180,110,180,25);
		labelDataVenda.setBounds(30, 140, 150, 25);
		valorDataVenda.setBounds(180,140,180,25);
		botSalvar.setBounds(30, 290, 170, 25);
		botExcluir.setBounds(210,290,170,25);
		
		this.janela.add(labelAnuncio);
		this.janela.add(listaAnuncio);
		this.janela.add(labelValorVenda);
		this.janela.add(valorValorVenda);
		this.janela.add(labelComprador);
		this.janela.add(valorComprador);
		this.janela.add(labelFormaPag);
		this.janela.add(valorFormaPag);
		this.janela.add(labelDataVenda);
		this.janela.add(valorDataVenda);
		this.janela.add(listaCliente);
		this.janela.add(botSalvar);
		this.janela.add(botExcluir);
		
		this.janela.setLayout(null);
		this.janela.setSize(500, 400);
		this.janela.setVisible(true);

		botSalvar.addActionListener(this);
		
		}
		else if(op==2) {
			listaAnuncio = new JComboBox<Anuncio>(dados.getAnuncios());
			listaAnuncio.setSelectedItem(dados.getAnuncios()[pos].getCarro());
			valorValorVenda = new JTextField(String.valueOf(dados.getVendas()[pos].getValor_pago()),15);
			valorComprador = new JTextField(dados.getVendas()[pos].getComprador().getNome(),200);
			valorFormaPag = new JTextField(dados.getVendas()[pos].getForma_pagamento(),200);
			valorDataVenda = new JTextField(dados.getVendas()[pos].getDt_venda(),6);
			listaAnuncio.setEnabled(false);
			
			labelAnuncio.setBounds(30, 20, 150, 25);
			listaAnuncio.setBounds(180,20,300,25);
			labelValorVenda.setBounds(30, 80, 150, 25);
			valorValorVenda.setBounds(180,80,300,25);
			labelComprador.setBounds(30, 110, 150, 25);
			valorComprador.setBounds(180,110,300,25);
			labelFormaPag.setBounds(30, 140, 150, 25);
			valorFormaPag.setBounds(180,140,300,25);
			labelDataVenda.setBounds(30, 170, 150, 25);
			valorDataVenda.setBounds(180,170,300,25);
			botSalvar.setBounds(30, 290, 150, 25);
			botExcluir.setBounds(210,290,150,25);

			listaAnuncio.setEditable(false);
			listaAnuncio.setBackground(Color.white);
			
			this.janela.add(labelAnuncio);
			this.janela.add(listaAnuncio);
			this.janela.add(labelValorVenda);
			this.janela.add(valorValorVenda);
			this.janela.add(labelComprador);
			this.janela.add(valorComprador);
			this.janela.add(labelFormaPag);
			this.janela.add(valorFormaPag);
			this.janela.add(labelDataVenda);
			this.janela.add(valorDataVenda);
			this.janela.add(botSalvar);
			this.janela.add(botExcluir);
			
			this.janela.setLayout(null);
			this.janela.setSize(500, 400);
			this.janela.setVisible(true);
			
			botSalvar.addActionListener(this);
			botExcluir.addActionListener(this);
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		if(src == botSalvar) {
			
				if(opcao == 1) {
					novoDado[0] = Integer.toString(dados.getQtdVendas());	
				}
				
				else {
					novoDado[0]=Integer.toString(posicao);
				}
				novoDado[1] = valorValorVenda.getText();
				novoDado[2] = valorFormaPag.getText();
				novoDado[3] = valorDataVenda.getText();
				anuncioEscolhido = (Anuncio) listaAnuncio.getSelectedItem();
				compradorEscolhido = (Usuario) listaCliente.getSelectedItem();
				dados.inserirEditarVenda(novoDado,anuncioEscolhido,compradorEscolhido);
				janela.dispose();
		}	
				
		if(src== botExcluir) {
			dados.apagarVenda(posicao);
			janela.dispose();
		}
	}

}
