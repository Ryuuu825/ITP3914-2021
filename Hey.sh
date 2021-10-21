#! /bin/bash

# build date
DATE=$(date)
JAVA_VERSION=$(java -version 2>&1 | grep 'version' | awk '{printf $3}' )

#----------------------------------------------

# which os that build it
case "$OSTYPE" in
  darwin*)  Paltform="MacOS" ;; 
  linux*)   Paltform="Linux" ;;
  msys*)    Paltform="Windows" ;;
  cygwin*)  Paltform="Windows" ;;
esac

#----------------------------------------------

# clean up before build
  find ./build -type f -name "*.class" -delete

#----------------------------------------------

# place the output into ./test/default_testcase.txt
TESTFILE="./log/default_testcase.log"

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

# redirect the error raised to the temp.log
javac -d "./build"  src/com/Bingo/Player.java src/com/Bingo/Card.java src/com/Bingo/Host.java src/com/Main.java 2> temp.log

if [[ $? != 0 ]] 
then 
  # terminate the program if last exit code is not zero
  # which mean error
  printf "[Compiling Fail]\n" >> $TESTFILE
  printf "[Compiling Fail]\n"

  # copy error message to log file
  error_message=$(cat temp.log |  grep 'error')
  printf  "\noutput :\n\t" >> $TESTFILE
  echo $error_message >> $TESTFILE 
  rm temp.log

  # clean up 
  find ./build -type f -name "*.class" -delete

  printf "[EXIT CODE : %d] \n" $? >> $TESTFILE 
  exit -1

else 
  printf "[Compiling Success]\n" >> $TESTFILE
fi




#----------------------------------------------



printf "[ Logging ...]\n\tAll output directed to -> %s\n"  $TESTFILE

for ((i=0;i<10;i++)) do
    printf "-" 
done 
printf "[Running]"
for ((i=0;i<10;i++)) do
    printf "-" 
done 
printf "\n"

printf "\nOutput : \n" >> $TESTFILE

# redirect the error raised to the file
java -cp "./build" "com.Main" 2>> $TESTFILE >> $TESTFILE
printf "[EXIT CODE : %d] \n" $? >> $TESTFILE

for ((i=0;i<10;i++)) do
    printf "-" 
done 
printf "[Finish]"
for ((i=0;i<10;i++)) do
    printf "-" 
done 
printf "\n"

