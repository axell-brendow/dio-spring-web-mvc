package br.com.axellbrendow.springwebmvc.repository;

import br.com.axellbrendow.springwebmvc.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {
    private final List<Jedi> jedis = new ArrayList<>();

    public List<Jedi> getAllJedi() {
        return jedis;
    }

    public void add(Jedi jedi) {
        jedis.add(jedi);
    }
}
