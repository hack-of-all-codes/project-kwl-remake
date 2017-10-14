package com.kwler.legacy.worker.scraper.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ScraperRequest {

    String id;
    String url;
}
