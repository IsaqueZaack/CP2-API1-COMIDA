package br.com.fiap.apiComidas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import br.com.fiap.apiComidas.model.CategoriaComida;
import br.com.fiap.apiComidas.repository.CategoriaComidaRepository;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/${api.version}/categoriaComida")
public class CategoriaComidaController {
    @Autowired
    private CategoriaComidaRepository repository;

    @PostMapping()
    public ResponseEntity<CategoriaComida> create(@RequestBody CategoriaComida categoriaComida) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoriaComida));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaComida> findById(@PathVariable Long id) {
        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CategoriaComida>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaComida> update(@PathVariable Long id,
            @RequestBody CategoriaComida categoriaComida) {

        Optional<CategoriaComida> optCategoriaComida = repository.findById(id);

        if (optCategoriaComida.isPresent()) {
            categoriaComida.setId(id);
            CategoriaComida categoriaComidaAlterada = repository.save(categoriaComida);
            return ResponseEntity.ok(categoriaComidaAlterada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByID(@PathVariable Long id, @RequestBody CategoriaComida categoriaComida) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
