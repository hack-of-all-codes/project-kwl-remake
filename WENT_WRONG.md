# What went wrong?
Everything thats is wrong with the project. Everyone is aware of these but no one has the time to fix them, perpetuating the issue the longer we avoid them.

## Data Harvest
The "Harvest" layer is our integration point to other websites/APIs, it was horribly designed with a lot of coupling with the job coordination layer, now the devs working on it are helplessly swamped with requests for updates.
- feature-envy harvester performs data processing
- the harvesters are vastly dependent on a coordinator system
- the communication protocol is a proprietary format over "SSH", not sure what the actual f*ck were they thinking back then 
- an update on the target page breaks the post-processing code
- no automated runtime error checks
- extremely difficult to test

## Data Processing
- does not scale to the amount of data
- extremely slow, despite the huge provisions of EC2 instances
- a shit-ton of temp tables

## Overarching Issues
- misuse of polyglot databases
- misuse of source control, such as using Git for a Pentaho project
- the systemic absence of automated testing; this has got to be the one fatal flaw that irked me the most
