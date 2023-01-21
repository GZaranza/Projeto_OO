package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.ControleDados;
import control.ControleLoja;
import pacote.Loja;
import pacote.Usuario;

public class TelaVenda implements ActionListener{

	private JFrame janela = new JFrame("Venda");
	private JLabel labelAnuncio = new JLabel("Anuncio: ");
	private JTextField tituloAnuncio;
	private JLabel labelValorAnuncio = new JLabel("Valor anunciado: ");
	private JTextField valorValorAnuncio;
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
	private Loja lojaEscolhida ;
	
	public void inserirEditarVenda(int op, ControleDados d,TelaListaVendas p, int pos) {
		
		
		/*********Mexer com a jcombobox dos usuarios *************/
		
		
		
		opcao = op;
		posicao=pos;
		dados=d;
		
		//listaNomeCliente = new ControleDados(dados).getUsuarios();
		//listaLojas = new JComboBox<Loja>();
		
		if(op==1) {//opção da loja de cadastrar
		tituloAnuncio = new JTextField(200);
		valorValorAnuncio = new JTextField(200);
		valorValorVenda = new JTextField(4);
		valorComprador = new JTextField(200);
		valorFormaPag = new JTextField(200);
		valorDataVenda = new JTextField(6);
		//listaLojas = new JComboBox<String>(listaNomeLojas);
		//listaLojas = new JComboBox<Loja>(dados.getLojas());
		//listaLojas.setSelectedIndex(-1);
		
		labelAnuncio.setBounds(30, 20, 150, 25);
		tituloAnuncio.setBounds(180,20,180,25);
		labelValorAnuncio.setBounds(30, 50, 150, 25);
		valorValorAnuncio.setBounds(180,50,180,25);
		labelValorVenda.setBounds(30, 80, 150, 25);
		valorValorVenda.setBounds(180,80,180,25);
		labelComprador.setBounds(30, 110, 150, 25);
		valorComprador.setBounds(180,110,180,25);
		labelFormaPag.setBounds(30, 140, 150, 25);
		valorFormaPag.setBounds(180,140,180,25);
		labelDataVenda.setBounds(30, 170, 150, 25);
		valorDataVenda.setBounds(180,170,180,25);
		botSalvar.setBounds(30, 290, 150, 25);
		botExcluir.setBounds(210,290,150,25);
		
		this.janela.add(labelAnuncio);
		this.janela.add(tituloAnuncio);
		this.janela.add(labelValorAnuncio);
		this.janela.add(valorValorAnuncio);
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
		
		}
		else if(op==2) {
			tituloAnuncio = new JTextField(dados.getVendas()[pos].toString(),200);
			valorValorAnuncio = new JTextField(String.valueOf(dados.getVendas()[pos].getAnuncio_venda().getValor()),200);
			valorValorVenda = new JTextField(String.valueOf(dados.getVendas()[pos].getValor_pago()),15);
			valorComprador = new JTextField(dados.getVendas()[pos].getComprador().getNome(),200);
			valorFormaPag = new JTextField(dados.getVendas()[pos].getForma_pagamento(),200);
			valorDataVenda = new JTextField(dados.getVendas()[pos].getDt_venda(),6);
			
			//listaLojas = new JComboBox<Loja>(dados.getLojas());
			//listaLojas.setSelectedItem(dados.getCarros()[pos].getLoja());
			
			labelAnuncio.setBounds(30, 20, 150, 25);
			tituloAnuncio.setBounds(180,20,300,25);
			labelValorAnuncio.setBounds(30, 50, 150, 25);
			valorValorAnuncio.setBounds(180,50,300,25);
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

			tituloAnuncio.setEditable(false);
			tituloAnuncio.setBackground(Color.white);
			valorValorAnuncio.setEditable(false);
			valorValorAnuncio.setBackground(Color.white);
			
			this.janela.add(labelAnuncio);
			this.janela.add(tituloAnuncio);
			this.janela.add(labelValorAnuncio);
			this.janela.add(valorValorAnuncio);
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
				novoDado[1] = valorMarca.getText();
				novoDado[2] = valorModelo.getText();
				novoDado[3] = valorAno.getText();
				novoDado[4] = valorCor.getText();
				novoDado[5] = valorPlaca.getText();
				novoDado[6] = valorDesc.getText();
				novoDado[7] = valorKm.getText();
				lojaEscolhida = (Loja) listaLojas.getSelectedItem();
				dados.inserirEditarVenda(novoDado,lojaEscolhida);
				janela.dispose();
		}	
				
		if(src== botExcluir) {
			dados.apagarCarro(posicao);
			janela.dispose();
		}
	}

}
