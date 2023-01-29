package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.ControleCarro;
import control.ControleDados;

import java.awt.Font;
import java.awt.event.*;
/**
 * Classe TelaListaCarros cria a interface gráfica da tela que mostra a lista de carros cadastrados no programa
 * @author Gabriel Zaranza
 *
 */
public class TelaListaCarros implements ActionListener, ListSelectionListener {

	private JFrame janela = new JFrame("Carros");
	private JLabel titulo = new JLabel("Carros cadastrados");
	private JButton cadastroCarro = new JButton("Cadastrar");
	private JButton attListaCarro = new JButton("Atualizar");
	private JList<String> listaCarrosCadastrados = new JList<String>();
	private static ControleDados dados;
	private String[] listaModelos = new String[50];
	/**
	 * Contrutor da classe TelaListaCarros
	 * @param d  a Classe ControleDados que controla os dados do programa
	 */
	public void mostrarDados(ControleDados d) {
		dados =d;
		
		listaModelos = new ControleCarro(dados).listarCarro();
		listaCarrosCadastrados = new JList<String>(listaModelos);
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		listaCarrosCadastrados.setFont(new Font("Arial",Font.PLAIN, 18));
		cadastroCarro.setFont(new Font("Arial",Font.PLAIN, 18));
		attListaCarro.setFont(new Font("Arial",Font.PLAIN, 18));
		titulo.setBounds(150, 10, 300, 40);
		cadastroCarro.setBounds(130, 520, 150, 30);
		attListaCarro.setBounds(320, 520, 150, 30);
		listaCarrosCadastrados.setBounds(20, 70, 540, 430);
		listaCarrosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaCarrosCadastrados.setVisibleRowCount(10);
		janela.setLocationRelativeTo(null);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(listaCarrosCadastrados);
		janela.add(cadastroCarro);
		janela.add(attListaCarro);
		
		janela.setSize(600, 600);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		cadastroCarro.addActionListener(this);
		attListaCarro.addActionListener(this);
		listaCarrosCadastrados.addListSelectionListener(this);
	}
	
	
	//Método que reconhece alguma ação realizada na interface gráfica
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Armazena o objeto que sofreu ação, nesse caso o botão "Cadastrar" ou "Atualizar"
		Object src = e.getSource();
		
		//Caso a ação foi apertar o botão "Cadastrar"
		if(src == cadastroCarro) {
			//Chama o construtor da TelaCarro e passa como parâmetro a TelaCarro de um novo carro
			new TelaCarro().mostrarDados(1, dados, this, 0);
		}
		
		//Caso a ação foi apertar o botão "Atualizar"
		if(src == attListaCarro) {
			//Atualiza o JList listaCarrosCadastrados com os novos dados após a criação/modificação/exclusão de um carro
			listaCarrosCadastrados.setListData(new ControleCarro(dados).listarCarro());
			//Atualiza visualmente a interface gráfica
			listaCarrosCadastrados.updateUI();
		}
	}

	//Método que reconhece quando um item da JList é selecionado
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		//Armazena o objeto que sofreu a ação, nesse caso um item da JList
		Object src = e.getSource();	
		
		//Entra nessa condição quando um item da lista e selicionada e a lista é a listaCarrosCadastrados
		if(e.getValueIsAdjusting() && src == listaCarrosCadastrados) {
			//Chama o construtor da TelaCarro e passa como opção a TelaCarro de um carro ja cadastrado e posição desse carro no Array de Carro
			new TelaCarro().mostrarDados(2, dados, this, listaCarrosCadastrados.getSelectedIndex());
		}
	}
}
