package pacote;


public class Loja extends Conta {

	private String cnpj;
	private String insc_est;
	private Anuncio[] anuncios= new Anuncio[50];
	private Venda[] vendas= new Venda[50];
	private int numAnuncios=0;
	private Carro[] carros = new Carro[50];
	private int numCarros;
	private int numVenda;
	
	public Loja(String nome, String email,String telefone,Endereco endereco,String cnpj, String insc_est) {
		this.nome=nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco=endereco;
		this.cnpj = cnpj;
		this.insc_est = insc_est;
		
	}

	
	
	public Venda getVendas(int i) {
		return vendas[i];
	}

	public void setVendas(Venda vendas, int i) {
		this.vendas[i] = vendas;
	}

	public int getNumVenda() {
		return numVenda;
	}

	public void setNumVenda(int numVenda) {
		this.numVenda = numVenda;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInsc_est() {
		return insc_est;
	}

	public void setInsc_est(String insc_est) {
		this.insc_est = insc_est;
	}

	public Anuncio getAnuncios(int i) {
		return this.anuncios[i];
	}

	public void setAnuncios(Anuncio anuncios,int i) {
		this.anuncios[i] = anuncios;
	}

	public Carro getCarros(int i) {
		return this.carros[i];
	}

	public void setCarros(Carro carros, int i) {
		this.carros[i] = carros;
	}

	public int getNumCarros() {
		return numCarros;
	}

	public void setNumCarros(int numCarros) {
		this.numCarros = numCarros;
	}

	public int getNumAnuncios() {
		return numAnuncios;
	}

	public void setNumAnuncios(int numAnuncios) {
		this.numAnuncios = numAnuncios;
	}	
	
	public String toString() {
		return "------Loja------\n"+"Loja: "+nome+"\nCNPJ: "+cnpj+"\nIE: "+insc_est+"\nEndereco: "+endereco.getLogradouro()+" "+endereco.getComplemento()+"\nNumero de carros na loja: "+this.getNumCarros()+"\n";
	}
	
	public String consultarEstoque() {
		String saida = "------ Lista de Carros da loja "+this.getNome()+" ------\n" ;
		for(int i = 0; i < numCarros; i++) {
			saida = saida + "\nCarro: "+carros[i].getId_carro()+". " +carros[i].getModelo();
		}
		
		return saida;
	}
	
	public String consultarAnuncios() {
		String saida = "------ Lista de Anuncios da loja "+this.getNome()+" ------\n" ;
		for(int i = 0; i < numAnuncios; i++) {
			saida = saida + "\n"+anuncios[i].getId_anuncio()+". Carro: "+anuncios[i].getCarro().getModelo()+"\n   "+"Valor: R$"+anuncios[i].getValor()+"\n";
		}
		
		return saida;
	}
	
	public String consultarVendas() {
		String saida = "------ Lista de Vendas da loja "+this.getNome()+" ------\n" ;
		for(int i = 0; i < numVenda; i++) {
			saida = saida + "\n"+vendas[i].getId_venda()+". Carro: "+vendas[i].getAnuncio_venda().getCarro().getModelo()+"\n   "+"Valor pago: R$"+vendas[i].getValor_pago()+"\n   "+"Forma de pag: "+vendas[i].getForma_pagamento()+"\n   "+"Cliente: "+vendas[i].getComprador().getNome()+"\n   "+"Data venda: "+vendas[i].getDt_venda()+"\n";
		}
		
		return saida;
	}
	
	
}
