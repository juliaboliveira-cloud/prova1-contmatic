package br.com.contmatic.prova;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova.model.Auditoria;

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
	void deve_guardar_a_data_e_hora_informada() {
		LocalDateTime dataHora = LocalDateTime.of(2025, 5, 11, 10, 30);
		auditoria.setDataHoraCriacao(dataHora);
		assertThat(auditoria.getDataHoraCriacao(), is(dataHora));
	}
	
	@Test
	void nao_deve_aceitar_data_e_hora_em_branco() {
		assertThrows(IllegalArgumentException.class, () -> auditoria.setDataHoraCriacao(null));
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
	void deve_comparar_auditoria_com_equals_e_hash_code() {
		Auditoria a = new Auditoria();
		a.setUsuarioCriacao("julia");
		a.setIpCriacao("192.168.0.1");
		
		Auditoria b = new Auditoria();
		b.setUsuarioCriacao("julia");
		b.setIpCriacao("192.168.0.1");
		
		assertThat(a.equals(a), is(true));
		assertThat(a.equals(null), is(false));
		assertThat(a.equals(b), is(true));
		assertThat(a.hashCode(), is(b.hashCode()));
		
		b.setUsuarioCriacao("maria");
		assertThat(a.equals(b), is(false));
		assertThat(a.hashCode(), is(not(b.hashCode())));
		
		b.setUsuarioCriacao("julia");
		b.setIpCriacao("192.168.0.2");
		assertThat(a.equals(b), is(false));
	}
}
