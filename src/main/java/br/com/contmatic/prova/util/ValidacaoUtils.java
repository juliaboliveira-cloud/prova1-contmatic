package br.com.contmatic.prova.util;

import java.util.Collection;

public final class ValidacaoUtils {
	
	private ValidacaoUtils() {
	}
	
	public static void validaEmpresa (Object valor, String mensagem) {
		if (valor == null) {
			throw new IllegalArgumentException(mensagem);
		}
		
		if (valor instanceof String texto && texto.isBlank()) {
			throw new IllegalArgumentException(mensagem);
		}
		
		if (valor instanceof Collection<?> colecao && colecao.isEmpty()) {
			throw new IllegalArgumentException(mensagem);
		}
	}

}
