package io.github.renatonobrega.produto_api.core.gateway;

import io.github.renatonobrega.produto_api.core.entities.Produto;

import java.util.List;

public interface ProdutoGateway {

    Produto cadastrar(Produto produto);

    Produto findById(String id);

    Produto findByNome(String nome);

    List<Produto> listar();
}
