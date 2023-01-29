package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import control.ControleDados;
/**
 * Classe TelaUsuPessoa cria a interface gráfica do menu de usuário (clientes)
 * @author Gabriel Zaranza
 *
 */
public class TelaUsuPessoa implements ActionListener{
	private JFrame janela = new JFrame("Clientes");
	private JLabel titulo = new JLabel("Clientes");
	private static JButton pessoa = new JButton("Criar conta");
	private static JButton anuncios = new JButton("Anuncios");
	public static ControleDados dados;
	/**
	 * Construtor da Classe TelaUsuPessoa
	 * @param d a Classe ControleDados que controla os dados do programa 
	 */
	public void mostrarDados(ControleDados d) {
		dados = d;
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(150, 0, 100, 35);
		pessoa.setBounds(150, 80, 100, 30);
		anuncios.setBounds(150, 40, 100, 30);
		janela.setLocationRelativeTo(null);
		
		janela.setLayout(null);
		janela.add(titulo);
		janela.add(pessoa);
		janela.add(anuncios);
		
		
		janela.setSize(600, 600);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		pessoa.addActionListener(this);
		anuncios.addActionListener(this);
		
	}

	
	//Método que reconhece alguma ação realizada na interface gráfica
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		//Caso a ação foi apertar o botão "Criar conta"
		/*if(src == pessoa) {
			//new TelaPessoa();
		}*/
		//Caso a ação foi apertar o botão "Anuncios"
		if(src == anuncios) {
			new TelaListaAnuncios().mostrarDados(dados,2);
		}
	}
	
	
}
