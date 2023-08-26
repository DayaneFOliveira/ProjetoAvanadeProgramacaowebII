package com.avanade.avanade.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.avanade.avanade.dto.EnderecoDTO;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Endereco")
public class Endereco {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long idnumero;
  private String cep;
  private String bairro;
  private String rua;
 

  @ManyToMany(mappedBy = "endereco")
  private List<Pessoa> pessoas;

  public Endereco(EnderecoDTO dto) {
    this.cep = dto.cep();
    this.rua = dto.rua();
    this.bairro = dto.bairro();
  
  }

public Object dto() {
    return null;
}
}