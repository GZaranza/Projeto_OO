package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.ControleAnuncio;
import control.ControleCarro;
import control.ControleDados;
import control.ControleLoja;
/**
 * Classe TelaListaAnuncios cria a interface gráfica da tela que mostra a lista de anúncios feitos
 * @author Gabriel Zaranza
 *
 */
public class TelaListaAnuncios implements ActionListener, ListSelectionListener{

	
	private JFrame janela;
	private JLabel titulo;
	private JList<String> listaAnunciosFeitos;
	private JButton anunciaCarro= new JButton("Anunciar");
	private JButton aplicarFiltro = new JButton ("Filtrar");
	private JButton refresh = new JButton("Atualizar");
	private JLabel labelMin = new JLabel("Valor mínimo: ");
	private JTextField valorMin = new JTextField();
	private JLabel labelMax = new JLabel("Valor máximo: ");
	private JTextField valorMax = new JTextField();
	private JLabel labelMarca = new JLabel("Marca: ");
	private JTextField procuraMarca = new JTextField();
	private static ControleDados dados;
	private String[] listaStringAnuncios;
	private int opcao;
	private String marcaFiltro = new String();
	private int minFiltro;
	private int maxFiltro;
	
	
	/**
	 * Contrutor da Classe TelaListaAnuncios
	 * @param d a Classe ControleDados que controla os dados do programa
	 * @param op o tipo de TelaListaAnuncio que será gerada
	 */
	public void mostrarDados(ControleDados d,int op) {
		
		dados = d;
		opcao=op;
		
		//Parâmetros para gerar a TelaListaAnuncio para as lojas
		if(op==1) {
			
			listaStringAnuncios = new ControleAnuncio(dados).listarAnuncios();
			listaAnunciosFeitos = new JList<String>(listaStringAnuncios);
			janela = new JFrame("Anúncios de Carros");
			titulo = new JLabel("Lista de Anúncios");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 30));
			listaAnunciosFeitos.setFont(new Font("Arial",Font.PLAIN, 18));
			anunciaCarro.setFont(new Font("Arial",Font.PLAIN, 18));
			refresh.setFont(new Font("Arial",Font.PLAIN, 18));
			
			titulo.setBounds(150, 10, 300, 40);
			anunciaCarro.setBounds(130, 520, 150, 30);
			refresh.setBounds(320, 520, 150, 30);
			listaAnunciosFeitos.setBounds(20, 70, 540, 430);
			
			janela.setLayout(null);
			janela.add(titulo);
			janela.add(listaAnunciosFeitos);
			janela.add(anunciaCarro);
			janela.add(refresh);
			
			janela.setSize(600, 600);
			janela.setVisible(true);
			janela.setLocationRelativeTo(null);
			anunciaCarro.addActionListener(this);
			refresh.addActionListener(this);
			listaAnunciosFeitos.addListSelectionListener(this);
			
		}
		
		//Parâmetros para gerar a TelaListaAnuncio para os clientes
		else {	
			
			listaStringAnuncios = new ControleAnuncio(dados).listarAnuncios();
			listaAnunciosFeitos = new JList<String>(listaStringAnuncios);
			janela = new JFrame("Anúncios de Carros");
			titulo = new JLabel("Anúncios");
			titulo.setFont(new Font("Arial", Font.BOLD, 30));
			labelMarca.setFont(new Font("Arial", Font.BOLD, 18));
			labelMin.setFont(new Font("Arial", Font.BOLD, 18));
			labelMax.setFont(new Font("Arial", Font.BOLD, 18));
			listaAnunciosFeitos.setFont(new Font("Arial",Font.PLAIN, 18));
			valorMin.setFont(new Font("Arial",Font.PLAIN, 18));
			valorMax.setFont(new Font("Arial",Font.PLAIN, 18));
			procuraMarca.setFont(new Font("Arial",Font.PLAIN, 18));
			aplicarFiltro.setFont(new Font("Arial",Font.PLAIN, 18));
			titulo.setBounds(240, 10, 150, 30);
			listaAnunciosFeitos.setBounds(20, 110, 540, 400);
			labelMin.setBounds(20,85,150,20);
			valorMin.setBounds(145,86,80,20);
			labelMax.setBounds(230,85,150,20);
			valorMax.setBounds(360,86,80,20);
			labelMarca.setBounds(20, 55, 80, 22);
			procuraMarca.setBounds(80,57,145,20);
			refresh.setBounds(20, 520, 100, 30);
			aplicarFiltro.setBounds(450, 85, 100, 20);
			janela.setLocationRelativeTo(null);
			
			janela.setLayout(null);
			janela.add(titulo);
			janela.add(listaAnunciosFeitos);
			janela.add(refresh);
			janela.add(labelMarca);
			janela.add(procuraMarca);
			janela.add(labelMin);
			janela.add(valorMin);
			janela.add(labelMax);
			janela.add(valorMax);
			janela.add(aplicarFiltro);
			
			janela.setSize(600, 600);
			janela.setVisible(true);
			janela.setLocationRelativeTo(null);
			listaAnunciosFeitos.addListSelectionListener(this);
			refresh.addActionListener(this);
			aplicarFiltro.addActionListener(this);
			
			
		}	
	}
	
	//Método que reconhece quando um item da JList é selecionado
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		//Armazena o objeto que sofreu a ação, nesse caso um item da JList
		Object src = e.getSource();
		
		//Caso seja a TelaListaAnuncios das lojas
		if(opcao==1) {	
			//Entra nessa condição quando um item da lista e selicionada e a lista é a listaAnunciosFeitos
			if(e.getValueIsAdjusting() && src == listaAnunciosFeitos) {
				//Chama o construtor da TelaAnuncio e passa como opção a TelaAnuncio de um carro ja cadastrado e posição desse carro no Array de Carro
				new TelaAnuncio().mostrarDados(2, dados, this, listaAnunciosFeitos.getSelectedIndex());
			}
		}
		
		//Caso seja a TelaListaAnuncios dos clientes
		else if(opcao==2) {
			//Entra nessa condição quando um item da lista e selicionada e a lista é a listaAnunciosFeitos
			if(e.getValueIsAdjusting() && src == listaAnunciosFeitos) {
				//Chama o construtor da TelaAnuncio e passa como opção a TelaAnuncio de um carro ja cadastrado e posição desse carro no Array de Carro
				new TelaAnuncio().mostrarDados(3, dados, this, listaAnunciosFeitos.getSelectedIndex());
			}
		}
		
	}

	//Método que reconhece alguma ação realizada na interface gráfica
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Armazena o objeto que sofreu ação, nesse caso o botão "Anunciar" ou "Atualizar"
		Object src = e.getSource();
		
		//Caso seja a TelaListaAnuncios das lojas
		if(opcao==1) {
			
			//Caso a ação foi apertar o botão "Anunciar"
			if(src == anunciaCarro) {
				//Chama o construtor da TelaAnuncio e passa como opção a TelaAnuncio de um anuncio novo
				new TelaAnuncio().mostrarDados(1, dados, this, 0);
			}
			
			//Caso a ação foi apertar o botão "Atualizar"
			if(src== refresh) {
				//Atualiza o JList listaAnunciosFeitos com os novos dados após a criação/modificação/exclusão de um anuncio
				listaAnunciosFeitos.setListData(new ControleAnuncio(dados).listarAnuncios());
				//Atualiza visualmente a interface gráfica
				listaAnunciosFeitos.updateUI();
			}
		}
		
		//Caso seja a TelaListaAnuncios dos clientes
		if(opcao==2) {
			//Caso a ação foi apertar o botão "Atualizar"
			if(src== refresh) {
				//Atualiza o JList listaAnunciosFeitos com os novos dados após a criação/modificação/exclusão de um anuncio
				listaAnunciosFeitos.setListData(new ControleAnuncio(dados).listarAnuncios());
				//Atualiza visualmente a interface gráfica
				listaAnunciosFeitos.updateUI();
			}
			
			//Caso a ação foi apertar o botão "Filtrar"
			if(src == aplicarFiltro) {
				
				//Armazena a String da marca que o cliente quer filtrar a lista de anuncios
				marcaFiltro = procuraMarca.getText();
				
				//Caso o cliente não coloque um valor minimo, o filtro considerará o valor como 0
				if(valorMin.getText().equals("")) {
					minFiltro = 0;
				}
				//Caso coloque o valor minimo, armazena o valor colocado pelo cliente
				else {
					minFiltro = Integer.parseInt(valorMin.getText());
				}
				
				//Caso o cliente não coloque um valor maximo, o filtro considerará o valor como 100000000
				if(valorMax.getText().equals("")) {
					maxFiltro = 100000000;
				}
				//Caso o cliente coloque o valor maximo, armazena o valor colocado pelo cliente
				else {
					maxFiltro = Integer.parseInt(valorMax.getText());
				}
				
				//Atualiza a JList listaAnunciosFeitos com o Array de String dos anuncios filtrados pelo métoto filtrarAnuncios
				listaAnunciosFeitos.setListData(new ControleAnuncio(dados).filtrarAnuncios(marcaFiltro,minFiltro,maxFiltro));
				//Atualiza visualmente a interface gráfica
				listaAnunciosFeitos.updateUI();
			}
		}
	}

}
