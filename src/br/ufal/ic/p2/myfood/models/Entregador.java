package br.ufal.ic.p2.myfood.models;

import br.ufal.ic.p2.myfood.Exceptions.AtributoInvalidoException;

/**
 * Classe que representa um Entregador.
 * Herda da classe Usuario, usando herança da POO para reutilizar atributos e comportamentos comuns a todos os usuários.
 */
public class Entregador extends Usuario {

    // Atributos específicos do Entregador
    private String veiculo; // Tipo de veículo usado pelo entregador (ex: moto, carro, bicicleta).
    private String placa;   // Placa do veículo do entregador.

    /**
     * Construtor da classe Entregador.
     * Inicializa os atributos herdados da classe Usuario, além dos atributos específicos de Entregador.
     * @param nome Nome do entregador.
     * @param email Email do entregador (herdado de Usuario).
     * @param senha Senha do entregador (herdado de Usuario).
     * @param endereco Endereço do entregador (herdado de Usuario).
     * @param veiculo Tipo de veículo que o entregador utiliza.
     * @param placa Placa do veículo utilizado.
     */
    public Entregador(String nome, String email, String senha, String endereco, String veiculo, String placa) {
        super(nome, email, senha, endereco); // Chama o construtor da classe pai (Usuario).
        this.veiculo = veiculo; // Define o tipo de veículo usado pelo entregador.
        this.placa = placa;     // Define a placa do veículo.
    }

    // Getters e Setters para encapsulamento dos atributos
    /**
     * Retorna o tipo de veículo que o entregador utiliza.
     * @return O veículo do entregador.
     */
    public String getVeiculo() {
        return veiculo;
    }

    /**
     * Define o tipo de veículo do entregador.
     * @param veiculo O veículo a ser definido.
     */
    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    /**
     * Retorna a placa do veículo do entregador.
     * @return A placa do veículo.
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Define a placa do veículo do entregador.
     * @param placa A placa a ser definida.
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * Sobrescreve o método getEmail da classe Usuario.
     * Mostra a reutilização de comportamento herdado, aplicando o conceito de herança.
     * @return O email do entregador.
     */
    public String getEmail() {
        return super.getEmail(); // Reutiliza o método da classe pai para retornar o email.
    }

    /**
     * Sobrescreve o método getAtributo da classe Usuario.
     * Implementa a recuperação de atributos específicos de Entregador ou delega para a classe pai.
     * @param atributo Nome do atributo solicitado.
     * @return O valor do atributo como String.
     * @throws AtributoInvalidoException Caso o atributo seja inválido.
     */
    @Override
    public String getAtributo(String atributo) throws AtributoInvalidoException {
        switch (atributo.toLowerCase()) {
            case "placa":
                return getPlaca();  // Retorna a placa do veículo
            case "veiculo":
                return getVeiculo(); // Retorna o tipo de veículo
            default:
                return super.getAtributo(atributo); // Delegação para o método da classe Usuario
        }
    }

    /**
     * Verifica se o entregador pode criar empresas.
     * Sobrescreve comportamento padrão, implementando uma regra de negócio.
     * @return false, pois um entregador não pode criar empresas.
     */
    public boolean podeCriarEmpresa() {
        return false; // Entregador não tem permissão para criar empresas.
    }

    /**
     * Retorna true para indicar que o usuário é um entregador.
     * @return true, pois este objeto representa um Entregador.
     */
    public boolean ehEntregador() {
        return true;
    }
}