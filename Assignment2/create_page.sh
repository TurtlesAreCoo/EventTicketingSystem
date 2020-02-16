#!/bin/bash
echo "======================="
echo "Create"
echo "======================="
read -p "Enter username: "
echo "$REPLY" >> users.txt
echo "Select the type of User"
echo "Enter 1 for admin"
echo "Enter 2 for full standard"
echo "Enter 3 for buy standard"
echo "Enter 4 for sell standard"
read typeAnswer
case $typeAnswer in
1) echo "You've created a new admin account!" ;;
2) echo "You've created a new full standard account!" ;;
3) echo "You've created a new buy standard account!" ;;
4) echo "You've created a new sell standard account!" ;;
esac
if [ $typeAnswer == "1" ]
then
echo "$REPLY has been given admin privileges!"
echo "01 $REPLY AA 1000" >> transaction.txt
elif [ $typeAnswer == "2" ]
then
echo "$REPLY has been given full standard privileges!"
echo "01 $REPLY FS 1000" >> transaction.txt
elif [ $typeAnswer == "3" ]
then
echo "$REPLY has been given buy standard privileges!"
echo "01 $REPLY BS 1000" >> transaction.txt
elif [ $typeAnswer == "4" ]
then
echo "$REPLY has been given sell standard privileges!"
echo "01 $REPLY SS 1000" >> transaction.txt
fi
