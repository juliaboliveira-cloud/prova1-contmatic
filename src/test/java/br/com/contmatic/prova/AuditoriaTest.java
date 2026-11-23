package br.com.contmatic.prova;

import static br.com.contmatic.prova.constantes.AuditoriaConstantes.GMT_SP;
import static java.time.LocalDateTime.now;
import static java.time.ZoneId.of;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova.model.Auditoria;
import br.com.contmatic.prova.model.Empresa;
import br.com.contmatic.prova.model.Telefone;
import br.com.contmatic.prova.util.AuditoriaUtil;

public class AuditoriaTest {
	
	private Auditoria auditoria;
	
	@BeforeEach
	void criarAuditoria() {
		auditoria = new Auditoria();
	}
	
	@Test
	void deve_guardar_o_usuario_informado() {
		auditoria.setUsuarioCriacao("julia");
		assertThat(auditoria.getUsuarioCriacao(), is("julia"));
	}
	
	
	@Test
	void nao_deve_aceitar_usuario_em_branco() {
		assertThrows(IllegalArgumentException.class, () -> auditoria.setUsuarioCriacao("  "));
	}
	
	@Test
	void deve_guardar_o_usuario_alterado_informado() {
		auditoria.setUsuarioAlteracao("julia");
		assertThat(auditoria.getUsuarioAlteracao(), is("julia"));
	}
	
	
	@Test
	void deve_recusar_usuario_nulo() {
		assertThrows(IllegalArgumentException.class, () -> auditoria.setUsuarioCriacao(null));
	}
	
	@Test
	void deve_guardar_a_data_e_hora_informada() {
		LocalDateTime dataHora = now(of(GMT_SP));
		auditoria.setDataHoraCriacao(dataHora);
		assertThat(auditoria.getDataHoraCriacao(), is(dataHora));
	}
	
	@Test
	void deve_recusar_data_e_hora_de_criacao_posterior() {
		LocalDateTime dataHora = now(of(GMT_SP)).plusDays(1);
		assertThrows(IllegalArgumentException.class, () -> auditoria.setDataHoraCriacao(dataHora));
	}
	
	@Test
	void nao_deve_aceitar_data_e_hora_em_branco() {
		assertThrows(IllegalArgumentException.class, () -> auditoria.setDataHoraCriacao(null));
	}
	
	@Test
	void deve_aceitar_data_e_hora_alterada() {
		auditoria.setDataHoraCriacao(now(of(GMT_SP)));
		LocalDateTime alteracao = now(of(GMT_SP));
		
		auditoria.setDataHoraAlteracao(alteracao);
		
		assertThat(auditoria.getDataHoraAlteracao(), is(alteracao));
	}
	
	@Test
	void nao_deve_aceitar_data_e_hora_alterada_em_branco() {
		assertThrows(IllegalArgumentException.class, () -> auditoria.setDataHoraAlteracao(null));
	}
	
	@Test
	void nao_deve_aceitar_data_e_hora_alterada_anterior_a_data_e_hora_da_criacao() {
		LocalDateTime criacao = now(of(GMT_SP));
		LocalDateTime alteracao = criacao.minusMinutes(1);
		
		auditoria.setDataHoraCriacao(criacao);
		
		assertThrows(IllegalArgumentException.class, () -> auditoria.setDataHoraAlteracao(alteracao));
	}

	@Test
	void deve_guardar_o_ip_informado() {
		auditoria.setIpCriacao("192.168.0.1");
		assertThat(auditoria.getIpCriacao(), is("192.168.0.1"));
	}
	
	@Test
	void nao_deve_aceitar_ip_em_branco() {
		assertThrows(IllegalArgumentException.class, () -> auditoria.setIpCriacao("  "));
	}
	
	@Test
	void nao_deve_aceitar_ip_nulo() {
		assertThrows(IllegalArgumentException.class, () -> auditoria.setIpCriacao(null));
	}
	
	@Test
	void nao_deve_aceitar_ip_zerado() {
		assertThrows(IllegalArgumentException.class, () -> auditoria.setIpCriacao("0"));
	}
	
	@Test
	void deve_guardar_o_ip_alterado() {
		auditoria.setIpAlteracao("192.168.0.2");
		assertThat(auditoria.getIpAlteracao(), is("192.168.0.2"));
	}
	
	@Test
	void nao_deve_aceitar_ip_alterado_em_branco() {
		assertThrows(IllegalArgumentException.class, () -> auditoria.setIpAlteracao("  "));
	}
	
	@Test
	void nao_deve_aceitar_ip_alterado_nulo() {
		assertThrows(IllegalArgumentException.class, () -> auditoria.setIpAlteracao(null));
	}
	
	
	@Test
	void deve_comparar_usuarios_iguais() {
		Auditoria a = new Auditoria();
		a.setUsuarioCriacao("julia");
		
		Auditoria b = new Auditoria();
		b.setUsuarioCriacao("julia");
		
		assertThat(a.equals(null), is(false));
		assertThat(a.equals(a), is(true));
		assertThat(a.equals(b), is(true));
		assertThat(a.hashCode(), is(b.hashCode()));
		
		b.setUsuarioCriacao("maria");
		assertThat(a.equals(b), is(false));
		assertThat(a.hashCode(), is(not(b.hashCode())));
	}
	
	@Test
	void deve_comparar_valores_ip_iguais() {
		Auditoria a = new Auditoria();
		a.setIpCriacao("192.168.0.1");
		
		Auditoria b = new Auditoria();
		b.setIpCriacao("192.168.0.1");
		
		assertThat(a.equals(null), is(false));
		assertThat(a.equals(a), is(true));
		assertThat(a.equals(b), is(true));
		assertThat(a.hashCode(), is(b.hashCode()));
		
		b.setIpCriacao("192.168.0.2");
		assertThat(a.equals(b), is(false));
		assertThat(a.hashCode(), is(not(b.hashCode())));
	}
	
	private void preencherAuditoriaTeste(Auditoria auditoria) {
		auditoria.setUsuarioCriacao("julia");
		auditoria.setDataHoraCriacao(now(of(GMT_SP)));
		auditoria.setIpCriacao("192.168.0.1");
	}
	
	@Test
	void deve_validar_auditoria_empresa() {
		Empresa empresa = new Empresa();
		preencherAuditoriaTeste(empresa);
		
		assertDoesNotThrow(() -> AuditoriaUtil.validar(empresa));
	}
	
	@Test
	void deve_validar_auditoria_telefone() {
		Telefone telefone = new Telefone();
		preencherAuditoriaTeste(telefone);
		
		assertDoesNotThrow(() -> AuditoriaUtil.validar(telefone));
	}
	
	
	@Test
	void deve_preencher_o_to_string() {
		Auditoria auditoriaNova = new Auditoria();
		preencherAuditoriaTeste(auditoriaNova);
		
		String texto = auditoriaNova.toString();
		
		assertThat(texto, containsString("julia"));
		assertThat(texto, containsString("192.168.0.1"));
		assertThat(texto, containsString(auditoriaNova.getDataHoraCriacao().toString()));
	}
	
	@Test
	void nao_deve_ser_igual_a_uma_empresa_com_os_mesmos_dados() {
		Empresa empresa = new Empresa();
		
		preencherAuditoriaTeste(empresa);
		preencherAuditoriaTeste(auditoria);
		
		assertThat(auditoria.equals(empresa), is(false));
	}
	
	@Test
	void nao_deve_aceitar_codigo_ip_com_numero_maior_que_255() {
		assertThrows(IllegalArgumentException.class, () -> auditoria.setIpCriacao("192.168.0.256"));
	}
}
