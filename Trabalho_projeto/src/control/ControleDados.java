package control;


import pacote.*;

public class ControleDados {

	private Dados d = new Dados();
	
	public ControleDados() {
		d.dadosPreCadastrados();
	}
	
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
	
	public Loja[] getLojas() {
		return this.d.getLojas();
	}
	
	public int getQtdLojas() {
		return this.d.getQtdLojas();
	}
	
	public Anuncio[] getAnuncios() {
		return this.d.getAnuncios();
	}
	
	public int getQtdAnuncios() {
		return this.d.getQtdAnuncios();
	}
	
	public void inserirEditarCarro(String[] dadosCarros,Loja loja) {
		Carro c = new Carro(dadosCarros[1],dadosCarros[2],dadosCarros[3],dadosCarros[4],dadosCarros[5],dadosCarros[6],Integer.parseInt(dadosCarros[7]));
		c.cadastrarCarro(loja);
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
			int aux =0;
			while(d.getCarros()[aux].getModelo().compareTo(carroExcluido)!=0) {
				aux++;
			}
			for(int b = aux;b<d.getQtdCarros()-1;b++) {
				d.getCarros()[b]=null;
				d.getCarros()[b]= d.getCarros()[b+1];
			}
			d.getCarros()[d.getQtdCarros()]=null;
			d.setQtdCarros(d.getQtdCarros()-1);
			return true;
		}
	}
	
	public void inserirEditarAnuncio(String[] dadosAnuncio,Carro carro) {
		Anuncio a = new Anuncio(Integer.parseInt(dadosAnuncio[2]),dadosAnuncio[1]);
		a.anunciar(carro);
		d.inserirEditarAnuncio(a, Integer.parseInt(dadosAnuncio[0]));
		
	}
	
	public boolean apagarAnuncio(int i) {
		String anuncioExcluido = d.getAnuncios()[i].getCarro().toString();
		if(i == (d.getQtdAnuncios()-1)) {
			d.setQtdAnuncios((d.getQtdAnuncios()-1));
			d.getAnuncios()[d.getQtdAnuncios()] = null;
			return true;
		}
		else {
			int aux =0;
			while(d.getAnuncios()[aux].toString().compareTo(anuncioExcluido)!=0) {
				aux++;
			}
			for(int b = aux;b<d.getQtdAnuncios()-1;b++) {
				d.getAnuncios()[b]=null;
				d.getAnuncios()[b]= d.getAnuncios()[b+1];
			}
			d.getAnuncios()[d.getQtdAnuncios()]=null;
			d.setQtdAnuncios(d.getQtdAnuncios()-1);
			return true;
		}
	}
}
