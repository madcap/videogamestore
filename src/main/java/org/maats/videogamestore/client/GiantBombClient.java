package org.maats.videogamestore.client;

import org.maats.videogamestore.domain.giantbomb.SearchResults;

public interface GiantBombClient {

    SearchResults search(String phrase) throws GiantBombException;

}
