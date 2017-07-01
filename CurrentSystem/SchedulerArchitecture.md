# Architecture: The Scheduler
A backend system for running scheduled task

Runs in the background infinitely and polls the job database: implemented in mongo and modifiable by adminitrators

###### Table 1: Job Collection
| Attribute         | Type                | Description         |
| ----------------- |:-------------------:| --------------------|
| id                | ObjectId            | Mongo Id            |
| name              | String              | Human-friendly name |
| jobType           | String              |                     |
| cronList          | String              |                     |
| jobParams         | Map<String,String>  |                     |
| lastRunTimestamp  | String              |                     |

###### Table 2: Job Types
| Job Type            | Description | 
| ------------------- | ----------- |
| ARTIST              | Gets the list of ALL tracked artists and harvests the missing values for their referenceEntries using the job queue|
| MONTHLYCHART        | Gets the list of all charts (Table 3) running on a monthly time interval, and creates a new job in the queue |
| WEEKLYCHART         | Gets the list of all charts running on a monthly time interval, and creates a new job in the queue |
| MONTHLYPLAYLIST     | Gets the list of all playlists (Table 4) running on a monthly interval |
| WEEKLYPLAYLIST      |             |
| DAILYPLAYLIST       |             |
| SIMILAR             |             |
| USERNAMERESOLVER    |             |
| EVENT               |             |
| DATA                |             |

###### Table 3: Chart Collection
| Attribute           | Type                | Description  |
| ------------------- |:-------------------:| -------------|
| id                  | ObjectId            |              |
| channel             | String              |              |
| description         | String              |              |
| dataSource          | String              | ITUNES, LASTFM, SCREENSCRAPER |
| dataSourceParams    | Map<String,String>  |              |
| tracked             | Boolean             |              |
| coverageType        | String              | NATIONAL, REGIONAL, GLOBAL |
| coverageArea        | String              |              |
| type                | String              | VIDEO, STREAMING, AUDIO, RADIO, TEXT |
| purpose             | List<String>        |              |
| interval            | String              | DAY, WEEK, MONTH, QUARTER, SEMESTER, ANNUAL |

###### Table 4: Playlist Collection
| Attribute           | Type                | Description  |
| ------------------- |:-------------------:| -------------|
| id                  | ObjectId            |              |
| name                | String              |              |
| description         | String              |              |
| params              | Map<String,String>  |              |
| tracked             | Boolean             |              |
| interval            | String              | DAY, WEEK, MONTH, QUARTER, SEMESTER, ANNUAL |
