#!/bin/bash
# fyi: suffix with | python -m json.tool to format json if you get a json response

curl -X GET http://localhost:8080/api/project/all
