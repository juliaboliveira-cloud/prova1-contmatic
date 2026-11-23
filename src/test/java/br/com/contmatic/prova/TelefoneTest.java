package br.com.contmatic.prova;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.TimeUnit;

import br.com.contmatic.prova.model.Empresa;
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
		telefone.setNumeroTelefone("965234548");
		assertThat(telefone.getNumeroTelefone(), is("965234548"));
	}
	
	@Test
	@Order(2)
	void nao_deve_aceitar_telefone_em_branco() {
		assertThrows(IllegalArgumentException.class, () -> telefone.setNumeroTelefone("  "));
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
		Telefone telefoneTeste = new Telefone();
		telefoneTeste.setDdd("21");
		telefoneTeste.setNumeroTelefone("965234548");
		
		telefone.setDdd("11");
		telefone.setNumeroTelefone("965234548");
		
		assertThat(telefone.equals(telefoneTeste), is(false));
	}
	
	private void preencherTelefoneTeste(Telefone telefone) {
		telefone.setDdd("11");
		telefone.setNumeroTelefone("912345678");
	}
	
	@Test
	@Order(6)
	void nao_deve_ser_uma_empresa() {
		Empresa empresa = new Empresa();
		
		assertThat(telefone.equals(empresa), is(false));
	}
	
	@Test
	@Order(7)
	void deve_preencher_to_string() {
		Telefone telefone1 = new Telefone();
		
		preencherTelefoneTeste(telefone1);
		
		String texto = telefone1.toString();
		
		assertThat(texto, containsString("11"));
		assertThat(texto, containsString("912345678"));
	}
	
	@Test
	@Order(8)
	void deve_ser_igual_a_ele_mesmo() {
		Telefone telefoneTeste = new Telefone();
		
		preencherTelefoneTeste(telefoneTeste);
		
		assertThat(telefoneTeste.equals(telefoneTeste), is(true));
	}
	
	@Test
	@Order(9)
	void deve_ser_igual_com_mesmo_ddd_e_telefone() {
		Telefone telefoneTeste1 = new Telefone();
		Telefone telefoneTeste2 = new Telefone();
		
		preencherTelefoneTeste(telefoneTeste1);
		preencherTelefoneTeste(telefoneTeste2);
		
		assertThat(telefoneTeste1.equals(telefoneTeste2), is(true));
	}
	
	@Test
	@Order(10)
	void nao_deve_ser_igual_com_telefone_diferente() {
		Telefone telefoneTeste1 = new Telefone();
		Telefone telefoneTeste2 = new Telefone();
		
		preencherTelefoneTeste(telefoneTeste1);
		preencherTelefoneTeste(telefoneTeste2);
		telefoneTeste1.setNumeroTelefone("987654321");
		
		assertThat(telefoneTeste1.equals(telefoneTeste2), is(false));
		assertThat(telefoneTeste1.hashCode(), is(not(telefoneTeste2.hashCode())));
	}
	
	@Test
	@Order(11)
	void nao_deve_ser_nulo() {
		Telefone telefoneDeTeste = new Telefone();
		
		assertThat(telefoneDeTeste.equals(null), is(false));
	}
	
	@Test
	@Order(11)
	@Disabled ("Teste desabilitado pois já tem uma classe que faz esse teste, não sendo mais necessário")
	void deve_ter_oito_digitos() {
		telefone.setNumeroTelefone("965234548");
		assertThat(telefone.getNumeroTelefone().length(), is(9));
	}
}
