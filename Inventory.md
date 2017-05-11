# Inventory: A Brief Overview of the Current System

#### Architecture:
```

Admin Dashboard
  |            (External API)  ---Worker ------------------ Web Scraper (Python/Scrapy)
  |                                 |
  |   |--------------------- Master Data (Mongo) ------------------------|
KWL API--------------------- Metrics (PostgreSQL) ---------------------- Data Processor (Pentaho DI)
  |   |--------------------- Search DB (ElasticSearch) ------------------|
  |
KWL360 Dashboard
```

#### Data Sources:
- [iTunes Enterprise Feed](https://affiliate.itunes.apple.com/resources/documentation/itunes-enterprise-partner-feed/)
- Twitter
- Facebook
- LastFM
