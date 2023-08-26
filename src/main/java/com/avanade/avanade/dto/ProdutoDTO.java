package com.avanade.avanade.dto;

public record ProdutoDTO(Long id,
                         String nome,
                         Integer estoque,
                         Double preco,
                         CategoriaDTO categoria) {
      

}
