package model;
/**
 * Classe Anuncio cria um anúncio de um carro em uma loja.
 * @author Gabriel Zaranza
 * @since 2023
*/
public class Anuncio {
	
	private Carro carro;
	private int valor;
	private String dt_anuncio; //"dd/MM/yyyy"
	private Loja loja;
	private int id_anuncio; //Identificador do anúncio em uma loja
	private boolean foiVendido = false; //True se o anúncio foi vendido e False se ainda não foi
	
	/**
	 * Contrutor da classe Anuncio 
	 * @param valor o valor a ser cobrado pelo Carro
	 * @param dt_anuncio a data que o anuncio foi feito (dd/MM/yyyy)
	*/
	public Anuncio(int valor, String dt_anuncio) {
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
	
	public boolean getFoiVendido() {
		return foiVendido;
	}
	
	public void setFoivendido(boolean foiVendido) {
		this.foiVendido = foiVendido;
	}
		
	public String toString() {
		return carro.getLoja().getNome()+": "+carro.toString()+' '+"R$"+valor;
	}
	
	/**
	 * Atribui o anúncio a um Carro e a Loja que o carro está cadastrado. Gera o identificador único do anúncio e incrementa em 1 a quantidade de anúncios da Loja.
	 * @param carro o carro a ser anunciado
	 */
	public void anunciar(Carro carro) {
		int qtd;
		this.setCarro(carro);
		this.setLoja(carro.getLoja());
		qtd = carro.getLoja().getNumAnuncios();
		this.setId_anuncio(qtd+1);
		loja.setAnuncios(this, qtd);
		loja.setNumAnuncios(qtd+1);
	}
	
	
	
}
