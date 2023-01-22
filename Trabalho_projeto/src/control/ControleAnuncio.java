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
			s[i] = a[i].toString();
		}
		return s;
	}
	
	public int getQtdAnuncios() {
		return qtdAnuncios;
	}

	public void setQtdAnuncios(int qtdAnuncios) {
		this.qtdAnuncios = qtdAnuncios;
	}
	
	public String[] filtroMarca(String marca) {
		String[] anunciosFiltrados = new String[qtdAnuncios];
		for(int i =0; i<qtdAnuncios;i++) {
			if(a[i].getCarro().getMarca() == marca){
				anunciosFiltrados[i] = a[i].toString();
			}
			else {
				anunciosFiltrados[i] = "ERRO";
			}
		}
		return anunciosFiltrados;
	}
	
}
