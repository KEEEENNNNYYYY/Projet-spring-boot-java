package hei.school.kenny.todoliste.Controller;

import hei.school.kenny.todoliste.Models.AllTasks;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllTasksController {
    @GetMapping("/Alltasks")
    public StringBuilder getAllTask(){
        AllTasks allTasks = new AllTasks();
        return new StringBuilder(allTasks.fetchTasks());
    }
}
