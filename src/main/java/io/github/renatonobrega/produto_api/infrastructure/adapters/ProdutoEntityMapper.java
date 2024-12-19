package io.github.renatonobrega.produto_api.infrastructure.adapters;

import io.github.renatonobrega.produto_api.core.entities.Produto;
import io.github.renatonobrega.produto_api.infrastructure.persistence.ProdutoEntity;
import org.springframework.stereotype.Component;

@Component
public class ProdutoEntityMapper {

    public ProdutoEntity toEntity(Produto produto) {
        return new ProdutoEntity(produto.id(), produto.nome(), produto.descricao(), produto.preco());
    }

    public Produto toProduto(ProdutoEntity produtoEntity) {
        return new Produto(produtoEntity.getId(), produtoEntity.getNome(), produtoEntity.getDescricao(), produtoEntity.getPreco());
    }
}
