package hei.school.kenny.todoliste.Controller;

import hei.school.kenny.todoliste.service.TaskService;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String getAllTasks() {
        JSONArray tasksArray = taskService.getAllTasks();
        return tasksArray.toString(2);
    }

    @GetMapping("/task/{idToFind}")
    public String getTaskByID(@PathVariable int idToFind) {
        JSONArray tasksArray = taskService.getTaskByID(idToFind);
        return tasksArray.toString(2);
    }
}
