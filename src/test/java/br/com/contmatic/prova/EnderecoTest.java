package br.com.contmatic.prova;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova.model.Auditoria;
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
		endereco.setNumeroEndereco(49);
		assertThat(endereco.getNumeroEndereco(), is(49));
	}
	
	@Test
	void nao_deve_aceitar_numero_em_branco() {
		assertThrows(IllegalArgumentException.class, () -> endereco.setNumeroEndereco(null));
	}
	
	@Test
	void nao_deve_aceitar_numero_zero() {
		assertThrows(IllegalArgumentException.class, () -> endereco.setNumeroEndereco(0));
	}
	
	@Test
	void nao_deve_aceitar_numero_negativo() {
		assertThrows(IllegalArgumentException.class, () -> endereco.setNumeroEndereco(-5));
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
	void nao_deve_aceitar_cep_nulo() {
		assertThrows(IllegalArgumentException.class, () -> endereco.setCep(null));
	}
	
	@Test
	void nao_deve_aceitar_o_cep_com_menos_de_oito_digitos() {
		assertThrows(IllegalArgumentException.class, () -> endereco.setCep("0150700"));
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
		a.setNumeroEndereco(100);
		
		Endereco b = new Endereco();
		b.setCep("01503000");
		b.setComplemento("Apto 1");
		b.setNumeroEndereco(100);
		
		assertThat(a.equals(null), is(false));
		assertThat(a.equals(b), is(true));
		assertThat(a.hashCode(), is(b.hashCode()));
		
		b.setCep("01503001");
		assertThat(a.equals(b), is(false));
		assertThat(a.hashCode(), is(not(b.hashCode())));
		
		b.setCep("01503000");
		b.setComplemento("Apto2");
		assertThat(a.equals(b), is(false));
		
		b.setComplemento("Apto 1");
		b.setNumeroEndereco(200);
		assertThat(a.equals(b), is(false));
	}
	
	private void criarEnderecoTeste(Endereco endereco) {
    	endereco.setRua("Rua de Teste");
    	endereco.setNumeroEndereco(100);
    	endereco.setComplemento("Apartamento 1");
    	endereco.setCep("01001000");
    	endereco.setBairro("Centro");
    	endereco.setCidade("São Paulo");
    	endereco.setUf("SP");
    }
	
	@Test
	void deve_ser_igual_a_ele_mesmo() {
		Endereco enderecoTeste = new Endereco();
		criarEnderecoTeste(enderecoTeste);
		
		assertThat(enderecoTeste.equals(enderecoTeste), is(true));
	}
	
	@Test
	void nao_deve_ser_nulo() {
		Endereco enderecoTeste = new Endereco();
		criarEnderecoTeste(enderecoTeste);
		
		assertThat(enderecoTeste.equals(null), is(false));
	}
	
	@Test
	void deve_preencher_o_to_string() {
		Endereco endereco1 = new Endereco();
		criarEnderecoTeste(endereco1);
		
		String texto = endereco1.toString();
	
		assertThat(texto, containsString("Rua de Teste"));
		assertThat(texto, containsString("01001000"));
		assertThat(texto, containsString("Centro"));
	}
	

    @Test
    void nao_deve_aceitar_numero_do_endereco_negativo() {
    	assertThrows(IllegalArgumentException.class, () -> endereco.setNumeroEndereco(-100));
    }
    
    @Test
    void nao_deve_ser_igual_a_outra_classe() {
    	Endereco enderecoTeste = new Endereco();
    	Object auditoria = new Auditoria();
    	
    	assertThat(enderecoTeste.equals(auditoria), is(false));
    }
}
