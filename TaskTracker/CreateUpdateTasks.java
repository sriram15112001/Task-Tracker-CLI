package TaskTracker;

import java.time.LocalDateTime;
import java.util.List;

public class CreateUpdateTasks {
    private final WriteTask writeTask;

    public CreateUpdateTasks(WriteTask writeTask) {
        this.writeTask = writeTask;
    }

    public int createTask(String taskName) {
        int currentTaskCount = writeTask.totalTasks();
        Task task = new Task(currentTaskCount + 1, taskName, Status.TODO.getStatus(), LocalDateTime.now(), LocalDateTime.now());
        List<Task> currentTasks = writeTask.readTasks();
        currentTasks.add(task);
        writeTask.writeTask(currentTasks);
        return currentTaskCount + 1;
    }

    public boolean updateTask(int taskId, String taskName) {
        List<Task> currentTasks = writeTask.readTasks();
        boolean taskUpdated = false;
        for(Task task: currentTasks) {
            if(task.getTaskId() == taskId) {
                task.setTaskName(taskName);
                task.setUpdatedAt(LocalDateTime.now());
                taskUpdated = true;
            }
        }
        writeTask.writeTask(currentTasks);
        return taskUpdated;
    }

    public void deleteTask(int taskId) {
        List<Task> currentTasks = writeTask.readTasks();
        List<Task> remainingTask = currentTasks.stream().filter(task -> task.getTaskId() != taskId).toList();
        writeTask.writeTask(remainingTask);
    }

    public boolean updateStatus(int taskId, Status status) {
        List<Task> currentTasks = writeTask.readTasks();
        boolean statusUpdate = false;
        for(Task task: currentTasks) {
            if(task.getTaskId() == taskId) {
                task.setUpdatedAt(LocalDateTime.now());
                task.setStatus(status.getStatus());
                statusUpdate = true;
            }
        }
        writeTask.writeTask(currentTasks);
        return statusUpdate;
    }

}
