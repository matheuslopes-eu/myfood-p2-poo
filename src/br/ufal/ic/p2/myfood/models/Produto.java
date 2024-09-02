package br.ufal.ic.p2.myfood.models;

import br.ufal.ic.p2.myfood.Exceptions.AtributoNaoExisteException;
import br.ufal.ic.p2.myfood.Exceptions.ProdutoNaoEncontradoException;

import java.io.Serializable;

/**
 * A classe Produto representa um produto oferecido por uma empresa.
 * Ela implementa Serializable para permitir a serialização dos objetos,
 * possibilitando a persistência dos dados.
 */
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;


    private static int idCounter = 0;
    private int id;
    private String nome;
    private float valor;
    private String categoria;

    /**
     * Construtor da classe Produto.
     * Inicializa um novo produto com nome, valor e categoria específicos.
     *
     * @param nome      Nome do produto.
     * @param valor     Valor do produto.
     * @param categoria Categoria à qual o produto pertence.
     */
    public Produto(String nome, float valor, String categoria) {
        this.id = ++idCounter;
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
    }

    // Métodos getters para acessar os atributos do produto

    /**
     * Retorna o ID único do produto.
     *
     * @return ID do produto.
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o nome do produto.
     *
     * @return Nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o valor do produto.
     *
     * @return Valor do produto.
     */
    public float getValor() {
        return valor;
    }

    /**
     * Retorna a categoria do produto.
     *
     * @return Categoria do produto.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Retorna o valor do atributo solicitado, se ele existir.
     *
     * @param atributo Nome do atributo que se deseja obter.
     * @return Valor do atributo solicitado.
     * @throws AtributoNaoExisteException Se o atributo solicitado não existir.
     * @throws ProdutoNaoEncontradoException Se o produto não for encontrado.
     */
    public String getAtributo(String atributo) throws AtributoNaoExisteException, ProdutoNaoEncontradoException {
        switch (atributo) {
            case "nome":
                return getNome();
            case "categoria":
                return getCategoria();
            default:
                throw new AtributoNaoExisteException();
        }
    }

    // Métodos setters para modificar os atributos do produto

    /**
     * Define o nome do produto.
     *
     * @param nome Novo nome do produto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define o valor do produto.
     *
     * @param valor Novo valor do produto.
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * Define a categoria do produto.
     *
     * @param categoria Nova categoria do produto.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}