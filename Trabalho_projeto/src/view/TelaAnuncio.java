package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.ControleCarro;
import control.ControleDados;
import control.ControleLoja;
import pacote.Carro;
import pacote.Loja;

public class TelaAnuncio implements ActionListener {
	private JFrame janela = new JFrame("Anuncios");
	private JLabel labelCarro = new JLabel("Carro: ");
	private JLabel labelValor = new JLabel("Valor(R$): ");
	private JTextField valorValor;
	private JLabel labelData = new JLabel("Data (dd/MM/aaaa): ");
	private JTextField valorData ;
	private String[] listaModelosCarros = new String[50];
	private JComboBox<Carro> listaCarros = new JComboBox<Carro>();
	private JButton botExcluir = new JButton("Excluir");
	private JButton botSalvar = new JButton("Salvar");
	private int opcao;
	private static ControleDados dados;
	private int posicao;
	private String[] novoDado = new String[9];
	private Carro carroEscolhido ;
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
	
public void inserirEditarAnuncio(int op, ControleDados d,TelaListaAnuncios p, int pos) {
		
		opcao = op;
		posicao=pos;
		dados=d;
		
		listaModelosCarros = new ControleCarro(dados).getModeloCarro();
		listaCarros = new JComboBox<Carro>();
		
		if(op==1) {//opção da loja de anunciar
		valorValor = new JTextField(200);
		valorData = new JTextField(10);
		listaCarros = new JComboBox<Carro>(new ControleCarro(dados).listarNaoVendidos());
		listaCarros.setSelectedIndex(-1);
		
		labelCarro.setBounds(30, 20, 150, 25);
		listaCarros.setBounds(180,20,280,25);
		labelValor.setBounds(30, 50, 150, 25);
		valorValor.setBounds(180,50,280,25);
		labelData.setBounds(30, 80, 150, 25);
		valorData.setBounds(180,80,280,25);
		botSalvar.setBounds(30, 290, 150, 25);
		botExcluir.setBounds(210,290,150,25);
		
		
		
		this.janela.add(labelCarro);
		this.janela.add(labelValor);
		this.janela.add(valorValor);
		this.janela.add(labelData);
		this.janela.add(valorData);
		this.janela.add(listaCarros);
		this.janela.add(botSalvar);
		this.janela.add(botExcluir);
		
		this.janela.setLayout(null);
		this.janela.setSize(500, 400);
		this.janela.setVisible(true);

		botSalvar.addActionListener(this);
		botExcluir.addActionListener(this);
		}
		else if(op==2) {
		
			valorValor = new JTextField(String.valueOf(dados.getAnuncios()[pos].getValor()),10);
			valorData = new JTextField(dados.getAnuncios()[pos].getDt_anuncio(),200);
			listaCarros = new JComboBox<Carro>(dados.getCarros());
			listaCarros.setSelectedItem(dados.getAnuncios()[pos].getCarro());
			listaCarros.setEnabled(false);
			
			labelCarro.setBounds(30, 20, 150, 25);
			listaCarros.setBounds(180,20,280,25);
			labelValor.setBounds(30, 50, 150, 25);
			valorValor.setBounds(180,50,280,25);
			labelData.setBounds(30, 80, 150, 25);
			valorData.setBounds(180,80,280,25);
			botSalvar.setBounds(30, 290, 150, 25);
			botExcluir.setBounds(210,290,150,25);
			
			this.janela.add(labelCarro);
			this.janela.add(labelValor);
			this.janela.add(valorValor);
			this.janela.add(labelData);
			this.janela.add(valorData);
			this.janela.add(listaCarros);
			this.janela.add(botSalvar);
			this.janela.add(botExcluir);
			
			this.janela.setLayout(null);
			this.janela.setSize(500, 400);
			this.janela.setVisible(true);

			botSalvar.addActionListener(this);
			botExcluir.addActionListener(this);
		}
		else if (op==3) {
			valorMarca = new JTextField(dados.getAnuncios()[pos].getCarro().getMarca(),200);
			valorModelo = new JTextField(dados.getAnuncios()[pos].getCarro().getModelo(),200);
			valorAno = new JTextField(dados.getAnuncios()[pos].getCarro().getAno(),4);
			valorCor = new JTextField(dados.getAnuncios()[pos].getCarro().getCor(),200);
			valorPlaca = new JTextField(dados.getAnuncios()[pos].getCarro().getPlaca(),200);
			valorKm = new JTextField(String.valueOf(dados.getAnuncios()[pos].getCarro().getKilometragem()),6);
			valorDesc = new JTextField(dados.getAnuncios()[pos].getCarro().getDescricao(),200);
			valorLoja = new JTextField(dados.getAnuncios()[pos].getCarro().getLoja().getNome(),200);
			valorValor = new JTextField(String.valueOf(dados.getAnuncios()[pos].getValor()),10);
			valorData = new JTextField(dados.getAnuncios()[pos].getDt_anuncio(),200);
			
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
			labelValor.setBounds(30, 230, 150, 25);
			valorValor.setBounds(180,230,180,25);
			labelLoja.setBounds(30, 260, 150, 25);
			valorLoja.setBounds(180,260,180,25);
			labelData.setBounds(30, 290, 150, 25);
			valorData.setBounds(180,290,180,25);
			
			valorMarca.setEditable(false);
			valorModelo.setEditable(false);
			valorAno.setEditable(false);
			valorCor.setEditable(false);
			valorPlaca.setEditable(false);
			valorKm.setEditable(false);
			valorDesc.setEditable(false);
			valorValor.setEditable(false);
			valorLoja.setEditable(false);
			valorData.setEditable(false);
			
			valorMarca.setBackground(Color.white);
			valorMarca.setBackground(Color.white);
			valorModelo.setBackground(Color.white);
			valorAno.setBackground(Color.white);
			valorCor.setBackground(Color.white);
			valorPlaca.setBackground(Color.white);
			valorKm.setBackground(Color.white);
			valorDesc.setBackground(Color.white);
			valorValor.setBackground(Color.white);
			valorLoja.setBackground(Color.white);
			valorData.setBackground(Color.white);
			
			this.janela.add(labelCarro);
			this.janela.add(labelValor);
			this.janela.add(valorValor);
			this.janela.add(labelData);
			this.janela.add(valorData);
			this.janela.add(listaCarros);
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
			
			this.janela.setLayout(null);
			this.janela.setSize(500, 400);
			this.janela.setVisible(true);
			
		}
		
	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Object src = e.getSource();
	if(src == botSalvar) {
		
			if(opcao == 1) {
				novoDado[0] = Integer.toString(dados.getQtdAnuncios());	
			}
			
			else {
				novoDado[0]=Integer.toString(posicao);
			}
			novoDado[1] = valorData.getText();
			novoDado[2] = valorValor.getText();
			carroEscolhido = (Carro) listaCarros.getSelectedItem();
			dados.inserirEditarAnuncio(novoDado,carroEscolhido);
			janela.dispose();
	}	
			
	if(src== botExcluir) {
		dados.apagarAnuncio(posicao);
		janela.dispose();
	}
}
}
