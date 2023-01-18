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
	
	public TelaListaCarros(ControleDados d) {
		dados =d;
		listaModelos = new ControleCarro(dados).getModeloCarro();
		listaCarrosCadastrados = new JList<String>(listaModelos);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(90, 10, 250, 30);
		cadastroCarro.setBounds(70, 177, 100, 30);
		attListaCarro.setBounds(200, 177, 100, 30);
		listaCarrosCadastrados.setBounds(20, 50, 350, 120);
		listaCarrosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaCarrosCadastrados.setVisibleRowCount(10);
		
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(listaCarrosCadastrados);
		janela.add(cadastroCarro);
		janela.add(attListaCarro);
		
		janela.setSize(400, 250);
		janela.setVisible(true);
		cadastroCarro.addActionListener(this);
		attListaCarro.addActionListener(this);
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
		
	}

}
