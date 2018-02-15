# sms-client
Sends an SMS message to a phone asking for a 1-10 rating on the customer's recent purchase experience. The response will be recorded by the `sms-webhook` service.

## Running the Client
You can run the client using the following Gradle command:

    $ TWILIO_ACCOUNT_ID={account sid} TWILIO_AUTH_TOKEN={auth token} TWILIO_NUMBER={twilio number} ../gradlew :sms-client:run -Dexec.args={recipient number}
