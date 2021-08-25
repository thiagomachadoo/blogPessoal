package org.generation.blogPessoal.controller;

import org.generation.blogPessoal.PostagemRepository;
import org.generation.blogPessoal.model.Postagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class postagemController {
    @Autowired
    private PostagemRepository repository;

    @GetMapping
    public ResponseEntity<List<Postagem>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Postagem> GetById(@PathVariable long id){
        return repository.findById(id)

                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());

    }
}
