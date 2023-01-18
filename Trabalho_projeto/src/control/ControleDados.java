package control;


import pacote.*;

public class ControleDados {

	private Dados d = new Dados();
	
	public Dados getDados() {
		return d;
	}
	public void setDados(Dados d) {
		this.d = d;
	}

	public Carro[] getCarros() {
		return this.d.getCarros();
	}
	
	public int getQtdCarros() {
		return this.d.getQtdCarros();
	}
	
	public void inserirEditarCarro(String[] dadosCarros) {
		Carro c = new Carro(dadosCarros[1],dadosCarros[2],dadosCarros[3],dadosCarros[4],dadosCarros[5],dadosCarros[6],Integer.parseInt(dadosCarros[7]));
		d.inserirEditarCarro(c, Integer.parseInt(dadosCarros[0]));
		
	}
	
	public boolean apagarCarro(int i) {
		String carroExcluido = d.getCarros()[i].getModelo();
		if(i == (d.getQtdCarros()-1)) {
			d.setQtdCarros((d.getQtdCarros()-1));
			d.getCarros()[d.getQtdCarros()] = null;
			return true;
		}
		else {
			int cont =0;
			while(d.getCarros()[cont].getModelo().compareTo(carroExcluido)!=0);
		}
	}
}
