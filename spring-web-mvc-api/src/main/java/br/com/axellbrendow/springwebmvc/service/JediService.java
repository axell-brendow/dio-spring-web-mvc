package br.com.axellbrendow.springwebmvc.service;

import br.com.axellbrendow.springwebmvc.exceptions.NotFoundException;
import br.com.axellbrendow.springwebmvc.model.Jedi;
import br.com.axellbrendow.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JediService {
    @Autowired
    private JediRepository repository;

    public List<Jedi> findAll() {
        return repository.findAll();
    }

    public Jedi findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Jedi save(Jedi jedi) {
        return repository.save(jedi);
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }

    public Jedi update(Long id, Jedi jedi) {
        var jediOnDb = findById(id);
        jediOnDb.setName(jedi.getName());
        jediOnDb.setLastName(jedi.getLastName());
        return save(jediOnDb);
    }
}
