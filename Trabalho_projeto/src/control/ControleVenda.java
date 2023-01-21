package control;

import pacote.*;

public class ControleVenda {
	private Venda[] v;
	private int qtdVendas;
	
	
	public ControleVenda(ControleDados d) {
		v=d.getVendas();
		qtdVendas = d.getQtdVendas();
	}
	
	public String[] getStringVenda() {
		String[]s = new String[qtdVendas];
		for(int i = 0; i<qtdVendas;i++) {
			s[i]= v[i].toString();
		}
		return s;
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
	
	
}
