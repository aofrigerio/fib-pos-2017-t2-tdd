package br.folhapagamentotdd.mock;
import java.util.ArrayList;
import java.util.List;

import br.banco.bean.Conta;
import br.banco.bean.Usuario;

public class ContaBuilder {
	
	private List<Conta> contas;
	private Usuario usuario;
	
	public ContaBuilder(){
		contas = new ArrayList<Conta>();
	}
	
	public ContaBuilder addConta(Conta conta, Usuario usuario){
		conta.setUsuario(usuario);
		this.contas.add(conta);
		return this;
	}
	
	public List<Conta> constroi() {
		return this.contas;
	}
	
}