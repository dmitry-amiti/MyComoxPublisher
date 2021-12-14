package il.telaviv.services;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Data
@Component
public class ActiveEnginesArray {
    private List<String> activeEngines = new CopyOnWriteArrayList<>();
}
