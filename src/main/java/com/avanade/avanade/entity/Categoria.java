package com.avanade.avanade.entity;

import com.avanade.avanade.dto.CategoriaDTO;

import jakarta.persistence.*;
import lombok.Data;
/* import lombok.Getter;
import lombok.Setter; */
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao;
    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;

    public Categoria(CategoriaDTO dto){
        this.nome = dto.nome();
        this.descricao = dto.descricao();
    }

    public Categoria(CategoriaDTO dto, Long id){
        this(dto);
        this.id = id;
    }

    public CategoriaDTO dto(){
        return new CategoriaDTO(this.id,this.nome,this.descricao);
    }
}
