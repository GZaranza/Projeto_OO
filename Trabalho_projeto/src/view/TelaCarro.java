package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.*;

public class TelaCarro implements ActionListener{
	
	private JFrame janela = new JFrame("Carros");
	private JLabel labelMarca = new JLabel("Marca: ");
	private JTextField valorMarca;
	private JLabel labelModelo = new JLabel("Modelo: ");
	private JTextField valorModelo;
	private JLabel labelAno = new JLabel("Ano : ");
	private JTextField valorAno ;
	private JLabel labelCor = new JLabel("Cor: ");
	private JTextField valorCor;
	private JLabel labelPlaca = new JLabel("Placa: ");
	private JTextField valorPlaca;
	private JLabel labelKm = new JLabel("Kilometragem: ");
	private JTextField valorKm;
	private JLabel labelLoja = new JLabel("Loja: ");
	private JTextField valorLoja;
	private JLabel labelDesc = new JLabel("Descrição: ");
	private JTextField valorDesc;
	private JButton botExcluir = new JButton("Excluir");
	private JButton botSalvar = new JButton("Salvar");
	private int opcao;
	private static ControleCarro dados;
	private int posicao;
	private String[] novoDado = new String [9];
	
	public void inserirEditarCarro(int op, ControleCarro d,TelaListaCarros p, int pos) {
		
		opcao = op;
		posicao=pos;
		dados=d;
		
		if(op==1) {//opção da loja de cadastrar
		valorMarca = new JTextField(200);
		valorModelo = new JTextField(200);
		valorAno = new JTextField(4);
		valorCor = new JTextField(200);
		valorPlaca = new JTextField(200);
		valorKm = new JTextField(6);
		valorLoja = new JTextField(200);
		valorDesc = new JTextField(200);
		
		
		labelMarca.setBounds(30, 20, 150, 25);
		valorMarca.setBounds(180,20,180,25);
		labelModelo.setBounds(30, 50, 150, 25);
		valorModelo.setBounds(180,50,180,25);
		labelAno.setBounds(30, 80, 150, 25);
		valorAno.setBounds(180,80,180,25);
		labelCor.setBounds(30, 110, 150, 25);
		valorCor.setBounds(180,110,180,25);
		labelPlaca.setBounds(30, 140, 150, 25);
		valorPlaca.setBounds(180,140,180,25);
		labelKm.setBounds(30, 170, 150, 25);
		valorKm.setBounds(180,170,180,25);
		labelDesc.setBounds(30, 200, 150, 25);
		valorDesc.setBounds(180,200,180,25);
		labelLoja.setBounds(30, 230, 150, 25);
		valorLoja.setBounds(180,230,180,25);
		botSalvar.setBounds(30, 290, 150, 25);
		
		
		this.janela.add(labelMarca);
		this.janela.add(valorMarca);
		this.janela.add(labelModelo);
		this.janela.add(valorModelo);
		this.janela.add(labelAno);
		this.janela.add(valorAno);
		this.janela.add(labelCor);
		this.janela.add(valorCor);
		this.janela.add(labelPlaca);
		this.janela.add(valorPlaca);
		this.janela.add(labelKm);
		this.janela.add(valorKm);
		this.janela.add(labelDesc);
		this.janela.add(valorDesc);
		this.janela.add(labelLoja);
		this.janela.add(valorLoja);
		this.janela.add(botSalvar);
		
		this.janela.setLayout(null);
		this.janela.setSize(500, 400);
		this.janela.setVisible(true);

		
		}
		botSalvar.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		if(src == botSalvar) {
			
			
				
				if(opcao == 1) {
					novoDado[0] = Integer.toString(dados.getQtdCarros());	
				}
				novoDado[1] = valorMarca.getText();
				novoDado[2] = valorModelo.getText();
				novoDado[3] = valorAno.getText();
				novoDado[4] = valorCor.getText();
				novoDado[5] = valorPlaca.getText();
				novoDado[8] = valorDesc.getText();
				novoDado[7] = valorKm.getText();
				dados.inserirEditarCarro(novoDado);
				janela.dispose();
			
			
				
		}	
				
		
	}
}