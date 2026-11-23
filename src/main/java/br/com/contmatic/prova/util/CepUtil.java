package br.com.contmatic.prova.util;

import static br.com.contmatic.prova.constantes.AuditoriaConstantes.O_CAMPO_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.TAMANHO_CEP;
import static br.com.contmatic.prova.util.ValidacaoUtils.validarTamanho;
import static java.lang.String.format;

import java.util.Objects;

public class CepUtil {
	
	private CepUtil() {}
	
	public static void temOitoDigitos(String cep) {
		isNull(cep, cep);
		String numeros = cep.replaceAll("\\D", "");
		validarTamanho(cep, numeros, TAMANHO_CEP);
	}

	public static void isNull(String cep, String valor) {
		if (Objects.isNull(valor)) {
			throw new IllegalArgumentException(format(O_CAMPO_NAO_PODE_ESTAR_VAZIO, cep));
		}
	}

}
