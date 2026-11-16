package br.com.contmatic.prova;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.TimeUnit;

import br.com.contmatic.prova.model.Telefone;

public class TelefoneTest {
	
	private Telefone telefone;

	@BeforeEach
	void criarTelefone() {
		telefone = new Telefone();
	}
	
	@Test
	@Order(1)
	@Timeout(value = 2, unit = TimeUnit.SECONDS)
	void deve_guardar_o_telefone_informado() {
		telefone.setTelefone("965234548");
		assertThat(telefone.getTelefone(), is("965234548"));
	}
	
	@Test
	@Order(2)
	void nao_deve_aceitar_telefone_em_branco() {
		assertThrows(IllegalArgumentException.class, () -> telefone.setTelefone("  "));
	}
	
	@Test
	@Order(3)
	void deve_guardar_o_ddd_informado() {
		telefone.setDdd("11");
		assertThat(telefone.getDdd(), is("11"));
	}
	
	@Test
	@Order(4)
	void nao_deve_aceitar_ddd_em_branco() {
		assertThrows(IllegalArgumentException.class, () -> telefone.setDdd("   "));
	}

	@Test
	@Order(5)
	void nao_deve_ser_igual_com_ddd_diferente() {
		Telefone outro = new Telefone();
		outro.setDdd("21");
		outro.setTelefone("965234548");
		
		telefone.setDdd("11");
		telefone.setTelefone("965234548");
		
		assertThat(telefone.equals(outro), is(false));
	}
	
	@Test
	@Order(6)
	@Disabled ("Teste desabilitado pois já tem uma classe que faz esse teste, não sendo mais necessário")
	void deve_ter_oito_digitos() {
		telefone.setTelefone("965234548");
		assertThat(telefone.getTelefone().length(), is(8));
	}
}
