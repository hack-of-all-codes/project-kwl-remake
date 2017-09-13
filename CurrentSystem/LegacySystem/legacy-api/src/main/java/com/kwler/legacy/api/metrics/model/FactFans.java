package com.kwler.legacy.api.metrics.model;

import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

@Data
public class FactFans extends ResourceSupport {

    Long fanCount;
    Long fanGrowthLast1D;
}
