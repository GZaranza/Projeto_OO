package control;

import model.*;
/**
 * Classe ControleAnuncio é o intermediador das views TelaCarro e TelaListaCarro
 * com a model Dados
 * @author Gabriel Zaranza
 *
 */
public class ControleCarro {
	private Carro[] c;//Array de carros
	private int qtdCarros;//Quantidade de carros cadastrados no programa
	
	/**
	 * Construtor da Classe ControleCarro
	 * @param d a classe ControleDados que controla os dados do programa
	 */
	public ControleCarro(ControleDados d) {
		c =d.getCarros();
		qtdCarros =d.getQtdCarros();
	}

	public String getMarca(int i) {
		return c[i].getMarca();
	}

	public String getModelo(int i) {
		return c[i].getModelo();
	}
	
	public String getAno(int i) {
		return c[i].getAno();
	}
	
	public String getCor(int i) {
		return c[i].getCor();
	}
	
	public String getDesc(int i) {
		return c[i].getDescricao();
	}
	
	public int getKm(int i) {
		return c[i].getKilometragem();
	}
	
	public Loja getLoja(int i) {
		return c[i].getLoja();
	}
	
	public int getQtdCarros() {
		return qtdCarros;
	}

	public void setQtdCarros(int qtdCarros) {
		this.qtdCarros = qtdCarros;
	}
	
	/**
	 * Retorna um Array de String que funciona como lista de carros, cada elemento do Array
	 * é o Modelo e Ano de um Carro não vendido
	 * @return String
	 */
	public String[] listarCarro() {
		String[] s = new String[qtdCarros];//Criando a lista 
		
		//Loop para percorrer todos os carros
		for(int i = 0; i< qtdCarros;i++) {
			
			//Condição que sepera apenas os carros que não foram vendidos
			if(c[i].getFoiVendido()==false) {
				
				//Atribui o Modelo e Ano do carro ao elemento da lista
				s[i]= c[i].getModelo() +' '+ c[i].getAno();
				//O index da lista de carros é o mesmo da posição do anúncio na Classe Dados
			}
		}
		
		return s;
	}
	
	/**
	 * Retorna um Array de Carros que não foram vendidos (foiVendido() = FALSE)
	 * @return Carro
	 */
	public Carro[] listarNaoVendidos() {
		int aux=0;//index da lista de carros filtrados
		
		Carro[] list = new Carro[qtdCarros];//Criando a lista 
		
		//Loop para percorrer todos os carros
		for(int i = 0; i< qtdCarros;i++) {
			
			//Condição que sepera apenas os carros que não foram vendidos
			if(c[i].getFoiVendido()==false) {
				
				//Atribui o Carro ao elemento do Array
				list[aux]= c[i];
				aux++;
				//index do Array de Carros é diferente da posição do carro na Classe Dados
			}
		}
		
		return list;
	}
	
	
	
}
