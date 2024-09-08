package hei.school.kenny.todoliste;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {
    @GetMapping("/todos")
    public String getAllTodos(){
        System.out.println("succes"); ;
        return "";
    }
}
