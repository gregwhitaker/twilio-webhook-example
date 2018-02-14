package twilio.webhook.service.service.messages;

import com.google.inject.Singleton;
import ratpack.exec.Blocking;
import ratpack.exec.Operation;
import ratpack.exec.Promise;
import twilio.webhook.service.service.messages.model.Rating;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class DefaultRatingService implements RatingService {

    private final ConcurrentHashMap<String, List<Rating>> ratingHistory = new ConcurrentHashMap<>();

    @Override
    public Operation addRating(String number, Integer rating) {
        return Blocking.op(() -> {
            List<Rating> ratings = ratingHistory.getOrDefault(number, new ArrayList<>());
            ratings.add(new Rating(rating));

            ratingHistory.put(number, ratings);
        });
    }

    @Override
    public Promise<List<Rating>> getRatingsByUser(String number) {
        return Blocking.get(() -> ratingHistory.get(number));
    }
}
