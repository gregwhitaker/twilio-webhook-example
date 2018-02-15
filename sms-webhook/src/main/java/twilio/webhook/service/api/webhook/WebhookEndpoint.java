package twilio.webhook.service.api.webhook;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.form.Form;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import twilio.webhook.service.service.messages.RatingService;

public class WebhookEndpoint implements Handler {
    private static final Logger LOG = LoggerFactory.getLogger(WebhookEndpoint.class);

    @Inject
    private RatingService ratingService;

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.parse(Form.class)
                .then(form -> {
                    LOG.info("Rating Received: [user={}]", form.get("From"));

                    try {
                        Integer rating = Integer.parseInt(form.get("Body").trim());

                        ratingService.addRating(form.get("From"), rating)
                                .then(() -> {
                                    ctx.getResponse().contentType("application/xml");
                                    ctx.render("<Response><Message>Thanks for the feedback!</Message></Response>");
                                });
                    } catch (NumberFormatException e) {
                        LOG.error("Error parsing rating from user '{}'", form.get("From"));
                        ctx.getResponse().contentType("application/xml");
                        ctx.render("<Response><Message>Thanks for the feedback!</Message></Response>");                    }
                });
    }
}
