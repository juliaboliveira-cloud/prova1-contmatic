package br.com.contmatic.prova.model;

import static br.com.contmatic.prova.constantes.EnderecoConstantes.BAIRRO;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.BAIRRO_TO_STRING;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.CEP_TO_STRING;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.CIDADE;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.CIDADE_TO_STRING;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.COMPLEMENTO_TO_STRING;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.ENDERECO_TO_STRING;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.NUMERO;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.NUMERO_TO_STRING;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.RUA;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.RUA_TO_STRING;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.UF;
import static br.com.contmatic.prova.constantes.EnderecoConstantes.UF_TO_STRING;
import static br.com.contmatic.prova.util.CepUtil.temOitoDigitos;
import static br.com.contmatic.prova.util.ValidacaoUtils.isBlank;
import static br.com.contmatic.prova.util.ValidacaoUtils.isGreaterThanZero;
import static br.com.contmatic.prova.util.ValidacaoUtils.isNull;

import java.util.Objects;

public class Endereco {


	private String rua;
	private Integer numeroEndereco;
	private String complemento;
	private String cep;
	private String bairro;
	private String cidade;
	private String uf;
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		isBlank(RUA, rua);
		this.rua = rua;
	}
	public Integer getNumeroEndereco() {
		return numeroEndereco;
	}
	public void setNumeroEndereco(Integer numero) {
		isNull("Numero", numero);
		isGreaterThanZero(NUMERO , numero);
		this.numeroEndereco = numero;
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
		temOitoDigitos(cep);
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		isBlank(BAIRRO, bairro);
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		isBlank(CIDADE, cidade);
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		isBlank(UF, uf);
		this.uf = uf;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cep, complemento, numeroEndereco);
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
				&& Objects.equals(numeroEndereco, other.numeroEndereco);
	}
	
	@Override
	public String toString() {
		return new StringBuilder(ENDERECO_TO_STRING)
				.append(RUA_TO_STRING).append(rua)
				.append(NUMERO_TO_STRING).append(numeroEndereco)
				.append(COMPLEMENTO_TO_STRING).append(complemento)
				.append(CEP_TO_STRING).append(cep)
				.append(BAIRRO_TO_STRING).append(bairro)
				.append(CIDADE_TO_STRING).append(cidade)
				.append(UF_TO_STRING).append(uf)
				.toString();
	}
	
}
