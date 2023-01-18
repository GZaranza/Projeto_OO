package control;

import pacote.*;

public class ControleCarro {
	private Carro[] c;
	private int qtdCarros;
	
	public ControleCarro(ControleDados d) {
		c =d.getCarros();
		qtdCarros =d.getQtdCarros();
	}
	
	public String[] getModeloCarro() {
		String[] s = new String[qtdCarros];
		for(int i = 0; i< qtdCarros;i++) {
			s[i]= c[i].getModelo();
		}
		return s;
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
	
	
	public int getQtdCarros() {
		return qtdCarros;
	}

	public void setQtdCarros(int qtdCarros) {
		this.qtdCarros = qtdCarros;
	}
	
	
	
	
}
