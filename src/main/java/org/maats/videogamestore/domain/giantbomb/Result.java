package org.maats.videogamestore.domain.giantbomb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    // partial implementation of a single result from giant bomb api /search
    // there are many more fields available
    private String guid;
    private String name;
    private String originalReleaseDate;
    private String siteDetailUrl;
}
