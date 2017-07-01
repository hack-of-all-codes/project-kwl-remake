# Birds Eye View Architecture


```


Public ------ KWL360 Dashboard      
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
Admin ------ Admin Dashboard


```
