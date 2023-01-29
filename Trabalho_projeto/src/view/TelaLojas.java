package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.ControleCarro;
import control.ControleDados;
import control.ControleLoja;

import java.awt.Font;
import java.awt.event.*;
/**
 * Classe TelaLojas cria a interface gráfica da tela que mostra a lista de lojas cadastradas no programa
 * @author Gabriel Zaranza
 *
 */
public class TelaLojas implements ActionListener, ListSelectionListener{
	private JFrame janela = new JFrame("Lista Lojas");
	private JLabel titulo = new JLabel("Lojas cadastradas");
	private JList<String> listaLojaCadastradas ;
	private static ControleDados dados;
	private String[] listaNomesLojas = new String[50];
	/**
	 * Contrutor da Classe TelaLojas
	 * @param d a Classe ControleDados que controla os dados do programa
	 */
	public void mostrarDados(ControleDados d) {
		dados =d;
		
		listaNomesLojas = new ControleLoja(dados).listarLoja();
		listaLojaCadastradas = new JList<String>(listaNomesLojas);
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		listaLojaCadastradas.setFont(new Font("Arial",Font.PLAIN, 18));
		titulo.setBounds(150, 10, 300, 40);
		listaLojaCadastradas.setBounds(20, 70, 540, 430);
		janela.setLocationRelativeTo(null);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(listaLojaCadastradas);
		
		janela.setSize(600, 600);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
