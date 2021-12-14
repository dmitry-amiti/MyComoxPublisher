package il.telaviv.repositories;

import il.telaviv.models.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ValueRepository extends JpaRepository<Value, Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into value(timestamp, value, engine_id, tool_id) " +
                               "values (?1,?2,?3,?4)", nativeQuery = true)
    Integer addNewValue(Long ts, Double value, Long eng_id, Long tool_id);


//    @Transactional
//    @Modifying
//    @Query(value = "update tool set critical_value = ?2 where tool.name = ?1", nativeQuery = true)
//    Integer updateCriticalByToolName(String toolName, Double criticalValue);
}
