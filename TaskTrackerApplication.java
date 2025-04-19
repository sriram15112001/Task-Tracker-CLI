import TaskTracker.CreateUpdateTasks;
import TaskTracker.WriteTask;

public class TaskTrackerApplication {
    public static void main(String[] args) {
        CreateUpdateTasks createUpdateTasks = new CreateUpdateTasks(new WriteTask());
        switch (args[0]){
            case "add":
                createUpdateTasks.createTask(args[1]);
                break;
            case "update":
                createUpdateTasks.updateTask(Integer.parseInt(args[1]), args[2]);
                break;
            case "delete":
                createUpdateTasks.deleteTask(Integer.parseInt(args[1]));
                break;
        }
    }
}
