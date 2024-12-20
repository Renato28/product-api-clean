package io.github.renatonobrega.produto_api.infrastructure.controllers;

import io.github.renatonobrega.produto_api.core.entities.Produto;
import io.github.renatonobrega.produto_api.core.usecases.BuscarProdutoPeloIdUseCase;
import io.github.renatonobrega.produto_api.core.usecases.BuscarProdutoPeloNomeUseCase;
import io.github.renatonobrega.produto_api.core.usecases.CadastrarProdutoUseCase;
import io.github.renatonobrega.produto_api.core.usecases.ListarProdutosUseCase;
import io.github.renatonobrega.produto_api.infrastructure.dtos.ProdutoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

    private final CadastrarProdutoUseCase cadastrarProdutoUseCase;
    private final BuscarProdutoPeloIdUseCase buscarProdutoPeloIdUseCase;
    private final BuscarProdutoPeloNomeUseCase buscarProdutoPeloNomeUseCase;
    private final ListarProdutosUseCase listarProdutosUseCase;
    private final ProdutoDtoMapper produtoDtoMapper;

    public ProdutoController(CadastrarProdutoUseCase cadastrarProdutoUseCase,
                             BuscarProdutoPeloIdUseCase buscarProdutoPeloIdUseCase,
                             BuscarProdutoPeloNomeUseCase buscarProdutoPeloNomeUseCase,
                             ListarProdutosUseCase listarProdutosUseCase,
                             ProdutoDtoMapper produtoDtoMapper) {
        this.cadastrarProdutoUseCase = cadastrarProdutoUseCase;
        this.buscarProdutoPeloIdUseCase = buscarProdutoPeloIdUseCase;
        this.buscarProdutoPeloNomeUseCase = buscarProdutoPeloNomeUseCase;
        this.listarProdutosUseCase = listarProdutosUseCase;
        this.produtoDtoMapper = produtoDtoMapper;
    }

    @PostMapping
    public ProdutoDto cadastrarProduto(@RequestBody @Valid ProdutoDto produtoDto) {
        Produto novoProduto = cadastrarProdutoUseCase.execute(produtoDtoMapper.toDomain(produtoDto));
        return produtoDtoMapper.toDto(novoProduto);
    }

    @GetMapping("/{id}")
    public ProdutoDto buscarProdutoPorId(@NotNull @PathVariable Long id) {
        Produto produtoEncontrado = buscarProdutoPeloIdUseCase.execute(id);
        return produtoDtoMapper.toDto(produtoEncontrado);
    }

    @GetMapping("/{nome}")
    public ProdutoDto buscarProdutoPeloNome(@PathVariable String nome) {
        Produto produtoEncontrado = buscarProdutoPeloNomeUseCase.execute(nome);
        return produtoDtoMapper.toDto(produtoEncontrado);
    }

    @GetMapping
    public List<ProdutoDto> listarProdutos() {
        return listarProdutosUseCase.execute()
                .stream()
                .map(produtoDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
