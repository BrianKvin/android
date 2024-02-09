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

}