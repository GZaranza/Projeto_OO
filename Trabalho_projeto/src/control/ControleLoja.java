package control;

import model.*;
/**
 * Classe ControleLoja é o intermediador das view TelaLoja com a model Dados
 * @author Gabriel Zaranza
 *
 */
public class ControleLoja {
	private Loja[] l;
	private int qtdLojas;
	/**
	 * Construtor da Classe ControleLoja
	 * @param d a classe ControleDados que controla os dados do programa
	 */
	public ControleLoja(ControleDados d) {
		l =d.getLojas();
		qtdLojas =d.getQtdLojas();
	}
		
	public int getQtdLojas() {
		return qtdLojas;
	}

	public void setQtdLojas(int qtdLojas) {
		this.qtdLojas = qtdLojas;
	}
	/**
	 * Retorna uma lista de lojas cadastradas no programa
	 * @return String
	 */
	public String[] listarLoja() {
		String[] s = new String[qtdLojas];//Criando a lista
		
		//Loop que percorre todas as lojas
		for(int i = 0; i< qtdLojas;i++) {
			//Atribui o Nome da loja ao elemento atual do Array
			s[i]= l[i].getNome() ;
		}
		return s;
	}
	
}
