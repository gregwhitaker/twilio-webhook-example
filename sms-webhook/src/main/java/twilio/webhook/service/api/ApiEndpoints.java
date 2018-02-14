package twilio.webhook.service.api;

import ratpack.func.Action;
import ratpack.handling.Chain;
import twilio.webhook.service.api.messages.ListUserRatingsEndpoint;
import twilio.webhook.service.api.webhook.WebhookEndpoint;

public class ApiEndpoints implements Action<Chain> {

    @Override
    public void execute(Chain chain) throws Exception {

        // Webhook invoked by Twilio on SMS reply
        chain.post("webhook", WebhookEndpoint.class);

        // Lists all messages for a specific number
        chain.get("users/:number/ratings", ListUserRatingsEndpoint.class);
    }
}
