package TaskTracker;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteTask {

    public boolean writeTask(List<Task> taskList) {
        try(PrintWriter printWriter = new PrintWriter("tasks.txt")) {
            taskList.forEach(task -> {
                printWriter.println(
                        task.getTaskId() + "-_" + task.getTaskName() + "-_" +
                                task.getStatus() + "-_" + task.getCreatedAt() + "-_" + task.getUpdatedAt()
                        );
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Task> readTasks() {
        List<Task> tasks = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File("tasks.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split("-_");
                tasks.add(
                        new Task(Integer.parseInt(words[0]), words[1], words[2],
                                LocalDateTime.parse(words[3]), LocalDateTime.parse(words[4]))
                );
            }
        } catch (Exception e) {
            return null;
        }
        return tasks;
    }

    public int totalTasks() {
        int count = 0;
        try(Scanner scanner = new Scanner(new File("tasks.txt"))) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }
        } catch (Exception e) {
            return 0;
        }
        return count;
    }
}
