package com.demo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import control.ControleAnuncio;
import control.ControleDados;
import model.*;

class TesteFiltroAnuncio {

	/*Testando o metodo filtrarLista que é usado na lista de anuncios
	  para filtrar os anuncios por Marca, valor mínimo e valor máximo */	
	@Test
	void test() {
		
		int numCarros = 4;
		Carro[] carros = new Carro[numCarros];
		Loja[] lojas = new Loja[50];
		Endereco[] enderecos = new Endereco[50];
		Anuncio[] anuncios = new Anuncio[50];
		ControleDados dados = new ControleDados();
	
		// Cadastrando os dados necessários para gerar uma lista de anuncios
		
		enderecos[0] = new Endereco("Rua", "20 sul loja 7", "Aguas Claras", "Brasilia","DF", 71924365);
		carros[0] = new Carro("Chevrolet", "Celta", "2015/2016", "Branco", "PAE7474", "4 PORTAS",74569);
		carros[1] = new Carro("Volkswagen", "Gol", "2017/2018", "Preto", "PGB4598", "2 portas ",35684);		
		carros[2] = new Carro("Volkswagen", "Amarok", "2019/2020", "Prata", "ABC9876", "4 PORTAS ",62679);	
		carros[3] = new Carro("Hyundai", "Hb20", "2018/2018", "Vermelho", "CVB6549", "2 portas ",21587);		
		lojas[0] = new Loja("Julia CAR", "julia@hotmail.com","61983802356", enderecos[0],"123456789","987654321");
		lojas[1] = new Loja("Bsb carros", "bsbcarros@hotmail.com","6134756982",  enderecos[0],"38154000158","25265874");				
		carros[0].cadastrarCarro(lojas[1]);
		carros[1].cadastrarCarro(lojas[1]);
		carros[2].cadastrarCarro(lojas[0]);
		carros[3].cadastrarCarro(lojas[0]);				
		anuncios[0] = new Anuncio( 25000, "08/12/2022");
		anuncios[1] = new Anuncio( 30000, "08/12/2022");
		anuncios[2] = new Anuncio( 60000, "08/12/2022");
		anuncios[3] = new Anuncio( 15000, "08/12/2022");		
		anuncios[0].anunciar(carros[0]);
		anuncios[1].anunciar(carros[1]);
		anuncios[2].anunciar(carros[2]);
		anuncios[3].anunciar(carros[3]);
		
		//Setando os filtros que serão usados no teste
		String marcaFiltro="Volkswagen";
		int valorMinFiltro=10000;
		int valorMaxFiltro=35000;
		
		//Para o caso acima, apenas o anuncio[1] se encaixa nos filtros, portanto, a lista esperada contem apenas ele.
		String[] listaEsperada = new String[numCarros];
		listaEsperada[0] = anuncios[1].toString();//os demais itens da listaEsperada são nulos
		
		//Filtrando a lista de anuncios com o metodo filtrarLista
		String[] listaEncontrada = new ControleAnuncio(dados).filtrarAnuncios(marcaFiltro, valorMinFiltro, valorMaxFiltro);
		
		//Comparando item a item da listaEsperada com a listaEncontrada
		assertEquals(listaEsperada[0],listaEncontrada[0]);
		assertEquals(listaEsperada[1],listaEncontrada[1]);
		assertEquals(listaEsperada[2],listaEncontrada[2]);
		assertEquals(listaEsperada[3],listaEncontrada[3]);
		
		
		
	}

}
