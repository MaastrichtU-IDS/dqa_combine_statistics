# dqa_combine_statistics

This application combines multiple NTRIPLES files into one and creates a connection between the fairsharing dataset and statistics.

## Build
docker build -t combine-statistics .

## Run
docker run -it --rm -v /data/dqa-statistics:/data combine-statistics /data/output.nt /data/input1.nt /data/input2.nt ...
