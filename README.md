# About
This project combines multiple NTRIPLES files into one and creates a connection between the fairsharing dataset and statistics. Required arguments are an output-file and at least one input-file. 
# Docker
## Build
```
docker build -t combine-statistics .
```
## Run
### Linux / OS-X
```
docker run -it --rm \
  -v /data/dqa-statistics/:/data/ \
  combine-statistics \
  /data/output.nt \
  /data/input1.nt \
  /data/input2.nt 
```
### Windows
```
docker run -it --rm \
  -v c:/data/dqa-statistics/:/data/ \
  combine-statistics \
  /data/output.nt \
  /data/input1.nt \
  /data/input2.nt 
```
