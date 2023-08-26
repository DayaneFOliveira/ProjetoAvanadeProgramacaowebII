package com.avanade.avanade.entity;

import jakarta.persistence.*;
import lombok.Data;
/* import lombok.Getter;
import lombok.Setter; */
import lombok.NoArgsConstructor;

import java.util.List;

import com.avanade.avanade.dto.ItemPedidoDTO;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Pedidos")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPedido;
    private Long idProduto;
    private Long iditemPedido;
    private Integer quantidade;
    private Double precounitario;
    private Double precototal;

    @OneToMany(mappedBy = "pedido")
    private List<Produto> produtos;

    public ItemPedido(ItemPedidoDTO dto){
          this.idPedido = dto.idItemPedido();
        this.idPedido = dto.idPedido();
        this.idProduto = dto.idProduto();
        this.quantidade = dto.quantidade();
        this.precounitario = dto.precounitario();
        this.precototal = dto.precototal();
    }

    public ItemPedido(ItemPedidoDTO dto, Long idPedido, Long idProduto){
        this(dto);
        this.idPedido = idPedido;
        this.idProduto = idProduto;
       
    }

    public ItemPedidoDTO dto(){
        return new ItemPedidoDTO(this.idPedido,this.iditemPedido,this.idProduto,this.quantidade, this.precounitario, this.precototal );
    }
}