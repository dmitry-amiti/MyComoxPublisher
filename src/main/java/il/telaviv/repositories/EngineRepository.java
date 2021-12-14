package il.telaviv.repositories;

import il.telaviv.models.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EngineRepository extends JpaRepository<Engine, Integer> {
    @Query(value = "select name from engine", nativeQuery = true)
    List<String> getEnginesNames();
}
