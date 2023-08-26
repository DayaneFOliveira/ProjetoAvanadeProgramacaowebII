package com.avanade.avanade.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
/* import org.springframework.http.ResponseEntity; */
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.avanade.avanade.dto.ProdutoDTO;
import com.avanade.avanade.service.ProdutoService;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService service;
    public ProdutoController(ProdutoService service){
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public /* ResponseEntity<String> */ ProdutoDTO create(@RequestBody ProdutoDTO body) {
/*         return ResponseEntity.status(HttpStatus.CREATED).body("created " + body); */
        return service.create(body);
    }

    @GetMapping("/{id}")
    public ProdutoDTO getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @GetMapping
    public List<ProdutoDTO> getAll(
    		@RequestParam(/* required = false, */ value = "filter", defaultValue = "") String filter) {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public ProdutoDTO edit(@RequestBody ProdutoDTO body, @PathVariable Long id) {
        return service.edit(body, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}