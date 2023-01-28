package control;

import model.*;

public class ControleUsuario {
	private Usuario[] u;
	private int qtdUsuarios;
	
	public ControleUsuario(ControleDados d) {
		u = d.getUsuarios();
		qtdUsuarios = d.getQtdUsuarios();
	}

	public int getQtdUsuarios() {
		return qtdUsuarios;
	}

	public void setQtdUsuarios(int qtdUsuarios) {
		this.qtdUsuarios = qtdUsuarios;
	}
	
	public String[] listarUsuario() {
		String s[] = new String[qtdUsuarios];
		for(int i =0; i<qtdUsuarios;i++) {
			s[i]=u[i].toString();
		}
		return s;
	}
}
