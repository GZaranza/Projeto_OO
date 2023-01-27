package com.demo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import control.ControleCarro;
import control.ControleDados;
import pacote.Anuncio;
import pacote.Carro;
import pacote.Endereco;
import pacote.Loja;
import pacote.Usuario;
import pacote.Venda;

class TesteListaNaoVendidos {

	@Test
	void test() {
		int numCarros = 4;
		Carro[] carros = new Carro[numCarros];
		Loja[] lojas = new Loja[50];
		Endereco[] enderecos = new Endereco[50];
		Anuncio[] anuncios = new Anuncio[50];
		Usuario[] usuarios = new Usuario[50];
		Venda[] vendas = new Venda[50];
		ControleDados dados = new ControleDados();
		
	
		// Cadastrando os dados necessários para gerar uma lista de anuncios
		
		enderecos[0] = new Endereco("Rua", "20 sul loja 7", "Aguas Claras", "Brasilia","DF", 71924365);
		carros[0] = new Carro("Chevrolet", "Celta", "2015/2016", "Branco", "PAE7474", "4 PORTAS",
				74569);
		carros[1] = new Carro("Volkswagen", "Gol", "2017/2018", "Preto", "PGB4598", "2 portas ",
				35684);
		carros[2] = new Carro("Volkswagen", "Amarok", "2019/2020", "Prata", "ABC9876", "4 PORTAS ",
				62679);
		carros[3] = new Carro("Hyundai", "Hb20", "2018/2018", "Vermelho", "CVB6549", "2 portas ",
				21587);
		lojas[0] = new Loja("Julia CAR", "julia@hotmail.com","61983802356", enderecos[0],"123456789","987654321");
		lojas[1] = new Loja("Bsb carros", "bsbcarros@hotmail.com","6134756982",  enderecos[0],"38154000158","25265874");
		carros[0].cadastrarCarro(lojas[1]);
		carros[1].cadastrarCarro(lojas[1]);
		carros[2].cadastrarCarro(lojas[0]);
		carros[3].cadastrarCarro(lojas[0]);
		
		usuarios[0] = new Usuario("Gabriel Zaranza", "gabriel@hotmail.com", "05295796183", "02/01/2001", "984596321", enderecos[0]);
		usuarios[1] = new Usuario("Victor Brito", "victor@gmail.com", "0123456789", "20/10/2001", "983235689", enderecos[0]);
		anuncios[0] = new Anuncio( 25000, "08/12/2022");
		anuncios[1] = new Anuncio( 30000, "08/12/2022");
		anuncios[2] = new Anuncio( 60000, "08/12/2022");
		anuncios[3] = new Anuncio( 15000, "08/12/2022");	
		anuncios[0].anunciar(carros[0]);
		anuncios[1].anunciar(carros[1]);
		anuncios[2].anunciar(carros[2]);
		anuncios[3].anunciar(carros[3]);
		
		vendas[0]= new Venda(anuncios[0],usuarios[0], 20000,"financiamento","09/12/2022");
		vendas[0].vender(anuncios[0]);
		vendas[0].getAnuncio_venda().getCarro().setFoivendido(true);				
		
		
		/*Como o anuncios[0] foi vendido ele não deverá aparecer na lista resultante do metodo listaNaoVendido*/
		Carro [] listaEsperada = new Carro[3];
		listaEsperada[0] = carros[1];
		listaEsperada[1] = carros[2];
		listaEsperada[2] = carros[3];
		
		//Gerando a lista de carros não vendidos com o metodo listarNaoVendidos
		Carro[] listaEncontrada = new ControleCarro(dados).listarNaoVendidos();
		
		//Comparando item a item da listaEsperada com a listaEncontrada
		assertEquals(listaEsperada[0].toString(),listaEncontrada[0].toString());
		assertEquals(listaEsperada[1].toString(),listaEncontrada[1].toString());
		assertEquals(listaEsperada[2].toString(),listaEncontrada[2].toString());
		
	}

}
