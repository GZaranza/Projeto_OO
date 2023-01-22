package pacote;

public class Venda {

	private int id_venda;
	private Anuncio anuncio_venda; //Carro produto, valor, endereco, dt_anuncio, Conta anunciante, id_anuncio
	private Usuario comprador;
	private int valor_pago;
	private String forma_pagamento;
	private String dt_venda;
	private Loja loja_vend;
	
	
	public Venda(Anuncio anuncio_venda, Usuario comprador, int valor_pago, String forma_pagamento,
			String dt_venda) {
		 
		this.anuncio_venda = anuncio_venda;
		this.comprador = comprador;
		this.valor_pago = valor_pago;
		this.forma_pagamento = forma_pagamento;
		this.dt_venda = dt_venda;
		
	}

	public int getId_venda() {
		return id_venda;
	}

	public void setId_venda(int id_venda) {
		this.id_venda = id_venda;
	}

	public Anuncio getAnuncio_venda() {
		return anuncio_venda;
	}

	public void setAnuncio_venda(Anuncio anuncio_venda) {
		this.anuncio_venda = anuncio_venda;
	}

	public Usuario getComprador() {
		return comprador;
	}

	public void setComprador(Usuario comprador) {
		this.comprador = comprador;
	}

	public int getValor_pago() {
		return valor_pago;
	}

	public void setValor_pago(int valor_pago) {
		this.valor_pago = valor_pago;
	}

	public String getForma_pagamento() {
		return forma_pagamento;
	}

	public void setForma_pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

	public String getDt_venda() {
		return dt_venda;
	}

	public void setDt_venda(String dt_venda) {
		this.dt_venda = dt_venda;
	}

	public Loja getLoja_vend() {
		return loja_vend;
	}

	public void setLoja_vend(Loja loja_vend) {
		this.loja_vend = loja_vend;
	}
	
	public String toString(){
		return anuncio_venda.getLoja().getNome()+": "+ anuncio_venda.getCarro().toString()+" R$"+anuncio_venda.getValor();
	}
	
	public void vender(Anuncio anuncio) {
		int qtd;
		this.setAnuncio_venda(anuncio);
		this.setLoja_vend(anuncio.getCarro().getLoja());
		qtd = anuncio.getCarro().getLoja().getNumVenda();
		this.setId_venda(qtd+1);
		loja_vend.setVendas(this, qtd);
		loja_vend.setNumVenda(qtd+1);
	}
	

}
