package control;

import pacote.*;

public class ControleLoja {
	private Loja[] l;
	private int qtdLojas;
	
	public ControleLoja(ControleDados d) {
		l =d.getLojas();
		qtdLojas =d.getQtdLojas();
	}
	
	public String[] getNomeLoja() {
		String[] s = new String[qtdLojas];
		for(int i = 0; i< qtdLojas;i++) {
			s[i]= l[i].getNome() ;
		}
		return s;
	}
		
	public int getQtdLojas() {
		return qtdLojas;
	}

	public void setQtdLojas(int qtdLojas) {
		this.qtdLojas = qtdLojas;
	}
}
