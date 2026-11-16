package br.com.contmatic.prova;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.Matchers.is;

import br.com.contmatic.prova.model.Endereco;

public class EnderecoTest {
	
	private Endereco endereco;
	
	@BeforeEach
	void criarEndereco() {
		endereco = new Endereco();
	}
	
	@Test
	void deve_guardar_a_rua_informada() {
		endereco.setRua("Rua Teste");
		assertThat(endereco.getRua(), is("Rua Teste"));
	}
	
	@Test
	void nao_deve_aceitar_rua_em_branco() {
		assertThrows(IllegalArgumentException.class, () -> endereco.setRua("  "));
	}
	
	@Test
	void deve_guardar_o_numero_informado() {
		endereco.setNumero(49);
		assertThat(endereco.getNumero(), is(49));
	}
	
	@Test
	void nao_deve_aceitar_numero_em_branco() {
		assertThrows(IllegalArgumentException.class, () -> endereco.setNumero(null));
	}
	
	@Test
	void deve_guardar_o_complemento_informado() {
		endereco.setComplemento("Apartamento 42");
		assertThat(endereco.getComplemento(), is("Apartamento 42"));
	}
	
	@Test
	void deve_guardar_o_cep_informado() {
		endereco.setCep("01503000");
		assertThat(endereco.getCep(), is("01503000"));
	}
	
	@Test
	void nao_deve_aceitar_cep_em_branco() {
		assertThrows(IllegalArgumentException.class, () -> endereco.setCep("  "));
	}
	
	@Test
	void deve_guardar_o_bairro_informado() {
		endereco.setBairro("Liberdade");
		assertThat(endereco.getBairro(), is("Liberdade"));
	}
	
	@Test
	void nao_deve_aceitar_bairro_em_branco() {
		assertThrows(IllegalArgumentException.class, () -> endereco.setBairro("  "));
	}
	
	@Test
	void deve_guardar_a_cidade_informada() {
		endereco.setCidade("São Paulo");
		assertThat(endereco.getCidade(), is("São Paulo"));
	}
	
	@Test
	void nao_deve_aceitar_cidade_em_branco() {
		assertThrows(IllegalArgumentException.class, () -> endereco.setCidade("  "));
	}
	
	@Test
	void deve_guardar_o_uf_informada() {
		endereco.setUf("SP");
		assertThat(endereco.getUf(), is("SP"));
	}
	
	@Test
	void nao_deve_aceitar_uf_em_branco() {
		assertThrows(IllegalArgumentException.class, () -> endereco.setUf("  "));
	}
	
	@Test
	void deve_comparar_enderecos_com_equals_e_hash_code() {
		Endereco a = new Endereco();
		a.setCep("01503000");
		a.setComplemento("Apto 1");
		a.setNumero(100);
		
		Endereco b = new Endereco();
		b.setCep("01503000");
		b.setComplemento("Apto 1");
		b.setNumero(100);
		
		assertThat(a.hashCode(), is(b.hashCode()));
		
		b.setCep("01503001");
		assertThat(a.equals(b), is(false));
		
		b.setCep("01503000");
		b.setComplemento("Apto2");
		assertThat(a.equals(b), is(false));
		
		b.setComplemento("Apto 1");
		b.setNumero(200);
		assertThat(a.equals(b), is(false));
	}
}
