package com.kwler.legacy.worker.facebook.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UsernameResolverRequest {

    String id;

    @JsonCreator
    public UsernameResolverRequest(@JsonProperty("id") String id) {
        this.id = id;
    }
}
