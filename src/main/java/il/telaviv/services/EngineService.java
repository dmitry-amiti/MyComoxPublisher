package il.telaviv.services;


import il.telaviv.repositories.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineService {

    @Autowired
    private EngineRepository engineRepository;

    public List<String> getAllEnginesNames() {
        return engineRepository.getEnginesNames();
    }


}
