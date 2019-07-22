#!/bin/bash
# fyi: suffix with | python -m json.tool to format json if you get a json response

curl -X POST -H "Content-Type:application/json" -d @$1 http://localhost:8080/api/project
