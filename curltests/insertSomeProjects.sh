#!/bin/bash
# fyi: suffix with | python -m json.tool to format json if you get a json response

curl -X POST -H "Content-Type:application/json" -d @project.json http://localhost:8080/api/project
curl -X POST -H "Content-Type:application/json" -d @project2.json http://localhost:8080/api/project
