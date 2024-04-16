package org.maats.videogamestore.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GiantBombConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(GiantBombConfiguration.class);

    @Bean("GiantBombApiKey")
    public String giantBombApiKey() {
        String apiKey = System.getenv("GB_API_KEY");
        if(apiKey == null || apiKey.isEmpty()) {
            LOG.warn("missing required giant bomb api key");
            return null;
        }
        LOG.info("giant bomb api key successfully loaded");
        return apiKey;
    }

}
