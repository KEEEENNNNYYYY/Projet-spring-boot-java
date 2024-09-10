package hei.school.kenny.todoliste.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandingController {
    @GetMapping("/")
    public String pingPong(){
        return "ping pong";
    }
}
