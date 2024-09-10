package hei.school.kenny.todoliste.service;

import hei.school.kenny.todoliste.DAO.TaskDAO;
import hei.school.kenny.todoliste.DAO.TaskByID_DAO;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskDAO taskDAO;
    private final TaskByID_DAO taskByID_DAO;

    public TaskService(TaskDAO taskDAO, TaskByID_DAO taskByID_DAO) {
        this.taskDAO = taskDAO;
        this.taskByID_DAO = taskByID_DAO;
    }

    public JSONArray getAllTasks() {
        return taskDAO.fetchAllTasks();
    }

    public JSONArray getTaskByID(int idToFind) {
        return taskByID_DAO.fetchTaskByID(idToFind);
    }
}
