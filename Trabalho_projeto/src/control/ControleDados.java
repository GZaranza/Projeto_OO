package control;


import model.*;
/**
 * Classe ControleDados é o conector entre as Classes do pacote View com as Classes do pacote Model
 * @author Gabriel Zaranza
 *
 */
public class ControleDados {

	private Dados d = new Dados();//Dados armazenados no programa
	
	
	/**
	 * Construtor da Classe ControleDados
	 */
	public ControleDados() {
		d.dadosPreCadastrados();
	}
	
	public Dados getDados() {
		return d;
	}
	public void setDados(Dados d) {
		this.d = d;
	}

	public Carro[] getCarros() {
		return this.d.getCarros();
	}
	
	public int getQtdCarros() {
		return this.d.getQtdCarros();
	}
	
	public Loja[] getLojas() {
		return this.d.getLojas();
	}
	
	public int getQtdLojas() {
		return this.d.getQtdLojas();
	}
	
	public Anuncio[] getAnuncios() {
		return this.d.getAnuncios();
	}
	
	public int getQtdAnuncios() {
		return this.d.getQtdAnuncios();
	}
	
	public Venda[] getVendas() {
		return this.d.getVendas();
	}
	
	public int getQtdVendas() {
		return this.d.getQtdVendas();
	}
	
	public Usuario[] getUsuarios() {
		return this.d.getUsuarios();
	}
	
	public int getQtdUsuarios() {
		return this.d.getQtdUsuarios();
	}
	
	
	/**
	 * Instância um novo objeto da Classe Carro e insere no Array de Carros da Classe Dados
	 * Cadastra o Carro na Loja selecionada
	 * No caso da edição de um objeto Carro já criado, esse método cria um novo Carro e o insere na mesma posição do carro editado no Array Carros[]
	 * @param dadosCarros os dados de cadastro do carro
	 * @param loja a loja que o carro será cadastrado
	 */
	public void inserirEditarCarro(String[] dadosCarros,Loja loja) {
		
		//Instância um novo objeto do tipo Carro e passa os valores dos atributos atraves do dadosCarros[]
		Carro c = new Carro(dadosCarros[1],dadosCarros[2],dadosCarros[3],dadosCarros[4],dadosCarros[5],dadosCarros[6],Integer.parseInt(dadosCarros[7]));
		//Cadastra o carro na loja
		c.cadastrarCarro(loja);
		//Insere o objeto Carro no Array de Carro na Classe Dados, o dadosCarros[0] é a posição que o Carro ficará/fica no Array
		d.inserirEditarCarro(c, Integer.parseInt(dadosCarros[0]));
		
	}
	/**
	 * Apaga a instância de um objeto Carro no Array de Carro na Classe Dados
	 * Diminui a Quatidade de Carros que é o tamanho do Array de Carro na Classe Dados 
	 * @param i a posição que o Carro ocupa no Array de Carro na Classe Dados
	 */
	public void apagarCarro(int i) {
		
		//Atribui a String do método toString do objeto tipo Carro que será apagado do programa
		String carroExcluido = d.getCarros()[i].toString();
		//Conefere se a posição do Carro que será apagado é a última posição do Array Carro
		if(i == (d.getQtdCarros()-1)) {
			
			//Diminui o tamanho do Array Carro em 1
			d.setQtdCarros((d.getQtdCarros()-1));
			//Apaga o Carro que está na última posição
			d.getCarros()[d.getQtdCarros()] = null;
		}
		//Caso o Carro a ser apagado não seja o último do Array de Carro
		else {
			
			//Variável auxiliar que irá armazenar a posição do Carro a ser exluído
			int aux =0;
			//Percorre todo o Array de Carro até encontrar o Carro a ser excluído
			while(d.getCarros()[aux].toString().compareTo(carroExcluido)!=0) {
				aux++;
			}
			//Agora a variável aux armazena a posição do Carro a ser excluído
			
			//Loop que começa na posição do Carro a ser excluído e vai até o final do Array de Carro
			for(int b = aux;b<d.getQtdCarros()-1;b++) {
				//Apaga o Carro da posição atual
				d.getCarros()[b]=null;
				//Atribui o Carro da próxima posição ao Carro da posição atual
				d.getCarros()[b]= d.getCarros()[b+1];
			}
			//Apaga o último Carro do Array
			d.getCarros()[d.getQtdCarros()]=null;
			//Diminui a Quantidade de Carros em 1
			d.setQtdCarros(d.getQtdCarros()-1);
		}
	}
	
	/**
	 * Instância um novo objeto da Classe Anuncio e insere no Array de Anuncios da Classe Dados
	 * Atribui o Anuncio a um Carro selecionado
	 * No caso da edição de um objeto Anuncio já criado, esse método cria um novo Anuncio e o insere na mesma posição do anúncio editado no Array Anuncios[]
	 * @param dadosAnuncio os dados de cadastro do anúncio
	 * @param carro o carro que será colocado no anúncio
	 */
	public void inserirEditarAnuncio(String[] dadosAnuncio,Carro carro) {
		//Instância um novo objeto do tipo Anuncio e passa os valores dos atributos atraves do dadosAnuncio[]
		Anuncio a = new Anuncio(Integer.parseInt(dadosAnuncio[2]),dadosAnuncio[1]);
		//Atribui o anúncio a um carro selecionado
		a.anunciar(carro);
		//Insere o objeto Anuncio no Array de Anuncio na Classe Dados, o dadosAnuncios[0] é a posição que o Anuncio ficará/fica no Array
		d.inserirEditarAnuncio(a, Integer.parseInt(dadosAnuncio[0]));
		
	}
	
	/**
	 * Apaga a instância de um objeto Anuncio no Array de Anuncio na Classe Dados
	 * Diminui a Quatidade de Anuncios que é o tamanho do Array de Anuncio na Classe Dados 
	 * @param i a posição que o Anuncio ocupa no Array de Anuncio na Classe Dados
	 */
	public void apagarAnuncio(int i) {
		//Atribui a String do método toString do objeto tipo Anuncio que será apagado do programa
		String anuncioExcluido = d.getAnuncios()[i].toString();
		//Conefere se a posição do Anuncio que será apagado é a última posição do Array Anuncio
		if(i == (d.getQtdAnuncios()-1)) {
			//Diminui o tamanho do Array Anuncio em 1
			d.setQtdAnuncios((d.getQtdAnuncios()-1));
			//Apaga o Anuncio que está na última posição
			d.getAnuncios()[d.getQtdAnuncios()] = null;
			
			
		}
		//Caso o Anuncio a ser apagado não seja o último do Array de Anuncio
		else {
			//Variável auxiliar que irá armazenar a posição do Anuncio a ser exluído
			int aux =0;
			//Percorre todo o Array de Anuncio até encontrar o Anuncio a ser excluído
			while(d.getAnuncios()[aux].toString().compareTo(anuncioExcluido)!=0) {
				aux++;
			}
			//Agora a variável aux armazena a posição do Anuncio a ser excluído
			
			//Loop que começa na posição do Anuncio a ser excluído e vai até o final do Array de Anuncio
			for(int b = aux;b<d.getQtdAnuncios()-1;b++) {
				//Apaga o Anuncio da posição atual
				d.getAnuncios()[b]=null;
				//Atribui o Anuncio da próxima posição ao Anuncio da posição atual
				d.getAnuncios()[b]= d.getAnuncios()[b+1];
			}
			//Apaga o último Anuncio do Array
			d.getAnuncios()[d.getQtdAnuncios()]=null;
			//Diminui a Quantidade de Anuncios em 1
			d.setQtdAnuncios(d.getQtdAnuncios()-1);
			
		}
	}
	
	/**
	 * Instância um novo objeto da Classe Venda e insere no Array de Vendas da Classe Dados
	 * Atribui a Venda a um Anuncio selecionado
	 * No caso da edição de um objeto Venda já criado, esse método cria um nova Venda e o insere na mesma posição do anúncio editado no Array Vendas[]
	 * @param dadosVendas dados de cadastro da venda
	 * @param anuncio o anúncio que será colocado na venda
	 * @param comprador o usuário que está comprando o carro
	 */
	public void inserirEditarVenda(String[] dadosVendas,Anuncio anuncio,Usuario comprador) {
		//Instância um novo objeto do tipo Venda e passa os valores dos atributos atraves do dadosVendas[]
		Venda v = new Venda(anuncio,comprador,Integer.parseInt(dadosVendas[1]),dadosVendas[2],dadosVendas[3]);
		//Atribui a venda a um anúncio selecionado
		v.vender(anuncio);
		//Insere o objeto Venda no Array de Venda na Classe Dados, o dadosVendas[0] é a posição que a Venda ficará/fica no Array
		d.inserirEditarVenda(v, Integer.parseInt(dadosVendas[0]));
		
	}
	/**
	 * Apaga a instância de um objeto Venda no Array de Venda na Classe Dados
	 * Diminui a Quatidade de Vendas que é o tamanho do Array de Venda na Classe Dados 
	 * @param i a posição que o Venda ocupa no Array de Venda na Classe Dados
	 */
	public void apagarVenda(int i) {
		//Atribui a String do método toString do objeto tipo Vendas que será apagado do programa
		String vendaExcluida = d.getVendas()[i].toString();
		//Conefere se a posição do Vendas que será apagado é a última posição do Array Vendas
		if(i == (d.getQtdVendas()-1)) {
			//Diminui o tamanho do Array Vendas em 1
			d.setQtdVendas((d.getQtdVendas()-1));
			//Apaga o Vendas que está na última posição
			d.getVendas()[d.getQtdVendas()] = null;
		
		}
		//Caso a Venda a ser apagado não seja o último do Array de Vendas
		else {
			//Variável auxiliar que irá armazenar a posição da Venda a ser exluído
			int aux =0;
			//Percorre todo o Array de Venda até encontrar a Venda a ser excluído
			while(d.getVendas()[aux].toString().compareTo(vendaExcluida)!=0) {
				aux++;
			}
			//Agora a variável aux armazena a posição da Venda a ser excluído
			
			//Loop que começa na posição da Venda a ser excluído e vai até o final do Array de Venda
			for(int b = aux;b<d.getQtdVendas()-1;b++) {
				//Apaga a Venda da posição atual
				d.getVendas()[b]=null;
				//Atribui a Venda da posição atual a Venda da próxima posição
				d.getVendas()[b]= d.getVendas()[b+1];
			}
			//Apaga o último Venda do Array
			d.getVendas()[d.getQtdVendas()]=null;
			//Diminui a Quantidade de Vendas em 1
			d.setQtdVendas(d.getQtdVendas()-1);
		
		}
	}
	
}
