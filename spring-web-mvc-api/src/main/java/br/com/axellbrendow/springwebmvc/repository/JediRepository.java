package br.com.axellbrendow.springwebmvc.repository;

import java.util.List;

import br.com.axellbrendow.springwebmvc.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Long> {

    List<Jedi> findByNameContainingIgnoreCase(final String name);
}
