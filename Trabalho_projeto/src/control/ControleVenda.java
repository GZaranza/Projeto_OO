package control;

import model.*;
/**
 * Classe ControleVenda é o intermediador das views TelaVenda e TelaListaVenda
 * com a model Dados
 * @author Gabriel Zaranza
 *
 */
public class ControleVenda {
	private Venda[] v;
	private int qtdVendas;
	
	/**
	 * Construtor da Classe ControleVenda
	 * @param d a classe ControleDados que controla os dados do programa
	 */
	public ControleVenda(ControleDados d) {
		v=d.getVendas();
		qtdVendas = d.getQtdVendas();
	}
	
	public Anuncio getAnuncio(int i){
		return v[i].getAnuncio_venda();
	}
	
	public Usuario getComprador(int i) {
		return v[i].getComprador();
	}
	
	public int getValorPago(int i) {
		return v[i].getValor_pago();
	}
	
	public String getFormaPagamento(int i) {
		return v[i].getForma_pagamento();
	}
	
	public String getDataVenda(int i) {
		return v[i].getDt_venda();
	}
	
	public Loja getLojaVenda(int i) {
		return v[i].getLoja_vend();
	}

	public int getQtdVendas() {
		return qtdVendas;
	}

	public void setQtdVendas(int qtdVendas) {
		this.qtdVendas = qtdVendas;
	}
	/**
	 * Retorna um Array de String que funciona como lista de vendas, cada elemento do Array é o retorno do método toString da Classe Venda
	 * @return String
	 */
	public String[] listarVendas() {
		//Criando a lista
		String[]s = new String[qtdVendas];
		
		//Loop que percorre todas as Vendas
		for(int i = 0; i<qtdVendas;i++) {
			//Atribui o retorno do método toString da Classe Venda ao elemento atual do Array
			s[i]= v[i].toString();
		}
		return s;
	}
	
}
