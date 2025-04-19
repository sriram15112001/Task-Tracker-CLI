package TaskTracker;

public enum Status {
    IN_PROGRESS("In Progress"),
    DONE("Done"),
    TODO("Todo");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
