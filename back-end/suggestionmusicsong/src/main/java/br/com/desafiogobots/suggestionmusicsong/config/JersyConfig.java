package br.com.desafiogobots.suggestionmusicsong.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JersyConfig extends ResourceConfig {

    public JersyConfig() {

        packages("br.com.desafiogobots");
    }
}
