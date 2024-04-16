package org.maats.videogamestore.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.maats.videogamestore.domain.giantbomb.SearchResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DefaultGiantBombClientIntegrationTest {

    @Autowired private GiantBombClient client;

    @Test
    void test_search() throws JsonProcessingException {
        SearchResults searchResults = client.search("helldivers");


        assertNotNull(searchResults);
        assertNotNull(searchResults.getResults());
        // as of 4/15 there are 2 helldivers games
        assertTrue(searchResults.getResults().size() >= 2);
    }

}