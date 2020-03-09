#!/bin/bash
cd ..
cd ..
DIR=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )

for i in {1..72}
do
	diff -y "$DIR/Results/Result_$i.bto" "$DIR/Outputs/Output_$i.out"  >> "$DIR/ValidatedResults/ValidatedResult_$i.out"
done