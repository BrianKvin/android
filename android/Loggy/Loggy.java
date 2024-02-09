import java.util.UUID;



// 2. Log class
class Log {
    private String id;
    private String name;
    private String description;
    private String date;
    private String shortCode;

    // Constructor  -> create
    public Log(String name, String description, String date) {
        this.id = UUID.randomUUID().toString(); // Unique ID
        this.name = name;
        this.description = description;
        this.date = date;
        this.shortCode = UUID.randomUUID().toString();
    }

    // Constructor for creating a log with only the name
    public Log(String name) {
        this(name, null, null);
    }

    // Constructor for creating a log with name and description
    public Log(String name, String description) {
        this(name, description, null);
    }

    // constructor with none
    public Log() {
        this(null, null, null);
    }  

    // Mockup methods  

    public void update(String newName, String newDescription, String newDate) {
        this.name = newName;
        this.description = newDescription;
        this.date = newDate;
    }

    public void delete() {
        this.name = null;
        this.description = null;
        this.date = null;
        this.id = null;
        this.shortCode = null;
    }

    // Getter methods -> read

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getShortCode() {
        return shortCode;
    }

    // Mockup method for creating a log
    public static Log createLog(String name, String description, String date) {
        Log newLog = new Log(name, description, date);
        System.out.println("Log created successfully:\n" + newLog);
        return newLog;
    }

    // Mockup method for reading a log
    public static void readLog(Log log) {
        System.out.println("Reading log:\n" + log);
    }

    // Mockup method for updating a log
    public void updateLog(String newName, String newDescription, String newDate) {
        update(newName, newDescription, newDate);
        System.out.println("Log updated successfully:\n" + this.toString());
    }

    // Mockup method for deleting a log
    public static void deleteLog(Log log) {
        System.out.println("Log deleted successfully:\n" + log);
    }

    @Override
        public String toString() {
            return "Log{" +
                    "internalId=" + id +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", date='" + date + '\'' +
                    ", shortCode='" + shortCode + '\'' +
                    '}';
    }


    public static void main(String[] args) {
    // Create logs using different constructors
        Log log1 = new Log("Meeting", "Team discussion", "2024-02-09");
        Log log2 = new Log("Meeting", "Team discussion");
        Log log3 = new Log("Meeting", "2024-02-09");
        Log log4 = new Log();

        // Read logs
        System.out.println(log1.toString());
        System.out.println(log2.toString());
        System.out.println(log3.toString());
        System.out.println(log4.toString());

        // Update log
        log1.update("Project Update", "Team progress meeting", "2024-02-10");
        System.out.println("Updated log: " + log1.toString());

        // Delete log
        log1.delete();
        System.out.println("Log deleted");
    }
}

