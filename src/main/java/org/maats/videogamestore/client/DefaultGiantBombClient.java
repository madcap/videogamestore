package org.maats.videogamestore.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.maats.videogamestore.domain.giantbomb.SearchResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("GiantBombClient")
public class DefaultGiantBombClient implements GiantBombClient {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultGiantBombClient.class);
    private static final String GIANT_BOMB_URL = "http://www.giantbomb.com/api/";

    @Autowired private OkHttpClient okHttpClient;
    @Autowired private String giantBombApiKey;
    @Autowired private ObjectMapper objectMapper;

    @Override
    public SearchResults search(String phrase) throws GiantBombException {
        checkForValidApiKey();
        String queryParameters = "?api_key=" + giantBombApiKey + "&format=json&query=\"" + phrase.trim() + "\"&resources=game";
        Request request = new Request.Builder()
                .url(GIANT_BOMB_URL + "search" + queryParameters)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            if(response.code() != 200) {
                LOG.error("received code [{}] when searching for: [{}], response body: [{}]", response.code(), queryParameters, response.body().string());
                throw new GiantBombException("call failed with status code: " + response.code());
            }
            return objectMapper.readValue(response.body().string(), SearchResults.class);
        }
        catch(GiantBombException e) {
            // already handled
            throw e;
        }
        catch(Exception e) {
            LOG.error("exception calling giant bomb api search with query parameters: [{}]", queryParameters, e);
            throw new GiantBombException("failed to  call giant bomb api", e);
        }
    }

    private void checkForValidApiKey() {
        if(giantBombApiKey == null) {
            String message = "cannot access giant bomb api without a valid api key";
            LOG.error(message);
            throw new GiantBombException(message);
        }
    }
}
