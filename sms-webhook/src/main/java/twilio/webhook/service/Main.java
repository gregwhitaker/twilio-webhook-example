package twilio.webhook.service;

import ratpack.guice.Guice;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;
import twilio.webhook.service.api.ApiEndpoints;
import twilio.webhook.service.api.ApiModule;
import twilio.webhook.service.service.ServiceModule;

public class Main {

    public static void main(String... args) throws Exception {
        RatpackServer.start(s -> s
                .serverConfig(c -> c
                        .env()
                        .baseDir(BaseDir.find())
                        .build()
                )
                .registry(Guice.registry(b -> b
                        .module(ApiModule.class)
                        .module(ServiceModule.class))
                )
                .handlers(chain -> chain
                        .insert(ApiEndpoints.class)
                )
        );
    }
}
