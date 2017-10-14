package com.kwler.legacy.worker.facebook.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UsernameResolverResponse {

    String id;
    String username;
    Boolean success;
    String errorMessage;

    @JsonCreator
    public UsernameResolverResponse(
            @JsonProperty("id") String id,
            @JsonProperty("username") String username,
            @JsonProperty("success") Boolean success,
            @JsonProperty("errorMessage") String errorMessage) {
        this.id = id;
        this.username = username;
        this.success = success;
        this.errorMessage = errorMessage;
    }
}
