package br.com.contmatic.prova.util;

import br.com.contmatic.prova.constantes.TelefoneConstantes;

public class TelefoneUtil {
	
	private TelefoneUtil() {}

	public static boolean telefoneValido(String telefone) {
		if (telefone == null) {
			throw new IllegalArgumentException(TelefoneConstantes.MENSAGEM_ERRO_TELEFONE);
		}
		
		if (telefone.length() < TelefoneConstantes.TAMANHO_TELEFONE) {
			throw new IllegalArgumentException(TelefoneConstantes.MENSAGEM_TELEFONE_COM_OITO_DIGITOS_OU_MAIS);
		}
		
		return true;
	}
	
	public static boolean dddValido(String ddd) {
		if (ddd == null) {
			throw new IllegalArgumentException(TelefoneConstantes.MENSAGEM_ERRO_DDD);
		}
		
		if (ddd.length() != TelefoneConstantes.TAMANHO_DDD) {
			throw new IllegalArgumentException(TelefoneConstantes.MENSAGEM_DDD_COM_DOIS_DIGITOS);
		}
		
		return true;
	}
}
