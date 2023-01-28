package view;

import java.awt.Color;
import java.awt.Font;
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
import model.Anuncio;
import model.Loja;
import model.Usuario;

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
	
	
	public void mostrarDados(int op, ControleDados d,TelaListaVendas p, int pos) {
	
		opcao = op;
		posicao=pos;
		dados=d;
		
		listaNomeCliente = new ControleUsuario(dados).listarUsuario();
		listaCliente = new JComboBox<Usuario>();
		
		if(op==1) {//fazer uma nova venda
		listaAnuncio = new JComboBox<Anuncio>(new ControleAnuncio(dados).listarNaoVendidos());
		valorValorVenda = new JTextField(4);
		valorComprador = new JTextField(200);
		valorFormaPag = new JTextField(200);
		valorDataVenda = new JTextField(6);
		listaCliente = new JComboBox<Usuario>(dados.getUsuarios());
		listaCliente.setSelectedIndex(-1);
		listaAnuncio.setSelectedIndex(-1);
		janela.setLocationRelativeTo(null);
		
		labelAnuncio.setBounds(30, 20, 150, 25);
		listaAnuncio.setBounds(180,20,360,25);
		labelValorVenda.setBounds(30, 50, 170, 25);
		valorValorVenda.setBounds(190,50,350,25);
		labelComprador.setBounds(30, 80, 150, 25);
		listaCliente.setBounds(180,80,360,25);
		labelFormaPag.setBounds(30, 110, 270, 25);
		valorFormaPag.setBounds(290,110,250,25);
		labelDataVenda.setBounds(30, 140, 200, 25);
		valorDataVenda.setBounds(220,140,320,25);
		botSalvar.setBounds(130, 520, 150, 30);
		botExcluir.setBounds(320, 520, 150, 30);
		
		labelAnuncio.setFont(new Font("Arial",Font.PLAIN, 25));
		listaAnuncio.setFont(new Font("Arial",Font.PLAIN, 15));
		labelValorVenda.setFont(new Font("Arial",Font.PLAIN, 25));
		valorValorVenda.setFont(new Font("Arial",Font.PLAIN, 25));
		labelComprador.setFont(new Font("Arial",Font.PLAIN, 25));
		listaCliente.setFont(new Font("Arial",Font.PLAIN, 20));
		labelFormaPag.setFont(new Font("Arial",Font.PLAIN, 25));
		valorFormaPag.setFont(new Font("Arial",Font.PLAIN, 25));
		labelDataVenda.setFont(new Font("Arial",Font.PLAIN, 25));
		valorDataVenda.setFont(new Font("Arial",Font.PLAIN, 25));
		botSalvar.setFont(new Font("Arial",Font.PLAIN, 25));
		botExcluir.setFont(new Font("Arial",Font.PLAIN, 25));
		
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
		this.janela.add(listaCliente);
		
		listaAnuncio.setBackground(Color.white);
		listaCliente.setBackground(Color.white);
		this.janela.setLayout(null);
		janela.setSize(600, 600);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);

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
			listaCliente = new JComboBox<Usuario>(dados.getUsuarios());
			listaCliente.setSelectedItem(dados.getVendas()[pos].getComprador());
			janela.setLocationRelativeTo(null);
			
			labelAnuncio.setBounds(30, 20, 150, 25);
			listaAnuncio.setBounds(180,20,360,25);
			labelValorVenda.setBounds(30, 50, 170, 25);
			valorValorVenda.setBounds(190,50,350,25);
			labelComprador.setBounds(30, 80, 150, 25);
			listaCliente.setBounds(180,80,360,25);
			labelFormaPag.setBounds(30, 110, 270, 25);
			valorFormaPag.setBounds(290,110,250,25);
			labelDataVenda.setBounds(30, 140, 200, 25);
			valorDataVenda.setBounds(220,140,320,25);
			botSalvar.setBounds(130, 520, 150, 30);
			botExcluir.setBounds(320, 520, 150, 30);
			
			labelAnuncio.setFont(new Font("Arial",Font.PLAIN, 25));
			listaAnuncio.setFont(new Font("Arial",Font.PLAIN, 15));
			labelValorVenda.setFont(new Font("Arial",Font.PLAIN, 25));
			valorValorVenda.setFont(new Font("Arial",Font.PLAIN, 25));
			labelComprador.setFont(new Font("Arial",Font.PLAIN, 25));
			listaCliente.setFont(new Font("Arial",Font.PLAIN, 20));
			labelFormaPag.setFont(new Font("Arial",Font.PLAIN, 25));
			valorFormaPag.setFont(new Font("Arial",Font.PLAIN, 25));
			labelDataVenda.setFont(new Font("Arial",Font.PLAIN, 25));
			valorDataVenda.setFont(new Font("Arial",Font.PLAIN, 25));
			botSalvar.setFont(new Font("Arial",Font.PLAIN, 25));
			botExcluir.setFont(new Font("Arial",Font.PLAIN, 25));
			
			
			
			janela.setLocationRelativeTo(null);
			listaAnuncio.setEditable(false);
			listaAnuncio.setBackground(Color.white);
			listaCliente.setBackground(Color.white);
			
			this.janela.add(labelAnuncio);
			this.janela.add(listaAnuncio);
			this.janela.add(labelValorVenda);
			this.janela.add(valorValorVenda);
			this.janela.add(labelComprador);
			this.janela.add(listaCliente);
			this.janela.add(valorComprador);
			this.janela.add(labelFormaPag);
			this.janela.add(valorFormaPag);
			this.janela.add(labelDataVenda);
			this.janela.add(valorDataVenda);
			this.janela.add(botSalvar);
			this.janela.add(botExcluir);
			
			this.janela.setLayout(null);
			janela.setSize(600, 600);
			janela.setVisible(true);
			janela.setLocationRelativeTo(null);
			
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
