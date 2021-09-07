package br.com.axellbrendow.springwebmvc.repository;

import br.com.axellbrendow.springwebmvc.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {
    public List<Jedi> getAllJedi() {
        final var jedis = new ArrayList<Jedi>();
        jedis.add(new Jedi("Luke", "Skywalker"));
        return jedis;
    }
}
