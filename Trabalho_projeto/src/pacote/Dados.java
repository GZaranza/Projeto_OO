package pacote;

public class Dados {

	private Carro[] carros = new Carro[50];
	private int qtdCarros = 0;
	private Loja[] lojas = new Loja[50];
	private int qtdLojas = 0;
	private Endereco[] enderecos = new Endereco[50];
	private int qtdEnderecos = 0;
	private Anuncio[] anuncios = new Anuncio[50];
	private int qtdAnuncios = 0;
	
	
	public void dadosPreCadastrados() {
		enderecos[0] = new Endereco("Rua", "20 sul loja 7", "Aguas Claras", "Brasilia","DF", 71924365);
		carros[0] = new Carro("Chevrolet", "Celta", "2015/2016", "Branco", "PAE7474", "4 PORTAS",
				74569);
		qtdCarros++;
		carros[1] = new Carro("Volkswagen", "Gol", "2017/2018", "Preto", "PGB4598", "2 portas ",
				35684);
		qtdCarros++;
		lojas[0] = new Loja("Julia CAR", "julia@hotmail.com","61983802356", enderecos[0],"123456789","987654321");
		qtdLojas++;
		lojas[1] = new Loja("Bsb carros", "bsbcarros@hotmail.com","6134756982",  enderecos[0],"38154000158","25265874");
		qtdLojas++;
		carros[0].cadastrarCarro(lojas[1]);
		carros[1].cadastrarCarro(lojas[1]);
		
		anuncios[0] = new Anuncio( 25000, "08/12/2022");
		qtdAnuncios++;
		anuncios[0].anunciar(carros[0]);
		
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
	
	public Loja[] getLojas() {
		return lojas;
	}
	
	public void setLojas(Loja[] lojas) {
		this.lojas = lojas;
	}
	
	public int getQtdLojas() {
		return qtdLojas;
	}
	public void setQtdLojas(int qtdLojas) {
		this.qtdLojas = qtdLojas;
	}
	
	public Loja[] getEnderecos() {
		return lojas;
	}
	
	public void setEnderecos(Endereco[] enderecos) {
		this.enderecos = enderecos;
	}
	
	public int getQtdEnderecos() {
		return qtdEnderecos;
	}
	public void setQtdEnderecos(int qtdEnderecos) {
		this.qtdEnderecos = qtdEnderecos;
	}
	
	public Anuncio[] getAnuncios() {
		return anuncios;
	}
	
	public void setAnuncios(Anuncio[] anuncios) {
		this.anuncios = anuncios;
	}
	
	public int getQtdAnuncios() {
		return qtdAnuncios;
	}
	public void setQtdAnuncios(int qtdAnuncios) {
		this.qtdAnuncios = qtdAnuncios;
	}
	
	public void inserirEditarCarro(Carro x, int pos) {
		this.carros[pos] = x;
		if(pos==qtdCarros) qtdCarros++;
	}
	
	public void inserirEditarAnuncio(Anuncio x, int pos) {
		this.anuncios[pos] = x;
		if(pos==qtdAnuncios) qtdAnuncios++;
	}
}
