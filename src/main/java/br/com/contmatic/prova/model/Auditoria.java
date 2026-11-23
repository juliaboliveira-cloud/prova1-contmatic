package br.com.contmatic.prova.model;

import static br.com.contmatic.prova.util.AuditoriaUtil.validarDataHoraAlteracao;
import static br.com.contmatic.prova.util.AuditoriaUtil.validarDataHoraCriacao;
import static br.com.contmatic.prova.util.AuditoriaUtil.validarIpCriacao;
import static br.com.contmatic.prova.util.AuditoriaUtil.validarOrdemDatas;
import static br.com.contmatic.prova.util.AuditoriaUtil.validarUsuarioAlteracao;
import static br.com.contmatic.prova.util.AuditoriaUtil.validarUsuarioCriacao;

import java.time.LocalDateTime;
import java.util.Objects;

import br.com.contmatic.prova.util.AuditoriaUtil;

public class Auditoria {


	private String usuarioCriacao;
	private String usuarioAlteracao;
	private LocalDateTime dataHoraCriacao;
	private LocalDateTime dataHoraAlteracao;
	private String ipCriacao;
	private String ipAlteracao;

	public String getUsuarioCriacao() {
		return usuarioCriacao;
	}

	public void setUsuarioCriacao(String usuarioCriacao) {
		validarUsuarioCriacao(usuarioCriacao);
		this.usuarioCriacao = usuarioCriacao;
	}

	public String getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(String usuarioAlteracao) {
		validarUsuarioAlteracao(usuarioAlteracao);
		this.usuarioAlteracao = usuarioAlteracao;
	}

	public LocalDateTime getDataHoraCriacao() {
		return dataHoraCriacao;
	}

	public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
		validarDataHoraCriacao(dataHoraCriacao);
		this.dataHoraCriacao = dataHoraCriacao;
	}

	public LocalDateTime getDataHoraAlteracao() {
		return dataHoraAlteracao;
	}

	public void setDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
		validarDataHoraAlteracao(dataHoraAlteracao);
		validarOrdemDatas(dataHoraCriacao, dataHoraAlteracao);
		
		this.dataHoraAlteracao = dataHoraAlteracao;
	}

	public String getIpCriacao() {
		return ipCriacao;
	}

	public void setIpCriacao(String ipCriacao) {
		validarIpCriacao(ipCriacao);
		this.ipCriacao = ipCriacao;
	}

	public String getIpAlteracao() {
		return ipAlteracao;
	}

	public void setIpAlteracao(String ipAlteracao) {
		AuditoriaUtil.validarIpAlteracao(ipAlteracao);
		this.ipAlteracao = ipAlteracao;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ipCriacao, usuarioCriacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auditoria other = (Auditoria) obj;
		return Objects.equals(ipCriacao, other.ipCriacao) && Objects.equals(usuarioCriacao, other.usuarioCriacao);
	}
	
	@Override
	public String toString() {
		return new StringBuilder("Auditoria: ")
				.append("Usuario Criação = ").append(usuarioCriacao)
				.append(", Data da Criação = ").append(dataHoraCriacao)
				.append(", IP do usuário = ").append(ipCriacao)
				.toString();
	}
}
