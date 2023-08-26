package com.avanade.avanade.dto;

public record ItemPedidoDTO(Long idPedido,
                         Long idProduto,
                         Long idItemPedido,
                         Integer quantidade,
                         Double precounitario,
                         Double precototal) {
    
}
