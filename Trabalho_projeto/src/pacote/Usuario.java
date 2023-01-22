package pacote;

public class Usuario extends Conta{

	private String CPF;
	private String dt_nasc; //"dd/MM/yyyy";

	public Usuario(String nome, String email, String cPF, String dt_nasc, String telefone, Endereco endereco) {
		this.nome=nome;
		this.email = email;
		this.telefone = telefone;
		CPF = cPF;
		this.dt_nasc = dt_nasc;
		this.endereco = endereco;
	}

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

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(String dt_nasc) {
		this.dt_nasc = dt_nasc;
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
	
	
	public String toString() {
		return this.getNome();
	}

}
