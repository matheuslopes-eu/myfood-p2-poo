package br.ufal.ic.p2.myfood.models;

import br.ufal.ic.p2.myfood.Exceptions.AtributoInvalidoException;

import java.io.Serializable;

/**
 * A classe abstrata Usuario representa um usuário genérico do sistema.
 * Esta classe é abstrata, significando que não pode ser instanciada diretamente,
 * mas serve de base para outras classes derivadas.
 * Implementa Serializable para permitir a serialização de suas instâncias.
 */
public abstract class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int contadorId = 1;
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String endereco;

    /**
     * Construtor da classe Usuario.
     * Inicializa um novo usuário com nome, email, senha e endereço.
     *
     * @param nome      Nome do usuário.
     * @param email     Email do usuário.
     * @param senha     Senha do usuário.
     * @param endereco  Endereço do usuário.
     */
    public Usuario(String nome, String email, String senha, String endereco) {
        this.id = contadorId++;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    // Métodos getters para acessar os atributos do usuário

    /**
     * Retorna o ID único do usuário.
     *
     * @return ID do usuário.
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o nome do usuário.
     *
     * @return Nome do usuário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o email do usuário.
     *
     * @return Email do usuário.
     */

    public String getEmail() {
        return email;
    }

    /**
     * Retorna a senha do usuário.
     *
     * @return Senha do usuário.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Retorna o endereço do usuário.
     *
     * @return Endereço do usuário.
     */
    public String getEndereco() { return endereco; }

    /**
     * Retorna o valor do atributo solicitado, se ele existir.
     *
     * @param atributo Nome do atributo que se deseja obter.
     * @return Valor do atributo solicitado.
     * @throws AtributoInvalidoException Se o atributo solicitado não existir.
     */
    public String getAtributo(String atributo) throws AtributoInvalidoException {
        switch (atributo) {
            case "nome":
                return getNome();
            case "email":
                return getEmail();
            case "senha":
                return getSenha();
            case "endereco":
                return getEndereco();
            default:
                throw new AtributoInvalidoException();
        }
    }

    /**
     * Método abstrato que deve ser implementado pelas subclasses.
     * Define se o usuário tem permissão para criar uma empresa.
     *
     * @return true se o usuário pode criar uma empresa, false caso contrário.
     */
    public abstract boolean podeCriarEmpresa();
}
