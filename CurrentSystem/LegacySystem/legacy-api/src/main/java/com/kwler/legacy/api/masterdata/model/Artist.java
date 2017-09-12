package com.kwler.legacy.api.masterdata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artist {

    @Id
    String id;

    String name;
    List<String> aliases;
    CountryAndRegion country;
    String photoUrl;
    Long lastUpdatedDate;
    Long insertedDate;
    Integer trackedDate;
    List<Translation> translations;
    List<String> genres;
    List<String> labels;
    Integer charting;
    Integer touring;
    Integer newRelease;
    Integer awarding;
    Boolean tracked;
    Boolean verified;
    String bio;
    LastfmInfo lastfmInfo;
    String itunesArtistId;
    List<ReferenceEntry> referenceEntries;
    String mbid;

    @Data
    public static class CountryAndRegion {
        Country country;
        String region;
    }

    @Data
    public static class Translation {
        String translation;
        String languageCode;
    }

    @Data
    public static class LastfmInfo {
        String similarArtistPeriod;
        List<LastfmSimilarArtist> similarArtists;
    }

    @Data
    public static class LastfmSimilarArtist {
        String mbid;
        String match;
    }

    @Data
    public static class ReferenceEntry {
        String id;
        String type;
        String referenceId;
        String referenceName;
        Boolean tracked;
        Boolean official;
        Map<String, String> attributes;
        Integer failedCount;
    }
}
