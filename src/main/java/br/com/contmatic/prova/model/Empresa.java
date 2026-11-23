package br.com.contmatic.prova.model;

import static br.com.contmatic.prova.util.CnpjUtil.isValido;
import static br.com.contmatic.prova.util.ValidacaoUtils.isBigDecimalGreaterThanZero;
import static br.com.contmatic.prova.util.ValidacaoUtils.isBlank;
import static br.com.contmatic.prova.util.ValidacaoUtils.isEmpty;
import static br.com.contmatic.prova.util.ValidacaoUtils.isGreaterThanZero;
import static br.com.contmatic.prova.util.ValidacaoUtils.isNull;
import static java.lang.String.format;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import br.com.contmatic.prova.constantes.EmpresaConstantes;
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
		isBlank("CNPJ", cnpj);
		isValido(cnpj);
		if (!isValido(cnpj)) {
			throw new IllegalArgumentException(format(EmpresaConstantes.CAMPO_INVALIDO, "CNPJ"));
		}
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		isBlank("Razão Social" ,razaoSocial);
		this.razaoSocial = razaoSocial;
	}

	public Integer getQuantidadeFuncionarios() {
		return quantidadeFuncionarios;
	}

	public void setQuantidadeFuncionarios(Integer quantidadeFuncionarios) {
		ValidacaoUtils.isNull("Quantidade de Funcionarios", quantidadeFuncionarios);
		isGreaterThanZero("Quantidade de Funcionarios", quantidadeFuncionarios);
		this.quantidadeFuncionarios = quantidadeFuncionarios;
	}

	public BigDecimal getCapitalSocial() {
		return capitalSocial;
	}

	public void setCapitalSocial(BigDecimal capitalSocial) {
		isNull("Capital Social", capitalSocial);
		isBigDecimalGreaterThanZero("Capital Social", capitalSocial);
		this.capitalSocial = capitalSocial;
	}

	public LocalDate getDataDeAbertura() {
		return dataDeAbertura;
	}

	public void setDataDeAbertura(LocalDate dataDeAbertura) {
		isNull("Data de Abertura", dataDeAbertura);
		this.dataDeAbertura = dataDeAbertura;
	}

	public Boolean getAtiva() {
		return ativa;
	}

	public void setAtiva(Boolean ativa) {
		isNull("Empresa ativa", ativa);
		this.ativa = ativa;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		isEmpty(enderecos, "Endereco");
		this.enderecos = enderecos;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		isEmpty(telefones, "Telefone");
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
				.append(", ").append(super.toString())
				.append("]")
				.toString();
	}
}
