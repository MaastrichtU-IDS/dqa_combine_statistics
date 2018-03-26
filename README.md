# About
This project combines multiple NTRIPLES files into one and creates a connection between the fairsharing dataset and statistics.
# Docker
## Build
```
docker build -t combine-statistics .
```
## Run
```
docker run -it --rm -v /data/dqa-statistics:/data combine-statistics /data/output.nt \
  /data/input1.nt \
  /data/input2.nt 
```
