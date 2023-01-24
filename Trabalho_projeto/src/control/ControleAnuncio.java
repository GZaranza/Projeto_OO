package control;

import pacote.*;

public class ControleAnuncio {
	private Anuncio[] a;
	private int qtdAnuncios;
	
	public ControleAnuncio(ControleDados d) {
		a = d.getAnuncios();
		qtdAnuncios = d.getQtdAnuncios();
	}
	
	public String[] getAnuncioString() {
		String[] s = new String[qtdAnuncios];
		
		for(int i=0; i<qtdAnuncios;i++) {
			if(a[i].getCarro().getFoiVendido()==false) {	
				s[i] = a[i].toString();
			}
		}
		
		return s;
	}
	
	public Anuncio[] listaNaoVendidos() {
		Anuncio[] list = new Anuncio[qtdAnuncios];
		for(int i = 0; i< qtdAnuncios;i++) {
			if(a[i].getCarro().getFoiVendido()==false) {
				list[i]= a[i];
			}
		}
		
		return list;
	}
	
	
	public int getQtdAnuncios() {
		return qtdAnuncios;
	}

	public void setQtdAnuncios(int qtdAnuncios) {
		this.qtdAnuncios = qtdAnuncios;
	}
	
	public String[] filtrarLista(String marca,int valorMin, int valorMax) {
		String[] anunciosFiltrados = new String[qtdAnuncios];
		
		if(marca.equals("")) {
			
		for(int i=0; i<qtdAnuncios;i++) {
				if(a[i].getValor()>=valorMin && a[i].getValor()<=valorMax) {
					anunciosFiltrados[i] = a[i].toString();
				}
		}
			return anunciosFiltrados;
		}
		
		for(int i =0; i<qtdAnuncios;i++) {
			if(a[i].getValor()>=valorMin && a[i].getValor()<=valorMax) {
				if(marca.equals(a[i].getCarro().getMarca())){
					anunciosFiltrados[i] = a[i].toString();
				}
			}
		}
		return anunciosFiltrados;
	}
	
}
