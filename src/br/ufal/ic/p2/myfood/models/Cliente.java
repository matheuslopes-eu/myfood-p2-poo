package br.ufal.ic.p2.myfood.models;

/**
 * A classe Cliente representa um usuário do tipo cliente no sistema MyFood.
 * Ela herda as propriedades e comportamentos da classe Usuario, mas com algumas
 * restrições específicas, como a incapacidade de criar empresas.
 */
public class Cliente extends Usuario{

    /**
     * Construtor da classe Cliente.
     *
     * @param nome     O nome do cliente.
     * @param email    O email do cliente.
     * @param senha    A senha do cliente.
     * @param endereco O endereço do cliente.
     */
    public Cliente(String nome, String email, String senha, String endereco) {
        // Chama o construtor da superclasse Usuario para inicializar os atributos comuns
        super(nome, email, senha, endereco);
    }
    /**
     * Método que verifica se o cliente tem permissão para criar uma empresa.
     */
    @Override
    public boolean podeCriarEmpresa() {
        return false; // Cliente não pode criar empresas
    }

}
