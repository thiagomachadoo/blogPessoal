package org.generation.blogPessoal.repository;

import org.generation.blogPessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemaInfo extends JpaRepository<Tema, Long> {
    public List<Tema> findallByDescricaoContainsIgnoreCase(String descricao);
}
