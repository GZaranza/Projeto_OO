package view;
import javax.swing.*;


public class teste {

	public static void main(String[] a) {
		JFrame f = new JFrame("Hello world!");
		JButton b =new JButton("clique aqui!");
		b.setBounds(50, 50, 100, 40);
		f.add(b);
		
		f.setSize(800,500);
		f.setLayout(null);
		f.setVisible(true);
	}
	
}
