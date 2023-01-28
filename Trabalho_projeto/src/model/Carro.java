package model;
/**
 * Classe Carro cria um carro.
 * @author Gabriel Zaranza
 * @since 2023
*/


public class Carro {
	
	private String marca;
	private String modelo;
	private String ano;//"yyyy/yyyy"
	private String cor;
	private String placa;
	private String descricao;
	private int kilometragem;
	private int id_carro;//Identificador do carro em uma loja
	private Loja loja;
	private boolean foiVendido = false;//True se o carro foi vendido e False se ainda não foi
	/**
	 * Contrutor da classe Carro
	 * @param marca a marca/montadora do carro
	 * @param modelo o modelo do carro
	 * @param ano o ano de fabricação do carro
	 * @param cor a cor do carro
	 * @param placa a placa do carro ("ABC1234")
	 * @param descricao os detalhes do carro
	 * @param kilometragem a kilometragem que o carro já andou
	 */
	
	public Carro(String marca, String modelo, String ano, String cor, String placa, String descricao,
			int kilometragem) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.placa = placa;
		this.descricao = descricao;
		this.kilometragem = kilometragem;
		
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getKilometragem() {
		return kilometragem;
	}

	public void setKilometragem(int kilometragem) {
		this.kilometragem = kilometragem;
	}

	public int getId_carro() {
		return id_carro;
	}

	public void setId_carro(int id_carro) {
		this.id_carro = id_carro;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	
	public boolean getFoiVendido() {
		return foiVendido;
	}
	
	public void setFoivendido(boolean foiVendido) {
		this.foiVendido = foiVendido;
	}
	
	public String toString() {
		return marca+ " "+ modelo+ " "+ano+" "+placa;
	}
	/**
	 * Cadastra o carro em uma Loja. Gera o identificador único do carro e incrementa a quantidade de carros na Loja de cadastro
	 * @param loja a Loja em que o carro será cadastrado
	 */
	public void cadastrarCarro(Loja loja) {
		int qtd;
		this.setLoja(loja);
		qtd = loja.getNumCarros();
		this.setId_carro(qtd+1);
		loja.setCarros(this, qtd);
		loja.setNumCarros(qtd+1);
	}
	/**
	 * Retorna o identificador único e a Loja em que o carro foi cadastrado
	 * @return String
	 */
	public String consultarCarro() {
		String saida = "ID CARR: "+id_carro+"\nLoja: "+this.getLoja().getNome();
		return saida;
	}
}
