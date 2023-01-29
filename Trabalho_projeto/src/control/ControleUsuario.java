package control;

import model.*;
/**
 * Classe ControleUsuario é o intermediador das views com a model Dados
 * @author Gabriel Zaranza
 *
 */
public class ControleUsuario {
	private Usuario[] u;
	private int qtdUsuarios;
	/**
	 * Construtor da Classe ControleUsuario
	 * @param d a classe ControleDados que controla os dados do programa
	 */
	public ControleUsuario(ControleDados d) {
		u = d.getUsuarios();
		qtdUsuarios = d.getQtdUsuarios();
	}

	public int getQtdUsuarios() {
		return qtdUsuarios;
	}

	public void setQtdUsuarios(int qtdUsuarios) {
		this.qtdUsuarios = qtdUsuarios;
	}
	/**
	 * Retorna um Array de String que funciona como lista de usuários, cada elemento do Array é o Nome de um usuário do programa
	 * @return String
	 */
	public String[] listarUsuario() {
		String s[] = new String[qtdUsuarios];//Criando a lista 
		//Loop para percorrer todos os usuários
		for(int i =0; i<qtdUsuarios;i++) {
			//Atribui o retorno do método toString da Classe usuário ao elemento atual do Array
			s[i]=u[i].toString();
		}
		return s;
	}
}
