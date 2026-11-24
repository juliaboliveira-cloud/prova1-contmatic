package br.com.contmatic.prova.util;

import static br.com.contmatic.prova.constantes.AuditoriaConstantes.A_LISTA_NAO_PODE_ESTAR_VAZIA;
import static br.com.contmatic.prova.constantes.AuditoriaConstantes.O_CAMPO_NAO_PODE_ESTAR_VAZIO;
import static br.com.contmatic.prova.constantes.AuditoriaConstantes.O_CAMPO_NAO_PODE_SER_NULO;
import static br.com.contmatic.prova.constantes.AuditoriaConstantes.O_CAMPO_NAO_PODE_SER_ZERO;
import static br.com.contmatic.prova.constantes.AuditoriaConstantes.O_CONTEUDO_DO_CAMPO_DEVE_TER_TAMANHO_X;
import static java.lang.String.format;
import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

public final class ValidacaoUtils {


	private ValidacaoUtils() {
	}

	public static void isEmpty(Collection<?> lista, String campo) {
		if (Objects.isNull(lista) || lista.isEmpty()) {
			throw new IllegalArgumentException(format(A_LISTA_NAO_PODE_ESTAR_VAZIA, campo));
		}
	}

	public static void isBlank(String campo, String valor) {
		if (!Objects.isNull(valor) && valor.isBlank()) {
			throw new IllegalArgumentException(format(O_CAMPO_NAO_PODE_ESTAR_VAZIO, campo));
		}
	}

	public static void isNull(String campo, Object valor) {
		if (Objects.isNull(valor)) {
			throw new IllegalArgumentException(format(O_CAMPO_NAO_PODE_SER_NULO, campo));
		}
	}
	
	public static void isGreaterThanZero(String campo, Integer valor) {
		if (!Objects.isNull(valor) && valor <= 0) {
			throw new IllegalArgumentException(format(O_CAMPO_NAO_PODE_SER_ZERO, campo));
		}
	}
	
	public static void isBigDecimalGreaterThanZero(String campo, BigDecimal valor) {
		if (!Objects.isNull(valor) && ZERO.compareTo(valor) >= 0) {
			throw new IllegalArgumentException(format(O_CAMPO_NAO_PODE_SER_ZERO, campo));
		}
	}
	
	public static void validarTamanho(String campo, String valor, Integer tamanho) {
		if (valor.length() != tamanho) {
			throw new IllegalArgumentException(String.format(O_CONTEUDO_DO_CAMPO_DEVE_TER_TAMANHO_X, campo, tamanho));
		}
	}
}
