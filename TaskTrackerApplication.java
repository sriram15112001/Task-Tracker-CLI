import TaskTracker.CreateUpdateTasks;
import TaskTracker.Status;
import TaskTracker.WriteTask;

public class TaskTrackerApplication {
    public static void main(String[] args) {
        CreateUpdateTasks createUpdateTasks = new CreateUpdateTasks(new WriteTask());
        switch (args[0]){
            case "add":
                int taskId = createUpdateTasks.createTask(args[1]);
                System.out.println("Task added successfully (ID: " + taskId + ")");
                break;
            case "update":
                createUpdateTasks.updateTask(Integer.parseInt(args[1]), args[2]);
                break;
            case "delete":
                createUpdateTasks.deleteTask(Integer.parseInt(args[1]));
                break;
            case "mark-in-progress":
                createUpdateTasks.updateStatus(Integer.parseInt(args[1]), Status.IN_PROGRESS);
                break;
            case "mark-done":
                createUpdateTasks.updateStatus(Integer.parseInt(args[1]), Status.DONE);
                break;
        }
    }
}
