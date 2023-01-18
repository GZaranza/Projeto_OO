package pacote;

public class Dados {

	private Carro[] carros = new Carro[50];
	private int qtdCarros = 0;
	
	
	public Carro[] getCarros() {
		return carros;
	}
	public void setCarros(Carro[] carros) {
		this.carros = carros;
	}
	public int getQtdCarros() {
		return qtdCarros;
	}
	public void setQtdCarros(int qtdCarros) {
		this.qtdCarros = qtdCarros;
	}
	
	public void inserirEditarCarro(Carro x, int pos) {
		this.carros[pos] = x;
		if(pos==qtdCarros) qtdCarros++;
	}
}
