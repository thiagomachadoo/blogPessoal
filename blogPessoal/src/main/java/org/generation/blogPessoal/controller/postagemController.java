package org.generation.blogPessoal.controller;

import org.generation.blogPessoal.repository.PostagemRepository;
import org.generation.blogPessoal.model.Postagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
        return  ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
    }
    @PostMapping //INSERÇÃO
    public ResponseEntity<Postagem> post (@RequestBody Postagem postagem){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
    }
    @PutMapping //ATUALIZAÇÃO
    public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
    }
    @DeleteMapping("/{id}") //
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }
}
