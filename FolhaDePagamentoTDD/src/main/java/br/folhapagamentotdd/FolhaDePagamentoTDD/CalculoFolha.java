package br.folhapagamentotdd.FolhaDePagamentoTDD;

import java.text.Format;
import java.util.ArrayList;
import java.util.List;

public class CalculoFolha {
	
	private double salario_liquido;
	private double salario_bruto;
	private double desconto_ir;
	private double desconto_inss;
	
	private List<Colaborador> colaboradores;
	
	public CalculoFolha() {
		colaboradores = new ArrayList<Colaborador>();
	}
	
	public void adicionaFolha(Colaborador colaborador) {
		colaboradores.add(colaborador);
	}
	
	public void calcularFolha() {
		
		for (Colaborador colaborador : colaboradores) {
			
			salario_bruto = (colaborador.getSalario_hora() * colaborador.getHora_trabalhada() + ( 50 * colaborador.getDependentes() ));
			
			desconto_ir = calculaValoIR(salario_bruto);
			desconto_inss = calculaValoINSS(salario_bruto);
			
			colaboradores.get(procurarNaLista(colaborador)).setSalario_bruto(salario_bruto);
		
			salario_liquido = calculaSalarioLiquido(salario_bruto, desconto_ir, desconto_inss); 
			
			colaboradores.get(procurarNaLista(colaborador)).setSalario_liquido(salario_liquido);
			
			//System.out.println("Colaborador: " + colaborador.getNome() + " / Salario Bruto : " + colaborador.getSalario_bruto() + " / Salario Liquido: " + colaborador.getSalario_liquido() );
		}
		
	}
	
	private int procurarNaLista(Colaborador colaborador) {
		
		int pesquisa = 0;
		
		for (int i = 0; i < colaboradores.size(); i++) {
			
			if(colaboradores.get(i).getNome().equals(colaborador.getNome())){
				pesquisa = i;
			}
		}
		
		return pesquisa;
	}
	
	private double calculaSalarioLiquido(double valor,double ir,double inss) {
		return valor - ir - inss;
	}
	
	
	private double calculaValoINSS(double valor) {
			
		double retorno;
		
		if(valor <= 1000) {
			retorno = valor*(0.085);
		}else {
			retorno = valor*(0.09);
		}
		
		return retorno;
	}
	
	//Calcular o IR
	private double calculaValoIR(double valor) {
		
			double retorno;
		
			if(valor <= 500) {
				retorno = valor*(0.00);
			}else if (valor > 500 && valor <= 1000 ) {
				retorno = valor*(0.05);
			}else {
				retorno = valor*(0.07);
			}
			
		return retorno;
	}

	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}

}
