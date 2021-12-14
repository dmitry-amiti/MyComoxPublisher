package il.telaviv.controllers;


import il.telaviv.services.ActiveEnginesArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@CrossOrigin
@Controller
public class ActiveEnginesController {

    @Autowired
    private ActiveEnginesArray activeEnginesArray;

    @PostMapping("/change_array")                          /// CHANGE ACTIVE ENGINES ARRAY ///
    @ResponseBody
    public String changeArray(@RequestBody Map<String, List<String>> map) {
        activeEnginesArray.setActiveEngines(map.get("arr"));
        return map.toString();
    }

}
