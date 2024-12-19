package io.github.renatonobrega.produto_api.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
    ProdutoEntity findByNome(String nome);
}
