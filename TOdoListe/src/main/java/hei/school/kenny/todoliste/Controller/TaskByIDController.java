package hei.school.kenny.todoliste.Controller;

import hei.school.kenny.todoliste.Models.TaskByID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskByIDController {
    @GetMapping("/task/{idToFind}")
    public String GetTaskByID(@PathVariable int idToFind){
        TaskByID allTasks = new TaskByID();
        return allTasks.fetchTasks(idToFind);
    }
}
