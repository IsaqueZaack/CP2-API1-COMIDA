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

import br.com.fiap.apiComidas.model.Comida;
import br.com.fiap.apiComidas.repository.ComidaRepository;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/${api.version}/comida")
public class ComidaController {
    @Autowired
    private ComidaRepository repository;

    @PostMapping()
    public ResponseEntity<Comida> create(@RequestBody Comida comida) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(comida));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comida> findById(@PathVariable Long id) {
        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Comida>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comida> update(@PathVariable Long id,
            @RequestBody Comida comida) {

        Optional<Comida> optComida = repository.findById(id);

        if (optComida.isPresent()) {
            comida.setId(id);
            Comida comidaAlterada = repository.save(comida);
            return ResponseEntity.ok(comidaAlterada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByID(@PathVariable Long id, @RequestBody Comida comida) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
