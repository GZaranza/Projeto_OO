package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.ControleCarro;
import control.ControleDados;

import java.awt.Font;
import java.awt.event.*;

public class TelaListaCarros implements ActionListener, ListSelectionListener {

	private JFrame janela = new JFrame("Carros");
	private JLabel titulo = new JLabel("Carros cadastrados");
	private JButton cadastroCarro = new JButton("Cadastrar");
	private JButton attListaCarro = new JButton("Atualizar");
	private JList<String> listaCarrosCadastrados = new JList<String>();
	private static ControleDados dados;
	private String[] listaModelos = new String[50];
	
	public void mostrarDados(ControleDados d) {
		dados =d;
		
		listaModelos = new ControleCarro(dados).getModeloCarro();
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
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		if(src == cadastroCarro) {
			new TelaCarro().inserirEditarCarro(1, dados, this, 0);
		}
		if(src == attListaCarro) {
			listaCarrosCadastrados.setListData(new ControleCarro(dados).getModeloCarro());
			listaCarrosCadastrados.updateUI();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();		
		if(e.getValueIsAdjusting() && src == listaCarrosCadastrados) {
			new TelaCarro().inserirEditarCarro(2, dados, this, listaCarrosCadastrados.getSelectedIndex());
		}
	}
}
