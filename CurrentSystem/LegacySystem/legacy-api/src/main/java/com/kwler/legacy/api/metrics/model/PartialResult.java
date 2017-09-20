package com.kwler.legacy.api.metrics.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PartialResult<T> {

    Long count;
    List<T> contents;
}
