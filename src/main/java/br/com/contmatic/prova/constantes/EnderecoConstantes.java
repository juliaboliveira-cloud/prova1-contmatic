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
	

	public static final String UF = "uf";
	public static final String CIDADE = "cidade";
	public static final String BAIRRO = "bairro";
	public static final String RUA = "rua";
	public static final String NUMERO = "Numero";
	
	public static final String UF_TO_STRING = ", UF = ";
	public static final String CIDADE_TO_STRING = ", Cidade = ";
	public static final String BAIRRO_TO_STRING = ", Bairro = ";
	public static final String CEP_TO_STRING = ", CEP = ";
	public static final String COMPLEMENTO_TO_STRING = ", Complemento = ";
	public static final String NUMERO_TO_STRING = ", Número = ";
	public static final String RUA_TO_STRING = "Rua = ";
	public static final String ENDERECO_TO_STRING = "Endereço: ";
}
