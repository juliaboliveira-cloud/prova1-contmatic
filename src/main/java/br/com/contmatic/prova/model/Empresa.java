package br.com.contmatic.prova.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import br.com.contmatic.prova.constantes.EmpresaConstantes;
import br.com.contmatic.prova.util.CnpjUtil;
import br.com.contmatic.prova.util.ValidacaoUtils;

public class Empresa extends Auditoria {

	
	private String cnpj;
	private String razaoSocial;
	private Integer quantidadeFuncionarios;
	private BigDecimal capitalSocial;
	private LocalDate dataDeAbertura;
	private Boolean ativa;
	private List<Endereco> enderecos;
	private Set<Telefone> telefones;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		CnpjUtil.isValido(cnpj);
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		ValidacaoUtils.validaEmpresa(razaoSocial, EmpresaConstantes.MENSAGEM_DE_ERRO_RAZAO_SOCIAL);
		this.razaoSocial = razaoSocial;
	}

	public Integer getQuantidadeFuncionarios() {
		return quantidadeFuncionarios;
	}

	public void setQuantidadeFuncionarios(Integer quantidadeFuncionarios) {
		ValidacaoUtils.validaEmpresa(quantidadeFuncionarios, EmpresaConstantes.MENSAGEM_DE_ERRO_QUANTIDADE_DE_FUNCIONARIOS);
		this.quantidadeFuncionarios = quantidadeFuncionarios;
	}

	public BigDecimal getCapitalSocial() {
		return capitalSocial;
	}

	public void setCapitalSocial(BigDecimal capitalSocial) {
		ValidacaoUtils.validaEmpresa(capitalSocial, EmpresaConstantes.MENSAGEM_DE_ERRO_CAPITAL_SOCIAL);
		this.capitalSocial = capitalSocial;
	}

	public LocalDate getDataDeAbertura() {
		return dataDeAbertura;
	}

	public void setDataDeAbertura(LocalDate dataDeAbertura) {
		ValidacaoUtils.validaEmpresa(dataDeAbertura, EmpresaConstantes.MENSAGEM_DE_ERRO_DATA_DE_ABERTURA);
		this.dataDeAbertura = dataDeAbertura;
	}

	public Boolean getAtiva() {
		return ativa;
	}

	public void setAtiva(Boolean ativa) {
		ValidacaoUtils.validaEmpresa(ativa, EmpresaConstantes.MENSAGEM_DE_ERRO_SITUACAO_EMPRESA);
		this.ativa = ativa;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		ValidacaoUtils.validaEmpresa(enderecos, EmpresaConstantes.MENSAGEM_DE_ERRO_ENDERECO_INCOMPLETO);
		this.enderecos = enderecos;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		ValidacaoUtils.validaEmpresa(telefones, EmpresaConstantes.MENSAGEM_DE_ERRO_TELEFONE_INCOMPLETO);
		this.telefones = telefones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(cnpj, other.cnpj);
	}

	@Override
	public String toString() {
		return new StringBuilder("Empresa [")
				.append(EmpresaConstantes.CNPJ).append(cnpj)
				.append(EmpresaConstantes.RAZAO_SOCIAL).append(razaoSocial)
				.append(EmpresaConstantes.QUANTIDADE_DE_FUNCIONARIOS).append(quantidadeFuncionarios)
				.append(EmpresaConstantes.CAPITAL_SOCIAL).append(capitalSocial)
				.append(EmpresaConstantes.DATA_DE_ABERTURA).append(dataDeAbertura)
				.append(EmpresaConstantes.SITUACAO).append(ativa)
				.append(EmpresaConstantes.ENDERECOS).append(enderecos)
				.append(EmpresaConstantes.TELEFONES).append(telefones)
				.append(", " + super.toString())
				.append("]")
				.toString();
	}
}
