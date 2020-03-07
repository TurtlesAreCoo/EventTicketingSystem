#!/bin/bash


#take the result file and read in the lines one by one 
STRING="Hello World"

#make a jar file of the orginial java files (this has to be done before script is ran)
# write java -cp controller.jar Controller <-- this will run the jar file) 

#take the test file and read in the lines one by one
#feed each line to the running progra
#compare the results to the results file. if they match, test is passed otherwise test is failed. 

STRING2=$(java -cp test.jar A)
if [STRING = STRING2]
	echo "passed"