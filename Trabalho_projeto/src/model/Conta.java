package model;
/**
 * Classe Conta define atributos que são comuns as subclasses Loja e Carro. Por ser uma classe abstrada, não pode ser instaciada.
 * @author Gabriel Zaranza
 * @since 2023
*/

public abstract class Conta {
	
	protected String nome;
	protected String email;
	protected String telefone;
	protected Endereco endereco;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
