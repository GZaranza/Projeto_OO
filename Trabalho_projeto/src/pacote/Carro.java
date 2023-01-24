package pacote;



public class Carro {
	
	private String marca;
	private String modelo;
	private String ano;
	private String cor;
	private String placa;
	private String descricao;
	private int kilometragem;
	private int id_carro;
	private Loja loja;
	private boolean foiVendido = false;
	
	
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
	
	public void cadastrarCarro(Loja loj) {
		int qtd;
		this.setLoja(loj);
		qtd = loj.getNumCarros();
		this.setId_carro(qtd+1);
		loj.setCarros(this, qtd);
		loj.setNumCarros(qtd+1);
	}

	public String consultarCarro() {
		String saida = "ID CARR: "+id_carro+"\nLoja: "+this.getLoja().getNome();
		return saida;
	}
}
