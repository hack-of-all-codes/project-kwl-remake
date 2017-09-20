package com.kwler.legacy.api.metrics.model;

import lombok.Data;

@Data
public class FactFan {

    Long id;
    Long dateId;
    Long artistId;
    Long channelId;
    Long countryId;

    Long fanCount;
    Long fanGrowthLast1D;
    Long fanGrowthLast7D;
    Long fanGrowthLast30D;
}
