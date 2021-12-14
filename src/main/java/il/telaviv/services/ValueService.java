package il.telaviv.services;

import il.telaviv.models.Engine;
import il.telaviv.repositories.EngineRepository;
import il.telaviv.repositories.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@EnableScheduling
public class ValueService {

    @Autowired
    private EngineRepository engineRepository;

    @Autowired
    private ValueRepository valueRepository;

    @Autowired
    private ActiveEnginesArray activeEnginesArray;


    @Scheduled(fixedRate = 1000, initialDelay = 5000)
    public void addRandomValue() {
        List<Engine> engines = engineRepository.findAll();
        List<Integer> results = new ArrayList<>();
        Integer res;
        double valueTemp = 0;
        double valueAcc = 0;
        double valueMagn = 0;

        for (Engine engine : engines) {                                                // перебираем все моторы из базы
            if (activeEnginesArray.getActiveEngines().contains(engine.getName())) {    // если мотор активен
                valueTemp = (double) ThreadLocalRandom.current().nextInt(90) / 10 + 20;
                valueAcc = (double) ThreadLocalRandom.current().nextInt(30) / 10 + 2;
                valueMagn = (double) ThreadLocalRandom.current().nextInt(700) / 10 + 100;

                try {
                    res = valueRepository.addNewValue(System.currentTimeMillis(), valueTemp, engine.getId(), 1L);
                    results.add(res);
                    res = valueRepository.addNewValue(System.currentTimeMillis(), valueAcc, engine.getId(), 2L);
                    results.add(res);
                    res = valueRepository.addNewValue(System.currentTimeMillis(), valueMagn, engine.getId(), 3L);
                    results.add(res);
                } catch (Exception ignored) {
                }
                System.out.println("Engine: " + engine + " | " + valueTemp + " | " + valueAcc + " | " + valueMagn);
            }
        }
        System.out.println(results.size());
    }


//    @Scheduled(fixedRate = 1000, initialDelay = 5000)
//    public void timer() {
//        System.out.println(enginesArray.getEngines());
//    }


}
