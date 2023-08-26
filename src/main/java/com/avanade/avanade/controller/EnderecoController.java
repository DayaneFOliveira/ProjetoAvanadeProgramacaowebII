package com.avanade.avanade.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.avanade.avanade.dto.EnderecoDTO;
import com.avanade.avanade.service.EnderecoService;

public class EnderecoController {
  private EnderecoService service;

    public EnderecoController(EnderecoService service){
        this.service = service;
    }


    @GetMapping("/{id}")
    public Object UsergetOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping("filter")
    public List<EnderecoDTO> getAll(
        @RequestBody EnderecoDTO body) {
        return service.getAll(body);
    }

    @PutMapping("/{id}")
    public EnderecoDTO edit(@RequestBody EnderecoDTO body, @PathVariable Long id) {
        return service.edit(body, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
