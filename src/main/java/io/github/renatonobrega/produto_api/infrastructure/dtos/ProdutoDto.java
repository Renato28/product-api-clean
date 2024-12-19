package io.github.renatonobrega.produto_api.infrastructure.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDto(@NotBlank String nome, @NotBlank String descricao, @NotNull Double preco) {
}
