package br.com.contmatic.prova.model;

import static br.com.contmatic.prova.constantes.TelefoneConstantes.DDD;
import static br.com.contmatic.prova.constantes.TelefoneConstantes.TELEFONE;
import static br.com.contmatic.prova.util.TelefoneUtil.validarDdd;
import static br.com.contmatic.prova.util.TelefoneUtil.validarTelefone;

import java.util.Objects;

public class Telefone extends Auditoria {
	

	private String ddd;
	private String numeroTelefone;
	
	public String getDdd() {
		return ddd;
	}
	
	public void setDdd(String ddd) {
		validarDdd(DDD, ddd);
		this.ddd = ddd;
	}
	
	public String getNumeroTelefone() {
		return numeroTelefone;
	}
	
	public void setNumeroTelefone(String telefone) {
		validarTelefone(TELEFONE, telefone);
		this.numeroTelefone = telefone;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ddd, numeroTelefone);
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
		return Objects.equals(ddd, other.ddd) && Objects.equals(numeroTelefone, other.numeroTelefone);
	}
	
	@Override
	public String toString() {
		return new StringBuilder("Telefone: ")
				.append("DDD = ").append(ddd)
				.append(", Telefone = ").append(numeroTelefone)
				.toString();
	}
}
