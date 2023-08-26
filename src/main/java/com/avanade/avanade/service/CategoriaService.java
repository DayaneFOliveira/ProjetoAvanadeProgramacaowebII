package com.avanade.avanade.service;

import java.util.List;
import java.util.Optional;

import com.avanade.avanade.repository.CategoriaFilterRepository;
import org.springframework.stereotype.Service;

import com.avanade.avanade.dto.CategoriaDTO;
import com.avanade.avanade.entity.Categoria;
import com.avanade.avanade.repository.CategoriaRepository;


@Service
public class CategoriaService {
    
    private CategoriaRepository repository;
    private CategoriaFilterRepository filterRepository;

    public CategoriaService(CategoriaRepository repository, CategoriaFilterRepository filterRepository) {
        this.repository = repository;
        this.filterRepository = filterRepository;
    }

    public CategoriaDTO create(CategoriaDTO dto) {
        Categoria categoria = new Categoria(dto);
        categoria = this.repository.save(categoria);
        return categoria.dto();
    }


    public CategoriaDTO getOne(Long id) {
        Optional<Categoria> categoriaOp = this.repository.findById(id);
        return categoriaOp.get().dto();
    }


    public List<CategoriaDTO> getAll(CategoriaDTO dto) {
        return this.filterRepository.filter(dto).stream().map(categoria -> categoria.dto()).toList();
    }

    public CategoriaDTO edit(CategoriaDTO dto, Long id) {
        Categoria categoria = new Categoria(dto, id);
        categoria = this.repository.save(categoria);
        return categoria.dto();
    }

    public void delete(Long id) {
        this.repository.deleteById(id);

    }
}
