package br.com.contmatic.prova.util;

import static br.com.contmatic.prova.constantes.EnderecoConstantes.TAMANHO_CEP;
import static br.com.contmatic.prova.util.ValidacaoUtils.isNull;
import static br.com.contmatic.prova.util.ValidacaoUtils.validarTamanho;

public class CepUtil {
	
	private CepUtil() {}
	
	public static void temOitoDigitos(String cep) {
		isNull(cep, cep);
		String numeros = cep.replaceAll("\\D", "");
		validarTamanho(cep, numeros, TAMANHO_CEP);
	}
}
