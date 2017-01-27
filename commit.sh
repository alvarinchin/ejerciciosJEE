#!/bin/bash

git add ${1-"ProgramacionJEE"}

git commit 

git push ${2-"origin"} ${3-"master"}