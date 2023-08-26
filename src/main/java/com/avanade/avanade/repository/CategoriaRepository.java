package com.avanade.avanade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.avanade.avanade.entity.Categoria;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
  @Query("SELECT c FROM Categoria c WHERE c.nome = :nome")
  List<Categoria> findByNome(String nome);
  // List<Categoria> findByNome(@Param("nome") String nome);
}
