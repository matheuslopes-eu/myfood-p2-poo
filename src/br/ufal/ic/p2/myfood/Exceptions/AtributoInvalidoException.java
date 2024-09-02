package br.ufal.ic.p2.myfood.Exceptions;

/**
 * Exceção lançada quando um atributo inválido é solicitado ou encontrado.
 * <p>
 * Esta exceção é uma subclasse de {@link Exception} e é utilizada para indicar que
 * o atributo solicitado não é reconhecido ou não é válido dentro do contexto da aplicação.
 * (Segue para todas as exceções da mesma maneira, mas muda a mensagem exibida)
 * </p>
 */
public class AtributoInvalidoException extends Exception {

    /**
     * Construtor padrão da exceção.
     * Inicializa a exceção com uma mensagem padrão que indica que o atributo é inválido.
     */
    public AtributoInvalidoException() {
        super("Atributo invalido");
    } // Mensagem padrão da exceção.
}
