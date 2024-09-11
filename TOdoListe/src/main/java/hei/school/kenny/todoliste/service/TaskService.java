package hei.school.kenny.todoliste.service;

import hei.school.kenny.todoliste.DAO.AddTaskDAO;
import hei.school.kenny.todoliste.DAO.SearchTaskByStateDAO;
import hei.school.kenny.todoliste.DAO.TaskDAO;
import hei.school.kenny.todoliste.DAO.TaskByID_DAO;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskDAO taskDAO;
    private final TaskByID_DAO taskByID_DAO;
    private final AddTaskDAO addTaskDAO;
    private final SearchTaskByStateDAO searchTaskByStateDAO;

    public TaskService(
            TaskDAO taskDAO,
            TaskByID_DAO taskByID_DAO,
            AddTaskDAO addTaskDAO,
            SearchTaskByStateDAO searchTaskByStateDAO
    ) {
        this.taskDAO = taskDAO;
        this.taskByID_DAO = taskByID_DAO;
        this.addTaskDAO = addTaskDAO;
        this.searchTaskByStateDAO = searchTaskByStateDAO;
    }

    public JSONArray getAllTasks() {
        return taskDAO.fetchAllTasks();
    }

    public JSONArray getTaskByID(int idToFind) {
        return taskByID_DAO.fetchTaskByID(idToFind);
    }

    public String addTask(int idToAdd, String nameToAdd, String stateToAdd) {
        return addTaskDAO.addTask(idToAdd, nameToAdd, stateToAdd);
    }

    public JSONArray searchTaskByState(String stateToSearch) {
        return searchTaskByStateDAO.fetchTaskByState(stateToSearch);
    }
}


