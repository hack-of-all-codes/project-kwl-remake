# Birds Eye View Architecture


```


Public ------ KWL360 Dashboard      
                    |
                    | |------------------- Postgres 
                    | | |----------------- Braintree
                API Server --------------- Master Database
                    | | |----------------- Facebook API
                    | |------------------- SQS Message Queue
                    |
                    |
                    | 
Admin ------ Admin Dashboard


```
