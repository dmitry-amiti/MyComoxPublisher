package il.telaviv.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"values"})
@Builder
@Entity
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "engine")
    private List<Value> values;

    private String name;
}
