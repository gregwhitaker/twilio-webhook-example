package twilio.webhook.publisher;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Main {

    public static void main(String... args) throws Exception {
        final String accountId = System.getenv("TWILIO_ACCOUNT_ID");
        final String authToken = System.getenv("TWILIO_AUTH_TOKEN");
        final String number = System.getenv("TWILIO_NUMBER");

        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("Missing Twilio account id. Please specify the account id in environment variable 'TWILIO_ACCOUNT_ID'");
        }

        if (authToken == null || authToken.isEmpty()) {
            throw new IllegalArgumentException("Missing Twilio auth token. Please specify the auth token in environment variable 'TWILIO_AUTH_TOKEN'");
        }

        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("Missing Twilio number. Please specify the number in environment variable 'TWILIO_NUMBER'");
        }

        if (args.length == 0) {
            throw new IllegalArgumentException("The To phone number is required");
        }

        System.out.println("Twilio Account Id: " + accountId);
        System.out.println("Twilio Auth Token: " + authToken);
        System.out.println("Twilio Number: " + number);
        System.out.println("Recipient Number: " + args[0]);

        Twilio.init(accountId, authToken);

        Message message = Message
                .creator(new PhoneNumber(args[0]), new PhoneNumber(number),
                        "How would you rate your recent purchase experience, 1-10?")
                .create();

        System.out.println("SMS Sent!");
    }
}
