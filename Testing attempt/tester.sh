#!/bin/bash
for i in *.txt;         #for all text files in the directory
do
echo "running test $i"
cat *.txt  >> results.out #appends all text files to results.out
done









#take the result file and read in the lines one by one 
#STRING="Hello World"

#make a jar file of the orginial java files (this has to be done before script is ran)
# write java -cp controller.jar Controller <-- this will run the jar file) 

#take the test file and read in the lines one by one
#feed each line to the running progra
#compare the results to the results file. if they match, test is passed otherwise test is failed. 

#STRING2=$(java -cp test.jar A)
#if [STRING = STRING2]
#	echo "passed"
