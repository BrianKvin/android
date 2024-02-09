

public class Main {

    public static void main(String[] args) {
        // Create an instance of the callback implementation
        RecordingCallback callback = new MyRecordingCallback();

        // Create a new recording controller with the callback instance
        RecordingController controller = new RecordingController(callback);

        // Create a LoggySimulator instance and pass the recording controller to it
        LoggySimulator simulator = new LoggySimulator(controller);

        // Run the simulation
        simulator.simulate();
    }

    // You can define your own implementation of RecordingCallback if needed
    static class MyRecordingCallback implements RecordingCallback {
        @Override
        public void onRecordingProcessed(Recording recording) {
            // Handle the notification, e.g., log the result
            System.out.println("Recording processed: " + recording.getId() +
                    " Media: " + recording.getMedia() +
                    " Closed Captioning: " + recording.getClosedCaptioning());
        }
    }
}