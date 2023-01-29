package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.*;
import model.Loja;
/**
 * Classe TelaCarro cria a interface gráfica da tela que mostra as informações de um carro
 * @author Gabriel Zaranza
 *
 */
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
	private String[] listaNomeLojas = new String[50];
	private JComboBox<Loja> listaLojas = new JComboBox<Loja>();
	private JLabel labelDesc = new JLabel("Descrição: ");
	private JTextField valorDesc;
	private JButton botExcluir = new JButton("Excluir");
	private JButton botSalvar = new JButton("Salvar");
	private int opcao;
	private static ControleDados dados;
	private int posicao;
	private String[] novoDado = new String [9];
	private Loja lojaEscolhida ;
	
	
	/**
	 * Contrutor da Classe TelaCarro
	 * @param op o tipo da TelaCarro que será gerada
	 * @param d a Classe ControleDados que controla os dados do programa
	 * @param p a Classe TelaListaCarros que precede a TelaCarro
	 * @param pos a posição que o carro, que será mostrado, opcupa na lista de carros
	 */
	public void mostrarDados(int op, ControleDados d,TelaListaCarros p, int pos) {
		
		opcao = op;
		posicao=pos;
		dados=d;
		
		listaNomeLojas = new ControleLoja(dados).listarLoja();
		listaLojas = new JComboBox<Loja>();
		
		//Parâmetros para gerar a TelaCarro de um novo carro
		if(op==1) {
		valorMarca = new JTextField(200);
		valorModelo = new JTextField(200);
		valorAno = new JTextField(4);
		valorCor = new JTextField(200);
		valorPlaca = new JTextField(200);
		valorKm = new JTextField(6);
		valorDesc = new JTextField(200);
		listaLojas = new JComboBox<Loja>(dados.getLojas());
		listaLojas.setSelectedIndex(-1);
		janela.setLocationRelativeTo(null);
		
		labelMarca.setBounds(30, 20, 150, 25);
		valorMarca.setBounds(200,20,180,25);
		labelModelo.setBounds(30, 50, 150, 25);
		valorModelo.setBounds(200,50,180,25);
		labelAno.setBounds(30, 80, 150, 25);
		valorAno.setBounds(200,80,180,25);
		labelCor.setBounds(30, 110, 150, 25);
		valorCor.setBounds(200,110,180,25);
		labelPlaca.setBounds(30, 140, 150, 25);
		valorPlaca.setBounds(200,140,180,25);
		labelKm.setBounds(30, 170, 180, 25);
		valorKm.setBounds(200,170,180,25);
		labelDesc.setBounds(30, 200, 150, 25);
		valorDesc.setBounds(200,200,300,25);
		labelLoja.setBounds(30, 230, 150, 25);
		listaLojas.setBounds(200,230,180,25);
		botSalvar.setBounds(130, 520, 150, 30);
		botExcluir.setBounds(320, 520, 150, 30);
		
		labelMarca.setFont(new Font("Arial",Font.PLAIN, 25));
		valorMarca.setFont(new Font("Arial",Font.PLAIN, 25));
		labelModelo.setFont(new Font("Arial",Font.PLAIN, 25));
		valorModelo.setFont(new Font("Arial",Font.PLAIN, 25));
		labelAno.setFont(new Font("Arial",Font.PLAIN, 25));
		valorAno.setFont(new Font("Arial",Font.PLAIN, 25));
		labelCor.setFont(new Font("Arial",Font.PLAIN, 25));
		valorCor.setFont(new Font("Arial",Font.PLAIN, 25));
		labelPlaca.setFont(new Font("Arial",Font.PLAIN, 25));
		valorPlaca.setFont(new Font("Arial",Font.PLAIN, 25));
		labelKm.setFont(new Font("Arial",Font.PLAIN, 25));
		valorKm.setFont(new Font("Arial",Font.PLAIN, 25));
		labelDesc.setFont(new Font("Arial",Font.PLAIN, 25));
		valorDesc.setFont(new Font("Arial",Font.PLAIN, 25));
		labelLoja.setFont(new Font("Arial",Font.PLAIN, 25));
		listaLojas.setFont(new Font("Arial",Font.PLAIN, 25));
		botSalvar.setFont(new Font("Arial",Font.PLAIN, 25));
		botExcluir.setFont(new Font("Arial",Font.PLAIN, 25));
		
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
		this.janela.add(listaLojas);
		this.janela.add(botSalvar);
		this.janela.add(botExcluir);
		
		this.janela.setLayout(null);
		janela.setSize(600, 600);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);

		botSalvar.addActionListener(this);
		
		}
		
		//Parâmetros para gerar a TelaCarro de um carro ja cadastrado
		else if(op==2) {
			valorMarca = new JTextField(dados.getCarros()[pos].getMarca(),200);
			valorModelo = new JTextField(dados.getCarros()[pos].getModelo(),200);
			valorAno = new JTextField(dados.getCarros()[pos].getAno(),4);
			valorCor = new JTextField(dados.getCarros()[pos].getCor(),200);
			valorPlaca = new JTextField(dados.getCarros()[pos].getPlaca(),200);
			valorKm = new JTextField(String.valueOf(dados.getCarros()[pos].getKilometragem()),6);
			valorDesc = new JTextField(dados.getCarros()[pos].getDescricao(),200);
			listaLojas = new JComboBox<Loja>(dados.getLojas());
			listaLojas.setSelectedItem(dados.getCarros()[pos].getLoja());
			janela.setLocationRelativeTo(null);
			
			labelMarca.setBounds(30, 20, 150, 25);
			valorMarca.setBounds(200,20,180,25);
			labelModelo.setBounds(30, 50, 150, 25);
			valorModelo.setBounds(200,50,180,25);
			labelAno.setBounds(30, 80, 150, 25);
			valorAno.setBounds(200,80,180,25);
			labelCor.setBounds(30, 110, 150, 25);
			valorCor.setBounds(200,110,180,25);
			labelPlaca.setBounds(30, 140, 150, 25);
			valorPlaca.setBounds(200,140,180,25);
			labelKm.setBounds(30, 170, 180, 25);
			valorKm.setBounds(200,170,180,25);
			labelDesc.setBounds(30, 200, 150, 25);
			valorDesc.setBounds(200,200,300,25);
			labelLoja.setBounds(30, 230, 150, 25);
			listaLojas.setBounds(200,230,180,25);
			botSalvar.setBounds(130, 520, 150, 30);
			botExcluir.setBounds(320, 520, 150, 30);
			
			labelMarca.setFont(new Font("Arial",Font.PLAIN, 25));
			valorMarca.setFont(new Font("Arial",Font.PLAIN, 25));
			labelModelo.setFont(new Font("Arial",Font.PLAIN, 25));
			valorModelo.setFont(new Font("Arial",Font.PLAIN, 25));
			labelAno.setFont(new Font("Arial",Font.PLAIN, 25));
			valorAno.setFont(new Font("Arial",Font.PLAIN, 25));
			labelCor.setFont(new Font("Arial",Font.PLAIN, 25));
			valorCor.setFont(new Font("Arial",Font.PLAIN, 25));
			labelPlaca.setFont(new Font("Arial",Font.PLAIN, 25));
			valorPlaca.setFont(new Font("Arial",Font.PLAIN, 25));
			labelKm.setFont(new Font("Arial",Font.PLAIN, 25));
			valorKm.setFont(new Font("Arial",Font.PLAIN, 25));
			labelDesc.setFont(new Font("Arial",Font.PLAIN, 25));
			valorDesc.setFont(new Font("Arial",Font.PLAIN, 25));
			labelLoja.setFont(new Font("Arial",Font.PLAIN, 25));
			listaLojas.setFont(new Font("Arial",Font.PLAIN, 25));
			botSalvar.setFont(new Font("Arial",Font.PLAIN, 25));
			botExcluir.setFont(new Font("Arial",Font.PLAIN, 25));
			
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
			this.janela.add(listaLojas);
			this.janela.add(botSalvar);
			this.janela.add(botExcluir);
			
			this.janela.setLayout(null);
			janela.setSize(600, 600);
			janela.setVisible(true);
			janela.setLocationRelativeTo(null);
			
			botSalvar.addActionListener(this);
			botExcluir.addActionListener(this);
		}
		
	}

	//Método que reconhece alguma ação realizada na interface gráfica
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Armazena o objeto que sofreu ação, nesse caso o botão "Salvar" ou "Excluir"
		Object src = e.getSource();
		
		//Caso a ação foi apertar o botão "Salvar"
		if(src == botSalvar) {
				
				//Caso seja um carro novo
				if(opcao == 1) {
					//A posição do novo carro será a quantidade de carros cadastrados
					novoDado[0] = Integer.toString(dados.getQtdCarros());	
				}
				
				//Caso seja a edição de um carro ja cadastrado
				else {
					//Armazana a posição do carro no Array de Carro
					novoDado[0]=Integer.toString(posicao);
				}
				
				//Armazena as informações preenchidas do carro
				novoDado[1] = valorMarca.getText();
				novoDado[2] = valorModelo.getText();
				novoDado[3] = valorAno.getText();
				novoDado[4] = valorCor.getText();
				novoDado[5] = valorPlaca.getText();
				novoDado[6] = valorDesc.getText();
				novoDado[7] = valorKm.getText();
				//Armazenando a loja que foi selecionada para receber o carro no JComboBox lojaEscolhida
				lojaEscolhida = (Loja) listaLojas.getSelectedItem();
				//Chamando o metodo que insere ou edita um carro da Classe ControleDados
				dados.inserirEditarCarro(novoDado,lojaEscolhida);
				//Fecha a TelaCarro para voltar a TelaListaVendas
				janela.dispose();
		}	
		
		//Caso a ação foi apertar o botão "Excluir"
		if(src== botExcluir) {
			//Chamando o método que apaga um caro e passando como parâmentro a posição do carro em questão
			dados.apagarCarro(posicao);
			//Fecha a TelaCarro para voltar a TelaListVendas
			janela.dispose();
		}
	}
}