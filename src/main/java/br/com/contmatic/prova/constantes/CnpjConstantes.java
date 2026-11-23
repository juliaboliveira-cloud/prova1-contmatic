package br.com.contmatic.prova.constantes;

public class CnpjConstantes {
	
	private CnpjConstantes() {}
	
	public static final String REGEX_CNPJ = "(\\d)\\1{13}";
	public static final String SPECIAL_KEYS = "\\D";
	public static final int [] PESOS_DIGITO_PRIMEIRO_DIGITO_VERIFICADOR = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
	public static final int [] PESOS_DIGITO_SEGUNDO_DIGITO_VERIFICADOR = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
	public static final int POSICAO_PRIMEIRO_DIGITO_VERIFICADOR = 12;
	public static final int POSICAO_SEGUNDO_DIGITO_VERIFICADOR = 13;
	public static final String MENSAGEM_ERRO_CNPJ_NAO_PODE_SER_NUMEROS_IGUAIS = "O CNPJ não pode ter todos os números iguais.";
	public static final int DIVISOR_DIGITO_VERIFICADOR = 11;
	public static final int RESTO_LIMITE_PARA_DIGITO_ZERO = 2;
	
}
