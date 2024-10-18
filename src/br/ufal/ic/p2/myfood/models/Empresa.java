package br.ufal.ic.p2.myfood.models;

import br.ufal.ic.p2.myfood.Exceptions.AtributoInvalidoException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstrata Empresa, representando a estrutura básica de uma empresa.
 * Implementa Serializable para que os dados possam ser persistidos.
 */
public abstract class Empresa implements Serializable {

    // Versão serial para garantir a compatibilidade de versões na serialização
    private static final long serialVersionUID = 1L;

    // Atributo estático para gerar IDs únicos para cada empresa
    private static int contadorId = 1;

    // Atributos de instância
    private int id; // ID único da empresa
    private String tipoEmpresa; // Tipo da empresa (e.g., mercado, restaurante)
    private String nome; // Nome da empresa
    private String endereco; // Endereço da empresa
    private List<Entregador> entregadores; // Lista de entregadores associados à empresa

    /**
     * Construtor da classe Empresa.
     * @param tipoEmpresa O tipo de empresa.
     * @param nome O nome da empresa.
     * @param endereco O endereço da empresa.
     */
    public Empresa(String tipoEmpresa, String nome, String endereco) {
        this.id = contadorId++; // Atribui um ID único e incrementa o contador
        this.tipoEmpresa = tipoEmpresa;
        this.nome = nome;
        this.endereco = endereco;
    }

    // Getter para a lista de entregadores com inicialização tardia (Lazy Initialization)
    public List<Entregador> getEntregadores() {
        if (entregadores == null) {
            entregadores = new ArrayList<>(); // Inicializa a lista se estiver nula
        }
        return entregadores;
    }

    // Setter para definir a lista de entregadores
    public void setEntregadores(List<Entregador> entregadores) {
        this.entregadores = entregadores;
    }

    // Getters para acessar os atributos encapsulados
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    /**
     * Métodos abstratos que definem se a empresa é um mercado ou uma farmácia.
     * Devem ser implementados pelas subclasses.
     */
    public abstract boolean isMercado();
    public abstract boolean isFarmacia();

    /**
     * Método abstrato para definir atributos.
     * Implementado pelas subclasses para permitir flexibilidade na manipulação de atributos.
     * @param atributo O nome do atributo a ser definido.
     * @param valor O valor do atributo.
     * @throws AtributoInvalidoException Se o atributo for inválido.
     */
    public abstract void setAtributo(String atributo, String valor) throws AtributoInvalidoException;

    /**
     * Método que retorna o valor de um atributo baseado em uma string.
     * Caso o atributo não seja encontrado, lança uma exceção personalizada.
     * @param atributo O nome do atributo a ser obtido.
     * @return O valor do atributo como string.
     * @throws AtributoInvalidoException Se o atributo for inválido.
     */
    public String getAtributo(String atributo) throws AtributoInvalidoException {
        switch (atributo) {
            case "nome":
                return getNome(); // Retorna o nome da empresa
            case "endereco":
                return getEndereco(); // Retorna o endereço da empresa
            case "tipoEmpresa":
                return getTipoEmpresa(); // Retorna o tipo de empresa
            default:
                throw new AtributoInvalidoException(); // Lança exceção se o atributo for inválido
        }
    }
}