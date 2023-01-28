package control;

import model.*;

public class ControleCarro {
	private Carro[] c;
	private int qtdCarros;
	
	public ControleCarro(ControleDados d) {
		c =d.getCarros();
		qtdCarros =d.getQtdCarros();
	}

	public String getMarca(int i) {
		return c[i].getMarca();
	}

	public String getModelo(int i) {
		return c[i].getModelo();
	}
	
	public String getAno(int i) {
		return c[i].getAno();
	}
	
	public String getCor(int i) {
		return c[i].getCor();
	}
	
	public String getDesc(int i) {
		return c[i].getDescricao();
	}
	
	public int getKm(int i) {
		return c[i].getKilometragem();
	}
	
	public Loja getLoja(int i) {
		return c[i].getLoja();
	}
	
	public int getQtdCarros() {
		return qtdCarros;
	}

	public void setQtdCarros(int qtdCarros) {
		this.qtdCarros = qtdCarros;
	}
	
	public String[] listarCarro() {
		String[] s = new String[qtdCarros];
		
		for(int i = 0; i< qtdCarros;i++) {
			if(c[i].getFoiVendido()==false) {
				s[i]= c[i].getModelo() +' '+ c[i].getAno();
			}
		}
		
		return s;
	}
	
	public Carro[] listarNaoVendidos() {
		int aux=0;
		Carro[] list = new Carro[qtdCarros];
		for(int i = 0; i< qtdCarros;i++) {
			if(c[i].getFoiVendido()==false) {
				list[aux]= c[i];
				aux++;
			}
		}
		
		return list;
	}
	
	
	
}
