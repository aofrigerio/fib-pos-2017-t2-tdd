package br.folhapagamentotdd.FolhaDePagamentoTDD;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculoFolhaTeste {

	
	CalculoFolha folha = new CalculoFolha();
	
	Colaborador alan = new Colaborador("alan",160,150,3);
	Colaborador marcelo = new Colaborador("marcelo",1,150,3);
	Colaborador denis = new Colaborador("denis",1,750,0);
	
	@Before
	public void init(){
		
	}
	
	@Test
	public void testeDoValoLiquido() {
		
		folha.adicionaFolha(alan);
		folha.adicionaFolha(marcelo);
		folha.adicionaFolha(denis);
		folha.calcularFolha();
		
		Assert.assertEquals(20286.00, folha.getColaboradores().get(0).getSalario_liquido(),0.0001);
		Assert.assertEquals(274.5, folha.getColaboradores().get(1).getSalario_liquido(),0.0001);
		Assert.assertEquals(648.75, folha.getColaboradores().get(2).getSalario_liquido(),0.0001);
		
		
	}
	
	@Test
	public void VerificarSetsDoColaborador() {
		//Colaborador alan = new Colaborador("alan",160,150,3);
		
		alan.setHora_trabalhada(150);
		alan.setSalario_hora(155);
		alan.setDependentes(3);
		alan.setNome("Alan Frigerio");
		alan.setSalario_bruto(24150);
				
		Assert.assertEquals(24150, alan.getSalario_bruto(),0.0001);
	}
	
	@Test
	public void CriadorTeste() {
		
		CalculoFolha folha2 = new CalculoFolha();
		
		folha2 = new CriadorDeFolha()
				.funcionario("alan", 160, 150, 3)
				.constroi();
		
		folha2.calcularFolha();
		
		Assert.assertEquals(20286.00, folha2.getColaboradores().get(0).getSalario_liquido(),0.0001);
		
	}


}
