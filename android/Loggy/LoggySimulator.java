

public class LoggySimulator implements RecordingCallback {

    private final RecordingController recordingController;

    public LoggySimulator(RecordingController recordingController) {
        this.recordingController = recordingController;
    }

    public void simulate() {
        // Create sample recordings
        Recording[] recordings = {
                new Recording("audio", 120.5),
                new Recording("video", 180.0),
                // Add more recordings as needed
        };

        // Process recordings
        for (Recording recording : recordings) {
            recordingController.enqueueRecording(recording);
        }
        // Shutdown the RecordingController after processing
        recordingController.shutdown();
    }

    @Override
    public void onRecordingProcessed(Recording recording) {
        // Handle the notification, e.g., log the result
        System.out.println("Recording processed: " + recording.getId() +
                " Media: " + recording.getMedia() +
                " Closed Captioning: " + recording.getClosedCaptioning());
    }


    // public static void main(String[] args) {
    //     // Create a RecordingController instance
    //     RecordingController controller = new RecordingController(new LoggySimulator());

    //     // Simulate recordings
    //     controller.getCallback().simulate();
    // }
}
