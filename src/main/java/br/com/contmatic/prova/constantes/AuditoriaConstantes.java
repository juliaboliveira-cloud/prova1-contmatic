package br.com.contmatic.prova.constantes;

public class AuditoriaConstantes {
	
	private AuditoriaConstantes() {}
	
	public static final String MENSAGEM_DE_ERRO_USUARIO_INVALIDO = "O campo de usuário não deve ficar em branco.";
	public static final String MENSAGEM_DE_ERRO_IP_INVALIDO = "O campo de Ip não deve ficar em branco.";
	public static final String MENSAGEM_DE_ERRO_DATA_HORA = "O campo de Data e Hora não deve ser anterior ou posterior ao horário real.";
	
	public static final String DATA_E_HORA_DE_CRIACAO = "Data e Hora de Criação";
	public static final String IP = "ip";
	public static final String IP_FORMATO = "^([0-9]{1,3}\\.){3}[0-9]{1,3}$";
	public static final String GMT_SP = "America/Sao_Paulo";
	
	
	public static final String O_CAMPO_NAO_PODE_SER_NULO = "O campo %s não pode ser nulo.";
	public static final String O_CAMPO_NAO_PODE_ESTAR_VAZIO = "O campo %s não pode estar vazio.";
	public static final String A_LISTA_NAO_PODE_ESTAR_VAZIA = "A lista %s não pode estar vazia.";
	public static final String O_CONTEUDO_DO_CAMPO_DEVE_TER_TAMANHO_X = "O conteúdo do campo %s deve ter tamanho %s.";
	public static final String O_CAMPO_NAO_PODE_SER_ZERO = "O campo %s não pode ser zero.";
	
	public static final String CAMPO_CODIGO_IP = "codigo IP";
	public static final String CAMPO_DATA_E_HORA_DE_ALTERACAO = "data e hora de alteração";
	public static final String CAMPO_DATA_E_HORA_DE_CRIACAO = "data e hora de criação";
	public static final String CAMPO_USUARIO_ALTERACAO = "usuário alteração";
	public static final String CAMPO_USUARIO_CRIACAO = "usuário criação";
}
