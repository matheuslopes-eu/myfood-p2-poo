package br.ufal.ic.p2.myfood.models;

import br.ufal.ic.p2.myfood.Exceptions.AtributoInvalidoException;
import br.ufal.ic.p2.myfood.Exceptions.AtributoNaoExisteException;
import br.ufal.ic.p2.myfood.services.PedidoSave;
import br.ufal.ic.p2.myfood.services.UsuarioSave;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

/**
 * Classe que representa uma Entrega.
 * Implementa Serializable para permitir que objetos dessa classe sejam salvos e carregados (persistência).
 */
public class Entrega implements Serializable {

    // Atributos da classe Entrega
    private int id; // ID único da entrega
    private int idPedido; // ID do pedido associado à entrega
    private int idEntregador; // ID do entregador responsável pela entrega
    private String destino; // Endereço de destino da entrega

    /**
     * Construtor da classe Entrega.
     * Inicializa os atributos com as informações fornecidas.
     * @param id ID da entrega.
     * @param idPedido ID do pedido relacionado.
     * @param idEntregador ID do entregador.
     * @param destino Endereço de destino da entrega.
     */
    public Entrega(int id, int idPedido, int idEntregador, String destino) {
        this.id = id;
        this.idPedido = idPedido;
        this.idEntregador = idEntregador;
        this.destino = destino;
    }

    // Getters para encapsulamento dos atributos
    public int getId() {
        return id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public int getIdEntregador() {
        return idEntregador;
    }

    public String getDestino() {
        return destino;
    }

    /**
     * Método que retorna o valor de um atributo especificado.
     * Utiliza dados persistidos (pedidos e usuários) para buscar informações relacionadas à entrega.
     * @param atributo Nome do atributo que se deseja obter.
     * @return O valor do atributo em formato String.
     * @throws AtributoInvalidoException Se o atributo for inválido.
     * @throws IOException Se houver problemas ao carregar os dados de pedidos ou usuários.
     * @throws ClassNotFoundException Se a classe dos objetos persistidos não for encontrada.
     * @throws AtributoNaoExisteException Se o atributo solicitado não existir.
     */
    public String getAtributo(String atributo) throws AtributoInvalidoException, IOException, ClassNotFoundException, AtributoNaoExisteException {

        // Carrega os pedidos e usuários de arquivos usando a camada de serviço
        Map<Integer, Pedido> pedidos = PedidoSave.carregarPedidos();
        Pedido pedido = pedidos.get(idPedido); // Busca o pedido relacionado ao ID da entrega
        Map<Integer, Usuario> usuarios = UsuarioSave.carregarUsuarios(); // Busca os usuários persistidos
        Usuario entregador = usuarios.get(idEntregador); // Busca o entregador associado à entrega

        // Limpa as estruturas de dados temporárias após o uso
        pedidos.clear();
        usuarios.clear();

        // Seleciona o comportamento adequado com base no atributo solicitado
        switch (atributo.toLowerCase()) {
            case "pedido":
                return String.valueOf(getIdPedido()); // Retorna o ID do pedido
            case "entregador":
                if (entregador != null) {
                    return entregador.getNome(); // Retorna o nome do entregador, se existir
                }
                throw new AtributoInvalidoException();
            case "cliente":
                if (pedido != null) {
                    return pedido.getCliente(); // Retorna o nome do cliente, se o pedido existir
                }
                throw new AtributoInvalidoException();
            case "empresa":
                if (pedido != null) {
                    return pedido.getEmpresa(); // Retorna o nome da empresa relacionada ao pedido
                }
                throw new AtributoInvalidoException();
            case "destino":
                return getDestino(); // Retorna o endereço de destino da entrega
            default:
                throw new AtributoNaoExisteException(); // Lança exceção se o atributo não existir
        }
    }
}