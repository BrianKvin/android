import java.util.concurrent.TimeUnit;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class RecordingController {

    private final ExternalService externalService;
    private final Queue<Recording> processingQueue;
    private final ExecutorService executorService;
    private final RecordingCallback callback;

    public RecordingController(RecordingCallback callback) {
        this.externalService = new ExternalService();
        this.processingQueue = new ConcurrentLinkedQueue<>();
        this.executorService = Executors.newFixedThreadPool(5); // Maximum of 5 concurrent processes
        this.callback = callback;
    }

    public void enqueueRecording(Recording recording) {
        processingQueue.add(recording);
        System.out.println("Recording enqueued for processing: " + recording.getId());
    }

    private void processRecordings() {
            while (!processingQueue.isEmpty()) {
                Recording recording = processingQueue.poll();
                if (recording != null) {
                    executorService.submit(() -> processRecording(recording));
                }
            }
    }
    private void processRecording(Recording recording) {
            // Simulate sending the recording to an external service
            String closedCaptioning = externalService.processRecording(recording);

            // Update the recording with closed captioning
            recording.setClosedCaptioning(closedCaptioning);

            // Notify the callback
            if (callback != null) {
                callback.onRecordingProcessed(recording);
            }
    }

    public void shutdown() {
            executorService.shutdown();
    }


    // public static void main(String[] args) {
    //     // Create an instance of the callback implementation
    //     MyRecordingCallback callback = new MyRecordingCallback();

    //     // Create a new recording controller with the callback instance
    //     RecordingController controller = new RecordingController(callback);

    //     // Create some recordings for testing
    //     Recording recording1 = new Recording("Video 1", 10.5);
    //     Recording recording2 = new Recording("Video 2", 8.0);
    //     Recording recording3 = new Recording("Video 3", 12.3);

    //     // Enqueue recordings for processing
    //     controller.enqueueRecording(recording1);
    //     controller.enqueueRecording(recording2);
    //     controller.enqueueRecording(recording3);

    //     // Shutdown the controller after processing
    //     controller.shutdown();
    // }

}



class ExternalService {

    // Simulate processing a recording and generating closed captioning
    public String processRecording(Recording recording) {
        System.out.println("Processing recording: " + recording.getId() +
                " Media: " + recording.getMedia() +
                " Length: " + recording.getLength());

        // Simulate processing time based on the length of the recording
        try {
          TimeUnit.SECONDS.sleep((long) recording.getLength());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Simulate generating closed captioning
        String closedCaptioning = "Closed captioning for " + recording.getMedia() + " recording";

        System.out.println("Closed captioning generated: " + closedCaptioning);

        return closedCaptioning;
    }

    // public static void main(String[] args) {
    //     // Create an instance of ExternalService
    //     ExternalService externalService = new ExternalService();

    //     // Create a sample recording for testing
    //     Recording recording = new Recording(
    //             UUID.randomUUID(), // Unique ID
    //             "Sample Media",     // Media type
    //             10.5                // Length in seconds
    //     );

    //     // Process the recording and generate closed captioning
    //     String closedCaptioning = externalService.processRecording(recording);

    //     // Output the generated closed captioning
    //     System.out.println("Generated Closed Captioning: " + closedCaptioning);
    // }
}

// public class RecordingController {

//     private final ExternalService externalService;
//     private final Queue<Recording> processingQueue;
//     private final ExecutorService executorService;

//     public RecordingController() {
//         this.externalService = new ExternalService();
//         this.processingQueue = new ConcurrentLinkedQueue<>();
//         this.executorService = Executors.newFixedThreadPool(5); // Maximum of 5 concurrent processes
//     }

//     public void enqueueRecording(Recording recording) {
//         processingQueue.add(recording);
//         System.out.println("Recording enqueued for processing: " + recording.getId());
//         processRecordings();
//     }

//     private void processRecordings() {
//         while (!processingQueue.isEmpty()) {
//             Recording recording = processingQueue.poll();
//             if (recording != null) {
//                 executorService.submit(() -> processRecording(recording));
//             }
//         }
//     }

//     private void processRecording(Recording recording) {
//         // Simulate sending the recording to an external service
//         String closedCaptioning = externalService.processRecording(recording);

//         // Update the recording with closed captioning
//         recording.setClosedCaptioning(closedCaptioning);

//         // Simulate further processing or callback
//         System.out.println("Recording processed: " + recording.getId() +
//                 " Closed Captioning: " + closedCaptioning);
//     }

//     public void shutdown() {
//         executorService.shutdown();
//     }