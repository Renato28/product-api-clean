package io.github.renatonobrega.produto_api.core.usecases;

import io.github.renatonobrega.produto_api.core.entities.Produto;
import io.github.renatonobrega.produto_api.core.gateway.ProdutoGateway;

public class BuscarProdutoPeloNomeUseCaseImpl implements BuscarProdutoPeloNomeUseCase{

    private final ProdutoGateway produtoGateway;

    public BuscarProdutoPeloNomeUseCaseImpl(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    @Override
    public Produto execute(String nome) {
        return produtoGateway.buscarPorNome(nome);
    }
}
