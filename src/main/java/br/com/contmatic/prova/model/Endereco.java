package br.com.contmatic.prova.model;

import java.util.Objects;

import br.com.contmatic.prova.constantes.EnderecoConstantes;
import br.com.contmatic.prova.util.CepUtil;
import br.com.contmatic.prova.util.ValidacaoUtils;

public class Endereco {

	private String rua;
	private Integer numero;
	private String complemento;
	private String cep;
	private String bairro;
	private String cidade;
	private String uf;
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		ValidacaoUtils.validaEmpresa(rua, EnderecoConstantes.MENSAGEM_DE_ERRO_ENDERECO_INSUFICIENTE);
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		ValidacaoUtils.validaEmpresa(numero, EnderecoConstantes.MENSAGEM_DE_ERRO_NUMERO);
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		CepUtil.temOitoDigitos(cep);
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		ValidacaoUtils.validaEmpresa(bairro, EnderecoConstantes.MENSAGEM_DE_ERRO_BAIRRO);
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		ValidacaoUtils.validaEmpresa(cidade, EnderecoConstantes.MENSAGEM_DE_ERRO_CIDADE);
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		ValidacaoUtils.validaEmpresa(uf, EnderecoConstantes.MENSAGEM_DE_ERRO_UF);
		this.uf = uf;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cep, complemento, numero);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(complemento, other.complemento)
				&& Objects.equals(numero, other.numero);
	}
	
	@Override
	public String toString() {
		return new StringBuilder("Endereço: ")
				.append("Rua = ").append(rua)
				.append(", Número = ").append(numero)
				.append(", Complemento = ").append(complemento)
				.append(", CEP = ").append(cep)
				.append(", Bairro = ").append(bairro)
				.append(", Cidade = ").append(cidade)
				.append(", UF = ").append(uf)
				.toString();
	}
	
}
