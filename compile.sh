#!/bin/sh

find . -name *.java > sources.txt
javac -sourcepath src @sources.txt

echo "\nCompilation Successful\n"