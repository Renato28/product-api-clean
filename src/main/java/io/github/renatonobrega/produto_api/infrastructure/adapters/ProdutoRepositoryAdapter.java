package io.github.renatonobrega.produto_api.infrastructure.adapters;

import io.github.renatonobrega.produto_api.core.entities.Produto;
import io.github.renatonobrega.produto_api.core.gateway.ProdutoGateway;
import io.github.renatonobrega.produto_api.infrastructure.persistence.ProdutoEntity;
import io.github.renatonobrega.produto_api.infrastructure.persistence.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProdutoRepositoryAdapter implements ProdutoGateway {

    private final ProdutoRepository produtoRepository;
    private final ProdutoEntityMapper produtoEntityMapper;

    @Override
    public Produto cadastrar(Produto produto) {
        ProdutoEntity entity = produtoEntityMapper.toEntity(produto);
        ProdutoEntity novoProduto = produtoRepository.save(entity);
        return produtoEntityMapper.toProduto(novoProduto);
    }

    @Override
    public Produto buscarPorId(Long id) {
        ProdutoEntity produtoEntity = produtoRepository.getReferenceById(id);
        return produtoEntityMapper.toProduto(produtoEntity);
    }

    @Override
    public Produto buscarPorNome(String nome) {
        ProdutoEntity produtoEntity = produtoRepository.findByNome(nome);
        return produtoEntityMapper.toProduto(produtoEntity);
    }

    @Override
    public List<Produto> listar() {
        return produtoRepository
                .findAll()
                .stream()
                .map(produtoEntityMapper::toProduto)
                .collect(Collectors.toList());
    }
}
