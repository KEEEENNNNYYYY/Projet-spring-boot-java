package hei.school.kenny.todoliste;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestTodoController {
    @GetMapping("/")
    public String pingPong(){
        return "ping pong";
    }
    @GetMapping("/todos")
    public String getAllTodos(){
        System.out.println("succes"); ;
        return "";
    }
}
