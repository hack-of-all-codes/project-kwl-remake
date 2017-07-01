# Birds Eye View Architecture


```


Public ------ KWL360 Dashboard      
                    |
                    | |------------------- Postgres     |----------------- Worker -------------- Spider --------- External Websites
                    | |                                 |                    |
                    | | |----------------- Braintree    |                    |---------------------|
                    | | |                               |                                          |
                API Server --------------- Master Database -------------------------|              |
                    | | |----------------- Facebook API                             |              |
                    | |------------------- SQS Message Queue ------------------ Scheduler          |
                    |                          |                                                   |
                    |                          |---------------------------------------------------|  
                    |                   
                    | 
Admin ------ Admin Dashboard


```
