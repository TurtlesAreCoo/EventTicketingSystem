#!/bin/bash
WD=$(pwd)
cd ..
cd ..
DIR=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )
cd $WD
#goes through test case # 1..72
javac Controller.java
for i in {1..72}
do 
	echo "running test $i"
<<<<<<< HEAD
=======
	javac Controller.java
>>>>>>> 7aff6007f9fcd0a635c7399d33e2247492e79825
	java Controller AccountList.txt EventList.txt < "$DIR/Inputs/Test_$i.inp" > "$DIR/Outputs/Output_$i.out"
done

rm *.class