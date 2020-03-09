#!/bin/bash
for i in *.txt;         #for all text files in the directory
do
echo "running test $i"
diff -y expectedoutput.txt actualoutput.txt  >> validatedresults.out #appends all text files to results.out
done
