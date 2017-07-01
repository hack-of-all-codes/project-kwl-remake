# Birds Eye View Architecture


```


Public ------ KWL360 Dashboard (Web Frontend)     
                    | 
                    | |------------------------------------------------Facebook API
                    | |                                                       |
                    | |                                                       |
                    | |                                                       |
                    | |                                                       |
                    | | |------ Elastic Search----|---Data Processor          |
                    | | |                         |      |                    |
                    | | |                         |      |                    |
                    | | |                         |      |                    |
                    | | |------------------- Postgres    ||----------------- Worker -------------- Spider --------- External Websites
                    | | |                                ||                    |
                    | | | |----------------- Braintree   ||                    |-------------------|
                    | | | |                              ||                                        |
                API Server ------------------ Master Database ----------------------|              |
                    | |                                                             |              |
                    | |------------------- SQS Message Queue ------------------ Scheduler          |
                    |                          |                                                   |
                    |                          |---------------------------------------------------|  
                    |                   
                    | 
Admin ------ Admin Dashboard (Web Frontend)     


```
