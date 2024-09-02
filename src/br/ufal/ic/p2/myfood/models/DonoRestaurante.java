package br.ufal.ic.p2.myfood.models;

import br.ufal.ic.p2.myfood.Exceptions.AtributoInvalidoException;

/**
 * A classe DonoRestaurante representa um usuário do tipo dono de restaurante
 * no sistema MyFood. Ela herda as propriedades e comportamentos da classe
 * Usuario, adicionando um atributo específico de CPF.
 */
public class DonoRestaurante extends Usuario{
    private String cpf;

    /**
     * Construtor da classe DonoRestaurante.
     *
     * @param nome     O nome do dono do restaurante.
     * @param email    O email do dono do restaurante.
     * @param senha    A senha do dono do restaurante.
     * @param endereco O endereço do dono do restaurante.
     * @param cpf      O CPF do dono do restaurante.
     */
    public DonoRestaurante(String nome, String email, String senha, String endereco, String cpf) {
        super(nome, email, senha, endereco);
        this.cpf = cpf;
    }
    /**
     * Método getter para acessar o CPF do dono do restaurante.
     *
     * @return O CPF do dono do restaurante.
     */
    public String getCpf() { return cpf; }

    /**
     * Método que retorna o valor de um atributo específico, baseado em seu nome.
     * Caso o atributo solicitado seja o CPF, ele é retornado diretamente.
     * Para outros atributos, o método da superclasse é chamado.
     *
     * @param atributo O nome do atributo a ser retornado.
     * @return O valor do atributo solicitado.
     * @throws AtributoInvalidoException Caso o atributo solicitado seja inválido.
     */
    @Override
    public String getAtributo(String atributo) throws AtributoInvalidoException {
        if ("cpf".equalsIgnoreCase(atributo)) {
            return getCpf();
        }
        return super.getAtributo(atributo);
    }
    /**
     * Método que verifica se o dono do restaurante tem permissão para criar uma empresa.
     *
     * @return true, pois donos de restaurantes têm permissão para criar empresas.
     */
    @Override
    public boolean podeCriarEmpresa() {
        return true; // DonoRestaurante pode criar empresas
    }
}
