# Inventory: A Brief Overview of the Current System

#### Architecture:
```

Admin Dashboard
  |                               Worker ------------------ Web Scraper (Python/Scrapy)
  |                                 |
  |   |--------------------- Master Data (Mongo) ------------------------|
KWL API--------------------- Metrics (PostgreSQL) ---------------------- Data Processor (Pentaho DI)
  |   |--------------------- Search DB (ElasticSearch) ------------------|
  |
KWL360 Dashboard
```
