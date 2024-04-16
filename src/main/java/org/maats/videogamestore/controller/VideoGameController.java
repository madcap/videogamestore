package org.maats.videogamestore.controller;

import org.maats.videogamestore.client.GiantBombClient;
import org.maats.videogamestore.domain.giantbomb.SearchResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class VideoGameController {

    private static final Logger LOG = LoggerFactory.getLogger(VideoGameController.class);

    @Autowired private GiantBombClient giantBombClient;

    @GetMapping("/search")
    public Map<String, Object> search(@RequestParam("phrase") String phrase) {

        // in a production grade application we'd do more error handling here
        SearchResults searchResults = giantBombClient.search(phrase);
        return Map.of("message", "success", "searchResults", searchResults);
    }

}
