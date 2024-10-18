package br.ufal.ic.p2.myfood.models;

import br.ufal.ic.p2.myfood.Exceptions.AtributoInvalidoException;

/**
 * Classe que representa uma Farmácia.
 * Herda da classe Empresa, utilizando o conceito de herança da Programação Orientada a Objetos.
 * Possui atributos específicos, como se é 24 horas e o número de funcionários.
 */
public class Farmacia extends Empresa {

    // Atributos específicos da Farmácia
    private boolean aberto24Horas; // Indica se a farmácia funciona 24 horas.
    private int numeroFuncionarios; // Número de funcionários na farmácia.

    /**
     * Construtor da classe Farmacia.
     * Inicializa os atributos herdados da classe Empresa e os atributos específicos de uma Farmácia.
     * @param tipoEmpresa Tipo da empresa (ex: Farmácia).
     * @param nome Nome da farmácia.
     * @param endereco Endereço da farmácia.
     * @param aberto24Horas Se a farmácia é aberta 24 horas ou não.
     * @param numeroFuncionarios Número de funcionários da farmácia.
     */
    public Farmacia(String tipoEmpresa, String nome, String endereco, boolean aberto24Horas, int numeroFuncionarios) {
        super(tipoEmpresa, nome, endereco); // Chama o construtor da classe pai Empresa.
        this.aberto24Horas = aberto24Horas; // Define se a farmácia é aberta 24 horas.
        this.numeroFuncionarios = numeroFuncionarios; // Define o número de funcionários.
    }

    /**
     * Indica que este objeto não representa um Mercado.
     * Sobrescreve o método da classe Empresa, aplicando o polimorfismo.
     * @return false, pois o objeto não é de tipo Mercado.
     */
    @Override
    public boolean isMercado() {
        return false;
    }

    /**
     * Indica que este objeto representa uma Farmácia.
     * Sobrescreve o método da classe Empresa, aplicando o polimorfismo.
     * @return true, pois o objeto é de tipo Farmácia.
     */
    @Override
    public boolean isFarmacia() {
        return true;
    }

    /**
     * Método para definir um atributo específico da Farmácia.
     * Ainda não implementado, podendo ser estendido para alterar atributos de forma dinâmica.
     * @param atributo Nome do atributo a ser modificado.
     * @param valor Novo valor do atributo.
     * @throws AtributoInvalidoException Caso o atributo seja inválido.
     */
    @Override
    public void setAtributo(String atributo, String valor) throws AtributoInvalidoException {
        // Método em branco, pronto para ser implementado conforme necessidades futuras.
    }

    /**
     * Getter para o atributo aberto24Horas.
     * @return true se a farmácia é aberta 24 horas, false caso contrário.
     */
    public boolean getAberto24Horas() {
        return aberto24Horas;
    }

    /**
     * Getter para o número de funcionários.
     * @return O número de funcionários da farmácia.
     */
    public int getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    /**
     * Sobrescreve o método getAtributo da classe Empresa.
     * Retorna o valor de atributos específicos da Farmácia ou delega à classe Empresa.
     * @param atributo Nome do atributo solicitado.
     * @return O valor do atributo como String.
     * @throws AtributoInvalidoException Caso o atributo não seja encontrado.
     */
    @Override
    public String getAtributo(String atributo) throws AtributoInvalidoException {
        switch (atributo.toLowerCase()) {
            case "aberto24horas":
                return getAberto24Horas() ? "true" : "false"; // Retorna se a farmácia é 24 horas.
            case "numerofuncionarios":
                return "" + getNumeroFuncionarios(); // Retorna o número de funcionários como string.
            default:
                return super.getAtributo(atributo); // Delega à classe Empresa se o atributo não for específico de Farmácia.
        }
    }
}