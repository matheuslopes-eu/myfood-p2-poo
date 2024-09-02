package br.ufal.ic.p2.myfood.models;

import br.ufal.ic.p2.myfood.Exceptions.AtributoInvalidoException;

import java.io.Serializable;

/**
 * A classe Restaurante representa um estabelecimento de alimentação.
 * Implementa Serializable para que suas instâncias possam ser serializadas,
 * permitindo a persistência de dados.
 */
public class Restaurante implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int contadorId = 1;
    private int id;
    private String nome;
    private String endereco;
    private String tipoCozinha;

    /**
     * Construtor da classe Restaurante.
     * Inicializa um novo restaurante com nome, endereço e tipo de cozinha específicos.
     *
     * @param nome         Nome do restaurante.
     * @param endereco     Endereço do restaurante.
     * @param tipoCozinha  Tipo de cozinha do restaurante.
     */
    public Restaurante(String nome, String endereco, String tipoCozinha) {
        this.id = contadorId++; // Atribui um ID único ao restaurante e incrementa o contador.
        this.nome = nome;
        this.endereco = endereco;
        this.tipoCozinha = tipoCozinha;
    }

    // Métodos getters para acessar os atributos do restaurante

    /**
     * Retorna o ID único do restaurante.
     *
     * @return ID do restaurante.
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o nome do restaurante.
     *
     * @return Nome do restaurante.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o endereço do restaurante.
     *
     * @return Endereço do restaurante.
     */
    public String getEndereco() { return endereco; }

    /**
     * Retorna o tipo de cozinha do restaurante.
     *
     * @return Tipo de cozinha do restaurante.
     */
    public String getTipoCozinha() { return tipoCozinha; }

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
            case "endereco":
                return getEndereco();
            case "tipoCozinha":
                return getTipoCozinha();
            default:
                throw new AtributoInvalidoException();
        }
    }

}
