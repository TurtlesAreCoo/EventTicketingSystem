#!/bin/bash
clear
echo "================================"
echo "CPS 707 Assignment"
echo "================================"
echo "Enter 1 to Login"
echo "Enter q to exit program"

read answer
case "$answer" in 
1) source login_page.sh ;;
q) exit ;;
esac

