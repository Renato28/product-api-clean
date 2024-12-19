package io.github.renatonobrega.produto_api.infrastructure.controllers;

import io.github.renatonobrega.produto_api.core.entities.Produto;
import io.github.renatonobrega.produto_api.infrastructure.dtos.ProdutoDto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoDtoMapper {

    public ProdutoDto toDto(Produto produto) {
        return new ProdutoDto(produto.nome(), produto.descricao(), produto.preco());
    }

    public Produto toDomain(ProdutoDto produtoDto) {
        return new Produto(null, produtoDto.nome(), produtoDto.descricao(), produtoDto.preco());
    }
}
