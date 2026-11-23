package br.com.contmatic.prova.util;

import static br.com.contmatic.prova.constantes.CnpjConstantes.DIVISOR_DIGITO_VERIFICADOR;
import static br.com.contmatic.prova.constantes.CnpjConstantes.PESOS_DIGITO_PRIMEIRO_DIGITO_VERIFICADOR;
import static br.com.contmatic.prova.constantes.CnpjConstantes.PESOS_DIGITO_SEGUNDO_DIGITO_VERIFICADOR;
import static br.com.contmatic.prova.constantes.CnpjConstantes.POSICAO_PRIMEIRO_DIGITO_VERIFICADOR;
import static br.com.contmatic.prova.constantes.CnpjConstantes.POSICAO_SEGUNDO_DIGITO_VERIFICADOR;
import static br.com.contmatic.prova.constantes.CnpjConstantes.REGEX_CNPJ;
import static br.com.contmatic.prova.constantes.CnpjConstantes.RESTO_LIMITE_PARA_DIGITO_ZERO;
import static br.com.contmatic.prova.constantes.EmpresaConstantes.TAMANHO_MAXIMO_CNPJ;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

import br.com.contmatic.prova.constantes.CnpjConstantes;

public class CnpjUtil {
	

	private CnpjUtil() {}
	
	public static boolean isValido(String cnpj) {
		String cnpjSemFormatacao = retirarCaracteresEspeciais(cnpj);
		
		
		return verificarTamanhoCnpj(cnpjSemFormatacao) && !verificarNumerosIguais(cnpjSemFormatacao) && validarDigitoVerificador(cnpjSemFormatacao);
	}

	private static boolean validarDigitoVerificador(String cnpj) {
		int primeiroDigitoCalculado = calcularDigito(cnpj, PESOS_DIGITO_PRIMEIRO_DIGITO_VERIFICADOR);
		int segundoDigitoCalculado = calcularDigito(cnpj, PESOS_DIGITO_SEGUNDO_DIGITO_VERIFICADOR);
		return validarDigitoVerificador(cnpj, primeiroDigitoCalculado, segundoDigitoCalculado);
	}

	private static boolean validarDigitoVerificador(String numeros, int primeiroDigitoCalculado,
			int segundoDigitoCalculado) {
		return primeiroDigitoCalculado == parseInt(valueOf(numeros.charAt(POSICAO_PRIMEIRO_DIGITO_VERIFICADOR)))
				&& segundoDigitoCalculado == parseInt(valueOf(numeros.charAt(POSICAO_SEGUNDO_DIGITO_VERIFICADOR)));
	}
	
	private static String retirarCaracteresEspeciais(String cnpj) {
		return cnpj.replaceAll(CnpjConstantes.SPECIAL_KEYS, "");
	}

	private static boolean verificarNumerosIguais(String cnpj) {
		return cnpj.matches(REGEX_CNPJ);
	}

	private static boolean verificarTamanhoCnpj(String cnpj) {
		return cnpj.length() == TAMANHO_MAXIMO_CNPJ;
	}

	
	private static int calcularDigito (String cnpj, int[] pesos) {
		int resto = getSoma(cnpj, pesos, 0) % DIVISOR_DIGITO_VERIFICADOR;
		return resto < RESTO_LIMITE_PARA_DIGITO_ZERO ? 0 : 11 - resto;
	}

	private static int getSoma(String cnpj, int[] pesos, int soma) {
		for (int i = 0; i < pesos.length; i++) {
			int digito = cnpj.charAt(i) - '0';
			soma += digito * pesos[i];
		}
		return soma;
	}
}
