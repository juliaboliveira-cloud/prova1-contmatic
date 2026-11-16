package br.com.contmatic.prova;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova.model.Empresa;
import br.com.contmatic.prova.model.Endereco;
import br.com.contmatic.prova.model.Telefone;

public class EmpresaTest {

	private Empresa empresa;
	
	@BeforeEach
	void criarEmpresa() {
        empresa = new Empresa();
    }
	
	@Test
    void deve_guardar_a_razao_social_informada() {
        empresa.setRazaoSocial("Restaurante do Oliveira");
        assertThat(empresa.getRazaoSocial(), is("Restaurante do Oliveira"));
    }
    @Test
    void nao_deve_aceitar_razao_social_em_branco() {
        assertThrows(IllegalArgumentException.class, () -> empresa.setRazaoSocial("  "));
    }
    
    @Test
    void deve_guardar_o_cnpj_informada() {
        empresa.setCnpj("59597281000126");
        assertThat(empresa.getCnpj(), is("59597281000126"));
    }
    @Test
    void nao_deve_aceitar_cnpj_em_branco() {
        assertThrows(IllegalArgumentException.class, () -> empresa.setCnpj("  "));
    }
    
    @Test
    void deve_guardar_a_quantidade_de_funcionarios_informada() {
        empresa.setQuantidadeFuncionarios(5);
        assertThat(empresa.getQuantidadeFuncionarios(), is(5));
    }
    @Test
    void nao_deve_aceitar_quantidade_de_funcionarios_em_branco() {
        assertThrows(IllegalArgumentException.class, () -> empresa.setQuantidadeFuncionarios(null));
    }
	
    @Test
    void deve_guardar_o_capital_social_informada() {
    	BigDecimal capital = new BigDecimal("2000.50");
        empresa.setCapitalSocial(capital);
        assertThat(empresa.getCapitalSocial(), is(capital));
    }
    
    @Test
    void nao_deve_aceitar_capital_social_em_branco() {
        assertThrows(IllegalArgumentException.class, () -> empresa.setCapitalSocial(null));
    }
    
    @Test
    void deve_guardar_a_data_de_abertura_informada() {
        empresa.setDataDeAbertura(LocalDate.of(2020, 5, 10));
        assertThat(empresa.getDataDeAbertura(), is(LocalDate.of(2020, 5, 10)));
    }
    @Test
    void nao_deve_aceitar_data_de_abertura_em_branco() {
        assertThrows(IllegalArgumentException.class, () -> empresa.setDataDeAbertura(null));
    }
    
    @Test
    void deve_guardar_a_situacao_informada() {
        empresa.setAtiva(true);
        assertThat(empresa.getAtiva(), is(true));
    }
    @Test
    void nao_deve_aceitar_situacao_em_branco() {
        assertThrows(IllegalArgumentException.class, () -> empresa.setAtiva(null));
    }
    
    @Test
    void deve_guardar_o_endereco_informado() {
    	Endereco endereco = new Endereco();
    	endereco.setRua("Rua Teste");
    	endereco.setNumero(100);
    	endereco.setCep("01500300");
    	endereco.setBairro("Liberdade");
    	endereco.setCidade("São Paulo");
    	endereco.setUf("SP");
    	
    	List<Endereco> enderecos = new ArrayList<>();
    	enderecos.add(endereco);
    	
        empresa.setEnderecos(enderecos);
        assertThat(empresa.getEnderecos(), is(enderecos));
    }
    
    @Test
    void nao_deve_aceitar_enderecos_em_branco() {
        assertThrows(IllegalArgumentException.class, () -> empresa.setEnderecos(new ArrayList<>()));
    }
    
    @Test
    void nao_deve_aceitar_enderecos_nulo() {
        assertThrows(IllegalArgumentException.class, () -> empresa.setEnderecos(null));
    }
    
    @Test
    void deve_guardar_o_telefone_informad() {
    	Telefone telefone = new Telefone();
    	telefone.setDdd("11");
    	telefone.setTelefone("965324147");
    	
    	Set<Telefone> telefones = new HashSet<>();
    	telefones.add(telefone);
    	
        empresa.setTelefones(telefones);
        assertThat(empresa.getTelefones(), is(telefones));
    }
    @Test
    void nao_deve_aceitar_telefone_em_branco() {
        assertThrows(IllegalArgumentException.class, () -> empresa.setTelefones(new HashSet<>()));
    }
    
    @Test
    void nao_deve_aceitar_telefones_nulo() {
    	assertThrows(IllegalArgumentException.class, () -> empresa.setTelefones(null));
    	
    }
    
    @Test
    void deve_comparar_empresas_com_equals_e_hash_code() {
    	Empresa a = new Empresa();
    	a.setCnpj("59597281000126");
    	
    	Empresa b = new Empresa();
    	b.setCnpj("59597281000126");
    	
    	assertThat(a.equals(a), is(true));
    	assertThat(a.equals(null), is(false));
    	assertThat(a.equals(b), is(true));
    	assertThat(a.hashCode(), is(b.hashCode()));
    	
    	b.setCnpj("59597281000130");
    	assertThat(a.equals(b), is(false));
    	assertThat(a.hashCode(), is(not(b.hashCode())));
    }
}
