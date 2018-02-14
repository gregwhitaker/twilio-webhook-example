package twilio.webhook.service.api.messages;

import com.google.inject.Inject;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;
import twilio.webhook.service.service.messages.RatingService;

public class ListUserRatingsEndpoint implements Handler {

    @Inject
    private RatingService ratingService;

    @Override
    public void handle(Context ctx) throws Exception {
        String number = ctx.getAllPathTokens().get("number");

        ratingService.getRatingsByUser(number)
                .then(messages -> {
                    if (messages == null) {
                        ctx.getResponse().status(404);
                        ctx.getResponse().send();
                    } else {
                        ctx.render(Jackson.json(messages));
                    }
                });
    }
}
