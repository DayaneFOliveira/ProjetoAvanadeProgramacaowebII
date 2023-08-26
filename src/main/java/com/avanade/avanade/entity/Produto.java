package com.avanade.avanade.entity;

import com.avanade.avanade.dto.ProdutoDTO;

import jakarta.persistence.*;
import lombok.Data;
/* import lombok.Getter;
import lombok.Setter; */
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name = "Produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Integer estoque;
    private Double preco;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
//    @ManyToMany
//    @JoinTable(name = "vendas",
//        joinColumns = @JoinColumn(name = "id_produto"),
//        inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
//    private List<Pessoa> pessoas;

    public Produto(ProdutoDTO dto){
        this.nome = dto.nome();
        this.estoque = dto.estoque();
        this.preco = dto.preco();
        this.categoria = new Categoria();
        this.categoria.setId(dto.categoria().id());
        
    }

    public Produto(ProdutoDTO dto, Long id){
        this(dto);
        this.id = id;
    }

    public ProdutoDTO dto(){
        return new ProdutoDTO(this.id,this.nome,this.estoque,this.preco, this.categoria.dto());
    }
}
