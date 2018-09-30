package br.folhapagamentotdd.mock;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.banco.bean.Banco;
import br.banco.bean.Conta;
import br.banco.bean.Usuario;
import br.banco.dao.ContaDaoFalso;
import br.banco.dao.Dao;


public class BancoTest {
	
	private Conta c1;
	private Conta c2;
	private Conta c3;
	private Conta c4;
	private Usuario joao;
	private Usuario manoel;
	private Usuario marcelo;
	private Usuario sandro;

	@Before
	public void criarAmbiente(){
		c1 = new Conta(100.0, "Basica");
		c2 = new Conta(200.0, "Prime");
		c3 = new Conta(0.0, "Estutante");
		c4 = new Conta(0.0, "Estudante");
		
		joao = new Usuario("Joao da Silva", "111111111", "joaosilva@mailinator.com");
		manoel = new Usuario("Manoel da Silva", "22222222", "manoelsilva@mailinator.com");
		marcelo = new Usuario("Marcelo Vittar", "22222222", "manoelsilva@mailinator.com");
		sandro = new Usuario("Sandro da Balsa", "22222222", "manoelsilva@mailinator.com");
		
	}
	
	@Test
	public void deveSomarTodasAsContasTrazendoOSaldoDoBanco(){
		
		List<Conta> contas = new ContaBuilder()
		.addConta(c1, joao)
		.addConta(c2, manoel)
		.addConta(c3, marcelo)
		.addConta(c4, sandro)
		.constroi();
		
		 Dao dao = mock(ContaDaoFalso.class);
		 when(dao.getContas()).thenReturn(contas);
		 
		 doThrow(new RuntimeException()).when(dao).atualizaConta(c3); 
		 
		 dao.salvaConta(contas.get(0));
		 dao.salvaConta(contas.get(1));
		 
		 Banco banco = new Banco(dao);
		 banco.atualizaJuros(5);
		 
		// verificando que o metodo atualizaConta foi realmente invocado!
		 verify(dao, times(1)).atualizaConta(contas.get(0));
		 
		 assertEquals(2, banco.getContas().size(), 0.00001);
		 //assertEquals(300, banco.totalSaldo(), 0.00001);
	}
	
}
