package br.banco.dao;
import java.util.ArrayList;
import java.util.List;

import br.banco.bean.Conta;


public class ContaDaoFalso implements Dao {

	private static List<Conta> contas = new ArrayList<Conta>();
	
	public void salvaConta(Conta conta) {
		contas.add(conta);
	}

	public List<Conta> getContas(){
		return contas;
	}
	
	
	public void atualizaConta(Conta conta) { /* faz nada! */ }
}