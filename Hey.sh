#! /bin/bash

# build date
DATE=$(date)
JAVA_VERSION=$(java -version 2>&1 | grep 'version' | awk '{printf $2}' )

#----------------------------------------------

# which os that build it
case "$OSTYPE" in
  darwin*)  Paltform="OSX" ;; 
  linux*)   Paltform="LINUX" ;;
  msys*)    Paltform="WINDOWS" ;;
  cygwin*)  Paltform="WINDOWS" ;;
esac

#----------------------------------------------

  # clean the build before
if [ -f ./build/com/Main.java ]
then 
    rm -r ./build/*
fi
#----------------------------------------------

# place the output into ./test/default_testcase.txt
TESTFILE="./test_log/default_testcase.txt"

# formatting
printf "\n" >> $TESTFILE
for ((i=0;i<30;i++)) do
    printf "-" >> $TESTFILE
done 
printf "\n" >> $TESTFILE

# put date and platform and (Result :) as header
echo "Date" : $DATE >> $TESTFILE
printf "Platform : %s \n" $Paltform >> $TESTFILE
printf "JDK version : %s \n" $JAVA_VERSION >> $TESTFILE
printf "Result:\t" >> $TESTFILE

#----------------------------------------------

printf "[Compiling...]\n" 

compile=$(javac -d "./build"  src/com/Bingo/Player.java src/com/Bingo/Card.java src/com/Bingo/Host.java src/com/Main.java 2> temp.log)

if [[ $? != 0 ]] 
then 
  printf "[Compiling Fail]\n" >> $TESTFILE
  printf "[Compiling Fail]\n"

  error_message=$(cat temp.log)
  printf  "\noutput :\n\t" >> $TESTFILE
  echo $error_message >> $TESTFILE 

  #### need to write error message into $TESTFILE
  printf "[EXIT CODE : -1]" >> $TESTFILE 
  exit -1

else 
  printf "[Compiling Success]\n" >> $TESTFILE
fi




#----------------------------------------------



printf "[ Logging ...] -> %s\n"  $TESTFILE

for ((i=0;i<10;i++)) do
    printf "-" 
done 
printf "[Running]"
for ((i=0;i<10;i++)) do
    printf "-" 
done 
printf "\n"

printf "\nOutput : \n" >> $TESTFILE
java -cp "./build" "com.Main" 2>> $TESTFILE >> $TESTFILE
printf "[EXIT CODE : %d] " $? >> $TESTFILE