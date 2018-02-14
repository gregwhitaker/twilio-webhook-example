package twilio.webhook.service.service.messages.model;

public class Rating {

    private final Long timestamp = System.currentTimeMillis();
    private final Integer rating;

    public Rating(final Integer rating) {
        this.rating = rating;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Integer getRating() {
        return rating;
    }
}
