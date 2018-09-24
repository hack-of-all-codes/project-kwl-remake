# What went wrong?
A compilation of all the POC stuff that went to prod

## Data Harvest
- feature-envy harvester performs data processing
- an update on the target page breaks the post-processing code
- no automated runtime error checks
- extremely difficult to test

## Data Processing
- does not scale to the amount of data
- extremely slow, despite the huge provisions

## Overall
- misuse of databases