#!/bin/bash
curl -X POST -H "Content-Type:application/json" -d @project.json http://localhost:8080/api/project
