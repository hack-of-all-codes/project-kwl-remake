package com.kwler.legacy.worker.scraper.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ScraperResponse {

    String id;
    String title;
    String body;
    Boolean success;
    String errorMessage;

}
