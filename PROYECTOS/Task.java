public class Task {
    private int id;
    private String description;
    private boolean done;

    public Task(int id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public int getId() { return id; }
    public String getDescription() { return description; }
    public boolean isDone() { return done; }

    public void setDescription(String description) { this.description = description; }
    public void setDone(boolean done) { this.done = done; }

    @Override
    public String toString() {
        return String.format("[%s] %d: %s", (done ? "x" : " "), id, description);
    }

    // Representación simple para guardar en archivo: id|done|description
    public String toFileString() {
        return id + "|" + (done ? "1" : "0") + "|" + description.replace("\n", " ");
    }

    public static Task fromFileString(String line) {
        String[] parts = line.split("\\|", 3);
        if (parts.length < 3) return null;
        try {
            int id = Integer.parseInt(parts[0]);
            boolean done = parts[1].equals("1");
            String desc = parts[2];
            return new Task(id, desc, done);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
//Gestor de tareas 
