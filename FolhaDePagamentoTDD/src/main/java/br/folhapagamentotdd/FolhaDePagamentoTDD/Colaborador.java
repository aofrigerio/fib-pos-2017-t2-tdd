package br.folhapagamentotdd.FolhaDePagamentoTDD;

public class Colaborador {
	
	private String nome;
	private double hora_trabalhada;
	private double salario_hora;
	private int dependentes;
	private double salario_bruto;
	private double salario_liquido;
	

	public Colaborador(String nome, double hora_trabalhada, double salario_hora, int dependentes) {
		super();
		this.nome = nome;
		this.hora_trabalhada = hora_trabalhada;
		this.salario_hora = salario_hora;
		this.dependentes = dependentes;
		this.salario_bruto = 0;
		this.salario_liquido = 0;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalario_bruto() {
		return salario_bruto;
	}
	public void setSalario_bruto(double salario_bruto) {
		this.salario_bruto = salario_bruto;
	}
	public double getSalario_liquido() {
		return salario_liquido;
	}
	public void setSalario_liquido(double salario_liquido) {
		this.salario_liquido = salario_liquido;
	}
	public double getHora_trabalhada() {
		return hora_trabalhada;
	}
	public void setHora_trabalhada(double hora_trabalhada) {
		this.hora_trabalhada = hora_trabalhada;
	}
	public double getSalario_hora() {
		return salario_hora;
	}
	public void setSalario_hora(double salario_hora) {
		this.salario_hora = salario_hora;
	}
	public int getDependentes() {
		return dependentes;
	}
	public void setDependentes(int dependentes) {
		this.dependentes = dependentes;
	}
	
	
	
}
