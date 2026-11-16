package br.com.contmatic.prova.util;

import br.com.contmatic.prova.constantes.EnderecoConstantes;

public class CepUtil {
	
	private CepUtil() {}
	
	public static boolean temOitoDigitos(String cep) {
		if (cep == null) {
			throw new IllegalArgumentException(EnderecoConstantes.MENSAGEM_DE_ERRO_CEP);
		}
		
		String numeros = cep.replaceAll("\\D", "");
		
		if (numeros.length() != EnderecoConstantes.TAMANHO_CEP) {
			throw new IllegalArgumentException(EnderecoConstantes.MENSAGEM_DE_ERRO_CEP);
		}
		
		return true;
	}

}
