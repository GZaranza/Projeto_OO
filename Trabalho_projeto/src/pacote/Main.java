package pacote;

public class Main {
	static Carro celta;
	static Carro gol;
	static Carro hb20;
	static Carro uno;
	static Anuncio anuncio1;//anuncio celta
	static Anuncio anuncio2;//anuncio gol
	static Anuncio anuncio3;//anuncio hb20
	static Anuncio anuncio4;//anuncio uno
	static Loja bsb_carros;
	static Loja julia_car;
	static Endereco endereco1;//end bsb_carros
	static Endereco endereco2;//end julia_car
	static Endereco endereco3;//end gabriel
	static Endereco endereco4;//end pedro
	static Usuario gabriel;
	static Usuario pedro;
	static Venda venda_celta;
	static Venda venda_hb20;
	
	
	public static void main(String[] args) {
		//----------CRIANDO E PRINTANDO UM ENDEREÇO NOVO---------------
		endereco1 = new Endereco("Rua", "20 sul loja 7", "Aguas Claras", "Brasilia","DF", 71924365);
		System.out.println(endereco1.toString());
		
		endereco2 = new Endereco("Rua", "Machado de Assis loja 10", "Vicente Pires", "Brasilia","DF", 7085632);
		System.out.println(endereco2.toString());
		
		endereco3 = new Endereco("Avenida", "JK casa 13", "Guara", "Brasilia","DF", 71587986);
		System.out.println(endereco3.toString());
		
		endereco4 = new Endereco("Rua", "10 norte residencial araucarias", "Taguatinga", "Brasilia","DF", 72569831);
		System.out.println(endereco4.toString());
		
		//----------CRIANDO E PRINTANDO OS USUARIOS--------------
		gabriel= new Usuario("Gabriel Zaranza", "gabriel@hotmail.com", "05295796183", "02/01/2001", "84596321", endereco3);
		System.out.println(gabriel.toString());
		
		pedro= new Usuario("Pedro Pessoa", "pedro@hotmail.com", "501489789", "15/06/2000", "87536214", endereco4);
		System.out.println(pedro.toString());
		
		//----------CRIANDO E PRINTANDO OS CARROS ---------------
		celta = new Carro("Chevrolet", "Celta", "2015/2016", "Branco", "PAE7474", "4 PORTAS",
				74569);
		System.out.println(celta.toString());
		
		gol = new Carro("Volkswagen", "Gol", "2017/2018", "Preto", "PGB4598", "2 portas ",
				35684);
		System.out.println(gol.toString());
		
		hb20= new Carro("Hyundai", "Hb20", "2018/2018", "Branco", "PGH7189", "4 portas ",
				35684);
		uno= new Carro("Fiat", "Uno", "2011/2012", "Vermelho", "JKL5984", "2 portas ",
					35684);
		
		//----------CRIANDO A BSB CARROS-----------------
		bsb_carros= new Loja("Bsb carros", "bsbcarros@hotmail.com","6134756982", endereco1,"38154000158","25265874");
		
		//---------CADASTRANDO O CELTA E O GOL NA BSB CARROS---------
		celta.cadastrarCarro(bsb_carros);
		gol.cadastrarCarro(bsb_carros);
		
		//---------PRINTANDO AS INFORMAÇÕES DA BSB CARROS-----------
		System.out.println(bsb_carros.toString());
		
		System.out.println(bsb_carros.consultarEstoque());
		System.out.println();
		
		//----------CRIANDO A SEGUNDA LOJA--------------
		julia_car= new Loja("Julia CAR", "julia@hotmail.com","61983802356", endereco2,"123456789","987654321");
		 
		//---------CADASTRANDO O HB20 E O UNO NA JULIA CARROS---------
		hb20.cadastrarCarro(julia_car);
		uno.cadastrarCarro(julia_car);
		
		//---------PRINTANDO AS INFORMAÇÕES DA JULIA CAR-----------
		System.out.println(julia_car.toString());
			
		System.out.println(julia_car.consultarEstoque());
		System.out.println();
		
		//----------ANUNCIANDO OS CARROS------------
		anuncio1= new Anuncio(celta,bsb_carros, 25000, endereco1, "08/12/2022");
		anuncio1.anunciar();
		System.out.println(anuncio1.toString());
		
		anuncio2= new Anuncio(gol,bsb_carros, 36999, endereco1, "09/12/2022");
		anuncio2.anunciar();
		System.out.println(anuncio2.toString());
		
		anuncio3= new Anuncio(hb20,julia_car, 47999, endereco2, "10/12/2022");
		anuncio3.anunciar();
		System.out.println(anuncio3.toString());
		
		anuncio4= new Anuncio(uno,julia_car, 21750, endereco2, "11/12/2022");
		anuncio4.anunciar();
		System.out.println(anuncio4.toString());
		
		//-----------CONSULTANDO OS ANUNCIOS DA BSB CARROS-------------
		System.out.println(bsb_carros.consultarAnuncios());
		
		//-----------CONSULTANDO OS ANUNCIOS DA BSB CARROS-------------
		System.out.println(julia_car.consultarAnuncios());
		
		//-----------FAZENDO A VENDA--------------
		venda_celta= new Venda(anuncio1, gabriel, 24500, "financiamento","09/12/2022");
		venda_celta.vender();
		System.out.println(venda_celta.toString());
		
		venda_hb20= new Venda(anuncio3, pedro, 31500, "consorcio","11/12/2022");
		venda_hb20.vender();
		System.out.println(venda_hb20.toString());
		
		//--------------CONSULTANDO AS VENDAS DAS LOJAS-------------
		System.out.println(bsb_carros.consultarVendas());
		System.out.println(julia_car.consultarVendas());
		
	}

}
