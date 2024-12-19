package io.github.renatonobrega.produto_api.core.usecases;

import io.github.renatonobrega.produto_api.core.entities.Produto;
import io.github.renatonobrega.produto_api.core.gateway.ProdutoGateway;

public class BuscarProdutoPeloIdUseCaseImpl implements BuscarProdutoPeloIdUseCase {

    private final ProdutoGateway produtoGateway;

    public BuscarProdutoPeloIdUseCaseImpl(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    @Override
    public Produto execute(String id) {
        return produtoGateway.buscarPorId(id);
    }
}
