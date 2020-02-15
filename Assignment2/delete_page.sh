#!/bin/bash
echo "============"
echo "Delete Page"
echo "============"
while read p; do
echo "Usernames available to delete: $p"
done < users.txt
echo "Enter username to Delete"
read dUser

awk -i inplace -v dUser="$dUser" '$0 != dUser' users.txt
