package io.github.renatonobrega.produto_api.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "TB_PRODUTO")
public class ProdutoEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
}
