package pacote;

public class Dados {

	private Carro[] carros = new Carro[50];
	private int qtdCarros = 0;
	
	
	public void dadosPreCadastrados() {
		carros[0] = new Carro("Chevrolet", "Celta", "2015/2016", "Branco", "PAE7474", "4 PORTAS",
				74569);
		qtdCarros = 1;
	}
	
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
