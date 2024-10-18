package br.ufal.ic.p2.myfood.models;

import br.ufal.ic.p2.myfood.Exceptions.AtributoInvalidoException;

/**
 * Classe que representa um Restaurante.
 * Herda da classe Empresa, mantendo o princípio de herança da Programação Orientada a Objetos (POO).
 * Inclui um atributo específico para o tipo de cozinha, além de métodos sobrescritos para comportamento especializado.
 */

public class Restaurante extends Empresa {
    // Atributo específico da classe Restaurante que armazena o tipo de cozinha oferecido.
    private String tipoCozinha;

    /**
     * Construtor da classe Restaurante que inicializa os atributos herdados da classe Empresa e o tipo de cozinha.
     * @param tipoEmpresa Tipo da empresa (ex: Restaurante).
     * @param nome Nome do restaurante.
     * @param endereco Endereço do restaurante.
     * @param tipoCozinha Tipo de cozinha oferecida pelo restaurante.
     */
    public Restaurante(String tipoEmpresa, String nome, String endereco, String tipoCozinha) {
        super(tipoEmpresa, nome, endereco); // Chamada ao construtor da classe pai (Empresa), aplicando o conceito de herança.
        this.tipoCozinha = tipoCozinha; // Atributo específico de restaurante.
    }

    /**
     * Método getter para obter o tipo de cozinha.
     * @return Tipo de cozinha do restaurante.
     */
    public String getTipoCozinha() {
        return tipoCozinha;
    }

    /**
     * Método sobrescrito da classe Empresa. Como restaurantes não são mercados,
     * este método sempre retorna false.
     * @return false, indicando que o Restaurante não é um Mercado.
     */
    @Override
    public boolean isMercado() {
        return false;
    }

    /**
     * Método sobrescrito da classe Empresa. Como restaurantes não são farmácias,
     * este método sempre retorna false.
     * @return false, indicando que o Restaurante não é uma Farmácia.
     */
    @Override
    public boolean isFarmacia(){return false;}

    /**
     * Método para ajustar um atributo do restaurante. Este método pode ser sobrescrito ou
     * estendido posteriormente para permitir ajustes dinâmicos.
     * @param atributo Nome do atributo a ser ajustado.
     * @param valor Valor a ser atribuído ao atributo.
     */
    @Override
    public void setAtributo(String atributo, String valor ){
        // Pode ser implementado para ajustar dinamicamente os atributos de Restaurante no futuro.
    }

    /**
     * Método para obter o valor de um atributo do restaurante.
     * Sobrescreve o método da classe pai para permitir que o tipo de cozinha seja acessado via atributo.
     * Caso o atributo solicitado seja desconhecido, delega a responsabilidade para a classe Empresa.
     * @param atributo Nome do atributo solicitado.
     * @return Valor do atributo solicitado.
     * @throws AtributoInvalidoException Caso o atributo não seja encontrado.
     */
    public String getAtributo(String atributo) throws AtributoInvalidoException {
        if ("tipoCozinha".equalsIgnoreCase(atributo)) {
            return getTipoCozinha(); // Se o atributo é "tipoCozinha", retorna o valor específico do Restaurante.
        }
        return super.getAtributo(atributo);  // Caso contrário, delega a verificação à classe Empresa.
    }
}