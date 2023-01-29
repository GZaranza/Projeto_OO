package model;
/**
 * Classe Dados possui os Array's que armazenam as instâncias das outras classes do pacote model e os dados pré-cadastrados do projeto.
 * @author Gabriel Zaranza
 *
 */
public class Dados {

	private Carro[] carros = new Carro[50];
	private int qtdCarros = 0;
	private Loja[] lojas = new Loja[50];
	private int qtdLojas = 0;
	private Endereco[] enderecos = new Endereco[50];
	private int qtdEnderecos = 0;
	private Anuncio[] anuncios = new Anuncio[50];
	private int qtdAnuncios = 0;
	private Venda[] vendas = new Venda[50];
	private int qtdVendas = 0;
	private Usuario[] usuarios = new Usuario[50];
	private int qtdUsuarios = 0;
	
	/**
	 * Instâncias das classes do pacote model pré-cadastradas para que o programa inicialize com alguns dados preenchidos
	 */
	public void dadosPreCadastrados() {
		enderecos[0] = new Endereco("Rua", "20 sul loja 7", "Aguas Claras", "Brasilia","DF", 71924365);
		carros[0] = new Carro("Chevrolet", "Celta", "2015/2016", "Branco", "PAE7474", "4 PORTAS",
				74569);
		
		qtdCarros++;
		carros[1] = new Carro("Volkswagen", "Gol", "2017/2018", "Preto", "PGB4598", "2 portas ",
				35684);
		qtdCarros++;
		
		carros[2] = new Carro("Volkswagen", "Amarok", "2019/2020", "Prata", "ABC9876", "4 PORTAS ",
				62679);
		qtdCarros++;
		carros[3] = new Carro("Fiat", "Uno", "2017/2017", "Branco", "PQD9875", "2 portas ",
				38975);
		qtdCarros++;
		carros[4] = new Carro("Fiat", "Strada", "2010/2011", "Vermelho", "JQT6843", "2 portas ",
				98645);
		qtdCarros++;
		carros[5] = new Carro("Hyundai", "Hb20", "2018/2018", "Vermelho", "CVB6549", "2 portas ",
				36544);
		qtdCarros++;
		carros[6] = new Carro("Chevrolet", "Onix", "2018/2018", "Prata", "GMA1976", "2 portas ",
				29874);
		qtdCarros++;

		lojas[0] = new Loja("Julia CAR", "julia@hotmail.com","61983802356", enderecos[0],"123456789","987654321");
		qtdLojas++;
		
		lojas[1] = new Loja("Bsb carros", "bsbcarros@hotmail.com","6134756982",  enderecos[0],"38154000158","25265874");
		qtdLojas++;
		
		carros[0].cadastrarCarro(lojas[1]);
		carros[1].cadastrarCarro(lojas[1]);
		carros[2].cadastrarCarro(lojas[0]);
		carros[3].cadastrarCarro(lojas[1]);
		carros[4].cadastrarCarro(lojas[0]);
		carros[5].cadastrarCarro(lojas[1]);
		carros[6].cadastrarCarro(lojas[0]);
		
		
		usuarios[0] = new Usuario("Gabriel Zaranza", "gabriel@hotmail.com", "05295796183", "02/01/2001", "984596321", enderecos[0]);
		qtdUsuarios++;
		
		usuarios[1] = new Usuario("Victor Brito", "victor@gmail.com", "0123456789", "20/10/2001", "983235689", enderecos[0]);
		qtdUsuarios++;
		
		anuncios[0] = new Anuncio( 25000, "08/12/2022");
		qtdAnuncios++;
		
		anuncios[1] = new Anuncio( 30000, "08/12/2022");
		qtdAnuncios++;
		
		anuncios[2] = new Anuncio( 60000, "08/12/2022");
		qtdAnuncios++;
		
		anuncios[3] = new Anuncio( 27000, "12/12/2022");
		qtdAnuncios++;
		
		anuncios[4] = new Anuncio( 45000, "17/12/2022");
		qtdAnuncios++;
		
		anuncios[5] = new Anuncio( 12000, "29/11/2022");
		qtdAnuncios++;
		
		anuncios[6] = new Anuncio( 56000, "03/01/2023");
		qtdAnuncios++;
		

		
		anuncios[0].anunciar(carros[0]);
		anuncios[1].anunciar(carros[1]);
		anuncios[2].anunciar(carros[2]);
		anuncios[3].anunciar(carros[3]);
		anuncios[4].anunciar(carros[4]);
		anuncios[5].anunciar(carros[5]);
		anuncios[6].anunciar(carros[6]);
		
		vendas[0]= new Venda(anuncios[0],usuarios[0], 20000,"financiamento","09/12/2022");
		qtdVendas++;
		vendas[1]= new Venda(anuncios[5],usuarios[1], 11000,"financiamento","30/12/2022");
		qtdVendas++;
		vendas[0].vender(anuncios[0]);
		vendas[0].getAnuncio_venda().getCarro().setFoivendido(true);
		vendas[1].vender(anuncios[1]);
		vendas[1].getAnuncio_venda().getCarro().setFoivendido(true);
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
	
	public Venda[] getVendas() {
		return vendas;
	}

	public void setVendas(Venda[] vendas) {
		this.vendas = vendas;
	}

	public int getQtdVendas() {
		return qtdVendas;
	}

	public void setQtdVendas(int qtdVendas) {
		this.qtdVendas = qtdVendas;
	}

	public Usuario[] getUsuarios() {
		return usuarios;
	}
	
	public void setAUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}
	
	public int getQtdUsuarios() {
		return qtdUsuarios;
	}
	public void setQtdUsuarios(int qtdUsuarios) {
		this.qtdUsuarios = qtdUsuarios;
	}
	
	/**
	 * Insere ou edita instâncias de carros no Array carros[]
	 * @param carro a instância de Carro a ser colocada ou editada no Array carros[]
	 * @param pos a posição que o Carro ficará ou fica no Array carros[]
	 */
	public void inserirEditarCarro(Carro carro, int pos) {
		this.carros[pos] = carro;
		if(pos==qtdCarros) qtdCarros++;
	}
	/**
	 * Insere ou edita instâncias de anuncios no Array anuncios[]
	 * @param anuncio a instância de Anuncio a ser colocado ou editado no Array anuncios[]
	 * @param pos a posição que o Anuncio ficará ou fica no Array anuncios[]
	 */
	public void inserirEditarAnuncio(Anuncio anuncio, int pos) {
		this.anuncios[pos] = anuncio;
		if(pos==qtdAnuncios) qtdAnuncios++;
	}
	/**
	 * Insere ou edita instâncias de anuncios no Array vendas[]
	 * @param venda a instância de Venda a ser colocada ou editada no Array vendas[]
	 * @param pos a posição que a Venda ficará ou fica no Array vendas[]
	 */
	public void inserirEditarVenda(Venda venda, int pos) {
		this.vendas[pos]=venda;
		if(pos==qtdVendas) qtdVendas++;
	}
}
