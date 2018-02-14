package twilio.webhook.service.service.messages;

import ratpack.exec.Operation;
import ratpack.exec.Promise;
import twilio.webhook.service.service.messages.model.Rating;

import java.util.List;

public interface RatingService {

    Operation addRating(String number, Integer rating);

    Promise<List<Rating>> getRatingsByUser(String number);
}
