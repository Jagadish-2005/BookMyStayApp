import java.util.*;

class Feedback {
    private String comments;
    private int rating;

    public Feedback(String comments, int rating) {
        this.comments = comments;
        this.rating = rating;
    }

    public String getComments() { return comments; }
    public int getRating() { return rating; }
}

class FeedbackService {
    private Map<String, Feedback> guestFeedback;

    public FeedbackService() {
        guestFeedback = new HashMap<>();
    }

    public void submitFeedback(String reservationId, Feedback feedback) {
        guestFeedback.put(reservationId, feedback);
    }

    public void displayFeedback(String reservationId) {
        Feedback f = guestFeedback.get(reservationId);
        if (f != null) {
            System.out.println("Guest Feedback for " + reservationId + ":");
            System.out.println("Rating: " + f.getRating() + "/5");
            System.out.println("Comments: " + f.getComments());
        } else {
            System.out.println("No feedback found for " + reservationId);
        }
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Room Feedback and Rating\n");

        FeedbackService feedbackService = new FeedbackService();
        String resId = "Single-1";

        Feedback guestFeedback = new Feedback("Excellent service and clean room!", 5);
        feedbackService.submitFeedback(resId, guestFeedback);

        feedbackService.displayFeedback(resId);
    }
}