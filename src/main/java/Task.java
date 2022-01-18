public class Task {
    protected String description;
    protected boolean isDone;

    public Task (String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return this.isDone ? "X" : " ";
    }

    public void markedDone() {
        this.isDone = true;
    }

    public void markedUndone() {
        this.isDone = false;
    }
}
