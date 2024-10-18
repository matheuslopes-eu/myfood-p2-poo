package br.ufal.ic.p2.myfood.models;

import br.ufal.ic.p2.myfood.Exceptions.AtributoInvalidoException;

/**
 * Classe que representa um Mercado.
 * Herda da classe Empresa, aplicando o conceito de herança da Programação Orientada a Objetos.
 * Possui atributos específicos para o tipo de mercado e horários de funcionamento.
 */
public class Mercado extends Empresa {

    // Atributos específicos do Mercado
    private String abre; // Horário de abertura no formato HH:MM.
    private String fecha; // Horário de fechamento no formato HH:MM.
    private String tipoMercado; // Define o tipo de mercado: supermercado, minimercado ou atacadista.

    /**
     * Construtor da classe Mercado.
     * Inicializa os atributos herdados da classe Empresa e os atributos específicos de um Mercado.
     * @param tipoEmpresa Tipo da empresa (ex: Mercado).
     * @param nome Nome do mercado.
     * @param endereco Endereço do mercado.
     * @param abre Horário de abertura do mercado.
     * @param fecha Horário de fechamento do mercado.
     * @param tipoMercado Tipo de mercado.
     */
    public Mercado(String tipoEmpresa, String nome, String endereco, String abre, String fecha, String tipoMercado) {
        super(tipoEmpresa, nome, endereco); // Chama o construtor da classe pai Empresa.
        this.abre = abre; // Define o horário de abertura.
        this.fecha = fecha; // Define o horário de fechamento.
        this.tipoMercado = tipoMercado; // Define o tipo de mercado.
    }

    /**
     * Indica que este objeto representa um Mercado.
     * Sobrescreve o método da classe Empresa, aplicando o polimorfismo.
     * @return true, pois o objeto é de tipo Mercado.
     */
    @Override
    public boolean isMercado() {
        return true;
    }

    /**
     * Indica que este objeto não é uma Farmácia.
     * @return false, pois o objeto não é de tipo Farmácia.
     */
    @Override
    public boolean isFarmacia() {
        return false;
    }

    /**
     * Getter para o horário de abertura.
     * @return O horário de abertura do mercado.
     */
    public String getAbre() {
        return abre;
    }

    /**
     * Getter para o horário de fechamento.
     * @return O horário de fechamento do mercado.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Getter para o tipo de mercado.
     * @return O tipo de mercado (supermercado, minimercado ou atacadista).
     */
    public String getTipoMercado() {
        return tipoMercado;
    }

    /**
     * Setter para o horário de abertura.
     * @param abre Novo horário de abertura no formato HH:MM.
     */
    public void setAbre(String abre) {
        this.abre = abre;
    }

    /**
     * Setter para o horário de fechamento.
     * @param fecha Novo horário de fechamento no formato HH:MM.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Sobrescreve o método setAtributo da classe Empresa.
     * Implementa a lógica para definir dinamicamente os atributos de horário de funcionamento.
     * @param atributo Nome do atributo a ser modificado.
     * @param valor Novo valor do atributo.
     * @throws AtributoInvalidoException Caso o atributo seja inválido.
     */
    @Override
    public void setAtributo(String atributo, String valor) throws AtributoInvalidoException {
        switch (atributo.toLowerCase()) {
            case "abre":
                setAbre(valor); // Define o horário de abertura.
                return;
            case "fecha":
                setFecha(valor); // Define o horário de fechamento.
                return;
            default:
                // Caso o atributo não seja reconhecido, nenhuma ação é tomada.
                return;
        }
    }

    /**
     * Sobrescreve o método getAtributo da classe Empresa.
     * Retorna o valor de atributos específicos do Mercado ou delega à classe Empresa.
     * @param atributo Nome do atributo solicitado.
     * @return O valor do atributo.
     * @throws AtributoInvalidoException Caso o atributo não seja encontrado.
     */
    @Override
    public String getAtributo(String atributo) throws AtributoInvalidoException {
        switch (atributo.toLowerCase()) {
            case "abre":
                return getAbre(); // Retorna o horário de abertura.
            case "fecha":
                return getFecha(); // Retorna o horário de fechamento.
            case "tipomercado":
                return getTipoMercado(); // Retorna o tipo de mercado.
            default:
                return super.getAtributo(atributo); // Delega à classe Empresa se o atributo não for específico de Mercado.
        }
    }
}