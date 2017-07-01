# Project: The Scheduler
A backend system for running scheduled task

Runs in the background infinitely and polls the job database: implemented in mongo and modifiable by adminitrators

Table 1: Job Collection

| Attribute         | Type                | Description  |
| ----------------- |:-------------------:| ------------:|
| _id               | ObjectId            | Mongo Id |
| name              | String              | Human-friendly name |
| jobType           | String              |    $1 |
| cronList          | String              |    $1 |
| jobParams         | Map<String,String>  |    $1 |
| lastRunTimestamp  | String              |    $1 |

Table 2: Job Types

| Job Type            | Description | 
| ------------------- | ----------- |
| ARTIST              |             |
| MONTHLYCHART        |             |
| WEEKLYCHART         |             |
| MONTHLYPLAYLIST     |             |
| WEEKLYPLAYLIST      |             |
| DAILYPLAYLIST       |             |
| SIMILAR             |             |
| USERNAMERESOLVER    |             |
| EVENT               |             |
| DATA                |             |
