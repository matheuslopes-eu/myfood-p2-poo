package br.ufal.ic.p2.myfood;

import br.ufal.ic.p2.myfood.Exceptions.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;

public class Facade {
    private Sistema sistema;

    // Construtor da fachada, inicializando o sistema
    public Facade() throws IOException, ClassNotFoundException {
        sistema = new Sistema();
    }

    // Método para zerar o sistema
    public void zerarSistema() {
        sistema.zerarSistema();
    }

    // Métodos sobrecarregados para criar usuários, variando conforme os parâmetros
    public void criarUsuario(String nome, String email, String senha, String endereco) throws NomeInvalidoException,
            EmailInvalidoException, SenhaInvalidaException, EnderecoInvalidoException, EmailExistenteException {
        sistema.criarUsuario(nome, email, senha, endereco);
    }

    public void criarUsuario(String nome, String email, String senha, String endereco, String cpf) throws NomeInvalidoException,
            EmailInvalidoException, SenhaInvalidaException, EnderecoInvalidoException, CpfInvalidoException, EmailExistenteException {
        sistema.criarUsuario(nome, email, senha, endereco, cpf);
    }

    public void criarUsuario(String nome, String email, String senha, String endereco, String veiculo, String placa) throws NomeInvalidoException
            , EmailInvalidoException, SenhaInvalidaException, EnderecoInvalidoException, PlacaInvalidaException, VeiculoInvalidoException,
            EmailExistenteException, AtributoInvalidoException {
        sistema.criarUsuario(nome, email, senha, endereco, veiculo, placa);
    }

    // Método para cadastrar um entregador a uma empresa
    public void cadastrarEntregador(int idEmpresa, int idEntregador)
            throws EmpresaNaoEncontradaException, UsuarioNaoEntregadorException {
        sistema.cadastrarEntregador(idEmpresa, idEntregador);
    }

    // Retorna uma string com os entregadores de uma empresa
    public String getEntregadores(int idEmpresa) throws EmpresaNaoEncontradaException {
        return sistema.getEntregadores(idEmpresa);
    }

    // Retorna uma string com as empresas associadas a um entregador
    public String getEmpresas(int idEntregador) throws UsuarioNaoEntregadorException {
        return sistema.getEmpresas(idEntregador);
    }

    // Método de login, retornando o id do usuário se válido
    public int login(String email, String senha) throws LoginSenhaInvalidosException {
        return sistema.login(email, senha);
    }

    // Método para obter o atributo de um usuário
    public String getAtributoUsuario(int id, String atributo) throws UsuarioNaoCadastradoException, AtributoInvalidoException {
        return sistema.getAtributoUsuario(id, atributo);
    }

    // Métodos sobrecarregados para criar uma empresa, variando conforme os parâmetros
    public int criarEmpresa(String tipoEmpresa, int idDono, String nome, String endereco, String tipoCozinha) throws EnderecoDuplicadoException, NomeEmpresaExistenteException, UsuarioNaoAutorizadoException {
        return sistema.criarEmpresa(tipoEmpresa, idDono, nome, endereco, tipoCozinha);
    }

    public int criarEmpresa(String tipoEmpresa, int idDono, String nome, String endereco, String abre, String fecha,
                            String tipoMercado) throws NomeEmpresaExistenteException, EnderecoDuplicadoException,
            UsuarioNaoAutorizadoException, FormatoHoraInvalidoException,
            TipoEmpresaInvalidoException, TipoMercadoInvalidoException, NomeInvalidoException,
            EnderecoInvalidoException, EnderecoEmpresaInvalidoException, HorarioInvalidoException {
        return sistema.criarEmpresa(tipoEmpresa, idDono, nome, endereco, abre, fecha, tipoMercado);
    }

    // Método para alterar o horário de funcionamento de um mercado
    public void alterarFuncionamento(int mercadoId, String abre, String fecha) throws AtributoInvalidoException,
            FormatoHoraInvalidoException, HorarioInvalidoException, MercadoInvalidoException {
        sistema.alterarFuncionamento(mercadoId, abre, fecha);
    }

    public int criarEmpresa(String tipoEmpresa, int idDono, String nome, String endereco, boolean aberto24Horas,
                            int numeroFuncionarios)
            throws TipoEmpresaInvalidoException, NomeInvalidoException, EnderecoInvalidoException, NomeEmpresaExistenteException, EnderecoDuplicadoException,
            UsuarioNaoAutorizadoException, EnderecoEmpresaInvalidoException{
        return sistema.criarEmpresa(tipoEmpresa, idDono, nome, endereco, aberto24Horas, numeroFuncionarios);
    }

    // Retorna as empresas associadas a um usuário
    public String getEmpresasDoUsuario(int idDono) throws UsuarioNaoAutorizadoException {
        return sistema.getEmpresasDoUsuario(idDono);
    }

    // Método para obter o id de uma empresa, dado o nome e índice
    public int getIdEmpresa(int idDono, String nome, int indice) throws NomeInvalidoException,
            NomeEmpresaNaoExisteException, IndiceInvalidoException, IndiceMaiorException {
        return sistema.getIdEmpresa(idDono, nome, indice);
    }

    // Método para obter um atributo de uma empresa
    public String getAtributoEmpresa(int empresaId, String atributo) throws EmpresaNaoCadastradaException, AtributoInvalidoException {
        return sistema.getAtributoEmpresa(empresaId, atributo);
    }

    // Método para criar um produto em uma empresa
    public int criarProduto(int empresa, String nome, float valor, String categoria) throws NomeProdutoExisteException, NomeInvalidoException, ValorInvalidoException, CategoriaInvalidaException {
        return sistema.criarProduto(empresa, nome, valor, categoria);
    }

    // Método para editar um produto existente
    public void editarProduto(int produto, String nome, float valor, String categoria) throws NomeInvalidoException,
            CategoriaInvalidaException, ValorInvalidoException, ProdutoNaoCadastradoException {
        sistema.editarProduto(produto, nome, valor, categoria);
    }

    // Método para obter um atributo de um produto
    public String getProduto(String nome, int empresa, String atributo) throws AtributoNaoExisteException,
            ProdutoNaoEncontradoException {
        return sistema.getProduto(nome, empresa, atributo);
    }

    // Método para listar os produtos de uma empresa
    public String listarProdutos(int empresa) throws EmpresaNaoEncontradaException {
        return sistema.listarProdutos(empresa);
    }

    // Método para criar um pedido de um cliente a uma empresa
    public int criarPedido(int clienteId, int empresaId) throws DonoNaoPodePedidoException, PedidoEmAbertoException {
        return sistema.criarPedido(clienteId, empresaId);
    }

    // Método para adicionar um produto a um pedido
    public void adicionarProduto(int numero, int produto) throws NaoExistePedidoAbertoException,
            ProdutoNaoEncontradoException, ProdutoNaoPertenceEmpresaException, EmpresaNaoEncontradaException, PedidoFechadoException {
        sistema.adicionarProduto(numero, produto);
    }

    // Método para obter informações de um pedido
    public String getPedidos(int numeroPedido, String atributo) throws NaoExistePedidoAbertoException,
            AtributoInvalidoException, AtributoNaoExisteException {
        return sistema.getPedidos(numeroPedido, atributo);
    }

    // Método para fechar um pedido
    public void fecharPedido(int numeroPedido) throws PedidoNaoEncontradoException {
        sistema.fecharPedido(numeroPedido);
    }

    // Método para remover um produto de um pedido
    public void removerProduto(int numeroPedido, String nomeProduto) throws PedidoNaoEncontradoException,
            ProdutoNaoEncontradoException, ProdutoInvalidoException, RemoverProdutoPedidoFechadoException {
        sistema.removerProduto(numeroPedido, nomeProduto);
    }

    // Método para obter o número de um pedido de um cliente
    public int getNumeroPedido(int clienteId, int empresaId, int indice) {
        return sistema.getNumeroPedido(clienteId, empresaId, indice);
    }

    // Método para liberar um pedido para entrega
    public void liberarPedido(int numero) throws PedidoNaoEncontradoException, PedidoJaLiberadoException, NaoEhPossivelLiberarException {
        sistema.liberarPedido(numero);
    }

    // Método para obter um pedido associado a um entregador
    public int obterPedido(int idEntregador) throws NaoExistePedidoEntregaException, UsuarioNaoEntregadorDoisException
            , EntregadorSemEmpresaException {
        return sistema.obterPedido(idEntregador);
    }

    // Método para criar uma entrega associada a um pedido e entregador
    public int criarEntrega(int idPedido, int idEntregador, String destino) throws PedidoNaoEncontradoException,
            UsuarioNaoEntregadorException, EntregadorNaoValidoException, PedidoNaoProntoException, EntregadorEmEntregaException {
        return sistema.criarEntrega(idPedido, idEntregador, destino);
    }

    // Método para obter informações de uma entrega
    public String getEntrega(int id, String atributo) throws EntregadorEmEntregaException, AtributoInvalidoException, IOException, ClassNotFoundException, AtributoNaoExisteException {
        return sistema.getEntrega(id, atributo);
    }

    // Método para obter o ID da entrega associada a um pedido
    public int getIdEntrega(int pedido) throws PedidoNaoEncontradoException {
        return sistema.getIdEntrega(pedido);
    }

    // Método para marcar uma entrega como realizada
    public void entregar(int idEntrega) throws EntregadorEmEntregaException, PedidoNaoEncontradoException {
        // Recupera o objeto de entrega e realiza a entrega
        sistema.entregar(idEntrega);
    }

    // Método para encerrar o sistema, realizando as operações necessárias para fechar corretamente
    public void encerrarSistema() throws IOException {
        sistema.encerrarSistema();
    }
}