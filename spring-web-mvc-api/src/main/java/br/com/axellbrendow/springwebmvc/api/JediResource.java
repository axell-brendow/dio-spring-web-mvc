package br.com.axellbrendow.springwebmvc.api;

import br.com.axellbrendow.springwebmvc.exceptions.NotFoundException;
import br.com.axellbrendow.springwebmvc.model.Jedi;
import br.com.axellbrendow.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
