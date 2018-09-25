# What went wrong?
Everything thats is wrong with the project. Everyone is aware of these but no one has the time to fix them, perpetuating the issue the longer we avoid them.

## Data Harvest
The "Harvest" layer is our integration point to other websites/APIs, it was horribly designed with a lot of coupling with the job coordination layey, now the devs working on it are helplessly swamped with requests for updates.
- feature-envy harvester performs data processing
- the harvesters are vastly dependent on a coordinator system
- an update on the target page breaks the post-processing code
- no automated runtime error checks
- extremely difficult to test

## Data Processing
- does not scale to the amount of data
- extremely slow, despite the huge provisions

## Overarching Issues
- misuse of polyglot databases