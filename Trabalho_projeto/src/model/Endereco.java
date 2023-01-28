package model;
/**
 * Classe Endereco que cria um endereço a ser usado por uma Loja ou Usuario
 * @author Gabriel Zaranza
 *
 */
public class Endereco {

	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private int cep;
	
	/**
	 * Contrutor da classe Endereco
	 * @param logradouro o logradouro do endereço
	 * @param complemento o complemento do endereço
	 * @param bairro o bairro do endereço
	 * @param cidade a cidade do endereço
	 * @param estado o estado do endereço
	 * @param cep o CEP do endereço ("12345-678")
	 */
	public Endereco(String logradouro, String complemento, String bairro, String cidade,String estado, int cep) {
		super();
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getCEP() {
		return cep;
	}

	public void setCEP(int cep) {
		this.cep = cep;
	}
	
	public String toString() {
		return "------------Endereco------------\n"+logradouro+" "+complemento+" "+bairro+" "+cidade+" "+estado+" CEP: "+cep+"\n";
	}
	
}
