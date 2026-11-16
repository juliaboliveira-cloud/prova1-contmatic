package br.com.contmatic.prova.util;

import br.com.contmatic.prova.constantes.EmpresaConstantes;

public class CnpjUtil {
	
	private CnpjUtil() {}
	
	private static final int [] PESOS_DIGITO1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
	private static final int [] PESOS_DIGITO2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
	
	public static boolean isValido(String cnpj) {
		if (cnpj == null) {
			throw new IllegalArgumentException(EmpresaConstantes.MENSAGEM_DE_ERRO_CNPJ);
		}
		
		String numeros = cnpj.replaceAll("\\D", "");
		
		if (numeros.length() != EmpresaConstantes.TAMANHO_MAXIMO_CNPJ) {
			throw new IllegalArgumentException(EmpresaConstantes.MENSAGEM_DE_ERRO_CNPJ_CURTO);
		}
		
		if (numeros.matches("(\\d)\\1{13}")) { return false; }
		
		int digito1 = calcularDigito(numeros, PESOS_DIGITO1);
		int digito2 = calcularDigito(numeros, PESOS_DIGITO2);
		
		return digito1 == numeros.charAt(12) - '0'
				&& digito2 == numeros.charAt(13) - '0';
	}
	
	private static int calcularDigito (String numeros, int[] pesos) {
		int soma = 0;
		
		for (int i = 0; i < pesos.length; i++) {
			int digito = numeros.charAt(i) - '0';
			soma += digito * pesos[i];
		}
		
		int resto = soma % 11;
		return resto < 2 ? 0 : 11 - resto;
	}
}
