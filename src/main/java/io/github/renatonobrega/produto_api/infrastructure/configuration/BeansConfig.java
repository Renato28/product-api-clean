package io.github.renatonobrega.produto_api.infrastructure.configuration;

import io.github.renatonobrega.produto_api.core.gateway.ProdutoGateway;
import io.github.renatonobrega.produto_api.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CadastrarProdutoUseCase cadastrarProdutoUseCase(ProdutoGateway produtoGateway) {
        return new CadastrarProdutoUseCaseImpl(produtoGateway);
    }

    @Bean
    public BuscarProdutoPeloIdUseCase buscarProdutoPeloIdUseCase(ProdutoGateway produtoGateway) {
        return new BuscarProdutoPeloIdUseCaseImpl(produtoGateway);
    }

    @Bean
    public BuscarProdutoPeloNomeUseCase buscarProdutoPeloNomeUseCase(ProdutoGateway produtoGateway) {
        return new BuscarProdutoPeloNomeUseCaseImpl(produtoGateway);
    }

    @Bean
    public ListarProdutosUseCase listarProdutosUseCase(ProdutoGateway produtoGateway) {
        return new ListarProdutosUseCaseImpl(produtoGateway);
    }
}
