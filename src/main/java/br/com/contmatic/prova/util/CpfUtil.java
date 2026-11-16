package br.com.contmatic.prova.util;

import br.com.contmatic.prova.constantes.EmpresaConstantes;

public class CpfUtil {
	
	private CpfUtil() {
		
	}
	
	public static boolean isValido(String cpf) {
		if (cpf == null) { 
			
			System.out.println(EmpresaConstantes.MENSAGEM_DE_ERRO_CPF);
			return false; 
			}
		
		String numeros = cpf.replaceAll("\\D", "");
		
		
		if (numeros.length() != EmpresaConstantes.TAMANHO_MAXIMO_CPF) { 
			System.out.println(EmpresaConstantes.MENSAGEM_DE_ERRO_CPF_CURTO);
			return false;
		}
		
		int digito1 = calcularDigito(numeros, 9, 10);
		int digito2 = calcularDigito(numeros, 10, 11);
		
		return digito1 == numeros.charAt(9) - '0'
				&& digito2 == numeros.charAt(10) - '0';
	}
	
	private static int calcularDigito(String numeros, int quantidade, int pesoInicial) {
		int soma = 0;
		
		for (int i = 0; i < quantidade; i++) {
			int digito = numeros.charAt(i) - '0';
			soma += digito * (pesoInicial - i);
		}
		
		int resto = soma % 11;
		return resto < 2 ? 0 : 11 - resto;
	}
	
}


