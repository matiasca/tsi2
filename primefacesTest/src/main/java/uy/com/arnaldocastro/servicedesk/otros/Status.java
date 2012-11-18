package uy.com.arnaldocastro.servicedesk.otros;

/**
 * 
 * Contenedor de los status de las respuestas de los WS
 */
public final class Status {

	/**
	 * Status generales para todas las operaciones
	 */

	public static final int PARAMETROS_INSUFICIENTES = -1;
	public static final int HIBERNATE_EXCEPTION = -2;
	public static final int TOKEN_INVALIDO = -3;

	/**
	 * Login status
	 */

	public static final int CREDENCIALES_INCORRECTAS = -4;
	public static final int USUARIO_LOGEADO = 0;
	public static final int USUARIO_LOGEADO_PREVIAMENTE = 1;

}
