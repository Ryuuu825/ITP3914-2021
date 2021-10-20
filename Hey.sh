#! /bin/bash

# build date
DATE=$(date)
# which os that buil it
case "$OSTYPE" in
  darwin*)  Paltform="OSX" ;; 
  linux*)   Paltform="LINUX" ;;
  msys*)    Paltform="WINDOWS" ;;
  cygwin*)  Paltform="WINDOWS" ;;
esac


if [ -f ./build/com/Main.class ]
then 
    # clean the build and recompile it
    rm -r ./build/*
fi

# place the output into ./test/default_testcase.txt
TESTFILE="./test/default_testcase.txt"

printf "\n" >> $TESTFILE
for ((i=0;i<30;i++)) do
    printf "-" >> $TESTFILE
done 
printf "\n" >> $TESTFILE

# put date and platform as header
echo "Date" : $DATE >> $TESTFILE
printf "Platform : %s \n" $Paltform >> $TESTFILE


printf "Result:\n" >> $TESTFILE
javac -d "./build" src/com/Main.java src/com/Bingo/Player.java src/com/Bingo/Card.java src/com/Bingo/Host.java 
java -cp "./build" "com.Main" >> $TESTFILE