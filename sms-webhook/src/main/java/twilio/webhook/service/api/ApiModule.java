package twilio.webhook.service.api;

import com.google.inject.AbstractModule;
import twilio.webhook.service.api.messages.ListUserRatingsEndpoint;
import twilio.webhook.service.api.webhook.WebhookEndpoint;

public class ApiModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ApiEndpoints.class);

        bind(ListUserRatingsEndpoint.class);
        bind(WebhookEndpoint.class);
    }
}
