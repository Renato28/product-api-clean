package io.github.renatonobrega.produto_api.core.usecases;

import io.github.renatonobrega.produto_api.core.entities.Produto;
import io.github.renatonobrega.produto_api.core.gateway.ProdutoGateway;

import java.util.List;

public class ListarProdutosUseCaseImpl implements ListarProdutosUseCase {

    private final ProdutoGateway produtoGateway;

    public ListarProdutosUseCaseImpl(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    @Override
    public List<Produto> execute() {
        return produtoGateway.listar();
    }
}
