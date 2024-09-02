package br.ufal.ic.p2.myfood.models;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
 * A classe Pedido representa um pedido feito por um cliente a uma empresa.
 * Ela implementa Serializable para permitir a serialização dos objetos,
 * possibilitando a persistência dos dados.
 */
public class Pedido implements Serializable {
    // Serialização da classe Pedido, garantindo compatibilidade durante o processo de serialização/deserialização.
    private static final long serialVersionUID = 1L;

    // Contador estático para gerar números de pedidos únicos.
    private static int contador = 0;

    // Atributos da classe Pedido
    private int numero; // Número único do pedido
    private String cliente; // Nome do cliente que fez o pedido
    private String empresa; // Nome da empresa onde o pedido foi feito
    private String estado; // Estado atual do pedido (ex: aberto, preparando)
    private List<Produto> produtos; // Lista de produtos incluídos no pedido
    private float valor; // Valor total do pedido

    /**
     * Construtor da classe Pedido.
     * Inicializa um novo pedido com um cliente e uma empresa específicos.
     *
     * @param cliente Nome do cliente que está fazendo o pedido.
     * @param empresa Nome da empresa onde o pedido foi realizado.
     */
    public Pedido(String cliente, String empresa) {
        this.numero = ++contador;
        this.cliente = cliente;
        this.empresa = empresa;
        this.estado = "aberto";  // Estado inicial do pedido
        this.produtos = new ArrayList<>();
        this.valor = 0;
    }

    // Métodos getters para acessar os atributos do pedido

    /**
     * Retorna o número único do pedido.
     *
     * @return Número do pedido.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Retorna o nome do cliente que fez o pedido.
     *
     * @return Nome do cliente.
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Retorna o nome da empresa onde o pedido foi feito.
     *
     * @return Nome da empresa.
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Retorna o estado atual do pedido.
     *
     * @return Estado do pedido.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Retorna a lista de produtos incluídos no pedido.
     *
     * @return Lista de produtos.
     */
    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     * Retorna o valor total do pedido.
     *
     * @return Valor total do pedido.
     */
    public float getValor() {
        return valor;
    }

    /**
     * Adiciona um produto ao pedido e atualiza o valor total.
     *
     * @param produto Produto a ser adicionado ao pedido.
     */
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        valor += produto.getValor(); // Atualiza o valor total do pedido
    }

    /**
     * Finaliza o pedido, mudando seu estado para "preparando".
     */
    public void finalizarPedido() {
        this.estado = "preparando";
    }

    /**
     * Remove um produto do pedido com base no nome do produto.
     * Se o produto for encontrado e removido, o valor total do pedido é atualizado.
     *
     * @param nomeProduto Nome do produto a ser removido.
     * @return true se o produto foi encontrado e removido, false caso contrário.
     */
    public boolean removerProdutoPorNome(String nomeProduto) {
        for (Iterator<Produto> it = produtos.iterator(); ((Iterator<?>) it).hasNext(); ) {
            Produto produto = it.next();
            if (produto.getNome().equals(nomeProduto)) {
                it.remove();
                valor -= produto.getValor();
                return true;
            }
        }
        return false;
    }

}
