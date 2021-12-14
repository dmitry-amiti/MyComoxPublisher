package il.telaviv.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@Controller
public class MainPageController {

    @GetMapping("/main")                                // MAIN PAGE //
    public String getHome() {
        return "timerdb";
    }
}
