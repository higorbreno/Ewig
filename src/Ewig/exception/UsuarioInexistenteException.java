package Ewig.exception;

public class UsuarioInexistenteException extends RuntimeException {
	public UsuarioInexistenteException(String mensagem) {
		super(mensagem);
	}
}
