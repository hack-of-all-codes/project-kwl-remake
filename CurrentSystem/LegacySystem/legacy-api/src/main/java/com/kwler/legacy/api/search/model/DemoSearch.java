package com.kwler.legacy.api.search.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "demo-search")
public class DemoSearch {

    @Id
    String id;
    String name;
    Integer age;
}
