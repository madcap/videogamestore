package org.maats.videogamestore.controller;

import org.maats.videogamestore.client.GiantBombClient;
import org.maats.videogamestore.domain.checkout.CheckoutResult;
import org.maats.videogamestore.domain.giantbomb.SearchResults;
import org.maats.videogamestore.service.CheckoutService;
import org.maats.videogamestore.service.NoInventoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class VideoGameController {

    private static final Logger LOG = LoggerFactory.getLogger(VideoGameController.class);

    @Autowired private GiantBombClient giantBombClient;
    @Autowired private CheckoutService checkoutService;

    // in a production grade application we'd do more validation/error handling in here

    @GetMapping("/search")
    public Map<String, Object> search(@RequestParam("phrase") String phrase) {
        SearchResults searchResults = giantBombClient.search(phrase);
        return Map.of("message", "success", "searchResults", searchResults);
    }

    // a real api would use a post here with a user information, but i'm not implementing all that
    @GetMapping("/checkout/{guid}")
    public Map<String, Object> checkout(@PathVariable String guid) {
        try {
            CheckoutResult result = checkoutService.checkOutGame(guid.trim());
            return Map.of("message", "success", "details", result);
        }
        catch(NoInventoryException e) {
            // in a real application we'd return a relevant status code here instead of 200
            return Map.of("message", "no copies available for game: " + guid);
        }
    }

}
