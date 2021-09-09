package br.com.axellbrendow.springwebmvc.api;

import br.com.axellbrendow.springwebmvc.model.Jedi;
import br.com.axellbrendow.springwebmvc.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class JediResource {
    @Autowired
    private JediService service;

    @GetMapping("/api/jedi")
    public List<Jedi> getAll() {
        return service.findAll();
    }

    @GetMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/api/jedi")
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi create(@Valid @RequestBody Jedi jedi) {
        return service.save(jedi);
    }

    @PutMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> update(@PathVariable("id") Long id, @Valid @RequestBody Jedi jedi) {
        return ResponseEntity.ok(service.update(id, jedi));
    }

    @DeleteMapping("/api/jedi/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
