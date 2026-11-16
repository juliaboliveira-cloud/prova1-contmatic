package br.com.contmatic.prova.constantes;

public final class EnderecoConstantes {
	
	private EnderecoConstantes() {}

	public static final String MENSAGEM_DE_ERRO_ENDERECO_INSUFICIENTE = "O endereço deve ter 5 ou mais caracteres";
	public static final String MENSAGEM_DE_ERRO_CEP = "O CEP precisa ter 8 dígitos.";
	public static final String MENSAGEM_DE_ERRO_NUMERO = "O número deve ser preenchido.";
	public static final String MENSAGEM_DE_ERRO_UF = "O UF deve ser preenchido.";
	public static final String MENSAGEM_DE_ERRO_CIDADE = "A cidade deve ser preenchida.";
	public static final String MENSAGEM_DE_ERRO_BAIRRO = "O bairro deve ser preenchido.";
	
	public static final Integer TAMANHO_MAXIMO_ENDERECO = 100;
	public static final Integer TAMANHO_MINIMO_ENDERECO = 5;
	public static final Integer TAMANHO_CEP = 8;
}
