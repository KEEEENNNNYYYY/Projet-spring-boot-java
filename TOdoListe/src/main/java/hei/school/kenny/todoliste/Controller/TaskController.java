package hei.school.kenny.todoliste.Controller;

import hei.school.kenny.todoliste.service.TaskService;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<String> getAllTasks() {
        JSONArray tasksArray = taskService.getAllTasks();
        return new ResponseEntity<>(tasksArray.toString(2), HttpStatus.OK);
    }

    @GetMapping("/task/{idToFind}")
    public ResponseEntity<String> getTaskByID(@PathVariable int idToFind) {
        JSONArray tasksArray = taskService.getTaskByID(idToFind);
        return new ResponseEntity<>(tasksArray.toString(2), HttpStatus.OK);
    }

    @PostMapping("/task/add/{idToAdd}/{nameToAdd}/{stateToAdd}")
    public String addTask(@PathVariable int idToAdd,
                          @PathVariable String nameToAdd,
                          @PathVariable String stateToAdd) {
        return taskService.addTask(idToAdd, nameToAdd, stateToAdd);
    }

    @GetMapping("/task/search/{stateToSearch}")
    public ResponseEntity<String> searchTaskByState(@PathVariable String stateToSearch) {
        JSONArray tasksArray = taskService.searchTaskByState(stateToSearch);
        return new ResponseEntity<>(tasksArray.toString(), HttpStatus.OK);
    }
}
