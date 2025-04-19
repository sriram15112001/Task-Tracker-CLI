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
            case "list":
                if(args.length == 1) {
                    createUpdateTasks.listTasks(null);
                } else {
                    switch (args[1]){
                        case "done":
                            createUpdateTasks.listTasks(Status.DONE);
                            break;
                        case "todo":
                            createUpdateTasks.listTasks(Status.TODO);
                            break;
                        case "in-progress":
                            createUpdateTasks.listTasks(Status.IN_PROGRESS);
                            break;
                    }
                }

        }
    }
}
