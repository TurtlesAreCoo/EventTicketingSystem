#!/bin/bash

while read p; do
        echo "Available Username: $p"
done < users.txt



echo "Enter Username: "
read name
if [ $name == "admin" ]
then
clear
echo "============================"
echo "Hello Admin!"
echo "============================"
echo "Enter 1 to Create!"
echo "Enter 2 to Delete!"
echo "Enter 3 to Sell!"
echo "Enter 4 to Buy!"
echo "Enter 5 to Refund!"
echo "Enter 6 to Add Credit!"
echo "Enter 0 to Logout!"
echo "Available Tickets File: $(cat availableTickets.txt)"
read answeradmin
case "$answeradmin" in
1) source create_page.sh ;;
2) source delete_page.sh ;;
3) source sell_page.sh ;;
4) source buy_page.sh ;;
5) source refund_page.sh ;;
6) source addcredit_page.sh ;;
0) source logout_page.sh ;;
esac
elif [ $name == "fullstandard" ]
then
clear
echo "============================"
echo "Hello Full Standard!"
echo "============================"
echo "Enter 1 to Sell!"
echo "Enter 2 to Buy!"
echo "Enter 3 to Add Credit!"
echo "Enter 0 to Logout!"
echo "Available Tickets File: $(cat availableTickets.txt)"
read answerfullstandard
case "$answerfullstandard" in
1) source sell_page.sh ;;
2) source buy_page.sh ;;
3) source addcredit_page.sh ;;
0) source logout_page.sh ;;
esac
elif [ $name == "buystandard" ]
then
clear
echo "==========================="
echo "Hello Buy Standard!"
echo "==========================="
echo "Enter 1 to Buy!"
echo "Enter 2 to Add Credit!"
echo "Enter 0 to Logout!"
echo "Available Tickets File: $(cat availableTickets.txt)"
read answerbuystandard
case "$answerbuystandard" in
1) source buy_page.sh ;;
2) source addcredit_page.sh ;;
0) source logout_page.sh ;;
esac
elif [ $name == "sellstandard" ]
then
clear
echo "==========================="
echo "Hello Sell Standard!"
echo "==========================="
echo "Enter 1 to Sell!"
echo "Enter 2 to Add Credit!"
echo "Enter 0 to Logout!"
echo "Available Tickets File: $(cat availableTickets.txt)"
read answersellstandard
case "$answersellstandard" in
1) source sell_page.sh ;;
2) source addcreddit_page.sh ;;
0) source logout_page.sh ;;
esac
fi
