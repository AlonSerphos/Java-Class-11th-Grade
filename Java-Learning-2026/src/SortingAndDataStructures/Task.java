package SortingAndDataStructures;

public class Task {
    private int priority;
    private int timestamp;

    public Task(int priority, int timestamp) {
        this.priority = priority;
        this.timestamp = timestamp;
    }

    public int getPriority() {
        return priority;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return priority + " " + timestamp;
    }
}