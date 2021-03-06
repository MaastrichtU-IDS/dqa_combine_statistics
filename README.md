[![License](https://img.shields.io/badge/FAIR-metrics-orange.svg)](http://fairmetrics.org/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)
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
  /data/input2.ttl \
  /data/input3.nq 
```
### Windows
```
docker run -it --rm ^
  -v c:/data/dqa-statistics/:/data/ ^
  combine-statistics ^
  /data/output.nt ^
  /data/input1.nt ^
  /data/input2.ttl 
```
