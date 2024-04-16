package org.maats.videogamestore.domain.giantbomb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResults {
    // partial implementation of a single result from giant bomb api /search
    // there are more fields available
    List<Result> results;
}
