package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.ControleCarro;
import control.ControleDados;
import control.ControleVenda;
/**
 * Classe TelaListaVenda cria a interface gráfica da tela que mostra a lista de vendas realizadas
 * @author Gabriel Zaranza
 *
 */
public class TelaListaVendas implements ActionListener, ListSelectionListener{
	private JFrame janela = new JFrame("Vendas");
	private JLabel titulo = new JLabel("Vendas realizadas");
	private JButton realizaVenda = new JButton("Vender");
	private JButton attListaVenda = new JButton("Atualizar");
	private JList<String> listaVendasRealizadas = new JList<String>();
	private static ControleDados dados;
	private String[] listaVendas = new String[50];
	
	/**
	 * Contrutor da Classe TelaListaVenda
	 * @param d a Classe ControleDados que controla os dados do programa 
	 */
	public void mostrarDados(ControleDados d) {
		dados =d;
		
		listaVendas = new ControleVenda(dados).listarVendas();
		listaVendasRealizadas = new JList<String>(listaVendas);
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		listaVendasRealizadas.setFont(new Font("Arial",Font.PLAIN, 18));
		realizaVenda.setFont(new Font("Arial",Font.PLAIN, 18));
		attListaVenda.setFont(new Font("Arial",Font.PLAIN, 18));
		
		titulo.setBounds(150, 10, 300, 40);
		realizaVenda.setBounds(130, 520, 150, 30);
		attListaVenda.setBounds(320, 520, 150, 30);
		listaVendasRealizadas.setBounds(20, 70, 540, 430);
		listaVendasRealizadas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaVendasRealizadas.setVisibleRowCount(10);
		janela.setLocationRelativeTo(null);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(listaVendasRealizadas);
		janela.add(realizaVenda);
		janela.add(attListaVenda);
		
		janela.setSize(600, 600);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		realizaVenda.addActionListener(this);
		attListaVenda.addActionListener(this);
		listaVendasRealizadas.addListSelectionListener(this);
	}
	
	
	//Método que reconhece alguma ação realizada na interface gráfica
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Armazena o objeto que sofreu ação, nesse caso o botão "Vender" ou "Atualizar"
		Object src = e.getSource();

		//Caso a ação foi apertar o botão "Vender"
		if(src == realizaVenda) {
			//Chama o contrutor da TelaVenda e passa como opção a TelaVenda de uma venda nova
			new TelaVenda().mostrarDados(1, dados, this, 0);
		}
		
		//Caso a ação foi apertar o botão "Atualizar"
		if(src == attListaVenda) {
			//Atualiza o JList listaVendasRealizadas com os novos dados após a criação/modificação/exclusão de uma venda
			listaVendasRealizadas.setListData(new ControleVenda(dados).listarVendas());
			//Atualiza visualmente a interface gráfica
			listaVendasRealizadas.updateUI();
		}
	}

	//Método que reconhece quando um item da JList é selecionado
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		//Armazena o objeto que sofreu a ação, nesse caso um item da JList
		Object src = e.getSource();		
		//Entra nessa condição quando um item da lista e selicionada e a lista é a listaVendasRealizadas
		if(e.getValueIsAdjusting() && src == listaVendasRealizadas) {
			//Chama o construtor da Tela venda e passa como opção a TelaVenda de uma venda ja feita e quando foi a venda selecionada
			new TelaVenda().mostrarDados(2, dados, this, listaVendasRealizadas.getSelectedIndex());
		}
	}
}
