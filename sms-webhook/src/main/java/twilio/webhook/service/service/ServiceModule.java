package twilio.webhook.service.service;

import com.google.inject.AbstractModule;
import twilio.webhook.service.service.messages.DefaultRatingService;
import twilio.webhook.service.service.messages.RatingService;

public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(RatingService.class).to(DefaultRatingService.class);
    }
}
