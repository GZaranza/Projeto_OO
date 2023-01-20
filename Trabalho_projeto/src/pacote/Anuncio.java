package pacote;



public class Anuncio {
	
	private Carro carro;
	private int valor;
	private String dt_anuncio; //"dd/MM/yyyy"
	private Loja loja;
	private int id_anuncio;
	
	public Anuncio(Carro carro,Loja loja, int valor, Endereco local_venda, String dt_anuncio) {
		
		this.carro = carro;
		this.loja=loja;
		this.valor = valor;
		this.dt_anuncio = dt_anuncio;
	}
	
	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getDt_anuncio() {
		return dt_anuncio;
	}

	public void setDt_anuncio(String dt_anuncio) {
		this.dt_anuncio = dt_anuncio;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public int getId_anuncio() {
		return id_anuncio;
	}

	public void setId_anuncio(int id_anuncio) {
		this.id_anuncio = id_anuncio;
	}
	
	public String toString() {
		return "\nCarro: "+carro.getModelo()+"\nValor: R$"+valor+"\nLoja: "+carro.getLoja().getNome()+"\nEndereco: "+carro.getLoja().getEndereco()+" "+loja.getEndereco().getComplemento()+"\nData de anuncio: "+dt_anuncio+"\n";
	}
	
	public void anunciar() {
		int qtd;
		Carro carro = this.getCarro();
		Loja loja = carro.getLoja();
		qtd = loja.getNumAnuncios();
		this.setId_anuncio(qtd+1);
		loja.setAnuncios(this, qtd);
		loja.setNumAnuncios(qtd+1);
	}
	
	
	
}
