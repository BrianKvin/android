import java.util.UUID;


// recording class
public class Recording {

    private String id;
    private String media;
    private double length;
    private String closedCaptioning;

    // Constructor for creating a recording with ID, media, and length
    public Recording(String media, double length) {
        this.id = UUID.randomUUID().toString();
        this.media = media;
        this.length = length;
        this.closedCaptioning = null; // Initially set to null, to be updated after processing
    }

    // Getter methods

    public String getId() {
        return id;
    }

    public String getMedia() {
        return media;
    }

    public double getLength() {
        return length;
    }

    public String getClosedCaptioning() {
        return closedCaptioning;
    }

    // Setter method for updating closed captioning
    public void setClosedCaptioning(String closedCaptioning) {
        this.closedCaptioning = closedCaptioning;
    }

    @Override
    public String toString() {
        return "Recording{" +
                "id=" + id +
                ", media='" + media + '\'' +
                ", length=" + length +
                ", closedCaptioning='" + closedCaptioning + '\'' +
                '}';
    }

    public static void main(String[] args) {
        // Create a recording with ID, media, and length
        UUID id = UUID.randomUUID();
        Recording recording1 = new Recording("Video", 10.5);

        // Print the details of the recording
        System.out.println("Recording 1 Details:");
        System.out.println(recording1.toString());

        // Get and print individual attributes of the recording
        System.out.println("Recording ID: " + recording1.getId());
        System.out.println("Media: " + recording1.getMedia());
        System.out.println("Length: " + recording1.getLength());
        System.out.println("Closed Captioning: " + recording1.getClosedCaptioning());

        // Set closed captioning for the recording
        recording1.setClosedCaptioning("This is the closed captioning for the recording");

        // Print the recording details after setting closed captioning
        System.out.println("Recording 1 Details After Setting Closed Captioning:");
        System.out.println(recording1.toString());
        System.out.println("Closed Captioning: " + recording1.getClosedCaptioning());
    }
}