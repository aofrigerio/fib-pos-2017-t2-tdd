package br.folhapagamentotdd.FolhaDePagamentoTDD;

public class CriadorDeFolha {

	private CalculoFolha calculoFolha;
	
	public CriadorDeFolha() {}; //construtor
		
	public CriadorDeFolha funcionario(String nome, double hora_trabalhada, double salario_hora, int dependentes) {
		CalculoFolha calculoFolha = new CalculoFolha();
		calculoFolha.adicionaFolha(new Colaborador(nome, hora_trabalhada, salario_hora, dependentes));
		return this;
	}
	
	public CalculoFolha constroi() {
		return calculoFolha;
	}

	
}
