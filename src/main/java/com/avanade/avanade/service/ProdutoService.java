package com.avanade.avanade.service;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import com.avanade.avanade.dto.ProdutoDTO;
import com.avanade.avanade.entity.Produto;
import com.avanade.avanade.repository.ProdutoRepository;


@Service
public class ProdutoService {
    
    private ProdutoRepository repository;
    public ProdutoService(ProdutoRepository repository){
        this.repository = repository;
    }


    public ProdutoDTO create(ProdutoDTO dto) {
        Produto categoria = new Produto(dto);
        categoria = this.repository.save(categoria);
        return categoria.dto();
    }


    public ProdutoDTO getOne(Long id) {
        Optional<Produto> produtoOp = this.repository.findById(id);
        if (produtoOp.isPresent()) {
            return produtoOp.get().dto();
        }

        throw new EntityNotFoundException();
    }


    public List<ProdutoDTO> getAll() {
        return this.repository.findAll().stream().map(categoria -> categoria.dto()).toList();
    }

    public ProdutoDTO edit(ProdutoDTO dto, Long id) {
        Produto categoria = new Produto(dto, id);
        categoria = this.repository.save(categoria);
        return categoria.dto();
    }

    public void delete(Long id) {
        this.repository.deleteById(id);

    }
}
