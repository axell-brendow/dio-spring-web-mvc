package br.com.axellbrendow.springwebmvc.api;

import br.com.axellbrendow.springwebmvc.exceptions.NotFoundException;
import br.com.axellbrendow.springwebmvc.model.Jedi;
import br.com.axellbrendow.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
public class JediResource {
    @Autowired
    private JediRepository repository;

    @GetMapping("/api/jedi")
    public List<Jedi> getAll() {
        return repository.findAll();
    }

    @GetMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> getById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(repository.findById(id).orElseThrow(() -> new NotFoundException(id)));
        } catch (NotFoundException e) {
//            final var errors = new HashMap<String, String>();
//            errors.put("msg", e.getMessage());
            return ResponseEntity.notFound().build();
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
        }
    }

    @PostMapping("/api/jedi")
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi create(@Valid @RequestBody Jedi jedi) {
        return repository.save(jedi);
    }

    @PutMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> update(@PathVariable("id") Long id, @Valid @RequestBody Jedi jedi) {
        try {
            var jediOnDb = repository.findById(id).orElseThrow(() -> new NotFoundException(id));
            jediOnDb.setName(jedi.getName());
            jediOnDb.setLastName(jedi.getLastName());
            repository.save(jediOnDb);
            return ResponseEntity.ok(jediOnDb);
        } catch (NotFoundException e) {
//            final var errors = new HashMap<String, String>();
//            errors.put("msg", e.getMessage());
            return ResponseEntity.notFound().build();
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
        }
    }
}
