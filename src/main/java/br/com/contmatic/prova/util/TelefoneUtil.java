package br.com.contmatic.prova.util;

import static br.com.contmatic.prova.constantes.TelefoneConstantes.TAMANHO_DDD;
import static br.com.contmatic.prova.constantes.TelefoneConstantes.TAMANHO_TELEFONE;
import static br.com.contmatic.prova.util.ValidacaoUtils.isBlank;
import static br.com.contmatic.prova.util.ValidacaoUtils.isNull;
import static br.com.contmatic.prova.util.ValidacaoUtils.validarTamanho;

public class TelefoneUtil {
	
	private static final String DDD = "ddd";
	private static final String TELEFONE = "telefone";

	private TelefoneUtil() {}

	public static void validarTelefone(String campo, String telefone) {
		isNull(campo, telefone);
		isBlank(campo, telefone);
		validarTamanho(TELEFONE, telefone, TAMANHO_TELEFONE);
	}
	
	public static void validarDdd(String campo, String ddd) {
		isNull(campo, ddd);
		isBlank(campo, ddd);
		validarTamanho(DDD, ddd, TAMANHO_DDD);
	}
}
