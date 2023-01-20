package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import control.ControleDados;

public class TelaUsuPessoa implements ActionListener{
	private JFrame janela = new JFrame("Clientes");
	private JLabel titulo = new JLabel("Clientes");
	private static JButton pessoa = new JButton("Criar conta");
	private static JButton anuncios = new JButton("Anuncios");
	public static ControleDados dados = new ControleDados();
	
	public TelaUsuPessoa() {
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(150, 0, 100, 35);
		pessoa.setBounds(150, 80, 100, 30);
		anuncios.setBounds(150, 40, 100, 30);
		
		
		janela.setLayout(null);
		janela.add(titulo);
		janela.add(pessoa);
		janela.add(anuncios);
		
		
		janela.setSize(500, 400);
		janela.setVisible(true);
		pessoa.addActionListener(this);
		anuncios.addActionListener(this);
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		
		if(src == pessoa) {
			//new TelaPessoa();
		}
		
		if(src == anuncios) {
			new TelaListaAnuncios(dados,2);
		}
	}
	
	
}
