package br.com.contmatic.prova.model;

import java.time.LocalDateTime;
import java.util.Objects;

import br.com.contmatic.prova.constantes.AuditoriaConstantes;
import br.com.contmatic.prova.util.ValidacaoUtils;

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
		ValidacaoUtils.validaEmpresa(usuarioCriacao, AuditoriaConstantes.MENSAGEM_DE_ERRO_USUARIO_INVALIDO);
		this.usuarioCriacao = usuarioCriacao;
	}

	public String getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(String usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

	public LocalDateTime getDataHoraCriacao() {
		return dataHoraCriacao;
	}

	public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
		ValidacaoUtils.validaEmpresa(dataHoraCriacao, AuditoriaConstantes.MENSAGEM_DE_ERRO_DATA_HORA_CRIACAO);
		this.dataHoraCriacao = dataHoraCriacao;
	}

	public LocalDateTime getDataHoraAlteracao() {
		return dataHoraAlteracao;
	}

	public void setDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
		this.dataHoraAlteracao = dataHoraAlteracao;
	}

	public String getIpCriacao() {
		return ipCriacao;
	}

	public void setIpCriacao(String ipCriacao) {
		ValidacaoUtils.validaEmpresa(ipCriacao, AuditoriaConstantes.MENSAGEM_DE_ERRO_IP_INVALIDO);
		this.ipCriacao = ipCriacao;
	}

	public String getIpAlteracao() {
		return ipAlteracao;
	}

	public void setIpAlteracao(String ipAlteracao) {
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
