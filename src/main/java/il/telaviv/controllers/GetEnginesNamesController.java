package il.telaviv.controllers;

import il.telaviv.services.EngineService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
public class GetEnginesNamesController {

    @Autowired
    private EngineService engineService;

    @GetMapping("/motors")                              /// GET ENGINES NAMES FROM DB ///
    @ResponseBody
    public String getAllNames() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("engines", engineService.getAllEnginesNames());
        return jsonObject.toString();
    }

}
