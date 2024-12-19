package io.github.renatonobrega.produto_api.core.usecases;

import io.github.renatonobrega.produto_api.core.entities.Produto;

import java.util.List;

public interface ListarProdutosUseCase {

    List<Produto> execute();
}
