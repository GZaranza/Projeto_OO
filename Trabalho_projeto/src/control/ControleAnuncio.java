package control;

import model.*;
/**
 * Classe ControleAnuncio é o intermediador das views TelaAnuncio e TelaListaAnuncio
 * com a model Dados
 * @author Gabriel Zaranza
 *
 */
public class ControleAnuncio {
	private Anuncio[] a;
	private int qtdAnuncios;
	/**
	 * Construtor da Classe ControleAnuncio
	 * @param d a classe ControleDados que controla os dados do programa
	 */
	public ControleAnuncio(ControleDados d) {
		a = d.getAnuncios();
		qtdAnuncios = d.getQtdAnuncios();
	}	
	
	public int getQtdAnuncios() {
		return qtdAnuncios;
	}

	public void setQtdAnuncios(int qtdAnuncios) {
		this.qtdAnuncios = qtdAnuncios;
	}
	
	/**
	 * Retorna uma lista de anúncios filtrados de acordo com os parâmetros que o cliente colocou nos filtros (marca,valor mínimo e valor máximo) 
	 * @param marca a marca de carro que deseja filtrar nos anúncios
	 * @param valorMin o valor mínimo de carro que deseja filtrar nos anúncios
	 * @param valorMax o valor máximo de carro que deseja filtrar nos anúncios
	 * @return String
	 */
	public String[] filtrarAnuncios(String marca,int valorMin, int valorMax) {
		
		String[] anunciosFiltrados = new String[qtdAnuncios];//Criando a lista 
		
		//Caso o campo de "marca" não foi preenchido pelo usuário
		if(marca.equals("")) {
			int aux =0;//index da lista de anúncios filtrados
			
			//Loop para percorrer todos os anúncios criados
			for(int i=0; i<qtdAnuncios;i++) {
					//Condição que separa apenas os anúncios que estão entre o valor mín. e o valor máx.
					if(a[i].getValor()>=valorMin && a[i].getValor()<=valorMax) {
						
						//Condição que separa apenas os carros que não foram vendidos
						if(a[i].getCarro().getFoiVendido()==false) {
							
							//Atribui o método toString() da Classe anúncio ao elemento da lista filtrada
							anunciosFiltrados[aux] = a[i].toString();
							aux++;
						}
					}
			}
			return anunciosFiltrados;	
		}
		
		int aux =0;//index da lista de anúncios filtrados
		
		//Caso o campo de "marca" foi preenchido pelo usuário
		for(int i =0; i<qtdAnuncios;i++) {
			//Condição que separa apenas os anúncios que estão entre o valor mín. e o valor máx.
			if(a[i].getValor()>=valorMin && a[i].getValor()<=valorMax) {
				
				//Condição que separa apenas os carros que são da marca que o usuário quer filtrar
				if(marca.equals(a[i].getCarro().getMarca())){
					
					//Condição que separa apenas os carros que não foram vendidos
					if(a[i].getCarro().getFoiVendido()==false) {
						
						//Atribui o retorno do método toString() da Classe anúncio ao elemento da lista filtrada
						anunciosFiltrados[aux] = a[i].toString();
						aux++;
					}
				}
			}
				
		}
		return anunciosFiltrados;
	}
	
	/**
	 * Retorna uma lista de todos os anúncios feitos e que não foram vendidos
	 * @return String
	 */
	public String[] listarAnuncios() {
		String[] s = new String[qtdAnuncios];//Criando a lista 
		
		//Loop para percorrer todos os anúncios
		for(int i=0; i<qtdAnuncios;i++) {
			
			//Condição que sepera apenas os carros que não foram vendidos
			if(a[i].getCarro().getFoiVendido()==false) {	
				
				//Atribui o retorno do método toString() da Classe anúncio ao elemento da lista
				s[i] = a[i].toString();
				//O index da lista de anúncios é o mesmo da posição do anúncio na Classe Dados
			}
		}
		
		return s;
	}
	
	/**
	 * Retorna uma lista de todos os anúncios feitos para ser colocado na JComboBox
	 * @return String
	 */
	public Anuncio[] listarNaoVendidos() {
		Anuncio[] list = new Anuncio[qtdAnuncios];//Criando a lista 
		
		int aux=0;//index da lista de anúncios filtrados
		
		//Loop para percorrer todos os anúncios
		for(int i = 0; i< qtdAnuncios;i++) {
			
			//Condição que separa apenas os carros que não foram vendidos
			if(a[i].getCarro().getFoiVendido()==false) {
				
				//Atribui o retorno do método toString() da Classe anúncio ao elemento da lista
				list[aux]= a[i];
				aux++;
				//O index da lista de anúncios não vendidos é diferente da posição do anúncio na Classe Dados
			}
		}
		
		return list;
	}
}
