package br.com.contmatic.prova.util;

import static br.com.contmatic.prova.constantes.AuditoriaConstantes.CAMPO_CODIGO_IP;
import static br.com.contmatic.prova.constantes.AuditoriaConstantes.CAMPO_DATA_E_HORA_DE_ALTERACAO;
import static br.com.contmatic.prova.constantes.AuditoriaConstantes.CAMPO_DATA_E_HORA_DE_CRIACAO;
import static br.com.contmatic.prova.constantes.AuditoriaConstantes.CAMPO_USUARIO_ALTERACAO;
import static br.com.contmatic.prova.constantes.AuditoriaConstantes.CAMPO_USUARIO_CRIACAO;
import static br.com.contmatic.prova.constantes.AuditoriaConstantes.GMT_SP;
import static br.com.contmatic.prova.constantes.AuditoriaConstantes.IP_FORMATO;
import static br.com.contmatic.prova.constantes.AuditoriaConstantes.MENSAGEM_DE_ERRO_DATA_HORA;
import static br.com.contmatic.prova.constantes.AuditoriaConstantes.MENSAGEM_DE_ERRO_IP_INVALIDO;
import static br.com.contmatic.prova.constantes.AuditoriaConstantes.O_CAMPO_NAO_PODE_SER_ZERO;
import static br.com.contmatic.prova.util.ValidacaoUtils.isBlank;
import static br.com.contmatic.prova.util.ValidacaoUtils.isNull;
import static java.lang.String.format;
import static java.time.LocalDateTime.now;
import static java.time.ZoneId.of;

import java.time.LocalDateTime;
import java.util.Objects;

import br.com.contmatic.prova.model.Auditoria;

public class AuditoriaUtil {


	private AuditoriaUtil() {}

	public static void validar(Auditoria auditoria) {
		isNull("auditoria", auditoria);
		validarUsuarioCriacao(auditoria.getUsuarioCriacao());
		validarDataHoraCriacao(auditoria.getDataHoraCriacao());
		validarIp(auditoria.getIpCriacao(), "ip");
	}

	public static void validarUsuarioCriacao(String usuario) {
		isNull(CAMPO_USUARIO_CRIACAO, usuario);
		isBlank(CAMPO_USUARIO_CRIACAO, usuario);
	}
	
	public static void validarUsuarioAlteracao(String usuario) {
		isBlank(CAMPO_USUARIO_ALTERACAO, usuario);
	}
	
	public static void validarDataHoraCriacao(LocalDateTime dataHoraCriacao) {
		isNull(CAMPO_DATA_E_HORA_DE_CRIACAO, dataHoraCriacao);
		if (now(of(GMT_SP)).isBefore(dataHoraCriacao)) {
			throw new IllegalArgumentException(MENSAGEM_DE_ERRO_DATA_HORA);
		}
	}
	
	public static void validarDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
		isNull(CAMPO_DATA_E_HORA_DE_ALTERACAO, dataHoraAlteracao);
	}
	
	public static void validarIpCriacao(String ip) {
		isNull(CAMPO_CODIGO_IP, ip);
		validarIp(ip, CAMPO_CODIGO_IP);
	}
	
	public static void validarIpAlteracao(String ip) {
		if (Objects.isNull(ip)) {
			throw new IllegalArgumentException(MENSAGEM_DE_ERRO_IP_INVALIDO);
		}
		validarIp(ip, CAMPO_CODIGO_IP);
	}
	
	public static void validarIp(String ip, String campo) {
		if (Objects.isNull(ip) || !ip.matches(IP_FORMATO)) {
			throw new IllegalArgumentException(format(O_CAMPO_NAO_PODE_SER_ZERO, campo));
		}
		validarCodigoIp(ip, CAMPO_CODIGO_IP);
	}
	
	public static void validarCodigoIp(String ip, String campo) {
		for (String numero : ip.split("\\.")) {
			if (Integer.parseInt(numero) > 255) {
				throw new IllegalArgumentException(format(O_CAMPO_NAO_PODE_SER_ZERO, campo));
			}
		}
	}
	
	public static void validarOrdemDatas(LocalDateTime criacao, LocalDateTime alteracao) {
		if (alteracao.isBefore(criacao)) {
			throw new IllegalArgumentException("A data e hora de alteração não pode ser anterior à data e hora da criação.");
		}
	}
}
