package br.ufal.ic.p2.myfood;

import br.ufal.ic.p2.myfood.Exceptions.*;

import java.io.IOException;

/**
 * A Facade (fachada) que fornece uma interface simplificada para interagir com o sistema.
 * <p>
 * Esta classe atua como um intermediário entre o usuário e o sistema, encapsulando a lógica de negócios e
 * expondo métodos para operações comuns, como criar usuários, gerenciar empresas, produtos e pedidos.
 * </p>
 */
public class Facade {
    private Sistema sistema; // Instância do sistema que a fachada controla

    /**
     * Construtor padrão que inicializa o sistema.
     *
     * @throws IOException Se ocorrer um erro de entrada/saída durante a inicialização.
     * @throws ClassNotFoundException Se a classe do sistema não for encontrada.
     */
    public Facade() throws IOException, ClassNotFoundException {
        sistema = new Sistema();
    }
    /**
     * Zera o sistema, redefinindo todos os dados.
     */
    public void zerarSistema(){
        sistema.zerarSistema();
    }

    /**
     * Cria um novo usuário no sistema.
     *
     * @param nome Nome do usuário.
     * @param email Email do usuário.
     * @param senha Senha do usuário.
     * @param endereco Endereço do usuário.
     * @throws NomeInvalidoException Se o nome fornecido for inválido.
     * @throws EmailInvalidoException Se o email fornecido for inválido.
     * @throws SenhaInvalidaException Se a senha fornecida for inválida.
     * @throws EnderecoInvalidoException Se o endereço fornecido for inválido.
     * @throws EmailExistenteException Se o email fornecido já estiver em uso.
     */
    public void criarUsuario(String nome, String email, String senha, String endereco)  throws NomeInvalidoException
            , EmailInvalidoException, SenhaInvalidaException, EnderecoInvalidoException, EmailExistenteException {
        sistema.criarUsuario(nome, email, senha, endereco);
    }

    /**
     * Cria um novo usuário no sistema com um CPF adicional (Dono de restaurante).
     *
     * @param nome Nome do usuário.
     * @param email Email do usuário.
     * @param senha Senha do usuário.
     * @param endereco Endereço do usuário.
     * @param cpf CPF do usuário.
     * @throws NomeInvalidoException Se o nome fornecido for inválido.
     * @throws EmailInvalidoException Se o email fornecido for inválido.
     * @throws SenhaInvalidaException Se a senha fornecida for inválida.
     * @throws EnderecoInvalidoException Se o endereço fornecido for inválido.
     * @throws CpfInvalidoException Se o CPF fornecido for inválido.
     * @throws EmailExistenteException Se o email fornecido já estiver em uso.
     */
    public void criarUsuario(String nome, String email, String senha, String endereco, String cpf)  throws NomeInvalidoException
            , EmailInvalidoException, SenhaInvalidaException, EnderecoInvalidoException, CpfInvalidoException, EmailExistenteException {
        sistema.criarUsuario(nome, email, senha, endereco, cpf);
    }

    /**
     * Realiza o login de um usuário.
     *
     * @param email Email do usuário.
     * @param senha Senha do usuário.
     * @return ID do usuário logado.
     * @throws LoginSenhaInvalidosException Se o email ou a senha estiverem incorretos.
     */
    public int login(String email, String senha) throws LoginSenhaInvalidosException{
        return sistema.login(email, senha);
    }

    /**
     * Obtém um atributo específico de um usuário.
     *
     * @param id ID do usuário.
     * @param atributo Nome do atributo desejado.
     * @return Valor do atributo solicitado.
     * @throws UsuarioNaoCadastradoException Se o usuário com o ID fornecido não estiver cadastrado.
     * @throws AtributoInvalidoException Se o atributo solicitado for inválido.
     */
    public String getAtributoUsuario(int id, String atributo) throws UsuarioNaoCadastradoException, AtributoInvalidoException{
        return sistema.getAtributoUsuario(id, atributo);
    }

    /**
     * Cria uma nova empresa no sistema.
     *
     * @param tipoEmpresa Tipo da empresa.
     * @param idDono ID do dono da empresa.
     * @param nome Nome da empresa.
     * @param endereco Endereço da empresa.
     * @param tipoCozinha Tipo de cozinha da empresa.
     * @return ID da empresa criada.
     * @throws EnderecoDuplicadoException Se o endereço fornecido já estiver em uso.
     * @throws NomeEmpresaExistenteException Se o nome da empresa já estiver em uso.
     * @throws UsuarioNaoAutorizadoException Se o usuário não tiver permissão para criar a empresa.
     */
    public int criarEmpresa(String tipoEmpresa, int idDono, String nome, String endereco, String tipoCozinha) throws EnderecoDuplicadoException, NomeEmpresaExistenteException, UsuarioNaoAutorizadoException{
        return sistema.criarEmpresa(tipoEmpresa, idDono, nome, endereco, tipoCozinha);
    }

    /**
     * Obtém as empresas associadas a um usuário específico.
     *
     * @param idDono ID do dono.
     * @return Lista de empresas do usuário.
     * @throws UsuarioNaoAutorizadoException Se o usuário não tiver autorização para obter essas informações.
     */
    public String getEmpresasDoUsuario(int idDono) throws UsuarioNaoAutorizadoException{
        return sistema.getEmpresasDoUsuario(idDono);
    }

    /**
     * Obtém o ID de uma empresa com base em critérios fornecidos.
     *
     * @param idDono ID do dono da empresa.
     * @param nome Nome da empresa.
     * @param indice Índice da empresa na lista.
     * @return ID da empresa.
     * @throws NomeInvalidoException Se o nome fornecido for inválido.
     * @throws NomeEmpresaNaoExisteException Se a empresa com o nome fornecido não existir.
     * @throws IndiceInvalidoException Se o índice fornecido for inválido.
     * @throws IndiceMaiorException Se o índice fornecido for maior que o número de empresas.
     */
    public int getIdEmpresa(int idDono, String nome, int indice)  throws NomeInvalidoException,
            NomeEmpresaNaoExisteException, IndiceInvalidoException, IndiceMaiorException{
        return sistema.getIdEmpresa(idDono, nome, indice);
    }

    /**
     * Obtém um atributo específico de uma empresa.
     *
     * @param empresaId ID da empresa.
     * @param atributo Nome do atributo desejado.
     * @return Valor do atributo solicitado.
     * @throws EmpresaNaoCadastradaException Se a empresa com o ID fornecido não estiver cadastrada.
     * @throws AtributoInvalidoException Se o atributo solicitado for inválido.
     */
    public String getAtributoEmpresa(int empresaId, String atributo) throws EmpresaNaoCadastradaException, AtributoInvalidoException {
        return sistema.getAtributoEmpresa(empresaId, atributo);
    }

    /**
     * Cria um novo produto para uma empresa específica.
     *
     * @param empresa ID da empresa.
     * @param nome Nome do produto.
     * @param valor Valor do produto.
     * @param categoria Categoria do produto.
     * @return ID do produto criado.
     * @throws NomeProdutoExisteException Se o nome do produto já estiver em uso.
     * @throws NomeInvalidoException Se o nome fornecido for inválido.
     * @throws ValorInvalidoException Se o valor fornecido for inválido.
     * @throws CategoriaInvalidaException Se a categoria fornecida for inválida.
     */
    public int criarProduto(int empresa, String nome, float valor, String categoria) throws NomeProdutoExisteException, NomeInvalidoException, ValorInvalidoException, CategoriaInvalidaException{

        return sistema.criarProduto(empresa, nome, valor, categoria);
    }

    /**
     * Edita um produto existente.
     *
     * @param produto ID do produto a ser editado.
     * @param nome Novo nome do produto.
     * @param valor Novo valor do produto.
     * @param categoria Nova categoria do produto.
     * @throws NomeInvalidoException Se o nome fornecido for inválido.
     * @throws CategoriaInvalidaException Se a categoria fornecida for inválida.
     * @throws ValorInvalidoException Se o valor fornecido for inválido.
     * @throws ProdutoNaoCadastradoException Se o produto com o ID fornecido não estiver cadastrado.
     */
    public void editarProduto(int produto, String nome, float valor, String categoria) throws NomeInvalidoException,
    CategoriaInvalidaException, ValorInvalidoException, ProdutoNaoCadastradoException {
        sistema.editarProduto(produto, nome, valor, categoria);
    }

    /**
     * Obtém um atributo específico de um produto.
     *
     * @param nome Nome do produto.
     * @param empresa ID da empresa.
     * @param atributo Nome do atributo desejado.
     * @return Valor do atributo solicitado.
     * @throws AtributoNaoExisteException Se o atributo solicitado não existir.
     * @throws ProdutoNaoEncontradoException Se o produto com o nome fornecido não for encontrado.
     */
    public String getProduto(String nome, int empresa, String atributo) throws AtributoNaoExisteException,
            ProdutoNaoEncontradoException {
        return sistema.getProduto(nome, empresa, atributo);
    }

    /**
     * Lista todos os produtos de uma empresa.
     *
     * @param empresa ID da empresa.
     * @return Lista de produtos da empresa.
     * @throws EmpresaNaoEncontradaException Se a empresa com o ID fornecido não for encontrada.
     */
    public String listarProdutos(int empresa) throws EmpresaNaoEncontradaException{
        return sistema.listarProdutos(empresa);
    }

    /**
     * Cria um novo pedido para um cliente e empresa específicos.
     *
     * @param clienteId ID do cliente.
     * @param empresaId ID da empresa.
     * @return Número do pedido criado.
     * @throws DonoNaoPodePedidoException Se o dono da empresa não puder fazer o pedido.
     * @throws PedidoEmAbertoException Se já existir um pedido em aberto para o cliente e empresa.
     */
    public int criarPedido(int clienteId, int empresaId) throws DonoNaoPodePedidoException, PedidoEmAbertoException{
        return sistema.criarPedido(clienteId, empresaId);
    }

    /**
     * Adiciona um produto a um pedido existente.
     *
     * @param numero Número do pedido.
     * @param produto ID do produto a ser adicionado.
     * @throws NaoExistePedidoAbertoException Se o pedido com o número fornecido não estiver aberto.
     * @throws ProdutoNaoEncontradoException Se o produto com o ID fornecido não for encontrado.
     * @throws ProdutoNaoPertenceEmpresaException Se o produto não pertencer à empresa associada ao pedido.
     * @throws EmpresaNaoEncontradaException Se a empresa associada ao pedido não for encontrada.
     * @throws PedidoFechadoException Se o pedido com o número fornecido já estiver fechado.
     */
    public void adicionarProduto(int numero, int produto) throws NaoExistePedidoAbertoException,
            ProdutoNaoEncontradoException, ProdutoNaoPertenceEmpresaException, EmpresaNaoEncontradaException, PedidoFechadoException {
        sistema.adicionarProduto(numero, produto);
    }

    /**
     * Obtém um atributo específico de um pedido.
     *
     * @param numeroPedido Número do pedido.
     * @param atributo Nome do atributo desejado.
     * @return Valor do atributo solicitado.
     * @throws NaoExistePedidoAbertoException Se o pedido com o número fornecido não estiver aberto.
     * @throws AtributoInvalidoException Se o atributo solicitado for inválido.
     * @throws AtributoNaoExisteException Se o atributo solicitado não existir.
     */
    public String getPedidos(int numeroPedido, String atributo) throws NaoExistePedidoAbertoException,
            AtributoInvalidoException, AtributoNaoExisteException {
        return sistema.getPedidos(numeroPedido, atributo);
    }

    /**
     * Fecha um pedido existente.
     *
     * @param numeroPedido Número do pedido a ser fechado.
     * @throws PedidoNaoEncontradoException Se o pedido com o número fornecido não for encontrado.
     */
    public void fecharPedido(int numeroPedido) throws PedidoNaoEncontradoException{
        sistema.fecharPedido(numeroPedido);
    }

    /**
     * Remove um produto de um pedido.
     *
     * @param numeroPedido Número do pedido.
     * @param nomeProduto Nome do produto a ser removido.
     * @throws PedidoNaoEncontradoException Se o pedido com o número fornecido não for encontrado.
     * @throws ProdutoNaoEncontradoException Se o produto com o nome fornecido não for encontrado.
     * @throws ProdutoInvalidoException Se o produto fornecido for inválido.
     * @throws RemoverProdutoPedidoFechadoException Se o pedido com o número fornecido estiver fechado.
     */
    public void removerProduto(int numeroPedido, String nomeProduto) throws PedidoNaoEncontradoException,
            ProdutoNaoEncontradoException, ProdutoInvalidoException, RemoverProdutoPedidoFechadoException{
        sistema.removerProduto(numeroPedido, nomeProduto);
    }

    /**
     * Obtém o número do pedido baseado em critérios fornecidos.
     *
     * @param clienteId ID do cliente.
     * @param empresaId ID da empresa.
     * @param indice Índice do pedido na lista de pedidos.
     * @return Número do pedido.
     */
    public int getNumeroPedido(int clienteId, int empresaId, int indice){
        return sistema.getNumeroPedido(clienteId, empresaId, indice);
    }

    /**
     * Encerra o sistema, salvando quaisquer dados persistentes e liberando recursos.
     *
     * @throws IOException Se ocorrer um erro de entrada/saída durante o encerramento.
     */
    public void encerrarSistema() throws IOException {
        sistema.encerrarSistema();
    }
}
