package br.com.contmatic.prova.model;

import java.util.Objects;

import br.com.contmatic.prova.constantes.TelefoneConstantes;
import br.com.contmatic.prova.util.TelefoneUtil;

public class Telefone {
	
	private String ddd;
	private String telefone;
	
	public String getDdd() {
		return ddd;
	}
	
	public void setDdd(String ddd) {
		if (!TelefoneUtil.dddValido(ddd)) {
			throw new IllegalArgumentException(TelefoneConstantes.MENSAGEM_ERRO_DDD);
		}
		this.ddd = ddd;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		if (!TelefoneUtil.telefoneValido(telefone)) {
			throw new IllegalArgumentException(TelefoneConstantes.MENSAGEM_ERRO_TELEFONE);
		}
		this.telefone = telefone;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ddd, telefone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		return Objects.equals(ddd, other.ddd) && Objects.equals(telefone, other.telefone);
	}
	
	@Override
	public String toString() {
		return new StringBuilder("Telefone: ")
				.append("DDD = ").append(ddd)
				.append(", Telefone = ").append(telefone)
				.toString();
	}
	

}
