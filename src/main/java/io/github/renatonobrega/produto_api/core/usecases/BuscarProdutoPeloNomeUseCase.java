package io.github.renatonobrega.produto_api.core.usecases;

import io.github.renatonobrega.produto_api.core.entities.Produto;

public interface BuscarProdutoPeloNomeUseCase {

    Produto execute(String nome);
}
