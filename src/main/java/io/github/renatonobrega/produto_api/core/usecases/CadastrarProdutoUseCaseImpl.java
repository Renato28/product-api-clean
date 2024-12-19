package io.github.renatonobrega.produto_api.core.usecases;

import io.github.renatonobrega.produto_api.core.entities.Produto;
import io.github.renatonobrega.produto_api.core.gateway.ProdutoGateway;

public class CadastrarProdutoUseCaseImpl implements CadastrarProdutoUseCase {

    private final ProdutoGateway produtoGateway;

    public CadastrarProdutoUseCaseImpl(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    @Override
    public Produto execute(Produto produto) {
        return produtoGateway.cadastrar(produto);
    }
}
