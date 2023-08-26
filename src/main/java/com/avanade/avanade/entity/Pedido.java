package com.avanade.avanade.entity;

import jakarta.persistence.*;
import lombok.Data;
/* import lombok.Getter;
import lombok.Setter; */
import lombok.NoArgsConstructor;

import java.util.List;

import com.avanade.avanade.dto.PedidoDTO;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPedido;
    private Long idUser;
   
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itemPedidos;

    public Pedido(PedidoDTO dto){
        this.idPedido = dto.idPedido();
        this.idUser = dto.idUser();
    }

    public Pedido(PedidoDTO dto, Long idPedido, Long idProduto, Long idUser){
        this(dto);
        this.idPedido = idPedido;
        this.idUser = idUser;
    }

    public PedidoDTO dto(){
        return new PedidoDTO(this.idPedido,this.idUser);
    }
}

